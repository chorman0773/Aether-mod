// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;

public interface IDestroyToolHandler
{

    public abstract void onDestroyCurrentItem(EntityPlayer entityplayer, ItemStack itemstack);
}