package holo.fallingearth.entity.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class EntityMeteoriteProjectile extends EntityArrow 
{
	public EntityMeteoriteProjectile(World par1World) {
		super(par1World);
	}
	
    public EntityMeteoriteProjectile(World var1, double var2, double var4, double var6)  {
        super(var1, var2, var4, var6);
    }
    
    public EntityMeteoriteProjectile(World var1, EntityLiving var2, EntityLiving var3, float var4, float var5) {
        super(var1, var2, var3, var4, var5);
    }
    
    public EntityMeteoriteProjectile(World var1, EntityLiving var2, float var3) {
        super(var1, var2, var3);
    }
    
    @Override
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer){
        par1EntityPlayer.attackEntityFrom(DamageSource.causeArrowDamage(this, this.shootingEntity), 8);
        par1EntityPlayer.setFire(4);
    }
}