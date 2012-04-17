// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            WorldChunkManager, BiomeGenAether, ChunkPosition, BiomeGenBase, 
//            ChunkCoordIntPair

public class WorldChunkManagerAether extends WorldChunkManager
{

    private BiomeGenBase biomeGenerator;

    public WorldChunkManagerAether(double d)
    {
        biomeGenerator = BiomeGenAether.me;
    }

    public BiomeGenBase getBiomeGenAtChunkCoord(ChunkCoordIntPair chunkcoordintpair)
    {
        return biomeGenerator;
    }

    public BiomeGenBase getBiomeGenAt(int i, int j)
    {
        return biomeGenerator;
    }

    public float[] getTemperatures(float af[], int i, int j, int k, int l)
    {
        if(af == null || af.length < k * l)
        {
            af = new float[k * l];
        }
        Arrays.fill(af, 0, k * l, 1.0F);
        return af;
    }

    public float[] func_40539_b(int i, int j, int k, int l)
    {
        return getTemperatures(new float[k * l], i, j, k, l);
    }

    public BiomeGenBase[] func_4069_a(int i, int j, int k, int l)
    {
        field_4195_d = loadBlockGeneratorData(field_4195_d, i, j, k, l);
        return field_4195_d;
    }

    public float[] getRainfall(float af[], int i, int j, int k, int l)
    {
        if(af == null || af.length < k * l)
        {
            af = new float[k * l];
        }
        Arrays.fill(af, 0, k * l, 0.0F);
        return af;
    }

    public ChunkPosition func_35556_a(int i, int j, int k, List list, Random random)
    {
        if(list.contains(biomeGenerator))
        {
            return new ChunkPosition((i - k) + random.nextInt(k * 2 + 1), 0, (j - k) + random.nextInt(k * 2 + 1));
        } else
        {
            return null;
        }
    }

    public BiomeGenBase[] func_35555_a(BiomeGenBase abiomegenbase[], int i, int j, int k, int l, boolean flag)
    {
        return loadBlockGeneratorData(abiomegenbase, i, j, k, l);
    }

    public boolean areBiomesViable(int i, int j, int k, List list)
    {
        return list.contains(biomeGenerator);
    }

    public float func_35558_c(int i, int j)
    {
        return 0.0F;
    }

    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase abiomegenbase[], int i, int j, int k, int l)
    {
        if(abiomegenbase == null || abiomegenbase.length < k * l)
        {
            abiomegenbase = new BiomeGenBase[k * l];
        }
        Arrays.fill(abiomegenbase, 0, k * l, biomeGenerator);
        return abiomegenbase;
    }
}
