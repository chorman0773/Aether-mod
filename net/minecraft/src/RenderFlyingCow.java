// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelFlyingCow2, EntityFlyingCow, ModelBase, 
//            EntityLiving

public class RenderFlyingCow extends RenderLiving
{

    private ModelBase wingmodel;

    public RenderFlyingCow(ModelBase modelbase, ModelBase modelbase1, float f)
    {
        super(modelbase, f);
        setRenderPassModel(modelbase1);
        wingmodel = modelbase1;
    }

    protected int setWoolColorAndRender(EntityFlyingCow entityflyingcow, int i, float f)
    {
        if(i == 0)
        {
            loadTexture("/aether/mobs/Mob_FlyingPigWings.png");
            ModelFlyingCow2.flyingcow = entityflyingcow;
            return 1;
        } else
        {
            return -1;
        }
    }

    protected int shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
        return setWoolColorAndRender((EntityFlyingCow)entityliving, i, f);
    }
}
