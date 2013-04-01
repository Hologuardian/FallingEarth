package holo.fallingearth.block;

import holo.fallingearth.util.helper.ItemHelper;

import java.util.Random;

import net.minecraft.block.BlockMobSpawner;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMeteoriteSpawner extends BlockMobSpawner
{
    public BlockMeteoriteSpawner(int par1)
    {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World)
    {
    	TileEntityMobSpawner var1 = new TileEntityMobSpawner();
    	var1.func_98049_a().setMobID("FallingEarth_Meteorite");
    	var1.func_98049_a().field_98286_b = 0;
        return var1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ItemHelper.meteoriticEssence.itemID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(3) + 1;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.blockID;
    }
}