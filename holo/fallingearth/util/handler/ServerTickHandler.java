package holo.fallingearth.util.handler;

import holo.fallingearth.util.helper.ItemHelper;

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
		Iterator players = MinecraftServer.getServer().getConfigurationManager().playerEntityList.iterator();
		
		while(players.hasNext())
		{
			EntityPlayerMP player = (EntityPlayerMP) players.next();
			
			long ticks = player.worldObj.getTotalWorldTime();
			long time = player.worldObj.getWorldTime();
			
			if (time >= 13000 && time <= 23000 && ticks > 72000 && player.getRNG().nextInt(3600) == 0)
			{
				MeteorDropHandler.DropMeteor(player.worldObj, player, 40);
				player.sendChatToPlayer("A large meteor is approaching your position!");
			}
			else if (time >= 13000 && time <= 23000 && player.getRNG().nextInt(600) == 0)
			{
				MeteorDropHandler.DropMeteor(player.worldObj, player, 10);
				player.sendChatToPlayer("A small meteor is approaching your position!");
			}
//			else if ((ticks % 24000) <= 12000 && player.getRNG().nextInt(1500) == 0) Didn't have time =(
//			{
//				MeteorDropHandler.DropComet(player.worldObj, player, 10);
//			player.sendChatToPlayer("Dropping comet");
//			}
			
			ItemStack boots = player.inventory.armorInventory[0];
			ItemStack legs = player.inventory.armorInventory[1];
			ItemStack chest = player.inventory.armorInventory[2];
			ItemStack helm = player.inventory.armorInventory[3];

			if (boots == null || legs == null || chest == null || helm == null)
			{
				continue;
			}
			else if (boots.itemID == ItemHelper.meteoriticBoots.itemID
					&& legs.itemID == ItemHelper.meteoriticLegs.itemID
					&& chest.itemID == ItemHelper.meteoriticBody.itemID
					&& helm.itemID == ItemHelper.meteoriticHead.itemID)
			{
				player.fallDistance = 0;
			}
		}
	}
}
