// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumSkyBlock extends Enum
{

    public static final EnumSkyBlock Sky;
    public static final EnumSkyBlock Block;
    public final int defaultLightValue;
    private static final EnumSkyBlock allSkyBlocks[];
    private static final EnumSkyBlock $VALUES[]; /* synthetic field */

    public static EnumSkyBlock[] values()
    {
        return (EnumSkyBlock[])$VALUES.clone();
    }

    public static EnumSkyBlock valueOf(String s)
    {
        return (EnumSkyBlock)Enum.valueOf(net.minecraft.src.EnumSkyBlock.class, s);
    }

    private EnumSkyBlock(String s, int i, String s1, int j, int k)
    {
        super(s, i);
        defaultLightValue = k;
    }

    static 
    {
        Sky = new EnumSkyBlock("Sky", 0, "Sky", 0, 15);
        Block = new EnumSkyBlock("Block", 1, "Block", 1, 0);
        $VALUES = (new EnumSkyBlock[] {
            Sky, Block
        });
        allSkyBlocks = (new EnumSkyBlock[] {
            Sky, Block
        });
    }
}
