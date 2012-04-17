// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, EntityTNTPresent, Block, 
//            Entity

public class RenderTNTPresent extends Render
{

    private RenderBlocks blockRenderer;

    public RenderTNTPresent()
    {
        blockRenderer = new RenderBlocks();
        shadowSize = 0.5F;
    }

    public void func_153_a(EntityTNTPresent entitytntpresent, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        if(((float)entitytntpresent.fuse - f1) + 1.0F < 10F)
        {
            float f2 = 1.0F - (((float)entitytntpresent.fuse - f1) + 1.0F) / 10F;
            if(f2 < 0.0F)
            {
                f2 = 0.0F;
            }
            if(f2 > 1.0F)
            {
                f2 = 1.0F;
            }
            f2 *= f2;
            f2 *= f2;
            float f4 = 1.0F + f2 * 0.3F;
            GL11.glScalef(f4, f4, f4);
        }
        float f3 = (1.0F - (((float)entitytntpresent.fuse - f1) + 1.0F) / 100F) * 0.8F;
        loadTexture("/terrain.png");
        blockRenderer.renderBlockOnInventory(Block.tnt, 0, entitytntpresent.getEntityBrightness(f1));
        if((entitytntpresent.fuse / 5) % 2 == 0)
        {
            GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
            GL11.glDisable(2896 /*GL_LIGHTING*/);
            GL11.glEnable(3042 /*GL_BLEND*/);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f3);
            blockRenderer.renderBlockOnInventory(Block.tnt, 0, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042 /*GL_BLEND*/);
            GL11.glEnable(2896 /*GL_LIGHTING*/);
            GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        }
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        func_153_a((EntityTNTPresent)entity, d, d1, d2, f, f1);
    }
}
