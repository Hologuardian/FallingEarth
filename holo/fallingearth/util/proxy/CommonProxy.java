package holo.fallingearth.util.proxy;

import holo.fallingearth.FallingEarth;
import holo.fallingearth.entity.meteor.EntityMeteor;
import holo.fallingearth.entity.mob.EntityMeteorSpawn;
import holo.fallingearth.entity.mob.EntityMeteorite;
import holo.fallingearth.util.handler.ArmorAbilityHandler;
import holo.fallingearth.util.handler.ServerTickHandler;
import holo.fallingearth.util.helper.BlockHelper;
import holo.fallingearth.util.helper.ConfigHelper;
import holo.fallingearth.util.helper.ItemHelper;
import holo.fallingearth.util.helper.LanguageHelper;
import holo.fallingearth.util.helper.RecipeHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	
	public static int START_EID = 130;

	public void init(FMLInitializationEvent event) {
		entityRegistry();
		tickRegistry();
		eventRegistry();
		ItemHelper.initItems();
		BlockHelper.initBlocks();
		renderRegistry();
		RecipeHelper.initRecipes();
		LanguageHelper.initNames();
	}
	
	public void tickRegistry() {
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);	
	}
	
	public void renderRegistry() {
	}
	
	public void eventRegistry() {
		MinecraftForge.EVENT_BUS.register(new ArmorAbilityHandler());
	}
	
	public void entityRegistry() {
		registerEntity(EntityMeteor.class, "FallingEarth_Meteor", START_EID++, 64, 10, true);
		registerEntity(EntityMeteorite.class, "FallingEarth_Meteorite", START_EID++, 64, 10, true);
		registerEntity(EntityMeteorSpawn.class, "FallingEarth_MeteorSpawn", START_EID++, 64, 10, true);
	}
	
	public void registerEntity(Class<? extends Entity> clazz, String name, int modID, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerGlobalEntityID(clazz, name, availableID(),  000000, 255255255);
		EntityRegistry.registerModEntity(clazz, name, modID, FallingEarth.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
	
	public int availableID() {
		return EntityRegistry.findGlobalUniqueEntityId();
	}

	public void configRegistry(FMLPreInitializationEvent event)
	{
		ConfigHelper.init(event);
	}
}