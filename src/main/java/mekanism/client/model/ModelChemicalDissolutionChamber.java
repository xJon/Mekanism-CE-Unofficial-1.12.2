package mekanism.client.model;

import mekanism.client.render.MekanismRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelChemicalDissolutionChamber extends ModelBase
{
	ModelRenderer support2;
	ModelRenderer vat5;
	ModelRenderer top2;
	ModelRenderer top;
	ModelRenderer base;
	ModelRenderer vat2;
	ModelRenderer vat3;
	ModelRenderer vat6;
	ModelRenderer vat9;
	ModelRenderer vat8;
	ModelRenderer vat7;
	ModelRenderer vat4;
	ModelRenderer backEdge2;
	ModelRenderer back;
	ModelRenderer backEdge1;
	ModelRenderer vents;
	ModelRenderer support1;
	ModelRenderer vat1;
	ModelRenderer nozzle8;
	ModelRenderer nozzle5;
	ModelRenderer nozzle7;
	ModelRenderer nozzle4;
	ModelRenderer nozzle9;
	ModelRenderer nozzle6;
	ModelRenderer nozzle3;
	ModelRenderer nozzle2;
	ModelRenderer nozzle1;
	ModelRenderer glass;
	ModelRenderer portToggle1;
	ModelRenderer portToggle2;

	public ModelChemicalDissolutionChamber() 
	{
		textureWidth = 128;
		textureHeight = 64;

		support2 = new ModelRenderer(this, 4, 0);
		support2.addBox(0F, 0F, 0F, 1, 2, 1);
		support2.setRotationPoint(6F, 9F, -7F);
		support2.setTextureSize(128, 64);
		support2.mirror = true;
		setRotation(support2, 0F, 0F, 0F);
		vat5 = new ModelRenderer(this, 0, 23);
		vat5.addBox(0F, 0F, 0F, 3, 4, 3);
		vat5.setRotationPoint(-1.5F, 13F, -1.5F);
		vat5.setTextureSize(128, 64);
		vat5.mirror = true;
		setRotation(vat5, 0F, 0F, 0F);
		top2 = new ModelRenderer(this, 0, 40);
		top2.addBox(0F, 0F, 0F, 16, 1, 15);
		top2.setRotationPoint(-8F, 11F, -8F);
		top2.setTextureSize(128, 64);
		top2.mirror = true;
		setRotation(top2, 0F, 0F, 0F);
		top = new ModelRenderer(this, 0, 23);
		top.addBox(0F, 0F, 0F, 16, 1, 16);
		top.setRotationPoint(-8F, 8F, -8F);
		top.setTextureSize(128, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		base = new ModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 16, 7, 16);
		base.setRotationPoint(-8F, 17F, -8F);
		base.setTextureSize(128, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		vat2 = new ModelRenderer(this, 0, 23);
		vat2.addBox(0F, 0F, 0F, 3, 4, 3);
		vat2.setRotationPoint(-5F, 13F, -1.5F);
		vat2.setTextureSize(128, 64);
		vat2.mirror = true;
		setRotation(vat2, 0F, 0F, 0F);
		vat3 = new ModelRenderer(this, 0, 23);
		vat3.addBox(0F, 0F, 0F, 3, 4, 3);
		vat3.setRotationPoint(-5F, 13F, 2F);
		vat3.setTextureSize(128, 64);
		vat3.mirror = true;
		setRotation(vat3, 0F, 0F, 0F);
		vat6 = new ModelRenderer(this, 0, 23);
		vat6.addBox(0F, 0F, 0F, 3, 4, 3);
		vat6.setRotationPoint(-1.5F, 13F, 2F);
		vat6.setTextureSize(128, 64);
		vat6.mirror = true;
		setRotation(vat6, 0F, 0F, 0F);
		vat9 = new ModelRenderer(this, 0, 23);
		vat9.addBox(0F, 0F, 0F, 3, 4, 3);
		vat9.setRotationPoint(2F, 13F, 2F);
		vat9.setTextureSize(128, 64);
		vat9.mirror = true;
		setRotation(vat9, 0F, 0F, 0F);
		vat8 = new ModelRenderer(this, 0, 23);
		vat8.addBox(0F, 0F, 0F, 3, 4, 3);
		vat8.setRotationPoint(2F, 13F, -1.5F);
		vat8.setTextureSize(128, 64);
		vat8.mirror = true;
		setRotation(vat8, 0F, 0F, 0F);
		vat7 = new ModelRenderer(this, 0, 23);
		vat7.addBox(0F, 0F, 0F, 3, 4, 3);
		vat7.setRotationPoint(2F, 13F, -5F);
		vat7.setTextureSize(128, 64);
		vat7.mirror = true;
		setRotation(vat7, 0F, 0F, 0F);
		vat4 = new ModelRenderer(this, 0, 23);
		vat4.addBox(0F, 0F, 0F, 3, 4, 3);
		vat4.setRotationPoint(-1.5F, 13F, -5F);
		vat4.setTextureSize(128, 64);
		vat4.mirror = true;
		setRotation(vat4, 0F, 0F, 0F);
		backEdge2 = new ModelRenderer(this, 8, 0);
		backEdge2.addBox(0F, 0F, 0F, 1, 8, 1);
		backEdge2.setRotationPoint(7F, 9F, 7F);
		backEdge2.setTextureSize(128, 64);
		backEdge2.mirror = true;
		setRotation(backEdge2, 0F, 0F, 0F);
		back = new ModelRenderer(this, 48, 0);
		back.addBox(0F, 0F, 0F, 14, 8, 2);
		back.setRotationPoint(-7F, 9F, 6F);
		back.setTextureSize(128, 64);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		backEdge1 = new ModelRenderer(this, 8, 0);
		backEdge1.addBox(0F, 0F, 0F, 1, 8, 1);
		backEdge1.setRotationPoint(-8F, 9F, 7F);
		backEdge1.setTextureSize(128, 64);
		backEdge1.mirror = true;
		setRotation(backEdge1, 0F, 0F, 0F);
		vents = new ModelRenderer(this, 70, 0);
		vents.addBox(0F, 0F, 0F, 8, 2, 10);
		vents.setRotationPoint(-4F, 9F, -4F);
		vents.setTextureSize(128, 64);
		vents.mirror = true;
		setRotation(vents, 0F, 0F, 0F);
		support1 = new ModelRenderer(this, 4, 0);
		support1.addBox(0F, 0F, 0F, 1, 2, 1);
		support1.setRotationPoint(-7F, 9F, -7F);
		support1.setTextureSize(128, 64);
		support1.mirror = true;
		setRotation(support1, 0F, 0F, 0F);
		vat1 = new ModelRenderer(this, 0, 23);
		vat1.addBox(0F, 0F, 0F, 3, 4, 3);
		vat1.setRotationPoint(-5F, 13F, -5F);
		vat1.setTextureSize(128, 64);
		vat1.mirror = true;
		setRotation(vat1, 0F, 0F, 0F);
		nozzle8 = new ModelRenderer(this, 0, 0);
		nozzle8.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle8.setRotationPoint(3F, 11.5F, -0.5F);
		nozzle8.setTextureSize(128, 64);
		nozzle8.mirror = true;
		setRotation(nozzle8, 0F, 0F, 0F);
		nozzle5 = new ModelRenderer(this, 0, 0);
		nozzle5.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle5.setRotationPoint(-0.5F, 11.5F, -0.5F);
		nozzle5.setTextureSize(128, 64);
		nozzle5.mirror = true;
		setRotation(nozzle5, 0F, 0F, 0F);
		nozzle7 = new ModelRenderer(this, 0, 0);
		nozzle7.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle7.setRotationPoint(3F, 11.5F, -4F);
		nozzle7.setTextureSize(128, 64);
		nozzle7.mirror = true;
		setRotation(nozzle7, 0F, 0F, 0F);
		nozzle4 = new ModelRenderer(this, 0, 0);
		nozzle4.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle4.setRotationPoint(-0.5F, 11.5F, -4F);
		nozzle4.setTextureSize(128, 64);
		nozzle4.mirror = true;
		setRotation(nozzle4, 0F, 0F, 0F);
		nozzle9 = new ModelRenderer(this, 0, 0);
		nozzle9.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle9.setRotationPoint(3F, 11.5F, 3F);
		nozzle9.setTextureSize(128, 64);
		nozzle9.mirror = true;
		setRotation(nozzle9, 0F, 0F, 0F);
		nozzle6 = new ModelRenderer(this, 0, 0);
		nozzle6.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle6.setRotationPoint(-0.5F, 11.5F, 3F);
		nozzle6.setTextureSize(128, 64);
		nozzle6.mirror = true;
		setRotation(nozzle6, 0F, 0F, 0F);
		nozzle3 = new ModelRenderer(this, 0, 0);
		nozzle3.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle3.setRotationPoint(-4F, 11.5F, 3F);
		nozzle3.setTextureSize(128, 64);
		nozzle3.mirror = true;
		setRotation(nozzle3, 0F, 0F, 0F);
		nozzle2 = new ModelRenderer(this, 0, 0);
		nozzle2.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle2.setRotationPoint(-4F, 11.5F, -0.5F);
		nozzle2.setTextureSize(128, 64);
		nozzle2.mirror = true;
		setRotation(nozzle2, 0F, 0F, 0F);
		nozzle1 = new ModelRenderer(this, 0, 0);
		nozzle1.addBox(0F, 0F, 0F, 1, 1, 1);
		nozzle1.setRotationPoint(-4F, 11.5F, -4F);
		nozzle1.setTextureSize(128, 64);
		nozzle1.mirror = true;
		setRotation(nozzle1, 0F, 0F, 0F);
		glass = new ModelRenderer(this, 64, 14);
		glass.addBox(0F, 0F, 0F, 14, 5, 13);
		glass.setRotationPoint(-7F, 12F, -7F);
		glass.setTextureSize(128, 64);
		glass.mirror = true;
		setRotation(glass, 0F, 0F, 0F);
		portToggle1 = new ModelRenderer(this, 106, 0);
		portToggle1.addBox(0F, 0F, 0F, 1, 10, 10);
		portToggle1.setRotationPoint(-8.01F, 10.99F, -5F);
		portToggle1.setTextureSize(128, 64);
		portToggle1.mirror = true;
		setRotation(portToggle1, 0F, 0F, 0F);
		portToggle2 = new ModelRenderer(this, 64, 32);
		portToggle2.addBox(0F, 0F, 0F, 1, 8, 8);
		portToggle2.setRotationPoint(7.01F, 12F, -4F);
		portToggle2.setTextureSize(128, 64);
		portToggle2.mirror = true;
		setRotation(portToggle2, 0F, 0F, 0F);
	}

	public void render(float size)
	{
		render(size, false);
	}

	public void render(float size, boolean inventory)
	{
		MekanismRenderer.blendOn();
		
		support2.render(size);
		if (!inventory) { vat5.render(size);
		top2.render(size);
		top.render(size);}
		base.render(size);
		if (!inventory) { vat2.render(size);
		vat3.render(size);
		vat6.render(size);
		vat9.render(size);
		vat8.render(size);
		vat7.render(size);
		vat4.render(size);}
		backEdge2.render(size);
		back.render(size);
		backEdge1.render(size);
		if (!inventory) { vents.render(size);
		support1.render(size);
		vat1.render(size);
		nozzle8.render(size);
		nozzle5.render(size);
		nozzle7.render(size);
		nozzle4.render(size);
		nozzle9.render(size);
		nozzle6.render(size);
		nozzle3.render(size);
		nozzle2.render(size);
		nozzle1.render(size);
		glass.render(size);
		portToggle1.render(size);
		portToggle2.render(size);}
		
		MekanismRenderer.blendOff();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
