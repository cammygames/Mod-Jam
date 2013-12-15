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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "WarDefenceArmor", name = "WarDefence : Armor", version = "v0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Armor
{
    public static CreativeTabs WarDefenceArmor = new WDArmour(CreativeTabs.getNextID(), "WarDefence:item. Armor");

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
        SantaHelmet = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 6, EnumArmorMaterial.CLOTH, 4, 0).setUnlocalizedName("SantaHelmet").setTextureName("WarDefence:item.ScubaHelmet");
        SantaBody = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 7, EnumArmorMaterial.CLOTH, 4, 1).setUnlocalizedName("SantaBody").setTextureName("WarDefence:item.ScubaBody");
        SantaLegs = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 8, EnumArmorMaterial.CLOTH, 4, 2).setUnlocalizedName("SantaLegs").setTextureName("WarDefence:item.ScubaLegs");
        SantaBoots = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 9, EnumArmorMaterial.CLOTH, 4, 3).setUnlocalizedName("SantaBoots").setTextureName("WarDefence:item.ScubaBoots");
        ScubaHelmet = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 10, EnumArmorMaterial.IRON, 4, 0).setUnlocalizedName("ScubaHelmet").setTextureName("WarDefence:item.ScubaHelmet");
        ScubaBody = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 11, EnumArmorMaterial.IRON, 4, 1).setUnlocalizedName("ScubaBody").setTextureName("WarDefence:item.ScubaBody");
        ScubaLegs = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 12, EnumArmorMaterial.IRON, 4, 2).setUnlocalizedName("ScubaLegs").setTextureName("WarDefence:item.ScubaLegs");
        ScubaBoots = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 13, EnumArmorMaterial.IRON, 4, 3).setUnlocalizedName("ScubaBoots").setTextureName("WarDefence:item.ScubaBoots");
        SpyHat = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 14, EnumArmorMaterial.CLOTH, 4, 0).setUnlocalizedName("SpyHat").setTextureName("WarDefence:item.SpyHat");
        SpyBody = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 15, EnumArmorMaterial.CLOTH, 4, 1).setUnlocalizedName("SpyBody").setTextureName("WarDefence:item.SpyBody");
        SpyLegs = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 16, EnumArmorMaterial.CLOTH, 4, 2).setUnlocalizedName("SpyLegs").setTextureName("WarDefence:item.SpyLegs");
        SpyBoots = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 17, EnumArmorMaterial.CLOTH, 4, 3).setUnlocalizedName("SpyBoots").setTextureName("WarDefence:item.SpyBoots");
        GhillieHelmet = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 18, EnumArmorMaterial.CLOTH, 4, 0).setUnlocalizedName("GhillieHelmet").setTextureName("WarDefence:item.GhillieHelmet");
        GhillieBody = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 29, EnumArmorMaterial.CLOTH, 4, 1).setUnlocalizedName("GhillieBody").setTextureName("WarDefence:item.GhillieBody");
        GhillieLegs = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 20, EnumArmorMaterial.CLOTH, 4, 2).setUnlocalizedName("GhillieLegs").setTextureName("WarDefence:item.GhillieLegs");
        GhillieBoots = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 22, EnumArmorMaterial.CLOTH, 4, 3).setUnlocalizedName("GhillieBoots").setTextureName("WarDefence:item.GhillieBoots");
        JuggernautHelmet = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 23, EnumArmorMaterial.IRON, 4, 0).setUnlocalizedName("JuggernautHelmet").setTextureName("WarDefence:item.JuggernautHelmet");
        JuggernautBodyArmor = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 24, EnumArmorMaterial.IRON, 4, 1).setUnlocalizedName("JuggernautBodyArmor").setTextureName("WarDefence:item.JuggernautBodyArmor");
        JuggernautLegs = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 25, EnumArmorMaterial.IRON, 4, 2).setUnlocalizedName("JuggernautLegs").setTextureName("WarDefence:item.JuggernautLegs");
        JuggernautBoots = new Custom_Armor(WarDefence.ITEM_ID_PREFIX + 26, EnumArmorMaterial.IRON, 4, 3).setUnlocalizedName("JuggernautBoots").setTextureName("WarDefence:item.Juggernautboots");
        
        LanguageRegistry.addName(ScubaHelmet, "Scuba Helmet");
        LanguageRegistry.addName(ScubaBody, "Scuba Body");
        LanguageRegistry.addName(ScubaLegs, "Scuba Legs");
        LanguageRegistry.addName(ScubaBoots, "Scuba Boots");
        LanguageRegistry.addName(SantaHelmet, "Santa Helmet");
        LanguageRegistry.addName(SantaBody, "Santa Body");
        LanguageRegistry.addName(SantaLegs, "Santa Legs");
        LanguageRegistry.addName(SantaBoots, "Santa Boots");
        LanguageRegistry.addName(SpyHat, "Spy Hat");
        LanguageRegistry.addName(SpyBody, "Spy Body");
        LanguageRegistry.addName(SpyLegs, "Spy Legs");
        LanguageRegistry.addName(SpyBoots, "Spy Boots");
        LanguageRegistry.addName(GhillieHelmet, "Ghillie Helmet");
        LanguageRegistry.addName(GhillieBody, "Ghillie Body");
        LanguageRegistry.addName(GhillieLegs, "Ghillie Legs");
        LanguageRegistry.addName(GhillieBoots, "Ghillie Boots");
        LanguageRegistry.addName(JuggernautHelmet, "Juggernaut Helmet");
        LanguageRegistry.addName(JuggernautBodyArmor, "Juggernaut Body Armor");
        LanguageRegistry.addName(JuggernautLegs, "Juggernaut Legs");
        LanguageRegistry.addName(JuggernautBoots, "Juggernaut Boots");
    }
}
