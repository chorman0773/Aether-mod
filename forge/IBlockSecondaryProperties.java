// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import net.minecraft.src.World;

public interface IBlockSecondaryProperties
{

    public abstract boolean isBlockNormalCube(World world, int i, int j, int k);

    public abstract boolean isBlockReplaceable(World world, int i, int j, int k);

    public abstract boolean isBlockBurning(World world, int i, int j, int k);

    public abstract boolean isAirBlock(World world, int i, int j, int k);
}
