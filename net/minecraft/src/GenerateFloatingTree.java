// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, AetherBlocks, Block

public class GenerateFloatingTree extends WorldGenerator
{

    public GenerateFloatingTree()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        boolean flag = true;
        for(int l = i - 6; l < i + 6 + 6; l++)
        {
            for(int j1 = j - 6; j1 < j + 11 + 6; j1++)
            {
                for(int k1 = k - 6; k1 < k + 6 + 6; k1++)
                {
                    if(world.getBlockId(l, j1, k1) != 0)
                    {
                        flag = false;
                    }
                }

            }

        }

        if(j + 11 <= world.worldHeight && flag)
        {
            world.setBlock(i, j, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j, k + 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j, k - 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i + 1, j, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i - 1, j, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j + 1, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j + 1, k + 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j + 1, k + 2, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j + 1, k - 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j + 1, k - 2, AetherBlocks.Holystone.blockID);
            world.setBlock(i + 1, j + 1, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i + 2, j + 1, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i - 1, j + 1, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i - 2, j + 1, k, AetherBlocks.Holystone.blockID);
            world.setBlock(i + 1, j + 1, k + 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i + 1, j + 1, k - 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i - 1, j + 1, k - 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i - 1, j + 1, k + 1, AetherBlocks.Holystone.blockID);
            world.setBlock(i, j + 2, k, AetherBlocks.Grass.blockID);
            world.setBlock(i, j + 2, k + 1, AetherBlocks.Grass.blockID);
            world.setBlock(i, j + 2, k + 2, AetherBlocks.Grass.blockID);
            world.setBlock(i, j + 2, k - 1, AetherBlocks.Grass.blockID);
            world.setBlock(i, j + 2, k - 2, AetherBlocks.Grass.blockID);
            world.setBlock(i + 1, j + 2, k, AetherBlocks.Grass.blockID);
            world.setBlock(i + 2, j + 2, k, AetherBlocks.Grass.blockID);
            world.setBlock(i - 1, j + 2, k, AetherBlocks.Grass.blockID);
            world.setBlock(i - 2, j + 2, k, AetherBlocks.Grass.blockID);
            world.setBlock(i + 1, j + 2, k + 1, AetherBlocks.Grass.blockID);
            world.setBlock(i + 1, j + 2, k - 1, AetherBlocks.Grass.blockID);
            world.setBlock(i - 1, j + 2, k - 1, AetherBlocks.Grass.blockID);
            world.setBlock(i - 1, j + 2, k + 1, AetherBlocks.Grass.blockID);
            for(int i1 = j + 3; i1 <= j + 9; i1++)
            {
                world.setBlock(i, i1, k, AetherBlocks.Log.blockID);
            }

            world.setBlockAndMetadataWithNotify(i, j + 10, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlock(i + 1, j + 5, k, AetherBlocks.Log.blockID);
            world.setBlock(i - 1, j + 5, k, AetherBlocks.Log.blockID);
            world.setBlock(i, j + 5, k + 1, AetherBlocks.Log.blockID);
            world.setBlock(i, j + 5, k - 1, AetherBlocks.Log.blockID);
            world.setBlockAndMetadataWithNotify(i, j + 5, k - 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 5, k + 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 2, j + 5, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 2, j + 5, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 5, k - 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 5, k - 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 5, k + 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 5, k + 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 2, j + 5, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 2, j + 5, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 2, j + 5, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 2, j + 5, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 5, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 5, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 5, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 5, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 6, k - 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 6, k + 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 2, j + 6, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 2, j + 6, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 6, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 6, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 6, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 6, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 6, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 6, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 6, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 6, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 7, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 7, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 7, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 7, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlock(i + 1, j + 8, k, AetherBlocks.Log.blockID);
            world.setBlock(i - 1, j + 8, k, AetherBlocks.Log.blockID);
            world.setBlock(i, j + 8, k + 1, AetherBlocks.Log.blockID);
            world.setBlock(i, j + 8, k - 1, AetherBlocks.Log.blockID);
            world.setBlockAndMetadataWithNotify(i, j + 8, k - 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 8, k + 2, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 2, j + 8, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 2, j + 8, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 8, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 8, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 8, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 8, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i + 1, j + 9, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i - 1, j + 9, k, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 9, k + 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            world.setBlockAndMetadataWithNotify(i, j + 9, k - 1, AetherBlocks.BlueLeaves.blockID, random.nextInt(2));
            return true;
        } else
        {
            return false;
        }
    }
}
