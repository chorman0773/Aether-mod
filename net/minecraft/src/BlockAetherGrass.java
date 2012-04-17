// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AetherBlocks, World, 
//            StatList, EntityPlayer, mod_Aether, EntityGoldenFX, 
//            ModLoader, EffectRenderer, ItemStack, AetherItems, 
//            Item

public class BlockAetherGrass extends Block
    implements ITextureProvider
{

    public static int sprTop = 16;
    public static int sprSide = 15;
    public static int sprGoldTop = 53;
    public static int sprGoldSide = 52;

    protected BlockAetherGrass(int i)
    {
        super(i, sprTop, Material.ground);
        setTickOnLoad(true);
        setRequiresSelfNotify();
    }

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            if(j == 0)
            {
                return sprTop;
            }
            if(j == 1)
            {
                return sprGoldTop;
            }
        }
        if(i == 0)
        {
            return AetherBlocks.Dirt.blockIndexInTexture;
        }
        if(j == 1)
        {
            return sprGoldSide;
        } else
        {
            return sprSide;
        }
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
        if(world.getBlockLightValue(i, j + 1, k) < 4 && world.getBlockMaterial(i, j + 1, k).getCanBlockGrass())
        {
            if(random.nextInt(4) != 0)
            {
                return;
            }
            world.setBlockWithNotify(i, j, k, AetherBlocks.Dirt.blockID);
        } else
        if(world.getBlockLightValue(i, j + 1, k) >= 9)
        {
            int l = (i + random.nextInt(3)) - 1;
            int i1 = (j + random.nextInt(5)) - 3;
            int j1 = (k + random.nextInt(3)) - 1;
            if(world.getBlockId(l, i1, j1) == AetherBlocks.Dirt.blockID && world.getBlockLightValue(l, i1 + 1, j1) >= 4 && !world.getBlockMaterial(l, i1 + 1, j1).getCanBlockGrass())
            {
                world.setBlockAndMetadataWithNotify(l, i1, j1, AetherBlocks.Grass.blockID, 0);
            }
        }
    }

    public int idDropped(int i, Random random, int j)
    {
        return AetherBlocks.Dirt.idDropped(0, random, j);
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
        if(mod_Aether.equippedSkyrootShovel())
        {
            dropBlockAsItem(world, i, j, k, l, 0);
        }
        super.harvestBlock(world, entityplayer, i, j, k, l);
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        super.randomDisplayTick(world, i, j, k, random);
        if(random.nextInt(10) == 0 && world.getBlockMetadata(i, j, k) == 1)
        {
            for(int l = 0; l < 4; l++)
            {
                EntityGoldenFX entitygoldenfx = new EntityGoldenFX(world, (float)i + random.nextFloat(), (float)j + 1.1F, (float)k + random.nextFloat(), 0.0D, 0.0D, 0.0D);
                ModLoader.getMinecraftInstance().effectRenderer.addEffect(entitygoldenfx);
            }

        }
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        if(world.multiplayerWorld)
        {
            return false;
        }
        if(entityplayer == null)
        {
            return false;
        }
        ItemStack itemstack = entityplayer.getCurrentEquippedItem();
        if(itemstack == null)
        {
            return false;
        }
        if(itemstack.itemID == AetherItems.AmbrosiumShard.shiftedIndex && world.getBlockMetadata(i, j, k) == 0)
        {
            world.setBlockMetadataWithNotify(i, j, k, 1);
            itemstack.stackSize--;
            return true;
        }
        if(itemstack.itemID == Item.dyePowder.shiftedIndex && itemstack.getItemDamage() == 15)
        {
            itemstack.stackSize--;
            int l = 0;
label0:
            for(int i1 = 0; i1 < 64; i1++)
            {
                int j1 = i;
                int k1 = j + 1;
                int l1 = k;
                for(int i2 = 0; i2 < i1 / 16; i2++)
                {
                    j1 += world.rand.nextInt(3) - 1;
                    k1 += ((world.rand.nextInt(3) - 1) * world.rand.nextInt(3)) / 2;
                    l1 += world.rand.nextInt(3) - 1;
                    if(world.getBlockId(j1, k1 - 1, l1) != blockID || world.isBlockNormalCube(j1, k1, l1))
                    {
                        continue label0;
                    }
                }

                if(world.getBlockId(j1, k1, l1) != 0)
                {
                    continue;
                }
                if(world.rand.nextInt(20 + 10 * l) == 0)
                {
                    world.setBlockWithNotify(j1, k1, l1, mod_Aether.idBlockWhiteFlower);
                    l++;
                    continue;
                }
                if(world.rand.nextInt(10 + 2 * l) <= 2)
                {
                    world.setBlockWithNotify(j1, k1, l1, mod_Aether.idBlockPurpleFlower);
                    l++;
                }
            }

        }
        return false;
    }

}
