package holo.fallingearth.entity.meteor;

import holo.fallingearth.entity.particle.EntityMeteorFlame;
import holo.fallingearth.util.handler.MeteorLandHandler;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMeteor extends EntityThrowable
{
	public int size = 1;

	public int innerRotation;
	private static final int yHeight = 128;
	
	public EntityMeteor(World par1World)
    {
        super(par1World);
    }
	
	public EntityMeteor(World par1World, double par2, double par6)
    {
        super(par1World);
        this.setLocationAndAngles(par2, yHeight, par6, 0.0F, 0.0F);
        this.innerRotation = this.rand.nextInt(100000);
    }
	
	public EntityMeteor(World par1World, double par2, double par6, int s)
	{
		this(par1World, par2, par6);
		this.size = s;
        this.setSize(s, s);
        this.motionX = this.rand.nextGaussian() - 0.5F;
        this.motionZ = this.rand.nextGaussian() - 0.5F;
        this.renderDistanceWeight = 12;
	}
	

    /**
     * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
     * length * 64 * renderDistanceWeight Args: distance
     */
    public boolean isInRangeToRenderDist(double par1)
    {
        return true;
    }

    /**
     * Makes the entity despawn if requirements are reached
     */
    protected void despawnEntity() {}

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        this.innerRotation++;
        
        this.motionX /= 0.99F;
        this.motionZ /= 0.99F;
        
        EntityMeteorFlame var20 = new EntityMeteorFlame(this.worldObj, this.posX, this.posY + 0.5, this.posZ, 0.125*this.rand.nextGaussian(), 0.25*this.rand.nextGaussian(), 0.125*this.rand.nextGaussian());
        FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
    }
    
    protected float getGravityVelocity()
    {
        return 0.01F;
    }

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) 
	{
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.size, true);
    	MeteorLandHandler.land(this.worldObj, this.posX, this.posY, this.posZ, this.size);
    	this.setDead();
		
	}
}
