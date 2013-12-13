package cammygames.modjam.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cammygames.modjam.WarDefence;

public class WDFlameThrower  extends Item
{
	public WDFlameThrower(int par1)
	{
		super(par1);
		this.setCreativeTab(WarDefence.WarDefenceItems);
	}

	public boolean lavaBucket = false;
	private int countparticles = 0;
	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		int direction = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		private EntityFireball;
		
    	if (par2EntityPlayer.inventory.hasItem(Item.bucketLava.itemID)) 
    	{
    		/*Consume a fire ball*/
    		par2EntityPlayer.inventory.consumeInventoryItem(Item.bucketLava.itemID);
    		
    		lavaBucket = true;
    		
    		while (lavaBucket)
    		{
    			for(countparticles = 0; countparticles <= 10; ++countparticles) 
    			{
    				world.spawnParticle("smoke", par2EntityPlayer.posX, par2EntityPlayer.posY, par2EntityPlayer.posZ, 0.0D, 0.0D, 0.0D);
					world.spawnEntityInWorld(EntityFireball);
				}
    		}
    		 
    	}
		
		return true;
	}
		
}
