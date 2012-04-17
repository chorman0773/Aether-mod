// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AetherBlocks, BlockTrap

public class BlockDungeon extends Block
    implements ITextureProvider
{

    public static int sprBronze;
    public static int sprSilver;
    public static int sprGold;
    public static int sprBronzeLit = 26;
    public static int sprSilverLit = 25;
    public static int sprGoldLit = 27;

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    protected BlockDungeon(int i)
    {
        super(i, Material.rock);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 2)
        {
            return isLit() ? sprGoldLit : sprGold;
        }
        if(j == 1)
        {
            return isLit() ? sprSilverLit : sprSilver;
        } else
        {
            return isLit() ? sprBronzeLit : sprBronze;
        }
    }

    private boolean isLit()
    {
        return blockID == AetherBlocks.LightDungeonStone.blockID || blockID == AetherBlocks.LockedLightDungeonStone.blockID;
    }

    protected int damageDropped(int i)
    {
        return i;
    }

    public static int getBlockFromDye(int i)
    {
        return ~i & 0xf;
    }

    public static int getDyeFromBlock(int i)
    {
        return ~i & 0xf;
    }

    static 
    {
        sprBronze = BlockTrap.sprBronze;
        sprSilver = BlockTrap.sprSilver;
        sprGold = BlockTrap.sprGold;
    }
}
