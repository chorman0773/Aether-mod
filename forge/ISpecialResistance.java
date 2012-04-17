// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import net.minecraft.src.Entity;
import net.minecraft.src.World;

public interface ISpecialResistance
{

    public abstract float getSpecialExplosionResistance(World world, int i, int j, int k, double d, double d1, double d2, Entity entity);
}
