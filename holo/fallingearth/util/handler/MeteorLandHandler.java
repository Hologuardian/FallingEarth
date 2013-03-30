package holo.fallingearth.util.handler;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import holo.fallingearth.entity.meteor.EntityMeteor;
import holo.fallingearth.util.helper.BlockHelper;

public class MeteorLandHandler 
{
	public static void land(World world, double eX, double eY, double eZ, int s)
	{
		int x = MathHelper.floor_double(eX);
		int y = MathHelper.floor_double(eY);
		int z = MathHelper.floor_double(eZ);

		for(float i = 0; i < s; i += 0.5)
			for(float j = 0; j < Math.PI * 2; j += (Math.PI / 8))
			{
				int pX = (int) (eX + (MathHelper.cos(j)));
				int pZ = (int) (eZ + (MathHelper.sin(j)));
				
				int pY = world.getHeightValue(pX, pZ);
				world.setBlock(pX, pY, pZ, BlockHelper.meteorStone.blockID);
			}
		
		
	}
}
