package cammygames.modjam.blocks;

import cammygames.modjam.WarDefence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSGlass extends Block
{

	public BlockSGlass(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(WarDefence.WarDefenceBlocks);
	}
	
}
