// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelZephyr extends ModelBase
{

    ModelRenderer body;

    public ModelZephyr()
    {
        byte byte0 = -16;
        body = new ModelRenderer(this, 0, 0);
        body.addBox(-8F, -4F, -8F, 10, 7, 12);
        body.rotationPointY += 24 + byte0;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        setRotationAngles(f, f1, f2, f3, f4, f5);
        body.render(f5);
    }
}
