package holo.fallingearth.entity.mob;

import holo.fallingearth.entity.ai.EntityAILeapToTarget;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMeteorSpawn extends EntityMob
{

	public EntityMeteorSpawn(World par1World) {
		super(par1World);
		this.stepHeight = 3.1F;
		this.moveSpeed = 0.3F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 64.0F, 0, true));
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

}
