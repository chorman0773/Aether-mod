// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, EntityPlayer, Block, Material, 
//            ItemStack, Item, InventoryPlayer, Slot, 
//            GuiContainerCreative, InventoryBasic

class ContainerCreative extends Container
{

    public List itemList;

    public ContainerCreative(EntityPlayer entityplayer)
    {
        itemList = new ArrayList();
        for(int i = 0; i < Block.blocksList.length; i++)
        {
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            int j2 = 0;
            int k2 = 0;
            int l2 = 0;
            int i3 = 1;
            int j3 = 0;
            if(Block.blocksList[i] == Block.cloth)
            {
                j3 = k1++;
            } else
            if(Block.blocksList[i] == Block.stairSingle)
            {
                j3 = l1++;
            } else
            if(Block.blocksList[i] == Block.wood)
            {
                j3 = i2++;
            } else
            if(Block.blocksList[i] == Block.sapling)
            {
                j3 = j2++;
            } else
            if(Block.blocksList[i] == Block.stoneBrick)
            {
                j3 = k2++;
            } else
            if(Block.blocksList[i] == Block.tallGrass)
            {
                j3 = i3++;
            } else
            if(Block.blocksList[i] == Block.leaves)
            {
                j3 = l2++;
            }
            if(Block.blocksList[i] != null && Block.blocksList[i].blockMaterial != Material.air && Block.blocksList[i].blockID != 191 && Block.blocksList[i].blockID != 192 && Block.blocksList[i].blockID != 199)
            {
                itemList.add(new ItemStack(Block.blocksList[i], 1, j3));
            }
        }

        for(int j = 0; j < 256; j++)
        {
            if(Block.blocksList[j] != null)
            {
                Block.blocksList[j].addCreativeItems((ArrayList)itemList);
            }
        }

        for(int k = 256; k < Item.itemsList.length; k++)
        {
            if(Item.itemsList[k] != null)
            {
                Item.itemsList[k].addCreativeItems((ArrayList)itemList);
            }
        }

        InventoryPlayer inventoryplayer = entityplayer.inventory;
        for(int l = 0; l < 9; l++)
        {
            for(int j1 = 0; j1 < 8; j1++)
            {
                addSlot(new Slot(GuiContainerCreative.getInventory(), j1 + l * 8, 8 + j1 * 18, 18 + l * 18));
            }

        }

        for(int i1 = 0; i1 < 9; i1++)
        {
            addSlot(new Slot(inventoryplayer, i1, 8 + i1 * 18, 184));
        }

        scrollTo(0.0F);
    }

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return true;
    }

    public void scrollTo(float f)
    {
        int i = (itemList.size() / 8 - 8) + 1;
        int j = (int)((double)(f * (float)i) + 0.5D);
        if(j < 0)
        {
            j = 0;
        }
        for(int k = 0; k < 9; k++)
        {
            for(int l = 0; l < 8; l++)
            {
                int i1 = l + (k + j) * 8;
                if(i1 >= 0 && i1 < itemList.size())
                {
                    GuiContainerCreative.getInventory().setInventorySlotContents(l + k * 8, (ItemStack)itemList.get(i1));
                } else
                {
                    GuiContainerCreative.getInventory().setInventorySlotContents(l + k * 8, null);
                }
            }

        }

    }

    protected void func_35373_b(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
    }
}
