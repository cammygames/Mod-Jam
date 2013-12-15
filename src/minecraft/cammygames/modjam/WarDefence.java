package cammygames.modjam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cammygames.modjam.armor.Armor;
import cammygames.modjam.blocks.BlockBardbedWire;
import cammygames.modjam.blocks.BlockSGlass;
import cammygames.modjam.blocks.BlockWD;
import cammygames.modjam.blocks.tabs.WDBlocks;
import cammygames.modjam.blocks.tabs.WDItems;
import cammygames.modjam.items.WDFlameThrower;
import cammygames.modjam.items.WDGasThrower;
import cammygames.modjam.items.WarDefenceItems;
import cammygames.modjam.items.WarDefenceKnife;
import cammygames.modjam.util.ToolTips_Helper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="WarDefence", name="WarDefence : WarDefence", version="v0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class WarDefence 
{


    @Instance("WarDefence")
    public static WarDefence instance;
	
	@SidedProxy(clientSide="cammygames.modjam.ClientProxy", serverSide="cammygames.modjam.ServerProxy")
	public static ServerProxy proxy;
	
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
    public static Block rawShatterGlass;
    public static Block barbedwire;

	public static Item Knife;
	public static Item flameThrower;
	public static Item gasThrower;
	public static Item Gel;
	public static Item KevlarFiber;
	public static Item camosegment;
	public static Item KevlarPlate;
	public static Item compGas;
    
    @EventHandler
    public void load(FMLInitializationEvent event) 
    {
        //--------------------------------------------\\
        //					BLOCKS					  \\
        //--------------------------------------------\\
	    	
		 BombWall = new BlockWD(BLOCK_ID_PREFIX + 1, Material.rock).setHardness(15).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BombWall");
		 BombWall2 = new BlockWD(BLOCK_ID_PREFIX + 2, Material.rock).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BombWall2");
		 BombWall3 = new BlockWD(BLOCK_ID_PREFIX + 3, Material.rock).setHardness(85).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BombWall3");
		 shatterGlass = new BlockSGlass(BLOCK_ID_PREFIX + 4, Material.glass, false).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("shatterGlass");
		 barbedwire = new BlockBardbedWire(BLOCK_ID_PREFIX + 5, Material.iron).setHardness(50).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("barbedwire");
		 concrete = new BlockWD(BLOCK_ID_PREFIX + 6, Material.rock).setHardness(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("concrete");
		 rawShatterGlass = new BlockSGlass(BLOCK_ID_PREFIX + 7, Material.rock,false).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("rawShatterGlass");
		 
		 LanguageRegistry.addName(shatterGlass,"Re-enforced Glass");
		 GameRegistry.registerBlock(shatterGlass, ToolTips_Helper.class, "shatterGlass");
		 
		 LanguageRegistry.addName(rawShatterGlass,"Raw Re-enforced Glass");
		 GameRegistry.registerBlock(rawShatterGlass, ToolTips_Helper.class, "rawShatterGlass");
		 
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
			KevlarPlate = new WarDefenceItems(ITEM_ID_PREFIX + 3).setUnlocalizedName("KevlarPlate").setTextureName("WarDefence:KevlarPlate");
			KevlarFiber = new WarDefenceItems(ITEM_ID_PREFIX + 4).setUnlocalizedName("KevlarFiber").setTextureName("WarDefence:Kevlar");
			flameThrower = new WDFlameThrower(ITEM_ID_PREFIX + 5).setUnlocalizedName("flameThrower").setTextureName("WarDefence:flameThrower");
			gasThrower = new WDGasThrower(ITEM_ID_PREFIX + 27).setUnlocalizedName("gasThrower").setTextureName("WarDefence:flameThrower");
			compGas = new WarDefenceItems(ITEM_ID_PREFIX + 28).setUnlocalizedName("compGas").setTextureName("WarDefence:compGas").setMaxStackSize(1);    
			
			
	        LanguageRegistry.addName(Gel, "Ballistics Gel");
	        LanguageRegistry.addName(Knife, "Knife");
	    	LanguageRegistry.addName(camosegment, "Camo Segment");   
	    	LanguageRegistry.addName(compGas, "Compressed Gas"); 
	    	LanguageRegistry.addName(KevlarPlate, "Kevlar Plate");   
	    	LanguageRegistry.addName(KevlarFiber, "Kevlar Fiber");  
	    	LanguageRegistry.addName(flameThrower, "Flame Thrower"); 
	    	LanguageRegistry.addName(gasThrower, "Entity Blaster"); 
	    	
         //--------------------------------------------\\
         //				    CRAFTING				   \\
         //--------------------------------------------\\
         
	    	GameRegistry.addRecipe(new ItemStack(flameThrower, 1), new Object[] { "R  ", "CBC", "ACA", Character.valueOf('A'), Item.ingotIron, Character.valueOf('C'), KevlarFiber, Character.valueOf('R'), Item.diamond , Character.valueOf('B'), Block.blockRedstone}); 
	    	
	    	GameRegistry.addRecipe(new ItemStack(barbedwire, 12), new Object[] { "AAA", "BBB", "AAA", Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.flint });
	    	GameRegistry.addRecipe(new ItemStack(Gel, 1), new Object[] { "TT ", "TT ", Character.valueOf('T'), Item.slimeBall });
	    	GameRegistry.addRecipe(new ItemStack(KevlarFiber, 1), new Object[] {"TGT", "GTG ", "TGT", Character.valueOf('T'), Block.fenceIron, Character.valueOf('G'), WarDefence.Gel });
	    	GameRegistry.addRecipe(new ItemStack(Knife, 1), new Object[] { " T ", "ABA", " A ", Character.valueOf('T'), Item.stick, Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.emerald });
	        GameRegistry.addRecipe(new ItemStack(camosegment, 1), new Object[] { "AAA", "ABA", "AAA", Character.valueOf('A'), Block.leaves, Character.valueOf('B'), Item.stick });
	        
	    	
	        GameRegistry.addRecipe(new ItemStack(KevlarPlate, 1), new Object[] { "ACA", "CBC", "ACA", Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Gel, Character.valueOf('C'), Item.diamond }); 
	        
	        GameRegistry.addRecipe(new ItemStack(shatterGlass,16), "xxx", "xyx", "xxx",'x', Block.glass, 'y', BombWall);
	        GameRegistry.addSmelting(rawShatterGlass.blockID, new ItemStack(shatterGlass,1), 0);
	        GameRegistry.addRecipe(new ItemStack(concrete,6), "xxx", "xyx", "xxx",'x', Block.stone, 'y', Block.gravel);
	        GameRegistry.addRecipe(new ItemStack(BombWall,4), "xxx", "xyx", "xxx",'x', Item.ingotIron, 'y', concrete);
	        GameRegistry.addRecipe(new ItemStack(BombWall2,4), "xxx", "dyd", "xxx",'x', Block.fenceIron, 'y', BombWall,'d', Block.stone);
	        GameRegistry.addRecipe(new ItemStack(BombWall3,4), "xdx", "gyg", "xdx",'x', Block.fenceIron, 'y', BombWall2, 'g', Item.ingotGold, 'd', Item.diamond);
   
	        GameRegistry.addRecipe(new ItemStack(Armor.GhillieBody, 1), new Object[] { "A A", "ABA", "AAA", Character.valueOf('A'), WarDefence.camosegment, Character.valueOf('B'), WarDefence.KevlarFiber });
	        GameRegistry.addRecipe(new ItemStack(Armor.GhillieHelmet, 1), new Object[] { "AAA", "ABA", Character.valueOf('A'), WarDefence.camosegment, Character.valueOf('B'), WarDefence.KevlarFiber });
	        GameRegistry.addRecipe(new ItemStack(Armor.GhillieLegs, 1), new Object[] { "AAA", "ABA", "A A", Character.valueOf('A'), WarDefence.camosegment, Character.valueOf('B'), WarDefence.KevlarFiber }); 
	        GameRegistry.addRecipe(new ItemStack(Armor.GhillieBoots, 1), new Object[] { "ABA", "A A", Character.valueOf('A'), WarDefence.camosegment, Character.valueOf('B'), WarDefence.KevlarFiber }); 
    
	        GameRegistry.addRecipe(new ItemStack(Armor.SpyHat, 1), new Object[] { "AAA", "ABA", Character.valueOf('A'), Block.cloth, Character.valueOf('B'), WarDefence.KevlarFiber }); 
	        GameRegistry.addRecipe(new ItemStack(Armor.SpyBody, 1), new Object[] { "A A", "ABA", "AAA", Character.valueOf('A'), Block.cloth, Character.valueOf('B'), WarDefence.KevlarFiber }); 
	        GameRegistry.addRecipe(new ItemStack(Armor.SpyLegs, 1), new Object[] { "AAA", "ABA", "A A", Character.valueOf('A'), Block.cloth, Character.valueOf('B'), WarDefence.KevlarFiber });
	        GameRegistry.addRecipe(new ItemStack(Armor.SpyBoots, 1), new Object[] { "A A", "ABA", Character.valueOf('A'), Block.cloth, Character.valueOf('B'), WarDefence.KevlarFiber });
	        
	        GameRegistry.addRecipe(new ItemStack(Armor.JuggernautHelmet, 1), new Object[] { "AAA", "A A", Character.valueOf('A'),WarDefence.KevlarPlate });
	        GameRegistry.addRecipe(new ItemStack(Armor.JuggernautBodyArmor, 1), new Object[] { "A A", "AAA", "AAA", Character.valueOf('A'),WarDefence.KevlarPlate });
	        GameRegistry.addRecipe(new ItemStack(Armor.JuggernautLegs, 1), new Object[] { "AAA", "A A", "A A", Character.valueOf('A'),WarDefence.KevlarPlate });
	        GameRegistry.addRecipe(new ItemStack(Armor.JuggernautBoots, 1), new Object[] { "A A", "A A", Character.valueOf('A'),WarDefence.KevlarPlate });
    
	        GameRegistry.addRecipe(new ItemStack(Armor.ScubaHelmet, 1), new Object[] { "BBB", "BAB", "BBB", Character.valueOf('A'), Block.glass, Character.valueOf('B'), Block.cloth });
	        GameRegistry.addRecipe(new ItemStack(Armor.ScubaBody, 1), new Object[] { "B B", "BBB", "BBB", Character.valueOf('B'), Block.cloth });
	        GameRegistry.addRecipe(new ItemStack(Armor.ScubaLegs, 1), new Object[] { "BBB", "B B", "B B", Character.valueOf('B'), Block.cloth });
	        GameRegistry.addRecipe(new ItemStack(Armor.ScubaBoots, 1), new Object[] { "B B", "B B", Character.valueOf('B'), Block.cloth });
    
    }


}


