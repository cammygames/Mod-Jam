package cammygames.modjam.util;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cammygames.modjam.WarDefence;

public class ToolTips_Helper extends ItemBlock
{
    public ToolTips_Helper(int par1)
    {
        super(par1);
    }

    public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
    {
        if (this.getBlockID() == WarDefence.BombWall.blockID)
        {
            list.add("Teir 1 Bomb Proof Wall");
        }

        if (this.getBlockID() == WarDefence.BombWall2.blockID)
        {
            list.add("Teir 2 Bomb Proof Wall");
        }

        if (this.getBlockID() == WarDefence.BombWall3.blockID)
        {
            list.add("Teir 3 Bomb Proof Wall");
        }

        if (this.getBlockID() == WarDefence.shatterGlass.blockID)
        {
            list.add("Blast Proof");
        }

        if (this.getBlockID() == WarDefence.rawShatterGlass.blockID)
        {
            list.add("Needs Heat To Become Tempered!");
        }

        if (this.getBlockID() == WarDefence.barbedwire.blockID)
        {
            list.add("Its Razer Sharp");
        }
    }
}
