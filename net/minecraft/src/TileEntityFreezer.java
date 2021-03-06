// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, Frozen, Item, AetherItems, 
//            AetherBlocks, Block, World, EntityPlayer

public class TileEntityFreezer extends TileEntity
    implements IInventory
{

    private static List frozen = new ArrayList();
    private ItemStack frozenItemStacks[];
    public int frozenProgress;
    public int frozenPowerRemaining;
    public int frozenTimeForItem;
    private Frozen currentFrozen;

    public TileEntityFreezer()
    {
        frozenItemStacks = new ItemStack[3];
        frozenProgress = 0;
        frozenPowerRemaining = 0;
        frozenTimeForItem = 0;
    }

    public int getSizeInventory()
    {
        return frozenItemStacks.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return frozenItemStacks[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if(frozenItemStacks[i] != null)
        {
            if(frozenItemStacks[i].stackSize <= j)
            {
                ItemStack itemstack = frozenItemStacks[i];
                frozenItemStacks[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = frozenItemStacks[i].splitStack(j);
            if(frozenItemStacks[i].stackSize == 0)
            {
                frozenItemStacks[i] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        frozenItemStacks[i] = itemstack;
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return "Freezer";
    }

    public void openChest()
    {
    }

    public void closeChest()
    {
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        frozenItemStacks = new ItemStack[getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if(byte0 >= 0 && byte0 < frozenItemStacks.length)
            {
                frozenItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        frozenProgress = nbttagcompound.getShort("BurnTime");
        frozenTimeForItem = nbttagcompound.getShort("CookTime");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)frozenProgress);
        nbttagcompound.setShort("CookTime", (short)frozenTimeForItem);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < frozenItemStacks.length; i++)
        {
            if(frozenItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                frozenItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.setTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int i)
    {
        if(frozenTimeForItem == 0)
        {
            return 0;
        } else
        {
            return (frozenProgress * i) / frozenTimeForItem;
        }
    }

    public int getBurnTimeRemainingScaled(int i)
    {
        return (frozenPowerRemaining * i) / 500;
    }

    public boolean isBurning()
    {
        return frozenPowerRemaining > 0;
    }

    public void updateEntity()
    {
        if(frozenPowerRemaining > 0)
        {
            frozenPowerRemaining--;
            if(currentFrozen != null)
            {
                frozenProgress++;
            }
        }
        if(currentFrozen != null && (frozenItemStacks[0] == null || frozenItemStacks[0].itemID != currentFrozen.frozenFrom.itemID))
        {
            currentFrozen = null;
            frozenProgress = 0;
        }
        if(currentFrozen != null && frozenProgress >= currentFrozen.frozenPowerNeeded)
        {
            if(frozenItemStacks[2] == null)
            {
                setInventorySlotContents(2, new ItemStack(currentFrozen.frozenTo.getItem(), 1, currentFrozen.frozenTo.getItemDamage()));
            } else
            {
                setInventorySlotContents(2, new ItemStack(currentFrozen.frozenTo.getItem(), getStackInSlot(2).stackSize + 1, currentFrozen.frozenTo.getItemDamage()));
            }
            if(getStackInSlot(0).itemID == Item.bucketWater.shiftedIndex || getStackInSlot(0).itemID == Item.bucketLava.shiftedIndex)
            {
                setInventorySlotContents(0, new ItemStack(Item.bucketEmpty));
            } else
            if(getStackInSlot(0).itemID == AetherItems.Bucket.shiftedIndex)
            {
                setInventorySlotContents(0, new ItemStack(AetherItems.Bucket));
            } else
            {
                decrStackSize(0, 1);
            }
            frozenProgress = 0;
            currentFrozen = null;
            frozenTimeForItem = 0;
        }
        if(frozenPowerRemaining <= 0 && currentFrozen != null && getStackInSlot(1) != null && getStackInSlot(1).itemID == AetherBlocks.Icestone.blockID)
        {
            frozenPowerRemaining += 500;
            decrStackSize(1, 1);
        }
        if(currentFrozen == null)
        {
            ItemStack itemstack = getStackInSlot(0);
            for(int i = 0; i < frozen.size(); i++)
            {
                if(itemstack == null || frozen.get(i) == null || itemstack.itemID != ((Frozen)frozen.get(i)).frozenFrom.itemID || itemstack.getItemDamage() != ((Frozen)frozen.get(i)).frozenFrom.getItemDamage())
                {
                    continue;
                }
                if(frozenItemStacks[2] == null)
                {
                    currentFrozen = (Frozen)frozen.get(i);
                    frozenTimeForItem = currentFrozen.frozenPowerNeeded;
                    continue;
                }
                if(frozenItemStacks[2].itemID == ((Frozen)frozen.get(i)).frozenTo.itemID && ((Frozen)frozen.get(i)).frozenTo.getItem().getItemStackLimit() > frozenItemStacks[2].stackSize)
                {
                    currentFrozen = (Frozen)frozen.get(i);
                    frozenTimeForItem = currentFrozen.frozenPowerNeeded;
                }
            }

        }
    }

    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        } else
        {
            return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
        }
    }

    public static void addFrozen(ItemStack itemstack, ItemStack itemstack1, int i)
    {
        frozen.add(new Frozen(itemstack, itemstack1, i));
    }

    static 
    {
        addFrozen(new ItemStack(Item.bucketWater, 1), new ItemStack(Block.ice, 5), 500);
        addFrozen(new ItemStack(AetherItems.Bucket, 1, 8), new ItemStack(Block.ice, 5), 500);
        addFrozen(new ItemStack(Item.bucketLava, 1), new ItemStack(Block.obsidian, 2), 500);
        addFrozen(new ItemStack(AetherBlocks.Aercloud, 1, 0), new ItemStack(AetherBlocks.Aercloud, 1, 1), 50);
        addFrozen(new ItemStack(AetherItems.GoldPendant, 1), new ItemStack(AetherItems.IcePendant, 1), 2500);
        addFrozen(new ItemStack(AetherItems.GoldRing, 1), new ItemStack(AetherItems.IceRing, 1), 1500);
        addFrozen(new ItemStack(AetherItems.IronRing, 1), new ItemStack(AetherItems.IceRing, 1), 1500);
        addFrozen(new ItemStack(AetherItems.IronPendant, 1), new ItemStack(AetherItems.IcePendant, 1), 2500);
    }
}
