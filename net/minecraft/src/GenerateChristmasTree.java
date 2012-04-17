// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, AetherBlocks, Block, 
//            MathHelper

public class GenerateChristmasTree extends WorldGenerator
{

    public GenerateChristmasTree()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
        int l = world.getBlockId(i, j - 1, k);
        if(l == AetherBlocks.Grass.blockID || l == AetherBlocks.Dirt.blockID)
        {
            if(j + 9 <= world.worldHeight)
            {
                for(int j1 = j; j1 <= j + 8; j1++)
                {
                    world.setBlock(i, j1, k, AetherBlocks.Log.blockID);
                }

                world.setBlockAndMetadataWithNotify(i, j + 9, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k + 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 2, k - 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 4, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 4, j + 2, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k + 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k - 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k - 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 4, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 4, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 4, j + 2, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 4, j + 2, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 2, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 2, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 2, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 2, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 2, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 2, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 2, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 2, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 2, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 2, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 2, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 2, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k + 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 3, k - 4, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 4, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 4, j + 3, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 3, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 3, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 3, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 3, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 3, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 3, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 3, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 3, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 3, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 3, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 3, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 3, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 4, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 4, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 4, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 4, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 4, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 4, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 4, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 4, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 4, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 4, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 4, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 4, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 4, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 4, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 5, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 5, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 5, k + 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 5, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 5, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 5, k - 3, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 5, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 5, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 3, j + 5, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 5, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 5, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 3, j + 5, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 5, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 5, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 5, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 5, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 5, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 5, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 5, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 5, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 5, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 5, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 5, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 5, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 5, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 5, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 5, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 5, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 5, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 5, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 5, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 5, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 6, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 6, k + 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 6, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 6, k - 2, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 6, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 2, j + 6, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 6, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 2, j + 6, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 6, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 6, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 6, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 6, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 6, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 6, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 6, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 6, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 7, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 7, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 7, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 7, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 7, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 7, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 7, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 7, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 7, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 7, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 7, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 7, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 8, k + 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i, j + 8, k - 1, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i + 1, j + 8, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                world.setBlockAndMetadataWithNotify(i - 1, j + 8, k, AetherBlocks.ChristmasLeaves.blockID, random.nextInt(2));
                int i1 = world.getBlockId(i, j - 1, k);
                if(i1 == AetherBlocks.Grass.blockID || i1 == AetherBlocks.Dirt.blockID)
                {
                    world.setBlock(i, j - 1, k, AetherBlocks.Dirt.blockID);
                }
                for(int k1 = -20; k1 < 20; k1++)
                {
                    for(int l1 = -20; l1 < 20; l1++)
                    {
                        int i2 = random.nextInt(MathHelper.abs(l1) + MathHelper.abs(k1) + 1);
                        if(MathHelper.abs(l1) + MathHelper.abs(k1) > 15)
                        {
                            i2 += 5;
                        }
                        if(i2 >= 10)
                        {
                            continue;
                        }
                        int j2 = world.getBlockId(k1 + i, world.getHeightValue(k1 + i, l1 + k) - 1, l1 + k);
                        if(j2 == 0)
                        {
                            continue;
                        }
                        if(random.nextInt(80) == 0 && (j2 == AetherBlocks.Grass.blockID || j2 == AetherBlocks.Dirt.blockID))
                        {
                            world.setBlock(k1 + i, world.getHeightValue(k1 + i, l1 + k), l1 + k, AetherBlocks.blockPresent.blockID);
                        } else
                        {
                            world.setBlock(k1 + i, world.getHeightValue(k1 + i, l1 + k), l1 + k, Block.snow.blockID);
                        }
                    }

                }

            }
            return true;
        } else
        {
            return false;
        }
    }
}
