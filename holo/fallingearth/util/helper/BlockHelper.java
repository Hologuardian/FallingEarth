package holo.fallingearth.util.helper;

import holo.fallingearth.block.BlockMeteorStone;
import net.minecraft.block.Block;

public class BlockHelper 
{
	public static Block meteorStone;
	
	public static void initBlocks()
	{
		meteorStone = new BlockMeteorStone(ConfigHelper.MeteorStoneID).setUnlocalizedName("MeteorStone").setLightValue(0.2F);
		
	}
}
