package cammygames.modjam.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
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
    public ItemStack onItemRightClick(ItemStack ItemStack, World world, EntityPlayer par3EntityPlayer)
    {
    	for(int countparticles = 0; countparticles <= 10; ++countparticles)
    	{
    	        world.spawnParticle("smoke", par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 0.0D, 0.0D, 0.0D); //spawns the particle "smoke"
    	}

    	par3EntityPlayer.setItemInUse(ItemStack, this.getMaxItemUseDuration(ItemStack)); //Use it like a Sword: Block attacks
    	return ItemStack; //Return the expected ItemStack.
    }
	
}
