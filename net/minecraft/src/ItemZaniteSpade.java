// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            ItemTool, ItemStack, Item, Block, 
//            AetherBlocks, EnumToolMaterial

public class ItemZaniteSpade extends ItemTool
    implements ITextureProvider
{

    private static Block blocksEffectiveAgainst[];

    public String getTextureFile()
    {
        return "/aetherItems.png";
    }

    public ItemZaniteSpade(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 1, enumtoolmaterial, blocksEffectiveAgainst);
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return super.getStrVsBlock(itemstack, block) * ((float)(itemstack.getItemDamage() / itemstack.getItem().getMaxDamage()) + 0.5F);
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
            AetherBlocks.Quicksoil, AetherBlocks.Dirt, AetherBlocks.Grass, AetherBlocks.Aercloud, Block.snow
        });
    }
}
