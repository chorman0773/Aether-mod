// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import net.minecraft.src.*;

public interface IHighlightHandler
{

    public abstract boolean onBlockHighlight(RenderGlobal renderglobal, EntityPlayer entityplayer, MovingObjectPosition movingobjectposition, int i, ItemStack itemstack, float f);
}
