// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            AetherItem, EntityPlayer, Item, InventoryPlayer, 
//            World, EntityFlamingArrow, ItemStack

public class ItemPhoenixBow extends AetherItem
{

    public ItemPhoenixBow(int i)
    {
        super(i);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(entityplayer.inventory.consumeInventoryItem(Item.arrow.shiftedIndex))
        {
            world.playSoundAtEntity(entityplayer, "mob.ghast.fireball", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!world.multiplayerWorld)
            {
                world.spawnEntityInWorld(new EntityFlamingArrow(world, entityplayer));
            }
        }
        return itemstack;
    }
}
