package cammygames.modjam.armor;

import cammygames.modjam.WarDefence;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
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

    public Custom_Armor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
    {
        super(par1, par2EnumArmorMaterial, par3, par4);
        this.setCreativeTab(Armor.WarDefenceArmor);
    }

    @Override
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
    {
        if (stack.itemID == Armor.JuggernautHelmet.itemID || stack.itemID == Armor.JuggernautBodyArmor.itemID || stack.itemID == Armor.JuggernautBoots.itemID || stack.itemID == Armor.JuggernautLegs.itemID)
        {
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 1, 3));
        }

        ItemStack boots = player.getCurrentArmor(0);
        ItemStack legs = player.getCurrentArmor(1);
        ItemStack chest = player.getCurrentArmor(2);
        ItemStack helmet = player.getCurrentArmor(3);

        if (boots != null && legs != null && chest != null && helmet != null)
        {
            if (boots.getItem() == Armor.ScubaBoots && legs.getItem() == Armor.ScubaLegs && chest.getItem() == Armor.ScubaBody && helmet.getItem() == Armor.ScubaHelmet)
            {
                player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1, 3));
            }

            if (boots.getItem() == Armor.GhillieBoots && legs.getItem() == Armor.GhillieLegs && chest.getItem() == Armor.GhillieBody && helmet.getItem() == Armor.GhillieHelmet)
            {
                if (player.isSneaking())
                {
                    player.setInvisible(true);
                }
                else
                {
                    player.setInvisible(false);
                }
            }

            if (boots.getItem() == Armor.SpyBoots && legs.getItem() == Armor.SpyLegs && chest.getItem() == Armor.SpyBody && helmet.getItem() == Armor.SpyHat)
            {
                if (player.isSneaking())
                {
                    player.setInvisible(true);
                }
                else
                {
                    player.setInvisible(false);
                }
            }
        }
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
    {
        if (stack.itemID == Armor.SantaHelmet.itemID || stack.itemID == Armor.SantaBody.itemID || stack.itemID == Armor.SantaBoots.itemID)
        {
            return "wardefence:textures/modles/armor/santa_1.png";
        }

        if (stack.itemID == Armor.SantaLegs.itemID)
        {
            return "wardefence:textures/modles/armor/santa_2.png";
        }

        if (stack.itemID == Armor.ScubaHelmet.itemID || stack.itemID == Armor.ScubaBody.itemID || stack.itemID == Armor.ScubaBoots.itemID)
        {
            return "wardefence:textures/modles/armor/scuba_1.png";
        }

        if (stack.itemID == Armor.ScubaLegs.itemID)
        {
            return "wardefence:textures/modles/armor/scuba_2.png";
        }

        if (stack.itemID == Armor.SpyHat.itemID || stack.itemID == Armor.SpyBody.itemID || stack.itemID == Armor.SpyBoots.itemID)
        {
            return "wardefence:textures/modles/armor/spy_1.png";
        }

        if (stack.itemID == Armor.SpyLegs.itemID)
        {
            return "wardefence:textures/modles/armor/spy_2.png";
        }

        if (stack.itemID == Armor.GhillieHelmet.itemID || stack.itemID == Armor.GhillieBody.itemID || stack.itemID == Armor.GhillieBoots.itemID)
        {
            return "wardefence:textures/modles/armor/ghillie_1.png";
        }

        if (stack.itemID == Armor.GhillieLegs.itemID)
        {
            return "wardefence:textures/modles/armor/ghillie_2.png";
        }

        if (stack.itemID == Armor.JuggernautHelmet.itemID || stack.itemID == Armor.JuggernautBodyArmor.itemID || stack.itemID == Armor.JuggernautBoots.itemID)
        {
            return "WarDefence:textures/modles/armor/jug_1.png";
        }

        if (stack.itemID == Armor.JuggernautLegs.itemID)
        {
            return "WarDefence:textures/modles/armor/jug_2.png";
        }
        else
        {
            return null;
        }
    }
}
