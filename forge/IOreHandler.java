// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import net.minecraft.src.ItemStack;

public interface IOreHandler
{

    public abstract void registerOre(String s, ItemStack itemstack);
}
