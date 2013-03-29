package holo.fallingearth.util.helper;

import holo.fallingearth.item.ItemMeteorSpawner;
import net.minecraft.item.Item;

public class ItemHelper 
{
	public static Item meteorSpawner;
	
	public static void initItems()
	{
		meteorSpawner = new ItemMeteorSpawner(ConfigHelper.MeteorSpawnerID).setUnlocalizedName("MeteorSpawner");
	}
}
