// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.reflect.Constructor;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, ChunkPosition, EntityPlayer, MathHelper, 
//            ChunkCoordIntPair, EnumCreatureType, ChunkCoordinates, SpawnListEntry, 
//            EntityLiving, Material, EntitySpider, EntitySkeleton, 
//            EntitySheep, BiomeGenBase, WeightedRandom, EntityZombie

public final class SpawnerAnimals
{

    private static HashMap eligibleChunksForSpawning = new HashMap();
    protected static final Class nightSpawnEntities[];

    public SpawnerAnimals()
    {
    }

    protected static ChunkPosition getRandomSpawningPointInChunk(World world, int i, int j)
    {
        int k = i + world.rand.nextInt(16);
        int l = world.rand.nextInt(world.worldHeight);
        int i1 = j + world.rand.nextInt(16);
        return new ChunkPosition(k, l, i1);
    }

    public static final int performSpawning(World world, boolean flag, boolean flag1)
    {
        int j;
        int l;
        ChunkCoordinates chunkcoordinates;
        EnumCreatureType aenumcreaturetype[];
        int j1;
        if(!flag && !flag1)
        {
            return 0;
        }
        eligibleChunksForSpawning.clear();
        for(int i = 0; i < world.playerEntities.size(); i++)
        {
            EntityPlayer entityplayer = (EntityPlayer)world.playerEntities.get(i);
            int i1 = MathHelper.floor_double(entityplayer.posX / 16D);
            int k = MathHelper.floor_double(entityplayer.posZ / 16D);
            byte byte0 = 8;
            for(int k1 = -byte0; k1 <= byte0; k1++)
            {
                for(int l1 = -byte0; l1 <= byte0; l1++)
                {
                    boolean flag2 = k1 == -byte0 || k1 == byte0 || l1 == -byte0 || l1 == byte0;
                    ChunkCoordIntPair chunkcoordintpair1 = new ChunkCoordIntPair(k1 + i1, l1 + k);
                    if(!flag2)
                    {
                        eligibleChunksForSpawning.put(chunkcoordintpair1, Boolean.valueOf(false));
                        continue;
                    }
                    if(!eligibleChunksForSpawning.containsKey(chunkcoordintpair1))
                    {
                        eligibleChunksForSpawning.put(chunkcoordintpair1, Boolean.valueOf(true));
                    }
                }

            }

        }

        j = 0;
        chunkcoordinates = world.getSpawnPoint();
        aenumcreaturetype = EnumCreatureType.values();
        l = aenumcreaturetype.length;
        j1 = 0;
_L10:
        if(j1 >= l) goto _L2; else goto _L1
_L1:
        EnumCreatureType enumcreaturetype;
        Iterator iterator;
        enumcreaturetype = aenumcreaturetype[j1];
        if(enumcreaturetype.getPeacefulCreature() && !flag1 || !enumcreaturetype.getPeacefulCreature() && !flag || world.countEntities(enumcreaturetype.getCreatureClass()) > (enumcreaturetype.getMaxNumberOfCreature() * eligibleChunksForSpawning.size()) / 256)
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator = eligibleChunksForSpawning.keySet().iterator();
_L4:
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        do
        {
            ChunkCoordIntPair chunkcoordintpair;
            do
            {
                if(!iterator.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            } while(((Boolean)eligibleChunksForSpawning.get(chunkcoordintpair)).booleanValue());
            ChunkPosition chunkposition = getRandomSpawningPointInChunk(world, chunkcoordintpair.chunkXPos * 16, chunkcoordintpair.chunkZPos * 16);
            i2 = chunkposition.x;
            j2 = chunkposition.y;
            k2 = chunkposition.z;
        } while(world.isBlockNormalCube(i2, j2, k2) || world.getBlockMaterial(i2, j2, k2) != enumcreaturetype.getCreatureMaterial());
        l2 = 0;
        i3 = 0;
_L9:
        if(i3 >= 3) goto _L4; else goto _L3
_L3:
        int j3;
        int k3;
        int l3;
        byte byte1;
        SpawnListEntry spawnlistentry;
        int i4;
        j3 = i2;
        k3 = j2;
        l3 = k2;
        byte1 = 6;
        spawnlistentry = null;
        i4 = 0;
_L8:
        if(i4 >= 4) goto _L6; else goto _L5
_L5:
        EntityLiving entityliving;
        j3 += world.rand.nextInt(byte1) - world.rand.nextInt(byte1);
        k3 += world.rand.nextInt(1) - world.rand.nextInt(1);
        l3 += world.rand.nextInt(byte1) - world.rand.nextInt(byte1);
        if(!canCreatureTypeSpawnAtLocation(enumcreaturetype, world, j3, k3, l3))
        {
            continue; /* Loop/switch isn't completed */
        }
        float f = (float)j3 + 0.5F;
        float f1 = k3;
        float f2 = (float)l3 + 0.5F;
        if(world.getClosestPlayer(f, f1, f2, 24D) != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f3 = f - (float)chunkcoordinates.posX;
        float f4 = f1 - (float)chunkcoordinates.posY;
        float f5 = f2 - (float)chunkcoordinates.posZ;
        float f6 = f3 * f3 + f4 * f4 + f5 * f5;
        if(f6 < 576F)
        {
            continue; /* Loop/switch isn't completed */
        }
        if(spawnlistentry == null)
        {
            spawnlistentry = world.func_40474_a(enumcreaturetype, j3, k3, l3);
            if(spawnlistentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        try
        {
            entityliving = (EntityLiving)spawnlistentry.entityClass.getConstructor(new Class[] {
                net.minecraft.src.World.class
            }).newInstance(new Object[] {
                world
            });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return j;
        }
        entityliving.setLocationAndAngles(f, f1, f2, world.rand.nextFloat() * 360F, 0.0F);
        if(!entityliving.getCanSpawnHere())
        {
            break; /* Loop/switch isn't completed */
        }
        l2++;
        world.spawnEntityInWorld(entityliving);
        creatureSpecificInit(entityliving, world, f, f1, f2);
        if(l2 < entityliving.getMaxSpawnedInChunk()) goto _L7; else goto _L4
_L7:
        j += l2;
        i4++;
          goto _L8
_L6:
        i3++;
          goto _L9
        j1++;
          goto _L10
_L2:
        return j;
    }

    private static boolean canCreatureTypeSpawnAtLocation(EnumCreatureType enumcreaturetype, World world, int i, int j, int k)
    {
        if(enumcreaturetype.getCreatureMaterial() == Material.water)
        {
            return world.getBlockMaterial(i, j, k).getIsLiquid() && !world.isBlockNormalCube(i, j + 1, k);
        } else
        {
            return world.isBlockNormalCube(i, j - 1, k) && !world.isBlockNormalCube(i, j, k) && !world.getBlockMaterial(i, j, k).getIsLiquid() && !world.isBlockNormalCube(i, j + 1, k);
        }
    }

    private static void creatureSpecificInit(EntityLiving entityliving, World world, float f, float f1, float f2)
    {
        if((entityliving instanceof EntitySpider) && world.rand.nextInt(100) == 0)
        {
            EntitySkeleton entityskeleton = new EntitySkeleton(world);
            entityskeleton.setLocationAndAngles(f, f1, f2, entityliving.rotationYaw, 0.0F);
            world.spawnEntityInWorld(entityskeleton);
            entityskeleton.mountEntity(entityliving);
        } else
        if(entityliving instanceof EntitySheep)
        {
            ((EntitySheep)entityliving).setFleeceColor(EntitySheep.getRandomFleeceColor(world.rand));
        }
    }

    public static void func_35957_a(World world, BiomeGenBase biomegenbase, int i, int j, int k, int l, Random random)
    {
        List list = biomegenbase.getSpawnableList(EnumCreatureType.creature);
        if(list.isEmpty())
        {
            return;
        }
        while(random.nextFloat() < biomegenbase.getSpawningChance()) 
        {
            SpawnListEntry spawnlistentry = (SpawnListEntry)WeightedRandom.func_35733_a(world.rand, list);
            int i1 = spawnlistentry.field_35591_b + random.nextInt((1 + spawnlistentry.field_35592_c) - spawnlistentry.field_35591_b);
            int j1 = i + random.nextInt(k);
            int k1 = j + random.nextInt(l);
            int l1 = j1;
            int i2 = k1;
            int j2 = 0;
            while(j2 < i1) 
            {
                boolean flag = false;
                for(int k2 = 0; !flag && k2 < 4; k2++)
                {
                    int l2 = world.getTopSolidOrLiquidBlock(j1, k1);
                    if(canCreatureTypeSpawnAtLocation(EnumCreatureType.creature, world, j1, l2, k1))
                    {
                        float f = (float)j1 + 0.5F;
                        float f1 = l2;
                        float f2 = (float)k1 + 0.5F;
                        EntityLiving entityliving;
                        try
                        {
                            entityliving = (EntityLiving)spawnlistentry.entityClass.getConstructor(new Class[] {
                                net.minecraft.src.World.class
                            }).newInstance(new Object[] {
                                world
                            });
                        }
                        catch(Exception exception)
                        {
                            exception.printStackTrace();
                            continue;
                        }
                        entityliving.setLocationAndAngles(f, f1, f2, random.nextFloat() * 360F, 0.0F);
                        world.spawnEntityInWorld(entityliving);
                        creatureSpecificInit(entityliving, world, f, f1, f2);
                        flag = true;
                    }
                    j1 += random.nextInt(5) - random.nextInt(5);
                    for(k1 += random.nextInt(5) - random.nextInt(5); j1 < i || j1 >= i + k || k1 < j || k1 >= j + k; k1 = (i2 + random.nextInt(5)) - random.nextInt(5))
                    {
                        j1 = (l1 + random.nextInt(5)) - random.nextInt(5);
                    }

                }

                j2++;
            }
        }
    }

    static 
    {
        nightSpawnEntities = (new Class[] {
            net.minecraft.src.EntitySpider.class, net.minecraft.src.EntityZombie.class, net.minecraft.src.EntitySkeleton.class
        });
    }
}
