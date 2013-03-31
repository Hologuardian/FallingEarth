package holo.fallingearth.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;


//Class not actually needed, but is in here for possible use with magic system if time.
public class MeteoriticEssence extends Item
{

	public MeteoriticEssence(int par1) 
	{
		super(par1);
	}

    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
        this.iconIndex = par1IconRegister.registerIcon("FallingEarth:MeteoriticEssence");
    }
}
