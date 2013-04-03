package holo.fallingearth;

import holo.fallingearth.util.Utils;
import holo.fallingearth.util.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Utils.MAIN_MOD_ID, version = Utils.VERSION, name = Utils.MAIN_MOD_ID)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FallingEarth
{	
	@Instance(Utils.MAIN_MOD_ID)
	public static FallingEarth instance;
	
	@SidedProxy
	(clientSide = Utils.clientProxy, 
		serverSide = Utils.commonProxy)
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		proxy.configRegistry(event);
	}
	
	@Init
	public void Init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}
	
	@PostInit
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}