package cammygames.modjam.blocks.tabs;

import net.minecraft.creativetab.CreativeTabs;
import cammygames.modjam.armor.Armor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WDArmour extends CreativeTabs
{
    public WDArmour(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return Armor.SantaHelmet.itemID;
    }

    public String getTranslatedTabLabel()
    {
        return "WarDefence: Armour";
    }
}
