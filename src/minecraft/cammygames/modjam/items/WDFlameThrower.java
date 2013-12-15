package cammygames.modjam.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cammygames.modjam.WarDefence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WDFlameThrower  extends Item
{
	public WDFlameThrower(int par1)
	{
		super(par1);
		this.setCreativeTab(WarDefence.WarDefenceItems);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("Burn Baby Burn !");
		list.add("Uses Fire Charges");
	}
	
	public static Icon particleIcon;
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("WarDefence:flameThrower");
        particleIcon = iconRegister.registerIcon("WarDefence:flames");
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
			double y = player.posY-0.30;
			double z = player.posZ-0.1;
	
			EntitySmallFireball fireball = new EntitySmallFireball(world, x, y, z, xDirection, yDirection, zDirection);		
			
			player.inventory.consumeInventoryItem(Item.fireballCharge.itemID);
	    	world.spawnParticle("smoke", player.posX+1, player.posY-1, player.posZ-2, 0.0D, 0.0D, 0.0D);
			world.spawnEntityInWorld(fireball);		
    	}
    		 
	}	
}
