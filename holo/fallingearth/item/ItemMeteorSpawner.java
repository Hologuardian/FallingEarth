package holo.fallingearth.item;

import holo.fallingearth.entity.meteor.EntityMeteor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMeteorSpawner extends Item
{
	public ItemMeteorSpawner(int par1)
    {
        super(par1);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1, World par2, EntityPlayer par3)
    {
        if (!par2.isRemote)
        {
        	par2.spawnEntityInWorld(new EntityMeteor(par2, par3.posX, par3.posZ, 10));
        }

        return par1;
    }
}
