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
		
		particleScale = 6;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		particleScale = (1- (float)particleAge / particleMaxAge) *3;
	}
	
	@Override
	public int getFXLayer()
	{
		return 2;
	}
	
}
