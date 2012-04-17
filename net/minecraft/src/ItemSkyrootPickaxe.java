// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemPickaxe, Block, AetherBlocks, EnumToolMaterial

public class ItemSkyrootPickaxe extends ItemPickaxe
    implements ITextureProvider
{

    private static Block blocksEffectiveAgainst[];
    private static Random random = new Random();

    public String getTextureFile()
    {
        return "/aetherItems.png";
    }

    protected ItemSkyrootPickaxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }

    public boolean canHarvestBlock(Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i].blockID == block.blockID)
            {
                return true;
            }
        }

        return false;
    }

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            AetherBlocks.Holystone, AetherBlocks.AmbrosiumOre, AetherBlocks.Freezer, AetherBlocks.QuicksoilGlass, AetherBlocks.Incubator
        });
    }
}
