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
    private double direction;
	private int size;
	
	private static final int yHeight = 72;
	
	public EntityMeteor(World par1World)
    {
        super(par1World);
    }
	
	public EntityMeteor(World par1World, double par2, double par6)
    {
        super(par1World);
        this.setLocationAndAngles(par2, yHeight, par6, 0.0F, 0.0F);
        this.direction = this.rand.nextInt(180) * Math.PI;
        if (!par1World.isRemote && par1World.doChunksNearChunkExist(MathHelper.floor_double(par2), yHeight, MathHelper.floor_double(par6), 10))
        {
            par1World.getClosestPlayerToEntity(this, 200);
        }
    }
	
	public EntityMeteor(World par1World, double par2, double par6, int s)
	{
		this(par1World, par2, par6);
		this.size = s;
	}

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.rand.nextInt(50) == 0)
        {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 0.8F, 0.5F + this.rand.nextFloat() * 0.2F);
        }
        
        this.motionX = Math.cos(this.direction) * 0.02 / this.size;
        this.motionY = Math.sin(this.direction) * 0.02 / this.size;
        
        //EntityMeteorFlame var20 = new EntityMeteorFlame(this.worldObj, this.posX, this.posY, this.posZ, 0.25*this.rand.nextGaussian(), 0.25*this.rand.nextGaussian(), 0.25*this.rand.nextGaussian());
        //FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Checks using a Vec3d to determine if this entity is within range of that vector to be rendered. Args: vec3D
     */
    public boolean isInRangeToRenderVec3D(Vec3 par1Vec3)
    {
        return true;
    }

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravityVelocity()
    {
        return (float) (0.01 / this.size);
    }

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) 
	{
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.size, true);
    	MeteorLandHandler.land(this.worldObj, this.posX, this.posY, this.posZ, this.size);
    	this.setDead();
		
	}
}
