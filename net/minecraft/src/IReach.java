// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemStack

public interface IReach
{

    public abstract boolean iReachMatches(boolean flag, ItemStack itemstack);

    public abstract float iReachGet(boolean flag, ItemStack itemstack);
}
