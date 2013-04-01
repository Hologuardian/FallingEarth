package holo.fallingearth.block;

import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMeteorStone extends BlockNetherrack
{
	public BlockMeteorStone(int par1)
	{
		super(par1);
		this.setResistance(14F);
		this.setHardness(5.0F);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("FallingEarth:MeteorStone");
    }
}
