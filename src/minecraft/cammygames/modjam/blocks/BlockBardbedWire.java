package cammygames.modjam.blocks;

import cammygames.modjam.WarDefence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBardbedWire extends Block
{
    public BlockBardbedWire(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.setCreativeTab(WarDefence.WarDefenceBlocks);
    }

    /**
     * Triggered whenever an entity collides with this block
     */
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        entity.setInWeb();
        entity.attackEntityFrom(DamageSource.cactus, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("WarDefence:barbedwire");
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    public int getRenderType()
    {
        return 1;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
