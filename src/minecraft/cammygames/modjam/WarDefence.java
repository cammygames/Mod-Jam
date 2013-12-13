package cammygames.modjam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cammygames.modjam.blocks.BlockBW;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="WarDefence", name="WarDefence : Core", version="v0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class WarDefence 
{

	public static final int BLOCK_ID_PREFIX = 3000;
	public static String name = "WarDefence:";	
	
	public static Block BombWall;
    public static Block BombWall2;
    public static Block BombWall3;
    public static Block concrete;
    public static Block shatterGlass;
    public static Block barbedwire;
	

    @EventHandler
    public void load(FMLInitializationEvent event) 
    {
    	 BombWall = new BlockBW(BLOCK_ID_PREFIX + 1, Material.rock).setHardness(15).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("bPWall");
    	 BombWall2 = new BlockBW(BLOCK_ID_PREFIX + 2, Material.rock).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("bP2Wall");
    	 BombWall3 = new BlockBW(BLOCK_ID_PREFIX + 3, Material.rock).setHardness(85).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("bP3Wall");
         shatterGlass = new BlockSGlass(BLOCK_ID_PREFIX + 4, Material.glass, false).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("shatterGlass");
         barbedwire = new BlockBarbedwire(BLOCK_ID_PREFIX + 5, Material.iron).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("barbedwire");
         concrete = new BlockBP(BLOCK_ID_PREFIX + 6, Material.rock).setHardness(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("concrete");
    	
    }


}


