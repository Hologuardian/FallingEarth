package holo.fallingearth.entity.mob;

import holo.fallingearth.entity.ai.EntityAILeapToTarget;
import holo.fallingearth.entity.meteor.IEntityMeteorSpinning;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMeteorSpawn extends EntityMob implements IEntityMeteorSpinning
{

	private int innerRotation;

	public EntityMeteorSpawn(World par1World) {
		super(par1World);
		this.stepHeight = 3.1F;
		this.moveSpeed = 0.25F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 64.0F, 0, true));
		this.experienceValue = 80;
		this.isImmuneToFire = true;
	}
	
	public void onUpdate()
	{
		super.onUpdate();
		innerRotation++;
	}
	
	
	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float par1){}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public int getMaxHealth() 
	{
		return 35;
	}

	/**
	 * Returns the amount of damage a mob should deal.
	 */
	public int getAttackStrength(Entity par1Entity)
	{
		return 18;
	}

	@Override
	public int getInnerRotation() 
	{
		return innerRotation;
	}

	/**
	 * Checks to make sure the light is not too bright where the mob is spawning
	 */
	 protected boolean isValidLightLevel()
	 {
		 return true;
	 }

	public boolean attackEntityAsMob(Entity par1Entity)
    {
        int i = this.getAttackStrength(par1Entity);

        if (this.isPotionActive(Potion.damageBoost))
        {
            i += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
        }

        if (this.isPotionActive(Potion.weakness))
        {
            i -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
        }

        int j = 0;

        if (par1Entity instanceof EntityLiving)
        {
            i += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)par1Entity);
            j += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)par1Entity);
        }

        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);

        if (flag)
        {
            if (j > 0)
            {
            	this.heal(5);
                par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int k = EnchantmentHelper.getFireAspectModifier(this);

            if (k > 0)
            {
                par1Entity.setFire(k * 4);
            }

            if (par1Entity instanceof EntityLiving)
            {
                EnchantmentThorns.func_92096_a(this, (EntityLiving)par1Entity, this.rand);
            }
        }

        return flag;
    }

}
