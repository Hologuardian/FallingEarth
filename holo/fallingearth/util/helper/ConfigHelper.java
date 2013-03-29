package holo.fallingearth.util.helper;

import java.io.File;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHelper 
{
	public static int MeteorStoneID;
	public static int MeteorSpawnerID;
	
	public static void init(FMLPreInitializationEvent event)
	{
		File file = new File(event.getModConfigurationDirectory(), "FallingEarth.cfg");
		Configuration config = new Configuration(file);
		config.load();
		MeteorStoneID = config.getBlock("MeteorStone", 3200).getInt();

		MeteorSpawnerID = config.getItem("MeteorSpawner", 5500).getInt();
		config.save();
	}
}
