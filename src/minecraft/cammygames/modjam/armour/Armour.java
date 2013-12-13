package cammygames.modjam.armour;

import cammygames.modjam.blocks.tabs.WDBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="WarDefenceArmour", name="WarDefence : Armour", version="v0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Armour
{
	public static CreativeTabs WarDefenceArmour = new WDArmour(CreativeTabs.getNextID(), "WarDefence: Armour");
	
	public static Item GhillieHelmet;
	public static Item GhillieBody;
	public static Item GhillieLegs;
	public static Item GhillieBoots;
	
	public static Item SpyHat;
	public static Item SpyBody;
	public static Item SpyLegs;
	public static Item SpyBoots;
	
	public static Item JuggernautHelmet;
	public static Item JuggernautBodyArmor;
	public static Item JuggernautLegs;
	public static Item JuggernautBoots;
	public static Item JuggernautPlate;
	
	public static Item ScubaHelmet;
	public static Item ScubaBody;
	public static Item ScubaLegs;
	public static Item ScubaBoots;
	
	public static Item SantaHelmet;
	public static Item SantaBody;
	public static Item SantaLegs;
	public static Item SantaBoots;
	
    @EventHandler
    public void load(FMLInitializationEvent event) 
    {
    	
    }
}
