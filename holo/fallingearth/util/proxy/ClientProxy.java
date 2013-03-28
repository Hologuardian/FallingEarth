package holo.fallingearth.util.proxy;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void tickRegistry() {
		super.tickRegistry();
		//TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	
	@Override
	public void entityRegistry() {
		super.entityRegistry();
		
	}

}
