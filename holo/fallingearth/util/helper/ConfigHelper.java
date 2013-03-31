package holo.fallingearth.util.helper;

import java.io.File;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHelper 
{
	public static int MeteorStoneID;
	public static int MeteorSpawnerID;

	public static int MeteoriticSwordID;
	public static int MeteoriticAxeID;
	public static int MeteoriticShovelID;
	public static int MeteoriticPickaxeID;
	public static int MeteoriticHoeID;

	public static int MeteoriticHeadID;
	public static int MeteoriticBodyID;
	public static int MeteoriticLegsID;
	public static int MeteoriticBootsID;

	public static int RisePlateID;
	public static int FlameTrapID;
	public static int MeteoriteSpawnerID;
	public static int MeteorSpawnSpawnerID;

	public static int MeteoriticEssenceID;
	
	public static void init(FMLPreInitializationEvent event)
	{
		File file = new File(event.getModConfigurationDirectory(), "FallingEarth.cfg");
		Configuration config = new Configuration(file);
		config.load();
		int bID = 3199;
		MeteorStoneID = config.getBlock("MeteorStone", bID++).getInt();
		RisePlateID = config.getBlock("RisePlate", bID++).getInt();
		FlameTrapID = config.getBlock("FlameTrap", bID++).getInt();

		int iID = 5499;
		MeteorSpawnerID = config.getItem("MeteorSpawner", iID++).getInt();
		
		MeteoriticSwordID = config.getItem("MeteoriticSword", iID++).getInt();
		MeteoriticAxeID = config.getItem("MeteoriticAxe", iID++).getInt();
		MeteoriticShovelID = config.getItem("MeteoriticShovel", iID++).getInt();
		MeteoriticPickaxeID = config.getItem("MeteoriticPickaxe", iID++).getInt();
		MeteoriticHoeID = config.getItem("MeteoriticHoe", iID++).getInt();

		MeteoriticHeadID = config.getItem("MeteoriticHead", iID++).getInt();
		MeteoriticBodyID = config.getItem("MeteoriticBody", iID++).getInt();
		MeteoriticLegsID = config.getItem("MeteoriticLegs", iID++).getInt();
		MeteoriticBootsID = config.getItem("MeteoriticBoots", iID++).getInt();

		MeteoriticEssenceID = config.getItem("MeteoriticEssence", iID++).getInt();
		config.save();
	}
}
