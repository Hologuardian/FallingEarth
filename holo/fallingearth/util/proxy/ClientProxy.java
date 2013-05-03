package holo.fallingearth.util.proxy;

import holo.fallingearth.entity.meteor.EntityMeteor;
import holo.fallingearth.entity.mob.EntityMeteorSpawn;
import holo.fallingearth.entity.mob.EntityMeteorite;
import holo.fallingearth.render.RenderMeteor;
import holo.fallingearth.render.RenderMeteorSpawn;
import holo.fallingearth.render.RenderMeteorite;
import holo.fallingearth.util.handler.ClientTickHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	public void tickRegistry() {
		super.tickRegistry();
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	@Override
	public void renderRegistry() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMeteor.class, new RenderMeteor());
		RenderingRegistry.registerEntityRenderingHandler(EntityMeteorite.class, new RenderMeteorite());
		RenderingRegistry.registerEntityRenderingHandler(EntityMeteorSpawn.class, new RenderMeteorSpawn());
	}
	
	@Override
    public int addArmor(String name)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(name);
	}
}
