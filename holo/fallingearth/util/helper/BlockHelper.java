package holo.fallingearth.util.helper;

import holo.fallingearth.block.BlockMeteorSpawnSpawner;
import holo.fallingearth.block.BlockMeteorStone;
import holo.fallingearth.block.BlockMeteoriteSpawner;
import holo.fallingearth.block.BlockRisePlate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHelper 
{
	public static Block meteorStone;
	public static Block risePlate;
	
	public static Block meteoriteSpawner;
	public static Block meteorSpawnSpawner;
	
	public static void initBlocks()
	{
		meteorStone = new BlockMeteorStone(ConfigHelper.MeteorStoneID).setUnlocalizedName("MeteorStone").setLightValue(0.2F);
		risePlate = new BlockRisePlate(ConfigHelper.RisePlateID, "FallingEarth:RisePlate", Material.rock).setUnlocalizedName("RisePlate");
		
		meteoriteSpawner = new BlockMeteoriteSpawner(ConfigHelper.MeteoriteSpawnerID).setUnlocalizedName("FallingEarth:Spawner");
		meteorSpawnSpawner = new BlockMeteorSpawnSpawner(ConfigHelper.MeteorSpawnSpawnerID).setUnlocalizedName("FallingEarth:Spawner");
		
		registerBlocks();
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(meteorStone, "Meteor Stone");
		GameRegistry.registerBlock(risePlate, "Rise Plate");
		GameRegistry.registerBlock(meteoriteSpawner, "Meteorite Spawner");
		GameRegistry.registerBlock(risePlate, "Meteor Spawn Spawner");
	}
}
