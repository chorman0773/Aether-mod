// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AetherItems, Item

public class BlockZaniteOre extends Block
    implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    protected BlockZaniteOre(int i)
    {
        super(i, 44, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return AetherItems.Zanite.shiftedIndex;
    }
}
