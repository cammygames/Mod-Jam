package cammygames.modjam.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
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
		
		if (player.inventory.hasItem(Item.fireballCharge.itemID)) 
    	{

			World world = player.worldObj;
			ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
	        MinecraftForge.EVENT_BUS.post(event);
	        if (event.isCanceled()) 
	        {
	            return;
	        }
			
			double yaw = Math.toRadians(player.rotationYaw);
			double pitch = Math.toRadians(player.rotationPitch);
	
			double xDirection = -Math.sin(yaw) * Math.cos(pitch);
			double yDirection = -Math.sin(pitch);
			double zDirection = Math.cos(yaw) * Math.cos(pitch);
	
			double x = player.posX;
			double y = player.posY-1;
			double z = player.posZ;
	
			FireBall fireball = new FireBall(world, x, y, z, xDirection, yDirection, zDirection);		

			player.inventory.consumeInventoryItem(Item.fireballCharge.itemID);
	    	world.spawnParticle("smoke", player.posX+1, player.posY-1, player.posZ, 0.0D, 0.0D, 0.0D);
			world.spawnEntityInWorld(fireball);		
			
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
    	}
    		 
	}	
}
