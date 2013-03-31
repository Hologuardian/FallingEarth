package holo.fallingearth.item;

import holo.fallingearth.entity.meteor.EntityMeteor;
import holo.fallingearth.util.handler.MeteorDropHandler;
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
        MeteorDropHandler.DropMeteor(par2, par3, 40);

        return par1;
    }
}
