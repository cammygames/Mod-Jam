package cammygames.modjam.entity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class FireBall extends EntitySmallFireball
{
    private double damage = 5;
    protected static Random itemRand = new Random();
    /**
     * The amount of knockback an arrow applies when it hits a mob.
     */
    
    private int knockbackStrength;
    private boolean isExplosive;
    public int explosionPower = 1;

    public FireBall(World world, double x, double y, double z, double xDirection, double yDirection, double zDirection) 
    {
        super(world, x, y, z, xDirection, yDirection, zDirection);


        double d6 = (double) MathHelper.sqrt_double(xDirection * xDirection + yDirection * yDirection + zDirection * zDirection);
        this.accelerationX = xDirection / d6 * 0.05D;
        this.accelerationY = yDirection / d6 * 0.05D;
        this.accelerationZ = zDirection / d6 * 0.05D;
    }

    /**
     * Return the motion factor for this projectile. The factor is multiplied by
     * the original motion.
     */
    @Override
    protected float getMotionFactor() {
        return 1;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getDamage() {
        return this.damage;
    }

    /**
     * Sets the amount of knockback the fireball applies when it hits a mob.
     */
    public void setKnockbackStrength(int strength) {
        this.knockbackStrength = strength;
    }

    public void setExplosive(boolean isExplosive) {
        this.isExplosive = isExplosive;
    }

    /**
     * Called when fireball hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition movingObjectPosition) 
    {
            int x = movingObjectPosition.blockX;
            int y = movingObjectPosition.blockY;
            int z = movingObjectPosition.blockZ;

            switch (movingObjectPosition.sideHit) 
            {
                case 0:
                    --y;
                    break;
                case 1:
                    ++y;
                    break;
                case 2:
                    --z;
                    break;
                case 3:
                    ++z;
                    break;
                case 4:
                    --x;
                    break;
                case 5:
                    ++x;
            }

            if (this.worldObj.isAirBlock(x, y, z)) 
            {
            	this.worldObj.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
            	this.worldObj.setBlock(x, y, z, Block.fire.blockID);
            }
    }

    /**
     * Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setDouble("damage", this.damage);
        nbt.setInteger("ExplosionPower", this.explosionPower);
    }

    /**
     * Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);

        if (nbt.hasKey("damage")) {
            this.damage = nbt.getDouble("damage");
        }

        if (nbt.hasKey("ExplosionPower")) {
            this.explosionPower = nbt.getInteger("ExplosionPower");
        }
    }
}
