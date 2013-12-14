package cammygames.modjam.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import cammygames.modjam.items.WDFlameThrower;

public class EntityFireWallFX extends EntityFX
{

	public EntityFireWallFX(World w, double x, double y,double z, double Mx, double My,double Mz) 
	{
		super(w, x, y, z, Mx, My, Mz);
		this.setParticleIcon(WDFlameThrower.particleIcon);
	}

}
