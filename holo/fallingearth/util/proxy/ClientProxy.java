package holo.fallingearth.util.proxy;

import holo.fallingearth.entity.meteor.EntityMeteor;
import holo.fallingearth.render.RenderMeteor;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	
	@Override
	public void tickRegistry() {
		super.tickRegistry();
		//TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	@Override
	public void renderRegistry() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMeteor.class, new RenderMeteor());
	}

}
