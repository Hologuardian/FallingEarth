package holo.fallingearth.util.handler;

import holo.fallingearth.util.helper.ItemHelper;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler
{

	public void tickStart(EnumSet var1, Object ... var2) {}

	public void tickEnd(EnumSet var1, Object ... var2)
	{
		onTickInGame();
	}

	public EnumSet ticks()
	{
		return EnumSet.of(TickType.CLIENT);
	}

	public String getLabel()
	{
		return "Falling Earth Client Tick Handler";
	}

	public void onTickInGame()
	{
		Minecraft mc = Minecraft.getMinecraft();
		EntityClientPlayerMP var3 = Minecraft.getMinecraft().thePlayer;
		WorldClient var4 = mc.theWorld;
		if (var3 != null)
		{
			ItemStack boots = var3.inventory.armorInventory[0];
			ItemStack legs = var3.inventory.armorInventory[1];
			ItemStack chest = var3.inventory.armorInventory[2];
			ItemStack helm = var3.inventory.armorInventory[3];

			if (boots == null || legs == null || chest == null || helm == null)
			{
				var3.capabilities.setPlayerWalkSpeed(0.1F);
			}
			else if (boots.itemID == ItemHelper.meteoriticBoots.itemID
					&& legs.itemID == ItemHelper.meteoriticLegs.itemID
					&& chest.itemID == ItemHelper.meteoriticBody.itemID
					&& helm.itemID == ItemHelper.meteoriticHead.itemID)
			{
				var3.capabilities.setPlayerWalkSpeed(0.2F);
			}
		}
	}
}