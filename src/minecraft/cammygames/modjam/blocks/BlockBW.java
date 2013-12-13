package cammygames.modjam.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cammygames.modjam.WarDefence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBW extends Block
{

	public BlockBW(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(WarDefence.WarDefenceBlocks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(WarDefence.name+this.getUnlocalizedName());
	}
}
