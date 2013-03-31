package holo.fallingearth.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;

public class ItemMeteoriticArmor extends ItemArmor implements IArmorTextureProvider, ISpecialArmor
{
    public ItemMeteoriticArmor(int var1, EnumArmorMaterial var2, int var3, int var4)
    {
        super(var1, var2, var3, var4);
    }

    public ArmorProperties getProperties(EntityLiving var1, ItemStack var2, DamageSource var3, double var4, int var6)
    {
        return new ISpecialArmor.ArmorProperties(0, 0.225D, 50000);
    }

    public int getArmorDisplay(EntityPlayer var1, ItemStack var2, int var3)
    {
        return var3 != 0 && var3 != 2 ? (var3 == 1 ? 4 : 2) : 3;
    }

    public void damageArmor(EntityLiving var1, ItemStack var2, DamageSource var3, int var4, int var5){}

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("22.5% Damage Reduction Per Peice");
        par3List.add("Infinite Uses");
        par3List.add("Full Set: 3x Jump");
        par3List.add("Full set: Fall Damage Protection");
        par3List.add("Full set: Fire Protection");
        par3List.add("Full set: 1.2x Movement Speed");
    }

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		return "/holo/fallingearth/textures/armor/MeteoriticArmor_" + (armorType == 2 ? 2 : 1) + ".png";
	}
}
