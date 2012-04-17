// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            Block, Material, StatList, EntityPlayer, 
//            ItemStack, World, mod_Aether, EntityItem

public class BlockHolystone extends Block
    implements ITextureProvider
{

    public static int sprNormal = 19;
    public static int sprMossy = 30;

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    protected BlockHolystone(int i)
    {
        super(i, sprNormal, Material.rock);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        ItemStack itemstack = new ItemStack(blockID, 1, l > 1 ? 2 : 0);
        if(mod_Aether.equippedSkyrootPick() && (l == 0 || l == 2))
        {
            itemstack.stackSize *= 2;
        }
        EntityItem entityitem = new EntityItem(world, i, j, k, itemstack);
        entityitem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityitem);
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j > 1)
        {
            return sprMossy;
        } else
        {
            return sprNormal;
        }
    }

}
