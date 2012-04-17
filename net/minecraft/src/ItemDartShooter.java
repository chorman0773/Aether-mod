// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            AetherItem, ItemStack, AetherItems, Item, 
//            World, EntityDartPoison, EntityDartGolden, EntityDartEnchanted, 
//            EntityPlayer, IInventory

public class ItemDartShooter extends AetherItem
{

    public static int sprNormal = 21;
    public static int sprPoison = 23;
    public static int sprEnchanted = 22;

    public ItemDartShooter(int i)
    {
        super(i);
        setHasSubtypes(true);
        maxStackSize = 1;
    }

    public int getIconFromDamage(int i)
    {
        if(i == 0)
        {
            return sprNormal;
        }
        if(i == 1)
        {
            return sprPoison;
        }
        if(i == 2)
        {
            return sprEnchanted;
        } else
        {
            return sprNormal;
        }
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        if(i > 2)
        {
            i = 2;
        }
        return (new StringBuilder()).append(getItemName()).append(i).toString();
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        int i = consumeItem(entityplayer, AetherItems.Dart.shiftedIndex, itemstack.getItemDamage());
        if(i != -1)
        {
            world.playSoundAtEntity(entityplayer, "aether.sound.other.dartshooter.shootDart", 2.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!world.multiplayerWorld)
            {
                Object obj = null;
                if(i == 1)
                {
                    obj = new EntityDartPoison(world, entityplayer);
                }
                if(i == 2)
                {
                    obj = new EntityDartEnchanted(world, entityplayer);
                }
                if(obj == null)
                {
                    obj = new EntityDartGolden(world, entityplayer);
                }
                world.spawnEntityInWorld(((Entity) (obj)));
            }
        }
        return itemstack;
    }

    private int consumeItem(EntityPlayer entityplayer, int i, int j)
    {
        InventoryPlayer inventoryplayer = entityplayer.inventory;
        for(int k = 0; k < inventoryplayer.getSizeInventory(); k++)
        {
            ItemStack itemstack = inventoryplayer.getStackInSlot(k);
            if(itemstack == null)
            {
                continue;
            }
            int l = itemstack.getItemDamage();
            if(itemstack.itemID != i || itemstack.getItemDamage() != j)
            {
                continue;
            }
            itemstack.stackSize--;
            if(itemstack.stackSize == 0)
            {
                itemstack = null;
            }
            inventoryplayer.setInventorySlotContents(k, itemstack);
            return l;
        }

        return -1;
    }

}
