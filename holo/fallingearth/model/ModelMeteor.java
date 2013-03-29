package holo.fallingearth.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelMeteor extends ModelBase
{
    /** The cube model for the Ender Crystal. */
    private ModelRenderer cube;

    /** The glass model for the Ender Crystal. */
    private ModelRenderer glass = new ModelRenderer(this, "glass");

	private final int size;

    public ModelMeteor(float par1, boolean par2, int par3)
    {
        this.glass.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.cube = new ModelRenderer(this, "cube");
        this.cube.setTextureOffset(32, 0).addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.size = par3;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        GL11.glPushMatrix();
        GL11.glScalef(2.0F * size, 2.0F * size, 2.0F * size);
        GL11.glTranslatef(0.0F, -0.5F, 0.0F);

        GL11.glRotatef(par3, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.8F + par4, 0.0F);
        GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
        this.glass.render(par7);
        float f6 = 0.875F;
        GL11.glScalef(f6, f6, f6);
        GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
        GL11.glRotatef(par3, 0.0F, 1.0F, 0.0F);
        this.glass.render(par7);
        GL11.glScalef(f6, f6, f6);
        GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
        GL11.glRotatef(par3, 0.0F, 1.0F, 0.0F);
        this.cube.render(par7);
        GL11.glPopMatrix();
    }
}