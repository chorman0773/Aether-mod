// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            World

public interface IBlockSet
{

    public abstract boolean iBlockMatches(World world, int i, int j, int k, int l);

    public abstract int iBlockGet(World world, int i, int j, int k, int l);

    public abstract void iAfterIntercept(World world, int i, int j, int k, int l);
}
