package cammygames.modjam.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cammygames.modjam.WarDefence;
import cammygames.modjam.entity.FireBall;

public class WDFlameThrower  extends Item
{
	public WDFlameThrower(int par1)
	{
		super(par1);
		this.setCreativeTab(WarDefence.WarDefenceItems);
	}

	public boolean lavaBucket = false;
	private int countparticles = 0;

	 @Override
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer player, int count) 
	{
		World world = player.worldObj;
	    boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;
	
	    if (flag || player.inventory.hasItem(Item.fireballCharge.itemID)) {
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
	        if (power > 0) {
	            fireball.setDamage(fireball.getDamage() + (double) power * 0.5D + 0.5D);
	            if (power == 5) {
	                fireball.setExplosive(true);
	            }
	        }
	
	        int knockback = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);
	        if (knockback > 0) {
	            fireball.setKnockbackStrength(knockback);
	        }
	
	        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0) {
	            fireball.setFire(100);
	        }
	
	        itemStack.damageItem(1, player);
	        world.playAuxSFX(1009, (int) x, (int) y, (int) z, 0);
	
	        if (!flag) {
	            player.inventory.consumeInventoryItem(Item.fireballCharge.itemID);
	        }
	
	        if (!world.isRemote) {
	            world.spawnEntityInWorld(fireball);
	        }
	    }
	}
	
}
