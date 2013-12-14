package cammygames.modjam.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cammygames.modjam.WarDefence;
import cammygames.modjam.entity.GasBall;

public class WDGasThrower  extends Item
{
	public WDGasThrower(int par1)
	{
		super(par1);
		this.setCreativeTab(WarDefence.WarDefenceItems);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("Burn Baby Burn !");
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
	
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(WarDefence.csGas.itemID)) 
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
		
		if (player.inventory.hasItem(WarDefence.csGas.itemID)) 
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
			double y = player.posY-0.30;
			double z = player.posZ-0.1;
	
			GasBall gasBall = new GasBall(world, x, y, z, xDirection, yDirection, zDirection);		
			gasBall.setExplosive(true);
			
			player.inventory.consumeInventoryItem(WarDefence.csGas.itemID);
			
			world.spawnParticle("smoke", player.posX+1, player.posY-1, player.posZ, 0.0D, 0.0D, 0.0D);
			world.spawnEntityInWorld(gasBall);		
    	}
    		 
	}	
}
