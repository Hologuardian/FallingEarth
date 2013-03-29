package holo.fallingearth.util.handler;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import holo.fallingearth.entity.meteor.EntityMeteor;

public class MeteorLandHandler 
{
	public static void land(World world, double eX, double eY, double eZ, int s)
	{
		int x = MathHelper.floor_double(eX);
		int y = MathHelper.floor_double(eY);
		int z = MathHelper.floor_double(eZ);
		world.setBlock(x, y, z, Block.bedrock.blockID);
	}
}
