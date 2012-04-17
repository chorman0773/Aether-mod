// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import java.util.Random;
import net.minecraft.src.ItemStack;

public class DungeonLoot
{

    private ItemStack item;
    private int minCount;
    private int maxCount;

    public DungeonLoot(ItemStack itemstack, int i, int j)
    {
        minCount = 1;
        maxCount = 1;
        item = itemstack;
        minCount = i;
        maxCount = j;
    }

    public ItemStack generateStack(Random random)
    {
        ItemStack itemstack = item.copy();
        itemstack.stackSize = minCount + random.nextInt((maxCount - minCount) + 1);
        return itemstack;
    }

    public boolean equals(ItemStack itemstack, int i, int j)
    {
        return i == minCount && j == maxCount && itemstack.isItemEqual(item);
    }

    public boolean equals(ItemStack itemstack)
    {
        return itemstack.isItemEqual(item);
    }
}
