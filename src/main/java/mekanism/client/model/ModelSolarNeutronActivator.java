package mekanism.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSolarNeutronActivator extends ModelBase {

    ModelRenderer pole;
    ModelRenderer panel3;
    ModelRenderer port;
    ModelRenderer panel1;
    ModelRenderer panel2;
    ModelRenderer panelBase;
    ModelRenderer panelBraceLeft2;
    ModelRenderer panelBraceRight2;
    ModelRenderer panelBraceLeft1;
    ModelRenderer panelBraceRight1;
    ModelRenderer panelBrace;
    ModelRenderer bridge;
    ModelRenderer platform;
    ModelRenderer hole2;
    ModelRenderer hole4;
    ModelRenderer hole1;
    ModelRenderer hole3;
    ModelRenderer brace2;
    ModelRenderer tube2c;
    ModelRenderer tube1b;
    ModelRenderer tube1c;
    ModelRenderer tube2b;
    ModelRenderer tube2a;
    ModelRenderer tube1a;
    ModelRenderer conduit;
    ModelRenderer brace1;
    ModelRenderer tank;
    ModelRenderer laser;
    ModelRenderer base;
    ModelRenderer support1;
    ModelRenderer support2;
    ModelRenderer support3;
    ModelRenderer support4;
    ModelRenderer support5;
    ModelRenderer support6;
    ModelRenderer support7;
    ModelRenderer support8;
    ModelRenderer support9;
    ModelRenderer support10;
    ModelRenderer support11;
    ModelRenderer support12;
    ModelRenderer support13;
    ModelRenderer support14;
    ModelRenderer support15;
    ModelRenderer support16;
    ModelRenderer portConnector;
    ModelRenderer laserBeamToggle;

    public ModelSolarNeutronActivator() {
        textureWidth = 128;
        textureHeight = 64;

        pole = new ModelRenderer(this, 116, 0);
        pole.addBox(0F, 0F, 0F, 4, 15, 2);
        pole.setRotationPoint(-2F, -5F, 6F);
        pole.setTextureSize(128, 64);
        pole.mirror = true;
        setRotation(pole, 0F, 0F, 0F);
        panel3 = new ModelRenderer(this, 84, 32);
        panel3.addBox(-6F, 0F, -16F, 6, 1, 16);
        panel3.setRotationPoint(-2.75F, -4.95F, 8F);
        panel3.setTextureSize(128, 64);
        panel3.mirror = true;
        //TODO
        setRotation(panel3, -0.1082104F, 0.0279253F, 0.2617994F);
        port = new ModelRenderer(this, 0, 45);
        port.addBox(0F, 0F, 0F, 8, 8, 1);
        port.setRotationPoint(-4F, 12F, -8.01F);
        port.setTextureSize(128, 64);
        port.mirror = true;
        setRotation(port, 0F, 0F, 0F);
        panel1 = new ModelRenderer(this, 84, 32);
        panel1.mirror = true;
        panel1.addBox(0F, 0F, -16F, 6, 1, 16);
        panel1.setRotationPoint(2.75F, -4.95F, 8F);
        panel1.setTextureSize(128, 64);
        setRotation(panel1, -0.1082104F, -0.0279253F, -0.2617994F);
        panel2 = new ModelRenderer(this, 84, 15);
        panel2.addBox(0F, 0F, -16F, 6, 1, 16);
        panel2.setRotationPoint(-3F, -5F, 8F);
        panel2.setTextureSize(128, 64);
        panel2.mirror = true;
        setRotation(panel2, -0.1047198F, 0F, 0F);
        panelBase = new ModelRenderer(this, 28, 45);
        panelBase.addBox(0F, 1F, -16F, 6, 1, 14);
        panelBase.setRotationPoint(-3F, -5F, 9F);
        panelBase.setTextureSize(128, 64);
        panelBase.mirror = true;
        setRotation(panelBase, -0.1047198F, 0F, 0F);
        panelBraceLeft2 = new ModelRenderer(this, 64, 15);
        panelBraceLeft2.addBox(-4F, 0.5F, -5F, 5, 1, 2);
        panelBraceLeft2.setRotationPoint(-3F, -5F, 9F);
        panelBraceLeft2.setTextureSize(128, 64);
        panelBraceLeft2.mirror = true;
        setRotation(panelBraceLeft2, -0.1047198F, 0F, 0.2505517F);
        panelBraceRight2 = new ModelRenderer(this, 64, 15);
        panelBraceRight2.addBox(-1F, 0.5F, -5F, 5, 1, 2);
        panelBraceRight2.setRotationPoint(3F, -5F, 9F);
        panelBraceRight2.setTextureSize(128, 64);
        panelBraceRight2.mirror = true;
        setRotation(panelBraceRight2, -0.1047198F, 0F, -0.2555938F);
        panelBraceLeft1 = new ModelRenderer(this, 64, 15);
        panelBraceLeft1.addBox(-4F, 0.5F, -15F, 5, 1, 2);
        panelBraceLeft1.setRotationPoint(-3F, -5F, 9F);
        panelBraceLeft1.setTextureSize(128, 64);
        panelBraceLeft1.mirror = true;
        setRotation(panelBraceLeft1, -0.1047198F, 0F, 0.2505517F);
        panelBraceRight1 = new ModelRenderer(this, 64, 15);
        panelBraceRight1.addBox(-1F, 0.5F, -15F, 5, 1, 2);
        panelBraceRight1.setRotationPoint(3F, -5F, 9F);
        panelBraceRight1.setTextureSize(128, 64);
        panelBraceRight1.mirror = true;
        setRotation(panelBraceRight1, -0.1047198F, 0F, -0.2555938F);
        panelBrace = new ModelRenderer(this, 56, 18);
        panelBrace.addBox(0F, 1.2F, -10F, 2, 2, 9);
        panelBrace.setRotationPoint(-1F, -5F, 8F);
        panelBrace.setTextureSize(128, 64);
        panelBrace.mirror = true;
        setRotation(panelBrace, -0.1047198F, 0F, 0F);
        bridge = new ModelRenderer(this, 65, 1);
        bridge.addBox(0F, 0F, 0F, 12, 1, 13);
        bridge.setRotationPoint(-6F, 19F, -6F);
        bridge.setTextureSize(128, 64);
        bridge.mirror = true;
        setRotation(bridge, 0F, 0F, 0F);
        platform = new ModelRenderer(this, 18, 45);
        platform.addBox(-2.5F, 1F, -2.5F, 6, 3, 6);
        platform.setRotationPoint(-0.5F, 8F, -2.5F);
        platform.setTextureSize(128, 64);
        platform.mirror = true;
        setRotation(platform, -0.1047198F, 0F, 0F);
        hole2 = new ModelRenderer(this, 0, 6);
        hole2.addBox(1F, 0F, 0F, 1, 2, 1);
        hole2.setRotationPoint(-0.5F, 8F, -2.5F);
        hole2.setTextureSize(128, 64);
        hole2.mirror = true;
        setRotation(hole2, -0.1047198F, 0F, 0F);
        hole4 = new ModelRenderer(this, 0, 3);
        hole4.addBox(-1F, 0F, 1F, 3, 2, 1);
        hole4.setRotationPoint(-0.5F, 8F, -2.5F);
        hole4.setTextureSize(128, 64);
        hole4.mirror = true;
        setRotation(hole4, -0.1047198F, 0F, 0F);
        hole1 = new ModelRenderer(this, 0, 3);
        hole1.addBox(-1F, 0F, -1F, 3, 2, 1);
        hole1.setRotationPoint(-0.5F, 8F, -2.5F);
        hole1.setTextureSize(128, 64);
        hole1.mirror = true;
        setRotation(hole1, -0.1047198F, 0F, 0F);
        hole3 = new ModelRenderer(this, 0, 6);
        hole3.addBox(-1F, 0F, 0F, 1, 2, 1);
        hole3.setRotationPoint(-0.5F, 8F, -2.5F);
        hole3.setTextureSize(128, 64);
        hole3.mirror = true;
        setRotation(hole3, -0.1047198F, 0F, 0F);
        brace2 = new ModelRenderer(this, 0, 11);
        brace2.addBox(0F, 0F, 0F, 1, 1, 2);
        brace2.setRotationPoint(1F, 9.5F, -7.1F);
        brace2.setTextureSize(128, 64);
        brace2.mirror = true;
        setRotation(brace2, 0.1745329F, 0F, 0F);
        tube2c = new ModelRenderer(this, 0, 9);
        tube2c.addBox(0F, 0F, 0F, 1, 1, 1);
        tube2c.setRotationPoint(2F, 9F, 4F);
        tube2c.setTextureSize(128, 64);
        tube2c.mirror = true;
        setRotation(tube2c, 0F, 0F, 0F);
        tube1b = new ModelRenderer(this, 0, 14);
        tube1b.addBox(0F, 0F, 0F, 6, 1, 1);
        tube1b.setRotationPoint(-3F, 8F, 2F);
        tube1b.setTextureSize(128, 64);
        tube1b.mirror = true;
        setRotation(tube1b, 0F, 0F, 0F);
        tube1c = new ModelRenderer(this, 0, 9);
        tube1c.addBox(0F, 0F, 0F, 1, 1, 1);
        tube1c.setRotationPoint(2F, 9F, 2F);
        tube1c.setTextureSize(128, 64);
        tube1c.mirror = true;
        setRotation(tube1c, 0F, 0F, 0F);
        tube2b = new ModelRenderer(this, 0, 14);
        tube2b.addBox(0F, 0F, 0F, 6, 1, 1);
        tube2b.setRotationPoint(-3F, 8F, 4F);
        tube2b.setTextureSize(128, 64);
        tube2b.mirror = true;
        setRotation(tube2b, 0F, 0F, 0F);
        tube2a = new ModelRenderer(this, 0, 9);
        tube2a.addBox(0F, 0F, 0F, 1, 1, 1);
        tube2a.setRotationPoint(-3F, 9F, 4F);
        tube2a.setTextureSize(128, 64);
        tube2a.mirror = true;
        setRotation(tube2a, 0F, 0F, 0F);
        tube1a = new ModelRenderer(this, 0, 9);
        tube1a.addBox(0F, 0F, 0F, 1, 1, 1);
        tube1a.setRotationPoint(-3F, 9F, 2F);
        tube1a.setTextureSize(128, 64);
        tube1a.mirror = true;
        setRotation(tube1a, 0F, 0F, 0F);
        conduit = new ModelRenderer(this, 48, 0);
        conduit.addBox(0F, 0F, 0F, 2, 1, 7);
        conduit.setRotationPoint(-1F, 9.5F, -1F);
        conduit.setTextureSize(128, 64);
        conduit.mirror = true;
        setRotation(conduit, 0F, 0F, 0F);
        brace1 = new ModelRenderer(this, 0, 11);
        brace1.addBox(0F, 0F, 0F, 1, 1, 2);
        brace1.setRotationPoint(-2F, 9.5F, -7.1F);
        brace1.setTextureSize(128, 64);
        brace1.mirror = true;
        setRotation(brace1, 0.1745329F, 0F, 0F);
        tank = new ModelRenderer(this, 0, 0);
        tank.addBox(0F, 0F, 0F, 16, 9, 16);
        tank.setRotationPoint(-8F, 10F, -8F);
        tank.setTextureSize(128, 64);
        tank.mirror = true;
        setRotation(tank, 0F, 0F, 0F);
        laser = new ModelRenderer(this, 4, 0);
        laser.addBox(0.5F, 2.1F, -9F, 1, 2, 1);
        laser.setRotationPoint(-1F, -5F, 8F);
        laser.setTextureSize(128, 64);
        laser.mirror = true;
        setRotation(laser, -0.1117011F, 0F, 0F);
        base = new ModelRenderer(this, 0, 25);
        base.addBox(0F, 0F, 0F, 16, 4, 16);
        base.setRotationPoint(-8F, 20F, -8F);
        base.setTextureSize(128, 64);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        support1 = new ModelRenderer(this, 0, 0);
        support1.addBox(0F, 0F, 0F, 1, 1, 1);
        support1.setRotationPoint(6.5F, 19F, -7.5F);
        support1.setTextureSize(128, 64);
        support1.mirror = true;
        setRotation(support1, 0F, 0F, 0F);
        support2 = new ModelRenderer(this, 0, 0);
        support2.addBox(0F, 0F, 0F, 1, 1, 1);
        support2.setRotationPoint(6.5F, 19F, 6.5F);
        support2.setTextureSize(128, 64);
        support2.mirror = true;
        setRotation(support2, 0F, 0F, 0F);
        support3 = new ModelRenderer(this, 0, 0);
        support3.addBox(0F, 0F, 0F, 1, 1, 1);
        support3.setRotationPoint(6.5F, 19F, -5.5F);
        support3.setTextureSize(128, 64);
        support3.mirror = true;
        setRotation(support3, 0F, 0F, 0F);
        support4 = new ModelRenderer(this, 0, 0);
        support4.addBox(0F, 0F, 0F, 1, 1, 1);
        support4.setRotationPoint(6.5F, 19F, -3.5F);
        support4.setTextureSize(128, 64);
        support4.mirror = true;
        setRotation(support4, 0F, 0F, 0F);
        support5 = new ModelRenderer(this, 0, 0);
        support5.addBox(0F, 0F, 0F, 1, 1, 1);
        support5.setRotationPoint(6.5F, 19F, -1.5F);
        support5.setTextureSize(128, 64);
        support5.mirror = true;
        setRotation(support5, 0F, 0F, 0F);
        support6 = new ModelRenderer(this, 0, 0);
        support6.addBox(0F, 0F, 0F, 1, 1, 1);
        support6.setRotationPoint(6.5F, 19F, 0.5F);
        support6.setTextureSize(128, 64);
        support6.mirror = true;
        setRotation(support6, 0F, 0F, 0F);
        support7 = new ModelRenderer(this, 0, 0);
        support7.addBox(0F, 0F, 0F, 1, 1, 1);
        support7.setRotationPoint(6.5F, 19F, 2.5F);
        support7.setTextureSize(128, 64);
        support7.mirror = true;
        setRotation(support7, 0F, 0F, 0F);
        support8 = new ModelRenderer(this, 0, 0);
        support8.addBox(0F, 0F, 0F, 1, 1, 1);
        support8.setRotationPoint(6.5F, 19F, 4.5F);
        support8.setTextureSize(128, 64);
        support8.mirror = true;
        setRotation(support8, 0F, 0F, 0F);
        support9 = new ModelRenderer(this, 0, 0);
        support9.addBox(0F, 0F, 0F, 1, 1, 1);
        support9.setRotationPoint(-7.5F, 19F, 6.5F);
        support9.setTextureSize(128, 64);
        support9.mirror = true;
        setRotation(support9, 0F, 0F, 0F);
        support10 = new ModelRenderer(this, 0, 0);
        support10.addBox(0F, 0F, 0F, 1, 1, 1);
        support10.setRotationPoint(-7.5F, 19F, 4.5F);
        support10.setTextureSize(128, 64);
        support10.mirror = true;
        setRotation(support10, 0F, 0F, 0F);
        support11 = new ModelRenderer(this, 0, 0);
        support11.addBox(0F, 0F, 0F, 1, 1, 1);
        support11.setRotationPoint(-7.5F, 19F, 2.5F);
        support11.setTextureSize(128, 64);
        support11.mirror = true;
        setRotation(support11, 0F, 0F, 0F);
        support12 = new ModelRenderer(this, 0, 0);
        support12.addBox(0F, 0F, 0F, 1, 1, 1);
        support12.setRotationPoint(-7.5F, 19F, 0.5F);
        support12.setTextureSize(128, 64);
        support12.mirror = true;
        setRotation(support12, 0F, 0F, 0F);
        support13 = new ModelRenderer(this, 0, 0);
        support13.addBox(0F, 0F, 0F, 1, 1, 1);
        support13.setRotationPoint(-7.5F, 19F, -1.5F);
        support13.setTextureSize(128, 64);
        support13.mirror = true;
        setRotation(support13, 0F, 0F, 0F);
        support14 = new ModelRenderer(this, 0, 0);
        support14.addBox(0F, 0F, 0F, 1, 1, 1);
        support14.setRotationPoint(-7.5F, 19F, -3.5F);
        support14.setTextureSize(128, 64);
        support14.mirror = true;
        setRotation(support14, 0F, 0F, 0F);
        support15 = new ModelRenderer(this, 0, 0);
        support15.addBox(0F, 0F, 0F, 1, 1, 1);
        support15.setRotationPoint(-7.5F, 19F, -5.5F);
        support15.setTextureSize(128, 64);
        support15.mirror = true;
        setRotation(support15, 0F, 0F, 0F);
        support16 = new ModelRenderer(this, 0, 0);
        support16.addBox(0F, 0F, 0F, 1, 1, 1);
        support16.setRotationPoint(-7.5F, 19F, -7.5F);
        support16.setTextureSize(128, 64);
        support16.mirror = true;
        setRotation(support16, 0F, 0F, 0F);
        portConnector = new ModelRenderer(this, 0, 14);
        portConnector.addBox(0F, 0F, 0F, 6, 1, 1);
        portConnector.setRotationPoint(-3F, 19F, -7.01F);
        portConnector.setTextureSize(128, 64);
        portConnector.mirror = true;
        setRotation(portConnector, 0F, 0F, 0F);
        laserBeamToggle = new ModelRenderer(this, 12, 0);
        laserBeamToggle.addBox(0.5F, 4.1F, -9F, 1, 11, 1);
        laserBeamToggle.setRotationPoint(-1F, -5F, 8F);
        laserBeamToggle.setTextureSize(128, 64);
        laserBeamToggle.mirror = true;
        setRotation(laserBeamToggle, -0.1117011F, 0F, 0F);
    }

    public void render(float size,boolean renderlaser) {
        pole.render(size);
        panel3.render(size);
        port.render(size);
        panel1.render(size);
        panel2.render(size);
        panelBase.render(size);
        panelBraceLeft2.render(size);
        panelBraceRight2.render(size);
        panelBraceLeft1.render(size);
        panelBraceRight1.render(size);
        panelBrace.render(size);
        bridge.render(size);
        platform.render(size);
        hole2.render(size);
        hole4.render(size);
        hole1.render(size);
        hole3.render(size);
        brace2.render(size);
        tube2c.render(size);
        tube1b.render(size);
        tube1c.render(size);
        tube2b.render(size);
        tube2a.render(size);
        tube1a.render(size);
        conduit.render(size);
        brace1.render(size);
        tank.render(size);
        laser.render(size);
        base.render(size);
        support1.render(size);
        support2.render(size);
        support3.render(size);
        support4.render(size);
        support5.render(size);
        support6.render(size);
        support7.render(size);
        support8.render(size);
        support9.render(size);
        support10.render(size);
        support11.render(size);
        support12.render(size);
        support13.render(size);
        support14.render(size);
        support15.render(size);
        support16.render(size);
        portConnector.render(size);
        if (renderlaser) {
            laserBeamToggle.render(size);
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
