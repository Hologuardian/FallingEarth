package holo.fallingearth.util.helper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper 
{
	public static void initRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticSword, 1), new Object[] {" y ", " y ", " x ", 'y', ItemHelper.meteoriticEssence , 'x', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticShovel, 1), new Object[] {" y ", " x ", " x ", 'y', ItemHelper.meteoriticEssence , 'x', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticAxe, 1), new Object[] {"yy ", "yx ", " x ", 'y', ItemHelper.meteoriticEssence , 'x', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticPickaxe, 1), new Object[] {"yyy", " x ", " x ", 'y', ItemHelper.meteoriticEssence , 'x', Item.stick});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticHead, 1), new Object[] {"yyy", "y y", 'y', ItemHelper.meteoriticEssence});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticBody, 1), new Object[] {" y ", " y ", " x ", 'y', ItemHelper.meteoriticEssence});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticLegs, 1), new Object[] {" y ", " y ", " x ", 'y', ItemHelper.meteoriticEssence});
		GameRegistry.addRecipe(new ItemStack(ItemHelper.meteoriticBoots, 1), new Object[] {" y ", " y ", " x ", 'y', ItemHelper.meteoriticEssence});
		GameRegistry.addRecipe(new ItemStack(BlockHelper.risePlate, 1), new Object[] {"xyx", "ydy", "xyx", 'y', ItemHelper.meteoriticEssence , 'x', Block.stone, 'd', Item.diamond});
	}
}
