// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            AchievementPage, ItemStack, Block, AetherBlocks, 
//            BlockHolystone

public class AetherACPage extends AchievementPage
{

    public AetherACPage()
    {
        super(new ItemStack(Block.blocksList[2]), "Aether");
    }

    public int bgGetSprite(Random random, int i, int j)
    {
        int k = Block.sand.blockIndexInTexture;
        int l = random.nextInt(1 + j) + j / 2;
        if(l > 37 || j == 35)
        {
            k = AetherBlocks.Aercloud.blockIndexInTexture;
        } else
        if(l == 22)
        {
            k = random.nextInt(2) == 0 ? AetherBlocks.GravititeOre.blockIndexInTexture : BlockHolystone.sprMossy;
        } else
        if(l == 10)
        {
            k = AetherBlocks.ZaniteOre.blockIndexInTexture;
        } else
        if(l == 8)
        {
            k = AetherBlocks.AmbrosiumOre.blockIndexInTexture;
        } else
        if(l > 4)
        {
            k = AetherBlocks.Holystone.blockIndexInTexture;
        } else
        if(l > 0)
        {
            k = AetherBlocks.Dirt.blockIndexInTexture;
        }
        return k;
    }
}
