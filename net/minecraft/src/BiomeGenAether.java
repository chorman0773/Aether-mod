// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, mod_Aether, SpawnListEntry, EntitySwet, 
//            EntityAechorPlant, EntityCockatrice, EntityAerwhale, EntityZephyr, 
//            EntitySheepuff, EntityPhyg, EntityMoa, EntityFlyingCow, 
//            Whirly, EntityAerbunny, AetherGenGoldenOak, AetherGenSkyroot, 
//            WorldGenerator

public class BiomeGenAether extends BiomeGenBase
{

    public static BiomeGenAether me = null;

    public BiomeGenAether()
    {
        super(237);
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
        if(mod_Aether.raritySwet != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntitySwet.class, mod_Aether.raritySwet, 4, 4));
        }
        if(mod_Aether.rarityAechorPlant != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityAechorPlant.class, mod_Aether.rarityAechorPlant, 3, 3));
        }
        if(mod_Aether.rarityCockatrice != 0)
        {
            spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityCockatrice.class, mod_Aether.rarityCockatrice, 4, 4));
        }
        if(mod_Aether.rarityAerwhale != 0)
        {
            spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityAerwhale.class, mod_Aether.rarityAerwhale, 3, 3));
        }
        if(mod_Aether.rarityZephyr != 0)
        {
            spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityZephyr.class, mod_Aether.rarityZephyr, 1, 1));
        }
        if(mod_Aether.raritySheepuff != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntitySheepuff.class, mod_Aether.raritySheepuff, 6, 6));
        }
        if(mod_Aether.rarityPhyg != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityPhyg.class, mod_Aether.rarityPhyg, 8, 8));
        }
        if(mod_Aether.rarityMoa != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityMoa.class, mod_Aether.rarityMoa, 3, 3));
        }
        if(mod_Aether.rarityFlyingCow != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityFlyingCow.class, mod_Aether.rarityFlyingCow, 6, 6));
        }
        if(mod_Aether.rarityWhirlwind != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.Whirly.class, mod_Aether.rarityWhirlwind, 2, 2));
        }
        if(mod_Aether.rarityAerbunny != 0)
        {
            spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityAerbunny.class, mod_Aether.rarityAerbunny, 10, 10));
        }
        me = this;
    }

    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if(random.nextInt(100) == 0)
        {
            return new AetherGenGoldenOak();
        } else
        {
            return new AetherGenSkyroot();
        }
    }

    public int getSkyColorByTemp(float f)
    {
        return 0xc0c0ff;
    }

}
