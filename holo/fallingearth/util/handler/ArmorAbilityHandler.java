package holo.fallingearth.util.handler;

import holo.fallingearth.util.helper.ItemHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;

public class ArmorAbilityHandler 
{
	
	//unused as of now, might use later
	@ForgeSubscribe
	public void onLivingHurtEvent(LivingHurtEvent e) 
	{
		if (!(e.entityLiving instanceof EntityPlayer))
			return;

		EntityPlayer var5 = (EntityPlayer)e.entityLiving;
		ItemStack boots = var5.inventory.armorInventory[0];
		ItemStack legs = var5.inventory.armorInventory[1];
		ItemStack chest = var5.inventory.armorInventory[2];
		ItemStack helm = var5.inventory.armorInventory[3];

		int bootID = 0;
		int chestID = 0;
		int legID = 0;
		int helmID = 0;
		if (boots != null)
			bootID = boots.itemID;
		else
			return;

		if (chest != null)
			chestID = chest.itemID;
		else
			return;

		if (legs != null)
			legID = legs.itemID;
		else
			return;

		if (helm != null)
			helmID = helm.itemID;
		else
			return;

		DamageSource s = e.source;
		
		if (bootID == ItemHelper.meteoriticBoots.itemID
				&& legID == ItemHelper.meteoriticLegs.itemID
				&& chestID == ItemHelper.meteoriticBody.itemID
				&& helmID == ItemHelper.meteoriticHead.itemID)
		{
			if (s.isFireDamage())
			{
				e.setCanceled(true);
			}
		}
	}
	
	@ForgeSubscribe
	public void onLivingJumpEvent(LivingJumpEvent e)
	{
		if (e.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer var5 = (EntityPlayer)e.entityLiving;
			ItemStack boots = var5.inventory.armorInventory[0];
			ItemStack legs = var5.inventory.armorInventory[1];
			ItemStack chest = var5.inventory.armorInventory[2];
			ItemStack helm = var5.inventory.armorInventory[3];
			int bootID = 0;
			int chestID = 0;
			int legID = 0;
			int helmID = 0;
			if (boots != null)
				bootID = boots.itemID;
			else
				return;

			if (chest != null)
				chestID = chest.itemID;
			else
				return;

			if (legs != null)
				legID = legs.itemID;
			else
				return;

			if (helm != null)
				helmID = helm.itemID;
			else
				return;

			
			if (bootID == ItemHelper.meteoriticBoots.itemID
					&& legID == ItemHelper.meteoriticLegs.itemID
					&& chestID == ItemHelper.meteoriticBody.itemID
					&& helmID == ItemHelper.meteoriticHead.itemID)
			{
				var5.addVelocity(0, 0.3D, 0);
			}
		}
    }
}
