package cammygames.modjam.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Custom_Armor extends ItemArmor
{
	private EntityPlayer Eplayer;
	 
	public Custom_Armor(int par1, EnumArmorMaterial par2EnumArmorMaterial,int par3, int par4) 
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Armor.WarDefenceArmor);
	}
	
	
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,int layer) 
	{
		if (stack.itemID == Armor.SantaHelmet.itemID || stack.itemID == Armor.SantaBody.itemID || stack.itemID == Armor.SantaBoots.itemID) 
		{
			return "wardefence:textures/modles/Armor/santa_1.png";
		}
		if (stack.itemID == Armor.SantaLegs.itemID) 
		{
			return "wardefence:textures/modles/Armor/santa_2.png";
		} 
		
		else { return null; }
	}
	
}
