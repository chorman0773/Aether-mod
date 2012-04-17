// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, TileEntityIncubatorSlot, Slot, InventoryPlayer, 
//            TileEntityIncubator, ItemStack, EntityPlayer

public class ContainerIncubator extends Container
{

    private TileEntityIncubator Incubator;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;

    public ContainerIncubator(InventoryPlayer inventoryplayer, TileEntityIncubator tileentityincubator)
    {
        cookTime = 0;
        burnTime = 0;
        itemBurnTime = 0;
        Incubator = tileentityincubator;
        addSlot(new TileEntityIncubatorSlot(tileentityincubator, 1, 73, 17));
        addSlot(new Slot(tileentityincubator, 0, 73, 53));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                addSlot(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            addSlot(new Slot(inventoryplayer, j, 8 + j * 18, 142));
        }

    }

    protected boolean mergeItemStack(ItemStack itemstack, int i, int j, boolean flag)
    {
        return false;
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return Incubator.isUseableByPlayer(entityplayer);
    }

    public ItemStack getStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(i);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i == 2)
            {
                mergeItemStack(itemstack1, 3, 39, true);
            } else
            if(i >= 3 && i < 30)
            {
                mergeItemStack(itemstack1, 30, 39, false);
            } else
            if(i >= 30 && i < 39)
            {
                mergeItemStack(itemstack1, 3, 30, false);
            } else
            {
                mergeItemStack(itemstack1, 3, 39, false);
            }
            if(itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            } else
            {
                slot.onSlotChanged();
            }
            if(itemstack1.stackSize != itemstack.stackSize)
            {
                slot.onPickupFromSlot(itemstack1);
            } else
            {
                return null;
            }
        }
        return itemstack;
    }
}
