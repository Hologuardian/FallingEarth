package holo.fallingearth.block;

import java.util.Iterator;

import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockRisePlate extends BlockBasePressurePlate
{
    private final int field_94357_a;

    protected BlockRisePlate(int par1, String par2Str, Material par3Material, int par4)
    {
        super(par1, par2Str, par3Material);
        this.field_94357_a = par4;
    }
    
    

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World)
    {
        return 10;
    }
}