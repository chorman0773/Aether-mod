// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Block, mod_Aether, Material, AetherBlocks, 
//            Item, World, EntityGoldenFX, ModLoader, 
//            EffectRenderer, Loc, EntityPlayer, ItemStack, 
//            ItemShears, StatList, IBlockAccess

public class BlockAetherLeaves extends Block
    implements ITextureProvider
{

    public static int sprSkyroot = 39;
    public static int sprGoldenOak = 12;

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    public int getRenderColor(int i)
    {
        return 0xffffff;
    }

    protected BlockAetherLeaves(int i)
    {
        super(i, i != mod_Aether.idBlockGoldenOakLeaves ? sprSkyroot : sprGoldenOak, Material.leaves);
        setTickOnLoad(true);
    }

    public int quantityDropped(Random random)
    {
        if(blockID == AetherBlocks.GoldenOakLeaves.blockID)
        {
            return random.nextInt(10) != 0 ? 0 : 1;
        } else
        {
            return random.nextInt(5) != 0 ? 0 : 1;
        }
    }

    public int idDropped(int i, Random random, int j)
    {
        if(blockID == AetherBlocks.SkyrootLeaves.blockID)
        {
            return AetherBlocks.SkyrootSapling.blockID;
        }
        if(random.nextInt(10) == 0)
        {
            return Item.appleGold.shiftedIndex;
        } else
        {
            return AetherBlocks.GoldenOakSapling.blockID;
        }
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        int l = 1;
        int i1 = l + 1;
        if(world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
        {
            for(int j1 = -l; j1 <= l; j1++)
            {
                for(int k1 = -l; k1 <= l; k1++)
                {
                    for(int l1 = -l; l1 <= l; l1++)
                    {
                        int i2 = world.getBlockId(i + j1, j + k1, k + l1);
                        if(i2 == blockID)
                        {
                            int j2 = world.getBlockMetadata(i + j1, j + k1, k + l1);
                            world.setBlockMetadata(i + j1, j + k1, k + l1, j2 | 8);
                        }
                    }

                }

            }

        }
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        super.randomDisplayTick(world, i, j, k, random);
        if(blockID == AetherBlocks.GoldenOakLeaves.blockID)
        {
            for(int l = 0; l < 4; l++)
            {
                double d = (double)(float)i + ((double)random.nextFloat() - 0.5D) * 10D;
                double d1 = (double)(float)j + ((double)random.nextFloat() - 0.5D) * 10D;
                double d2 = (double)(float)k + ((double)random.nextFloat() - 0.5D) * 10D;
                double d3 = 0.0D;
                double d4 = 0.0D;
                double d5 = 0.0D;
                d3 = ((double)random.nextFloat() - 0.5D) * 0.5D;
                d4 = ((double)random.nextFloat() - 0.5D) * 0.5D;
                d5 = ((double)random.nextFloat() - 0.5D) * 0.5D;
                EntityGoldenFX entitygoldenfx = new EntityGoldenFX(world, d, d1, d2, d3, d4, d5);
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(entitygoldenfx);
            }

        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld || AetherBlocks.GoldenOakSapling.blockID == blockID)
        {
            return;
        }
        if(!nearTrunk(world, i, j, k))
        {
            removeLeaves(world, i, j, k);
        }
    }

    private void removeLeaves(World world, int i, int j, int k)
    {
        world.setBlockWithNotify(i, j, k, 0);
    }

    private boolean nearTrunk(World world, int i, int j, int k)
    {
        Loc loc = new Loc(i, j, k);
        LinkedList linkedlist = new LinkedList();
        ArrayList arraylist = new ArrayList();
        linkedlist.offer(new Loc(i, j, k));
        int l = blockID;
        do
        {
            if(linkedlist.isEmpty())
            {
                break;
            }
            Loc loc1 = (Loc)linkedlist.poll();
            if(!arraylist.contains(loc1))
            {
                if(loc1.distSimple(loc) <= 4)
                {
                    int i1 = loc1.getBlock(world);
                    int j1 = loc1.getMeta(world);
                    if(i1 == AetherBlocks.Log.blockID)
                    {
                        return true;
                    }
                    if(i1 == l)
                    {
                        linkedlist.addAll(Arrays.asList(loc1.adjacent()));
                    }
                }
                arraylist.add(loc1);
            }
        } while(true);
        return false;
    }

    private boolean isMyTrunkMeta(int i)
    {
        if(blockID == AetherBlocks.SkyrootLeaves.blockID)
        {
            return i <= 1;
        } else
        {
            return i >= 2;
        }
    }

    protected int damageDropped(int i)
    {
        return i & 3;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if(!world.multiplayerWorld && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex)
        {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(blockID, 1, l & 3));
        } else
        {
            super.harvestBlock(world, entityplayer, i, j, k, l);
        }
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        return true;
    }

}
