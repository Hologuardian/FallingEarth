package holo.fallingearth.item;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemMeteoriticPickaxe extends ItemPickaxe
{
	public ItemMeteoriticPickaxe(int par1, EnumToolMaterial par2)
    {
        super(par1, par2);
    }
	
	@Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        return false;
    }
	
	@Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) 
	{
		if (player.worldObj.isRemote)
		{
			return false;
		}

		int id = player.worldObj.getBlockId(x, y, z);
		Block target = Block.blocksList[id];

		Random rand = new Random();
		
		ArrayList<ItemStack> drops = target.getBlockDropped(player.worldObj, x, y, z, 
				player.worldObj.getBlockMetadata(x, y, z),
				EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
		
		boolean smelted = false;
		
		for(ItemStack stack : drops)
		{
			if (FurnaceRecipes.smelting().getSmeltingResult(stack) != null)
			{
				stack = FurnaceRecipes.smelting().getSmeltingResult(stack).copy();
				
				float f = 0.7F;
				double d  = rand.nextFloat() * f + (1.0F - f) * 0.5D;
				double d1 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
				double d2 = rand.nextFloat() * f + (1.0F - f) * 0.5D;
				EntityItem entityitem = new EntityItem(player.worldObj, x + d, y + d1, z + d2, stack);
				entityitem.delayBeforeCanPickup = 10;
				entityitem.lifespan = 6000;
				player.worldObj.spawnEntityInWorld(entityitem);
				smelted = true;
			}
		}
		
		if (smelted)
			player.worldObj.setBlockToAir(x, y, z);
		
		return smelted;
	}

    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("FallingEarth:MeteoriticPickaxe");
    }
}
