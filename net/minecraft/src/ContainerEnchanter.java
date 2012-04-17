// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Slot, SlotFurnace, InventoryPlayer, 
//            TileEntityEnchanter, ICrafting, ItemStack, EntityPlayer

public class ContainerEnchanter extends Container
{

    private TileEntityEnchanter enchanter;
    private int cookTime;
    private int burnTime;
    private int itemBurnTime;

    public ContainerEnchanter(InventoryPlayer inventoryplayer, TileEntityEnchanter tileentityenchanter)
    {
        cookTime = 0;
        burnTime = 0;
        itemBurnTime = 0;
        enchanter = tileentityenchanter;
        addSlot(new Slot(tileentityenchanter, 0, 56, 17));
        addSlot(new Slot(tileentityenchanter, 1, 56, 53));
        addSlot(new SlotFurnace(inventoryplayer.player, tileentityenchanter, 2, 116, 35));
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

    public void updateCraftingResults()
    {
        super.updateCraftingResults();
        for(int i = 0; i < crafters.size(); i++)
        {
            ICrafting icrafting = (ICrafting)crafters.get(i);
            if(cookTime != enchanter.enchantTimeForItem)
            {
                icrafting.updateCraftingInventoryInfo(this, 0, enchanter.enchantTimeForItem);
            }
            if(burnTime != enchanter.enchantProgress)
            {
                icrafting.updateCraftingInventoryInfo(this, 1, enchanter.enchantProgress);
            }
            if(itemBurnTime != enchanter.enchantPowerRemaining)
            {
                icrafting.updateCraftingInventoryInfo(this, 2, enchanter.enchantPowerRemaining);
            }
        }

        cookTime = enchanter.enchantTimeForItem;
        burnTime = enchanter.enchantProgress;
        itemBurnTime = enchanter.enchantPowerRemaining;
    }

    public ItemStack transferStackInSlot(int i)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(i);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(i == 2)
            {
                if(!mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }
            } else
            if(i >= 3 && i < 30)
            {
                if(!mergeItemStack(itemstack1, 30, 39, false))
                {
                    return null;
                }
            } else
            if(i >= 30 && i < 39)
            {
                if(!mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            } else
            if(!mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
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

    public void updateProgressBar(int i, int j)
    {
        if(i == 0)
        {
            enchanter.enchantTimeForItem = j;
        }
        if(i == 1)
        {
            enchanter.enchantProgress = j;
        }
        if(i == 2)
        {
            enchanter.enchantPowerRemaining = j;
        }
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return enchanter.isUseableByPlayer(entityplayer);
    }
}
