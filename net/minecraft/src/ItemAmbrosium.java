// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            AetherItem, ItemStack, EntityPlayer, World

public class ItemAmbrosium extends AetherItem
{

    private int healAmount;

    public ItemAmbrosium(int i, int j)
    {
        super(i);
        healAmount = j;
        maxStackSize = 64;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        itemstack.stackSize--;
        entityplayer.heal(healAmount);
        return itemstack;
    }

    public int getHealAmount()
    {
        return healAmount;
    }
}
