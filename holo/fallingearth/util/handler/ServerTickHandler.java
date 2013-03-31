package holo.fallingearth.util.handler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{

	public void tickStart(EnumSet var1, Object ... var2) {}

	public void tickEnd(EnumSet var1, Object ... var2)
	{
		onTickInGame();
	}

	public EnumSet ticks()
	{
		return EnumSet.of(TickType.SERVER);
	}
	
	public String getLabel()
	{
		return "Falling Earth Server Tick Handler";
	}

	public void onTickInGame()
	{
		int ticks = MinecraftServer.getServer().getTickCounter();
		Iterator players = MinecraftServer.getServer().getConfigurationManager().playerEntityList.iterator();
		
		while(players.hasNext())
		{
			EntityPlayerMP player = (EntityPlayerMP) players.next();
			
			if ((ticks & 24000) >= 12000 && ticks > 72000 && player.getRNG().nextInt(12000) == 0)
			{
				MeteorDropHandler.DropMeteor(player.worldObj, player, 40);
			}
			else if ((ticks & 24000) >= 12000 && player.getRNG().nextInt(1500) == 0)
			{
				MeteorDropHandler.DropMeteor(player.worldObj, player, 10);
			}
//			else if ((ticks & 24000) <= 12000 && player.getRNG().nextInt(1500) == 0)
//			{
//				MeteorDropHandler.DropComet(player.worldObj, player, 10);
//			}
		}
	}
}
