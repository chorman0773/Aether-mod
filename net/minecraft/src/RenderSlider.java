// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySlider, OpenGlHelper, ModelBase, 
//            EntityLiving

public class RenderSlider extends RenderLiving
{

    public RenderSlider(ModelBase modelbase, float f)
    {
        super(modelbase, f);
        renderPassModel = modelbase;
    }

    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        EntitySlider entityslider = (EntitySlider)entityliving;
        if(entityslider.harvey > 0.01F)
        {
            GL11.glRotatef(entityslider.harvey * -30F, entityslider.rennis, 0.0F, entityslider.dennis);
        }
    }

    protected int setSliderEyeBrightness(EntitySlider entityslider, int i, float f)
    {
        if(i != 0)
        {
            return -1;
        }
        if(entityslider.awake)
        {
            if(entityslider.criticalCondition())
            {
                loadTexture("/aether/mobs/sliderAwakeGlow_red.png");
            } else
            {
                loadTexture("/aether/mobs/sliderAwakeGlow.png");
            }
        } else
        {
            loadTexture("/aether/mobs/sliderSleepGlow.png");
        }
        float f1 = 1.0F;
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3008 /*GL_ALPHA_TEST*/);
        GL11.glBlendFunc(1, 1);
        int j = 61680;
        int k = j % 0x10000;
        int l = j / 0x10000;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapEnabled, (float)k / 1.0F, (float)l / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
        return 1;
    }

    protected int shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return setSliderEyeBrightness((EntitySlider)entityliving, i, f);
    }
}
