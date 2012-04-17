// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, StatList, EntityPlayer, 
//            ItemStack, mod_Aether, EntityItem, World, 
//            InventoryPlayer, AetherItems, Item

public class BlockAetherLog extends Block
    implements ITextureProvider
{

    public static int sprTop = 41;
    public static int sprSide = 40;
    public static int sprGoldenSide = 11;
    private static Random rand = new Random();

    protected BlockAetherLog(int i)
    {
        super(i, sprSide, Material.wood);
    }

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i <= 1 && j <= 3)
        {
            return sprTop;
        }
        if(j <= 1)
        {
            return sprSide;
        } else
        {
            return sprGoldenSide;
        }
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        ItemStack itemstack = new ItemStack(blockID, 1, 0);
        if(mod_Aether.equippedSkyrootAxe() && l != 1)
        {
            itemstack.stackSize *= 2;
        }
        EntityItem entityitem = new EntityItem(world, i, j, k, itemstack);
        entityitem.delayBeforeCanPickup = 10;
        world.spawnEntityInWorld(entityitem);
        ItemStack itemstack2 = entityplayer.inventory.getCurrentItem();
        if(itemstack2 == null || itemstack2.itemID != AetherItems.AxeZanite.shiftedIndex && itemstack2.itemID != AetherItems.AxeGravitite.shiftedIndex && l >= 2)
        {
            return;
        }
        if(l > 1 && rand.nextBoolean())
        {
            ItemStack itemstack1 = new ItemStack(AetherItems.GoldenAmber.shiftedIndex, 2 + rand.nextInt(2), 0);
            EntityItem entityitem1 = new EntityItem(world, i, j, k, itemstack1);
            entityitem1.delayBeforeCanPickup = 10;
            world.spawnEntityInWorld(entityitem1);
        }
    }

}
