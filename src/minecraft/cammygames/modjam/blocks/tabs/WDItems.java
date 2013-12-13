package cammygames.modjam.blocks.tabs;

import cammygames.modjam.WarDefence;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WDItems extends CreativeTabs
{
	   public WDItems(int par1, String par2Str)
	   {
		   super(par1, par2Str);
	   }
	 
	   @SideOnly(Side.CLIENT)
	   public int getTabIconItemIndex()
	   {
		   return WarDefence.barbedwire.blockID;
	   }
	 
	   public String getTranslatedTabLabel()
	   {
		   return "WarDefence: Items";
	   }
}
