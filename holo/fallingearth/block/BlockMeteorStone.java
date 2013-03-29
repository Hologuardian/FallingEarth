package holo.fallingearth.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMeteorStone extends Block
{
	public BlockMeteorStone(int par1)
	{
		super(par1, Material.rock);
		this.setResistance(14F);
		this.setHardness(2.4F);
	}
}
