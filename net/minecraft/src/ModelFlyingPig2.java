// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityPhyg, Entity

public class ModelFlyingPig2 extends ModelBase
{

    private ModelRenderer leftWingInner;
    private ModelRenderer leftWingOuter;
    private ModelRenderer rightWingInner;
    private ModelRenderer rightWingOuter;
    public static EntityPhyg pig;

    public ModelFlyingPig2()
    {
        leftWingInner = new ModelRenderer(this, 0, 0);
        leftWingOuter = new ModelRenderer(this, 20, 0);
        rightWingInner = new ModelRenderer(this, 0, 0);
        rightWingOuter = new ModelRenderer(this, 40, 0);
        leftWingInner.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        leftWingOuter.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        rightWingInner.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        rightWingOuter.addBox(-1F, -8F, -4F, 2, 16, 8, 0.0F);
        rightWingOuter.rotateAngleY = 3.141593F;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        if(field_40301_k)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glPopMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24F * f5, 0.0F);
            float f8 = -(float)Math.acos(pig.wingFold);
            float f10 = (32F * pig.wingFold) / 4F;
            float f12 = (-32F * (float)Math.sqrt(1.0F - pig.wingFold * pig.wingFold)) / 4F;
            float f14 = 0.0F;
            float f16 = f10 * (float)Math.cos(pig.wingAngle) - f12 * (float)Math.sin(pig.wingAngle);
            float f18 = f10 * (float)Math.sin(pig.wingAngle) + f12 * (float)Math.cos(pig.wingAngle);
            leftWingInner.setRotationPoint(4F + f16, f18 + 12F, f14);
            rightWingInner.setRotationPoint(-4F - f16, f18 + 12F, f14);
            f10 *= 3F;
            f16 = f10 * (float)Math.cos(pig.wingAngle) - f12 * (float)Math.sin(pig.wingAngle);
            f18 = f10 * (float)Math.sin(pig.wingAngle) + f12 * (float)Math.cos(pig.wingAngle);
            leftWingOuter.setRotationPoint(4F + f16, f18 + 12F, f14);
            rightWingOuter.setRotationPoint(-4F - f16, f18 + 12F, f14);
            leftWingInner.rotateAngleZ = pig.wingAngle + f8 + 1.570796F;
            leftWingOuter.rotateAngleZ = (pig.wingAngle - f8) + 1.570796F;
            rightWingInner.rotateAngleZ = -((pig.wingAngle + f8) - 1.570796F);
            rightWingOuter.rotateAngleZ = -((pig.wingAngle - f8) + 1.570796F);
            leftWingOuter.render(f5);
            leftWingInner.render(f5);
            rightWingOuter.render(f5);
            rightWingInner.render(f5);
        } else
        {
            float f7 = -(float)Math.acos(pig.wingFold);
            float f9 = (32F * pig.wingFold) / 4F;
            float f11 = (-32F * (float)Math.sqrt(1.0F - pig.wingFold * pig.wingFold)) / 4F;
            float f13 = 0.0F;
            float f15 = f9 * (float)Math.cos(pig.wingAngle) - f11 * (float)Math.sin(pig.wingAngle);
            float f17 = f9 * (float)Math.sin(pig.wingAngle) + f11 * (float)Math.cos(pig.wingAngle);
            leftWingInner.setRotationPoint(4F + f15, f17 + 12F, f13);
            rightWingInner.setRotationPoint(-4F - f15, f17 + 12F, f13);
            f9 *= 3F;
            f15 = f9 * (float)Math.cos(pig.wingAngle) - f11 * (float)Math.sin(pig.wingAngle);
            f17 = f9 * (float)Math.sin(pig.wingAngle) + f11 * (float)Math.cos(pig.wingAngle);
            leftWingOuter.setRotationPoint(4F + f15, f17 + 12F, f13);
            rightWingOuter.setRotationPoint(-4F - f15, f17 + 12F, f13);
            leftWingInner.rotateAngleZ = pig.wingAngle + f7 + 1.570796F;
            leftWingOuter.rotateAngleZ = (pig.wingAngle - f7) + 1.570796F;
            rightWingInner.rotateAngleZ = -((pig.wingAngle + f7) - 1.570796F);
            rightWingOuter.rotateAngleZ = -((pig.wingAngle - f7) + 1.570796F);
            leftWingOuter.render(f5);
            leftWingInner.render(f5);
            rightWingOuter.render(f5);
            rightWingInner.render(f5);
        }
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }
}
