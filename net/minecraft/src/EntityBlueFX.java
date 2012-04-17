// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityPortalFX, World

public class EntityBlueFX extends EntityPortalFX
{

    public EntityBlueFX(World world, double d, double d1, double d2, 
            double d3, double d4, double d5)
    {
        super(world, d, d1, d2, d3, d4, d5);
        particleBlue = 0.9764706F;
        particleRed = 0.3921569F;
        particleGreen = 0.9333333F;
    }
}
