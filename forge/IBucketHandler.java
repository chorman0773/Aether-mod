// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public interface IBucketHandler
{

    public abstract ItemStack fillCustomBucket(World world, int i, int j, int k);
}
