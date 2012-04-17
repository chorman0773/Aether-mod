// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenClay, WorldGenSand, Block, WorldGenMinable, 
//            WorldGenFlowers, BlockFlower, WorldGenBigMushroom, WorldGenReed, 
//            WorldGenCactus, MapGenWaterlily, World, WorldGenerator, 
//            BiomeGenBase, WorldGenTallGrass, BlockTallGrass, WorldGenDeadBush, 
//            BlockDeadBush, WorldGenPumpkin, WorldGenLiquids

public class BiomeDecorator
{

    protected World currentWorld;
    protected Random decoRNG;
    protected int chunk_X;
    protected int chunk_Z;
    protected BiomeGenBase biome;
    protected WorldGenerator clayGen;
    protected WorldGenerator sandGen;
    protected WorldGenerator gravelAsSandGen;
    protected WorldGenerator dirtGen;
    protected WorldGenerator gravelGen;
    protected WorldGenerator coalGen;
    protected WorldGenerator ironGen;
    protected WorldGenerator goldGen;
    protected WorldGenerator redstoneGen;
    protected WorldGenerator diamondGen;
    protected WorldGenerator lapisGen;
    protected WorldGenerator plantYellowGen;
    protected WorldGenerator plantRedGen;
    protected WorldGenerator mushroomBrownGen;
    protected WorldGenerator mushroomRedGen;
    protected WorldGenerator field_40720_u;
    protected WorldGenerator reedGen;
    protected WorldGenerator cactusGen;
    protected WorldGenerator waterlilyGen;
    protected int waterlilyPerChunk;
    protected int treesPerChunk;
    protected int flowersPerChunk;
    protected int grassPerChunk;
    protected int deadBushPerChunk;
    protected int mushroomsPerChunk;
    protected int reedsPerChunk;
    protected int cactiPerChunk;
    protected int sandPerChunk;
    protected int sandPerChunk2;
    protected int clayPerChunk;
    protected int field_40718_J;
    public boolean generateFluid;

    public BiomeDecorator(BiomeGenBase biomegenbase)
    {
        clayGen = new WorldGenClay(4);
        sandGen = new WorldGenSand(7, Block.sand.blockID);
        gravelAsSandGen = new WorldGenSand(6, Block.gravel.blockID);
        dirtGen = new WorldGenMinable(Block.dirt.blockID, 32);
        gravelGen = new WorldGenMinable(Block.gravel.blockID, 32);
        coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
        ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
        goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
        redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
        diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
        lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
        plantYellowGen = new WorldGenFlowers(Block.plantYellow.blockID);
        plantRedGen = new WorldGenFlowers(Block.plantRed.blockID);
        mushroomBrownGen = new WorldGenFlowers(Block.mushroomBrown.blockID);
        mushroomRedGen = new WorldGenFlowers(Block.mushroomRed.blockID);
        field_40720_u = new WorldGenBigMushroom();
        reedGen = new WorldGenReed();
        cactusGen = new WorldGenCactus();
        waterlilyGen = new MapGenWaterlily();
        waterlilyPerChunk = 0;
        treesPerChunk = 0;
        flowersPerChunk = 2;
        grassPerChunk = 1;
        deadBushPerChunk = 0;
        mushroomsPerChunk = 0;
        reedsPerChunk = 0;
        cactiPerChunk = 0;
        sandPerChunk = 1;
        sandPerChunk2 = 3;
        clayPerChunk = 1;
        field_40718_J = 0;
        generateFluid = true;
        biome = biomegenbase;
    }

    public void decorate(World world, Random random, int i, int j)
    {
        if(currentWorld != null)
        {
            throw new RuntimeException("Already decorating!!");
        } else
        {
            currentWorld = world;
            decoRNG = random;
            chunk_X = i;
            chunk_Z = j;
            decorate_do();
            currentWorld = null;
            decoRNG = null;
            return;
        }
    }

    protected void decorate_do()
    {
        generateOres();
        for(int i = 0; i < sandPerChunk2; i++)
        {
            int i1 = chunk_X + decoRNG.nextInt(16) + 8;
            int k5 = chunk_Z + decoRNG.nextInt(16) + 8;
            sandGen.generate(currentWorld, decoRNG, i1, currentWorld.getTopSolidOrLiquidBlock(i1, k5), k5);
        }

        for(int j = 0; j < clayPerChunk; j++)
        {
            int j1 = chunk_X + decoRNG.nextInt(16) + 8;
            int l5 = chunk_Z + decoRNG.nextInt(16) + 8;
            clayGen.generate(currentWorld, decoRNG, j1, currentWorld.getTopSolidOrLiquidBlock(j1, l5), l5);
        }

        for(int k = 0; k < sandPerChunk; k++)
        {
            int k1 = chunk_X + decoRNG.nextInt(16) + 8;
            int i6 = chunk_Z + decoRNG.nextInt(16) + 8;
            sandGen.generate(currentWorld, decoRNG, k1, currentWorld.getTopSolidOrLiquidBlock(k1, i6), i6);
        }

        int l = treesPerChunk;
        if(decoRNG.nextInt(10) == 0)
        {
            l++;
        }
        for(int l1 = 0; l1 < l; l1++)
        {
            int j6 = chunk_X + decoRNG.nextInt(16) + 8;
            int j10 = chunk_Z + decoRNG.nextInt(16) + 8;
            WorldGenerator worldgenerator = biome.getRandomWorldGenForTrees(decoRNG);
            worldgenerator.func_517_a(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(currentWorld, decoRNG, j6, currentWorld.getHeightValue(j6, j10), j10);
        }

        for(int i2 = 0; i2 < field_40718_J; i2++)
        {
            int k6 = chunk_X + decoRNG.nextInt(16) + 8;
            int k10 = chunk_Z + decoRNG.nextInt(16) + 8;
            field_40720_u.generate(currentWorld, decoRNG, k6, currentWorld.getHeightValue(k6, k10), k10);
        }

        for(int j2 = 0; j2 < flowersPerChunk; j2++)
        {
            int l6 = chunk_X + decoRNG.nextInt(16) + 8;
            int l10 = decoRNG.nextInt(currentWorld.worldHeight);
            int j14 = chunk_Z + decoRNG.nextInt(16) + 8;
            plantYellowGen.generate(currentWorld, decoRNG, l6, l10, j14);
            if(decoRNG.nextInt(4) == 0)
            {
                int i17 = chunk_X + decoRNG.nextInt(16) + 8;
                int k17 = decoRNG.nextInt(currentWorld.worldHeight);
                int l17 = chunk_Z + decoRNG.nextInt(16) + 8;
                plantRedGen.generate(currentWorld, decoRNG, i17, k17, l17);
            }
        }

        for(int k2 = 0; k2 < grassPerChunk; k2++)
        {
            int i7 = 1;
            int i11 = chunk_X + decoRNG.nextInt(16) + 8;
            int k14 = decoRNG.nextInt(currentWorld.worldHeight);
            int j17 = chunk_Z + decoRNG.nextInt(16) + 8;
            (new WorldGenTallGrass(Block.tallGrass.blockID, i7)).generate(currentWorld, decoRNG, i11, k14, j17);
        }

        for(int l2 = 0; l2 < deadBushPerChunk; l2++)
        {
            int j7 = chunk_X + decoRNG.nextInt(16) + 8;
            int j11 = decoRNG.nextInt(currentWorld.worldHeight);
            int l14 = chunk_Z + decoRNG.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.deadBush.blockID)).generate(currentWorld, decoRNG, j7, j11, l14);
        }

        for(int i3 = 0; i3 < waterlilyPerChunk; i3++)
        {
            int k7 = chunk_X + decoRNG.nextInt(16) + 8;
            int k11 = chunk_Z + decoRNG.nextInt(16) + 8;
            int i15;
            for(i15 = decoRNG.nextInt(currentWorld.worldHeight); i15 > 0 && currentWorld.getBlockId(k7, i15 - 1, k11) == 0; i15--) { }
            waterlilyGen.generate(currentWorld, decoRNG, k7, i15, k11);
        }

        for(int j3 = 0; j3 < mushroomsPerChunk; j3++)
        {
            if(decoRNG.nextInt(4) == 0)
            {
                int l7 = chunk_X + decoRNG.nextInt(16) + 8;
                int l11 = chunk_Z + decoRNG.nextInt(16) + 8;
                int j15 = currentWorld.getHeightValue(l7, l11);
                mushroomBrownGen.generate(currentWorld, decoRNG, l7, j15, l11);
            }
            if(decoRNG.nextInt(8) == 0)
            {
                int i8 = chunk_X + decoRNG.nextInt(16) + 8;
                int i12 = chunk_Z + decoRNG.nextInt(16) + 8;
                int k15 = decoRNG.nextInt(currentWorld.worldHeight);
                mushroomRedGen.generate(currentWorld, decoRNG, i8, k15, i12);
            }
        }

        if(decoRNG.nextInt(4) == 0)
        {
            int k3 = chunk_X + decoRNG.nextInt(16) + 8;
            int j8 = decoRNG.nextInt(currentWorld.worldHeight);
            int j12 = chunk_Z + decoRNG.nextInt(16) + 8;
            mushroomBrownGen.generate(currentWorld, decoRNG, k3, j8, j12);
        }
        if(decoRNG.nextInt(8) == 0)
        {
            int l3 = chunk_X + decoRNG.nextInt(16) + 8;
            int k8 = decoRNG.nextInt(currentWorld.worldHeight);
            int k12 = chunk_Z + decoRNG.nextInt(16) + 8;
            mushroomRedGen.generate(currentWorld, decoRNG, l3, k8, k12);
        }
        for(int i4 = 0; i4 < reedsPerChunk; i4++)
        {
            int l8 = chunk_X + decoRNG.nextInt(16) + 8;
            int l12 = chunk_Z + decoRNG.nextInt(16) + 8;
            int l15 = decoRNG.nextInt(currentWorld.worldHeight);
            reedGen.generate(currentWorld, decoRNG, l8, l15, l12);
        }

        for(int j4 = 0; j4 < 10; j4++)
        {
            int i9 = chunk_X + decoRNG.nextInt(16) + 8;
            int i13 = decoRNG.nextInt(currentWorld.worldHeight);
            int i16 = chunk_Z + decoRNG.nextInt(16) + 8;
            reedGen.generate(currentWorld, decoRNG, i9, i13, i16);
        }

        if(decoRNG.nextInt(32) == 0)
        {
            int k4 = chunk_X + decoRNG.nextInt(16) + 8;
            int j9 = decoRNG.nextInt(currentWorld.worldHeight);
            int j13 = chunk_Z + decoRNG.nextInt(16) + 8;
            (new WorldGenPumpkin()).generate(currentWorld, decoRNG, k4, j9, j13);
        }
        for(int l4 = 0; l4 < cactiPerChunk; l4++)
        {
            int k9 = chunk_X + decoRNG.nextInt(16) + 8;
            int k13 = decoRNG.nextInt(currentWorld.worldHeight);
            int j16 = chunk_Z + decoRNG.nextInt(16) + 8;
            cactusGen.generate(currentWorld, decoRNG, k9, k13, j16);
        }

        if(generateFluid)
        {
            for(int i5 = 0; i5 < 50; i5++)
            {
                int l9 = chunk_X + decoRNG.nextInt(16) + 8;
                int l13 = decoRNG.nextInt(decoRNG.nextInt(currentWorld.worldHeight - 8) + 8);
                int k16 = chunk_Z + decoRNG.nextInt(16) + 8;
                (new WorldGenLiquids(Block.waterMoving.blockID)).generate(currentWorld, decoRNG, l9, l13, k16);
            }

            for(int j5 = 0; j5 < 20; j5++)
            {
                int i10 = chunk_X + decoRNG.nextInt(16) + 8;
                int i14 = decoRNG.nextInt(decoRNG.nextInt(decoRNG.nextInt(currentWorld.worldHeight - 16) + 8) + 8);
                int l16 = chunk_Z + decoRNG.nextInt(16) + 8;
                (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(currentWorld, decoRNG, i10, i14, l16);
            }

        }
    }

    protected void genStandardOre1(int i, WorldGenerator worldgenerator, int j, int k)
    {
        for(int l = 0; l < i; l++)
        {
            int i1 = chunk_X + decoRNG.nextInt(16);
            int j1 = decoRNG.nextInt(k - j) + j;
            int k1 = chunk_Z + decoRNG.nextInt(16);
            worldgenerator.generate(currentWorld, decoRNG, i1, j1, k1);
        }

    }

    protected void genStandardOre2(int i, WorldGenerator worldgenerator, int j, int k)
    {
        for(int l = 0; l < i; l++)
        {
            int i1 = chunk_X + decoRNG.nextInt(16);
            int j1 = decoRNG.nextInt(k) + decoRNG.nextInt(k) + (j - k);
            int k1 = chunk_Z + decoRNG.nextInt(16);
            worldgenerator.generate(currentWorld, decoRNG, i1, j1, k1);
        }

    }

    protected void generateOres()
    {
        genStandardOre1(20, dirtGen, 0, currentWorld.worldHeight);
        genStandardOre1(10, gravelGen, 0, currentWorld.worldHeight);
        genStandardOre1(20, coalGen, 0, currentWorld.worldHeight);
        genStandardOre1(20, ironGen, 0, currentWorld.worldHeight / 2);
        genStandardOre1(2, goldGen, 0, currentWorld.worldHeight / 4);
        genStandardOre1(8, redstoneGen, 0, currentWorld.worldHeight / 8);
        genStandardOre1(1, diamondGen, 0, currentWorld.worldHeight / 8);
        genStandardOre2(1, lapisGen, currentWorld.worldHeight / 8, currentWorld.worldHeight / 8);
    }
}
