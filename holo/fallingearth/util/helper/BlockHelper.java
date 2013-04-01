package holo.fallingearth.util.helper;

import cpw.mods.fml.common.registry.GameRegistry;
import holo.fallingearth.block.BlockMeteorStone;
import holo.fallingearth.block.BlockRisePlate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockHelper 
{
	public static Block meteorStone;
	public static Block risePlate;
	
	public static void initBlocks()
	{
		meteorStone = new BlockMeteorStone(ConfigHelper.MeteorStoneID).setUnlocalizedName("MeteorStone").setLightValue(0.2F);
		risePlate = new BlockRisePlate(ConfigHelper.RisePlateID, "FallingEarth:RisePlate", Material.rock).setUnlocalizedName("RisePlate");
		
		registerBlocks();
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(meteorStone, "Meteor Stone");
		GameRegistry.registerBlock(risePlate, "Rise Plate");
	}
}
