package cammygames.modjam.items;

import cammygames.modjam.WarDefence;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WarDefenceKnife  extends ItemSword
{
    public static EnumToolMaterial EnumToolMaterialKnife = EnumHelper.addToolMaterial("HighPower", 0, 750, 0.2F, 8, 15);

    public WarDefenceKnife(int ItemID, EnumToolMaterial material)
    {
        super(ItemID, EnumToolMaterialKnife);
        this.setCreativeTab(WarDefence.WarDefenceItems);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon("WarDefence:knife");
    }
}
