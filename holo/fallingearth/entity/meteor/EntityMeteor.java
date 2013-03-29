package holo.fallingearth.entity.meteor;

import holo.fallingearth.entity.particle.EntityMeteorFlame;
import holo.fallingearth.util.handler.MeteorLandHandler;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMeteor extends EntityWeatherEffect
{
    private double direction;
	private int size;

	public EntityMeteor(World par1World, double par2, double par6)
    {
        super(par1World);
        this.setLocationAndAngles(par2, 250, par6, 0.0F, 0.0F);
        this.direction = this.rand.nextInt(180) * Math.PI;
        if (!par1World.isRemote && par1World.doChunksNearChunkExist(MathHelper.floor_double(par2), 250, MathHelper.floor_double(par6), 10))
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

        if (this.onGround)
        {
        	this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.size, true);
        	MeteorLandHandler.land(this.worldObj, this.posX, this.posY, this.posZ, this.size);
        	this.setDead();
        }
        else
        {
        	EntityMeteorFlame var20 = new EntityMeteorFlame(this.worldObj, this.posX, this.posY, this.posZ, 0.25*this.rand.nextGaussian(), 0.25*this.rand.nextGaussian(), 0.25*this.rand.nextGaussian());
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
        }
    }

    protected void entityInit() {}

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {}

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {}

    @SideOnly(Side.CLIENT)

    /**
     * Checks using a Vec3d to determine if this entity is within range of that vector to be rendered. Args: vec3D
     */
    public boolean isInRangeToRenderVec3D(Vec3 par1Vec3)
    {
        return true;
    }
}
