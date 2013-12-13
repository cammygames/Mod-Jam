package cammygames.modjam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cammygames.modjam.blocks.BlockBW;
import cammygames.modjam.blocks.BlockBardbedWire;
import cammygames.modjam.blocks.tabs.WDBlocks;
import cammygames.modjam.blocks.tabs.WDItems;
import cammygames.modjam.items.WarDefenceItems;
import cammygames.modjam.items.WarDefenceKnife;
import cammygames.modjam.util.ToolTips_Helper;
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

	public static CreativeTabs WarDefenceItems = new WDItems(CreativeTabs.getNextID(), "WarDefence: Items");
	public static CreativeTabs WarDefenceBlocks = new WDBlocks(CreativeTabs.getNextID(), "WarDefence: Blocks");
	
	public static final int BLOCK_ID_PREFIX = 3000;
	public static final int ITEM_ID_PREFIX = 20000;
	
	public static String name = "WarDefence:";	
	
	public static Block BombWall;
    public static Block BombWall2;
    public static Block BombWall3;
    public static Block concrete;
    public static Block shatterGlass;
    public static Block barbedwire;
	

	public static Item Knife;
	public static Item Gel;
	public static Item KevlarFiber;
	public static Item camosegment;
	public static Item KevlarPlate;
    
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
		 GameRegistry.registerBlock(BombWall, ToolTips_Helper.class, "BombWall");
		 
		 LanguageRegistry.addName(BombWall2, "Bomb Proof Wall");
		 GameRegistry.registerBlock(BombWall2, ToolTips_Helper.class, " BombWall2");
		 
		 LanguageRegistry.addName(BombWall3, "Bomb Proof Wall");
		 GameRegistry.registerBlock(BombWall3, ToolTips_Helper.class, " BombWall3");
		 
		 LanguageRegistry.addName(concrete, "Concrete");
		 GameRegistry.registerBlock(concrete, ToolTips_Helper.class, "concrete");         
		 
		 LanguageRegistry.addName(barbedwire, "Barbedwire");
		 GameRegistry.registerBlock(barbedwire, ToolTips_Helper.class, "barbedwire");
         
         //--------------------------------------------\\
         //					ITEMS					  \\
         //--------------------------------------------\\
			Gel = new WarDefenceItems(ITEM_ID_PREFIX).setUnlocalizedName("Gel").setTextureName("WarDefence:Jelly");    
			camosegment = new WarDefenceItems(ITEM_ID_PREFIX + 1).setUnlocalizedName("camosegment").setTextureName("WarDefence:camosegment");
			Knife = new WarDefenceKnife(ITEM_ID_PREFIX + 2,  WarDefenceKnife.EnumToolMaterialKnife).setUnlocalizedName("knife").setTextureName("WarDefence:knife");
			KevlarPlate = new WarDefenceItems(ITEM_ID_PREFIX + 31).setUnlocalizedName("KevlarPlate").setTextureName("WarDefence:KevlarPlate");
			KevlarFiber = new WarDefenceItems(ITEM_ID_PREFIX + 32).setUnlocalizedName("KevlarFiber").setTextureName("WarDefence:Kevlar");
     
	        LanguageRegistry.addName(Gel, "Ballistics Gel");
	        LanguageRegistry.addName(Knife, "Knife");
	    	LanguageRegistry.addName(camosegment, "Camo Segment");   
	    	LanguageRegistry.addName(KevlarPlate, "Kevlar Plate");   
	    	LanguageRegistry.addName(KevlarFiber, "Kevlar Fiber");  
			
         //--------------------------------------------\\
         //				    CRAFTING				   \\
         //--------------------------------------------\\
         
    }


}


