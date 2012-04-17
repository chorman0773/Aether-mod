// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelAerbunny extends ModelBase
{

    public ModelRenderer onGround;
    public ModelRenderer isRiding;
    public ModelRenderer b2;
    public ModelRenderer b3;
    public ModelRenderer e1;
    public ModelRenderer e2;
    public ModelRenderer ff1;
    public ModelRenderer ff2;
    public ModelRenderer g;
    public ModelRenderer g2;
    public ModelRenderer h;
    public ModelRenderer h2;
    public float puffiness;

    public ModelAerbunny()
    {
        byte byte0 = 16;
        onGround = new ModelRenderer(this, 0, 0);
        onGround.addBox(-2F, -1F, -4F, 4, 4, 6, 0.0F);
        onGround.setRotationPoint(0.0F, -1 + byte0, -4F);
        g = new ModelRenderer(this, 14, 0);
        g.addBox(-2F, -5F, -3F, 1, 4, 2, 0.0F);
        g.setRotationPoint(0.0F, -1 + byte0, -4F);
        g2 = new ModelRenderer(this, 14, 0);
        g2.addBox(1.0F, -5F, -3F, 1, 4, 2, 0.0F);
        g2.setRotationPoint(0.0F, -1 + byte0, -4F);
        h = new ModelRenderer(this, 20, 0);
        h.addBox(-4F, 0.0F, -3F, 2, 3, 2, 0.0F);
        h.setRotationPoint(0.0F, -1 + byte0, -4F);
        h2 = new ModelRenderer(this, 20, 0);
        h2.addBox(2.0F, 0.0F, -3F, 2, 3, 2, 0.0F);
        h2.setRotationPoint(0.0F, -1 + byte0, -4F);
        isRiding = new ModelRenderer(this, 0, 10);
        isRiding.addBox(-3F, -4F, -3F, 6, 8, 6, 0.0F);
        isRiding.setRotationPoint(0.0F, 0 + byte0, 0.0F);
        b2 = new ModelRenderer(this, 0, 24);
        b2.addBox(-2F, 4F, -2F, 4, 3, 4, 0.0F);
        b2.setRotationPoint(0.0F, 0 + byte0, 0.0F);
        b3 = new ModelRenderer(this, 29, 0);
        b3.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7, 0.0F);
        b3.setRotationPoint(0.0F, 0.0F, 0.0F);
        e1 = new ModelRenderer(this, 24, 16);
        e1.addBox(-2F, 0.0F, -1F, 2, 2, 2);
        e1.setRotationPoint(3F, 3 + byte0, -3F);
        e2 = new ModelRenderer(this, 24, 16);
        e2.addBox(0.0F, 0.0F, -1F, 2, 2, 2);
        e2.setRotationPoint(-3F, 3 + byte0, -3F);
        ff1 = new ModelRenderer(this, 16, 24);
        ff1.addBox(-2F, 0.0F, -4F, 2, 2, 4);
        ff1.setRotationPoint(3F, 3 + byte0, 4F);
        ff2 = new ModelRenderer(this, 16, 24);
        ff2.addBox(0.0F, 0.0F, -4F, 2, 2, 4);
        ff2.setRotationPoint(-3F, 3 + byte0, 4F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        if(field_40301_k)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, f5, f5);
            onGround.render(f5);
            g.render(f5);
            g2.render(f5);
            h.render(f5);
            h2.render(f5);
            GL11.glPopMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 18F * f5, 0.0F);
            isRiding.render(f5);
            b2.render(f5);
            e1.render(f5);
            e2.render(f5);
            ff1.render(f5);
            ff2.render(f5);
            float f8 = 1.0F + puffiness * 0.5F;
            GL11.glTranslatef(0.0F, 1.0F, 0.0F);
            GL11.glScalef(f8, f8, f8);
            b3.render(f5);
        } else
        {
            onGround.render(f5);
            g.render(f5);
            g2.render(f5);
            h.render(f5);
            h2.render(f5);
            isRiding.render(f5);
            b2.render(f5);
            GL11.glPushMatrix();
            float f7 = 1.0F + puffiness * 0.5F;
            GL11.glTranslatef(0.0F, 1.0F, 0.0F);
            GL11.glScalef(f7, f7, f7);
            b3.render(f5);
            GL11.glPopMatrix();
            e1.render(f5);
            e2.render(f5);
            ff1.render(f5);
            ff2.render(f5);
        }
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        onGround.rotateAngleX = -(f4 / 57.29578F);
        onGround.rotateAngleY = f3 / 57.29578F;
        g.rotateAngleX = onGround.rotateAngleX;
        g.rotateAngleY = onGround.rotateAngleY;
        g2.rotateAngleX = onGround.rotateAngleX;
        g2.rotateAngleY = onGround.rotateAngleY;
        h.rotateAngleX = onGround.rotateAngleX;
        h.rotateAngleY = onGround.rotateAngleY;
        h2.rotateAngleX = onGround.rotateAngleX;
        h2.rotateAngleY = onGround.rotateAngleY;
        isRiding.rotateAngleX = 1.570796F;
        b2.rotateAngleX = 1.570796F;
        b3.rotateAngleX = 1.570796F;
        e1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        ff1.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.2F * f1;
        e2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.0F * f1;
        ff2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.2F * f1;
    }
}
