package holo.fallingearth.util.helper;

import holo.fallingearth.item.ItemMeteorSpawner;
import holo.fallingearth.item.ItemMeteoriticArmor;
import holo.fallingearth.item.ItemMeteoriticAxe;
import holo.fallingearth.item.ItemMeteoriticPickaxe;
import holo.fallingearth.item.ItemMeteoriticShovel;
import holo.fallingearth.item.ItemMeteoriticSword;
import holo.fallingearth.item.MeteoriticEssence;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ItemHelper 
{
	public static Item meteorSpawner;
	public static Item meteoriticPickaxe;
	public static Item meteoriticAxe;
	public static Item meteoriticShovel;
	public static Item meteoriticSword;

	public static Item meteoriticHead;
	public static Item meteoriticBody;
	public static Item meteoriticLegs;
	public static Item meteoriticBoots;

	public static Item meteoriticEssence;

	public static void initItems()
	{
		meteorSpawner = new ItemMeteorSpawner(ConfigHelper.MeteorSpawnerID).setUnlocalizedName("MeteorSpawner");

		EnumToolMaterial meteor = EnumHelper.addToolMaterial("Meteoritic", 3, -1, 16, 14, 30);
		meteoriticPickaxe = new ItemMeteoriticPickaxe(ConfigHelper.MeteoriticPickaxeID, meteor).setUnlocalizedName("MeteoriticPickaxe");
		meteoriticAxe = new ItemMeteoriticAxe(ConfigHelper.MeteoriticAxeID, meteor).setUnlocalizedName("MeteoriticAxe");
		meteoriticShovel = new ItemMeteoriticShovel(ConfigHelper.MeteoriticShovelID, meteor).setUnlocalizedName("MeteoriticShovel");
		meteoriticSword = new ItemMeteoriticSword(ConfigHelper.MeteoriticSwordID, meteor).setUnlocalizedName("MeteoriticSword");

		int meteoriticArmor = RenderingRegistry.addNewArmourRendererPrefix("FallingEarth:Meteor");
		EnumArmorMaterial meteoritic = EnumHelper.addArmorMaterial("Meteoritic", -1, new int[]{0,0,0,0}, 30);
		meteoriticHead = new ItemMeteoriticArmor(ConfigHelper.MeteoriticHeadID, meteoritic, meteoriticArmor, 0).setUnlocalizedName("FallingEarth:MeteoriticHelmet");
		meteoriticBody = new ItemMeteoriticArmor(ConfigHelper.MeteoriticBodyID, meteoritic, meteoriticArmor, 1).setUnlocalizedName("FallingEarth:MeteoriticBody");
		meteoriticLegs = new ItemMeteoriticArmor(ConfigHelper.MeteoriticLegsID, meteoritic, meteoriticArmor, 2).setUnlocalizedName("FallingEarth:MeteoriticLegs");
		meteoriticBoots = new ItemMeteoriticArmor(ConfigHelper.MeteoriticBootsID, meteoritic, meteoriticArmor, 3).setUnlocalizedName("FallingEarth:MeteoriticBoots");

		meteoriticEssence = new MeteoriticEssence(ConfigHelper.MeteoriticEssenceID).setUnlocalizedName("MeteoriticEssence");
	}
}
