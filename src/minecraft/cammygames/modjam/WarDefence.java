package cammygames.modjam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cammygames.modjam.blocks.BlockBW;
import cammygames.modjam.blocks.BlockBardbedWire;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
        //--------------------------------------------\\
        //					BLOCKS					  \\
        //--------------------------------------------\\
    	
    	 BombWall = new BlockBW(BLOCK_ID_PREFIX + 1, Material.rock).setHardness(15).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BombWall");
    	 BombWall2 = new BlockBW(BLOCK_ID_PREFIX + 2, Material.rock).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BombWall2");
    	 BombWall3 = new BlockBW(BLOCK_ID_PREFIX + 3, Material.rock).setHardness(85).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BombWall3");
         //shatterGlass = new BlockSGlass(BLOCK_ID_PREFIX + 4, Material.glass, false).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("shatterGlass");
         barbedwire = new BlockBardbedWire(BLOCK_ID_PREFIX + 5, Material.iron).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("barbedwire");
         concrete = new BlockBW(BLOCK_ID_PREFIX + 6, Material.rock).setHardness(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("concrete");
    	
         LanguageRegistry.addName(BombWall,"Bomb Proof Wall");
         GameRegistry.registerBlock(BombWall, "BombWall");
         
         LanguageRegistry.addName(BombWall2, "Bomb Proof Wall T2");
         GameRegistry.registerBlock(BombWall2, " BombWall2");
         
         LanguageRegistry.addName(BombWall3, "Bomb Proof Wall T3");
         GameRegistry.registerBlock(BombWall3, " BombWall3");
         
         LanguageRegistry.addName(concrete, "Concrete");
         GameRegistry.registerBlock(concrete, "concrete");         
         
         LanguageRegistry.addName(barbedwire, "Barbedwire");
         GameRegistry.registerBlock(barbedwire, "barbedwire");
         
         //--------------------------------------------\\
         //					ITEMS					  \\
         //--------------------------------------------\\
         
         
         //--------------------------------------------\\
         //				    CRAFTING				   \\
         //--------------------------------------------\\
         
    }


}


