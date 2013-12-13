package cammygames.modjam.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import cammygames.modjam.WarDefence;
import cammygames.modjam.blocks.tabs.WDArmour;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="WarDefenceArmor", name="WarDefence : Armor", version="v0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Armor
{
	public static CreativeTabs WarDefenceArmor = new WDArmour(CreativeTabs.getNextID(), "WarDefence: Armor");
	
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
    	SantaHelmet = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 6, EnumArmorMaterial.IRON, 4, 0).setUnlocalizedName("SantaHelmet").setTextureName("WarDefence:ScubaHelmet");
    	SantaBody = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 7, EnumArmorMaterial.IRON, 4, 1).setUnlocalizedName("SantaBody").setTextureName("WarDefence:ScubaBody");
    	SantaLegs = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 8, EnumArmorMaterial.IRON, 4, 2).setUnlocalizedName("SantaLegs").setTextureName("WarDefence:ScubaLegs");
    	SantaBoots = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 9, EnumArmorMaterial.IRON, 4, 3).setUnlocalizedName("SantaBoots").setTextureName("WarDefence:ScubaBoots");
    	
    	ScubaHelmet = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 10, EnumArmorMaterial.IRON, 4, 0).setUnlocalizedName("ScubaHelmet").setTextureName("WarDefence:ScubaHelmet");
    	ScubaBody = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 11, EnumArmorMaterial.IRON, 4, 1).setUnlocalizedName("ScubaBody").setTextureName("WarDefence:ScubaBody");
    	ScubaLegs = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 12, EnumArmorMaterial.IRON, 4, 2).setUnlocalizedName("ScubaLegs").setTextureName("WarDefence:ScubaLegs");
    	ScubaBoots = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 13, EnumArmorMaterial.IRON, 4, 3).setUnlocalizedName("ScubaBoots").setTextureName("WarDefence:ScubaBoots");
    }
}
