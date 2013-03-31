package holo.fallingearth.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMeteorStone extends Block
{
	public BlockMeteorStone(int par1)
	{
		super(par1, Material.rock);
		this.setResistance(14F);
		this.setHardness(5.0F);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("FallingEarth:MeteorStone");
    }
}
