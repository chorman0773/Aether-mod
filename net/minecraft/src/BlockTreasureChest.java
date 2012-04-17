// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockChest, IBlockAccess, Block, World, 
//            TileEntityChest, EntityPlayer, InventoryPlayer, ItemStack, 
//            AetherItems, Item, GuiTreasureChest, ModLoader, 
//            TileEntityTreasureChest, TileEntity

public class BlockTreasureChest extends BlockChest
    implements ITextureProvider
{

    private Random random;
    private int sideTexture;

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    protected BlockTreasureChest(int i, int j, int k)
    {
        super(i);
        random = new Random();
        blockIndexInTexture = j;
        sideTexture = k;
    }

    public int quantityDropped(Random random1)
    {
        return 0;
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        if(l == 1)
        {
            return 62;
        }
        if(l == 0)
        {
            return 62;
        }
        int i1 = iblockaccess.getBlockId(i, j, k - 1);
        int j1 = iblockaccess.getBlockId(i, j, k + 1);
        int k1 = iblockaccess.getBlockId(i - 1, j, k);
        int l1 = iblockaccess.getBlockId(i + 1, j, k);
        byte byte0 = 3;
        if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[j1])
        {
            byte0 = 3;
        }
        if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[i1])
        {
            byte0 = 2;
        }
        if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[l1])
        {
            byte0 = 5;
        }
        if(Block.opaqueCubeLookup[l1] && !Block.opaqueCubeLookup[k1])
        {
            byte0 = 4;
        }
        return l == byte0 ? blockIndexInTexture : sideTexture;
    }

    public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return 51;
        }
        if(i == 0)
        {
            return 51;
        }
        if(i == 3)
        {
            return blockIndexInTexture;
        } else
        {
            return sideTexture;
        }
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return false;
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return true;
        }
        TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i, j, k);
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if(itemstack != null && itemstack.itemID == AetherItems.Key.shiftedIndex && itemstack.getItemDamage() == 0)
        {
            ModLoader.OpenGUI(entityplayer, new GuiTreasureChest(entityplayer.inventory, tileentitychest, 1));
            return true;
        }
        if(itemstack != null && itemstack.itemID == AetherItems.Key.shiftedIndex && itemstack.getItemDamage() == 1)
        {
            ModLoader.OpenGUI(entityplayer, new GuiTreasureChest(entityplayer.inventory, tileentitychest, 3));
            return true;
        }
        if(itemstack != null && itemstack.itemID == AetherItems.Key.shiftedIndex && itemstack.getItemDamage() == 2)
        {
            ModLoader.OpenGUI(entityplayer, new GuiTreasureChest(entityplayer.inventory, tileentitychest, 5));
            return true;
        } else
        {
            return false;
        }
    }

    public void checkForAdjacentChests()
    {
    }

    public TileEntity getBlockEntity()
    {
        return new TileEntityTreasureChest();
    }
}
