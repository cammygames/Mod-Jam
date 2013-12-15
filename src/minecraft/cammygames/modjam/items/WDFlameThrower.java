package cammygames.modjam.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cammygames.modjam.WarDefence;
import cammygames.modjam.entity.FireBall;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WDFlameThrower extends ItemBow
{
    private Icon loadedIcon;
    private Icon emptyIcon;

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        if (!player.inventory.hasItem(Item.fireballCharge.itemID))
        {
            this.itemIcon = emptyIcon;
            list.add("Requires Fire Charges");
        }
        else
        {
            this.itemIcon = loadedIcon;
        }

        list.add("Burn Baby Burn!");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.loadedIcon = iconRegister.registerIcon("WarDefence:flamethrower");
        this.emptyIcon = iconRegister.registerIcon("WarDefence:flamethrower-empty");
        this.itemIcon = emptyIcon;
    }

    private final EnumToolMaterial toolMaterial;

    public WDFlameThrower(int par1)
    {
        super(par1);
        this.setMaxDamage(1500);
        this.toolMaterial = EnumToolMaterial.EMERALD;
        this.setCreativeTab(WarDefence.WarDefenceItems);
    }

    /**
     * called when the player releases the use item button. Args: itemstack,
     * world, entityplayer, itemInUseCount
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int par4)
    {
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);

        if (event.isCanceled())
        {
            return event.result;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.fireballCharge.itemID))
        {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
    }

    /**
     * Called each tick while using an item.
     *
     * @param stack The Item being used
     * @param player The Player using the item
     * @param count The amount of time in tick the item has been used for
     * continuously
     */
    @Override
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer player, int count)
    {
        if (count % 2 != 0)
        {
            return;
        }

        World world = player.worldObj;
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);

        if (event.isCanceled())
        {
            return;
        }

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(Item.fireballCharge.itemID))
        {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        int j = this.getMaxItemUseDuration(itemStack) - 1;
        ArrowLooseEvent eventAr = new ArrowLooseEvent(player, itemStack, j);
        MinecraftForge.EVENT_BUS.post(eventAr);
        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

        if (flag || player.inventory.hasItem(Item.fireballCharge.itemID))
        {
            double yaw = Math.toRadians(player.rotationYaw);
            double pitch = Math.toRadians(player.rotationPitch);
            double xDirection = -Math.sin(yaw) * Math.cos(pitch);
            double yDirection = -Math.sin(pitch);
            double zDirection = Math.cos(yaw) * Math.cos(pitch);
            double x = player.posX + xDirection * 2;
            double y = player.posY + 1.5 + yDirection;
            double z = player.posZ + zDirection * 2;
            FireBall fireball = new FireBall(world, x, y, z, xDirection, yDirection, zDirection);
            int power = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);

            if (power > 0)
            {
                fireball.setDamage(fireball.getDamage() + (double) power * 0.5D + 0.5D);

                if (power == 5)
                {
                    fireball.setExplosive(true);
                }
            }

            int knockback = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

            if (knockback > 0)
            {
                fireball.setKnockbackStrength(knockback);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0)
            {
                fireball.setFire(100);
            }

            itemStack.damageItem(1, player);
            world.playAuxSFX(1009, (int) x, (int) y, (int) z, 0);

            if (!flag)
            {
                player.inventory.consumeInventoryItem(Item.fireballCharge.itemID);
            }

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(fireball);
            }
        }
    }

    /**
     * returns the action that specifies what animation to play when the items
     * is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based
     * on material.
     */
    @Override
    public int getItemEnchantability()
    {
        return 1;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStack2)
    {
        return this.toolMaterial.getToolCraftingMaterial() == itemStack2.itemID ? true : super.getIsRepairable(itemStack, itemStack2);
    }
}
