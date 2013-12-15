package cammygames.modjam.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cammygames.modjam.WarDefence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WDGasThrower extends ItemBow
{
	private boolean flag = false;
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{	
		if(!player.inventory.hasItem(WarDefence.compGas.itemID))
		{
			list.add("Requires Compressed Gas");
		}
		if(!player.isSneaking())
		{
			list.add("Sneak To Blow The Entity Further Away!");
		}
	}
	
	private Icon loadedIcon;
	private Icon emptyIcon;
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
    	this.loadedIcon = iconRegister.registerIcon("WarDefence:gasthrower");
    	this.emptyIcon = iconRegister.registerIcon("WarDefence:gasthrower-empty");
    	this.itemIcon = emptyIcon;
    }
	
	private final EnumToolMaterial toolMaterial;

    public WDGasThrower(int par1) 
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


    @Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target) 
    {
		if (!target.worldObj.isRemote) 
		{
			target.motionY = 2;

			if(player.inventory.hasItem(WarDefence.compGas.itemID))
			{
				this.itemIcon = loadedIcon;
				player.inventory.consumeInventoryItem(WarDefence.compGas.itemID);
				
				if (flag)
				{
					target.motionX = (target.posX - player.posZ) * 4;
					target.motionZ = (target.posZ - player.posX) * 4;
					System.out.println("SNEAKING");
				}
				else
				{
					target.motionX = (target.posX - player.posX) * 2;
					target.motionZ = (target.posZ - player.posZ) * 2;
				}
			}
			
			if(player.inventory.hasItem(WarDefence.compGas.itemID))
			{
				this.itemIcon = loadedIcon;	
			}
			else if(!player.inventory.hasItem(WarDefence.compGas.itemID))
			{
				this.itemIcon = emptyIcon;	
			}
			else 
			{
				
			}
			
			itemstack.setItemDamage(0);

		}
		else
		{
			itemstack.setItemDamage(itemstack.getItemDamage() + 1);
		}
			
		return false;	
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

        if (player.capabilities.isCreativeMode || player.inventory.hasItem(WarDefence.compGas.itemID))
        {
            player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }

        return itemStack;
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
