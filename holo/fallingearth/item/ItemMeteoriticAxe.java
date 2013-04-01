package holo.fallingearth.item;

import java.util.ArrayList;
import java.util.List;
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
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class ItemMeteoriticAxe extends ItemAxe 
{
	public ItemMeteoriticAxe(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.damageVsEntity = 22;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1, EntityLiving par2, EntityLiving par3)
    {
        par2.setFire(3);
        return super.hitEntity(par1, par2, par3);
    }

    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
        this.iconIndex = par1IconRegister.registerIcon("FallingEarth:MeteoriticAxe");
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	par3List.add("22 Damage");
    	par3List.add("Burn IV");
    }
}
