// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
import net.minecraft.src.*;

// Referenced classes of package forge:
//            ForgeHooks, IBucketHandler, IOreHandler, ObjectPair, 
//            DungeonLoot, ISleepHandler, IBonemealHandler, IHoeHandler, 
//            IDestroyToolHandler, ICraftingHandler

public class MinecraftForge
{
    public static class OreQuery
        implements Iterable
    {
        public class OreQueryIterator
            implements Iterator
        {

            LinkedList itering;
            LinkedList output;

            public boolean hasNext()
            {
                return output != null;
            }

            public Object[] next()
            {
                Object aobj[] = output.toArray();
                do
                {
                    if(itering.size() == 0)
                    {
                        output = null;
                        return aobj;
                    }
                    Object obj = itering.getLast();
                    output.removeLast();
                    if(obj instanceof Iterator)
                    {
                        Iterator iterator1 = (Iterator)obj;
                        if(iterator1.hasNext())
                        {
                            output.addLast(iterator1.next());
                            break;
                        }
                    }
                    itering.removeLast();
                } while(true);
                for(int i = itering.size(); i < proto.length; i++)
                {
                    if(proto[i] instanceof Collection)
                    {
                        Iterator iterator2 = ((Collection)proto[i]).iterator();
                        if(!iterator2.hasNext())
                        {
                            output = null;
                            break;
                        }
                        itering.addLast(iterator2);
                        output.addLast(iterator2.next());
                    } else
                    {
                        itering.addLast(proto[i]);
                        output.addLast(proto[i]);
                    }
                }

                return aobj;
            }

            public void remove()
            {
            }

            private OreQueryIterator()
            {
                itering = new LinkedList();
                output = new LinkedList();
                for(int i = 0; i < proto.length; i++)
                {
                    if(proto[i] instanceof Collection)
                    {
                        Iterator iterator1 = ((Collection)proto[i]).iterator();
                        if(!iterator1.hasNext())
                        {
                            output = null;
                            break;
                        }
                        itering.addLast(iterator1);
                        output.addLast(iterator1.next());
                    } else
                    {
                        itering.addLast(proto[i]);
                        output.addLast(proto[i]);
                    }
                }

            }

        }


        Object proto[];

        public Iterator iterator()
        {
            return new OreQueryIterator();
        }

        private OreQuery(Object aobj[])
        {
            proto = aobj;
        }

    }


    private static LinkedList bucketHandlers = new LinkedList();
    private static LinkedList oreHandlers = new LinkedList();
    private static TreeMap oreDict = new TreeMap();
    private static int dungeonLootAttempts = 8;
    private static ArrayList dungeonMobs = new ArrayList();
    private static ArrayList dungeonLoot = new ArrayList();

    public MinecraftForge()
    {
    }

    public static void registerCustomBucketHandler(IBucketHandler ibuckethandler)
    {
        bucketHandlers.add(ibuckethandler);
    }

    public static void registerSleepHandler(ISleepHandler isleephandler)
    {
        ForgeHooks.sleepHandlers.add(isleephandler);
    }

    public static void registerBonemealHandler(IBonemealHandler ibonemealhandler)
    {
        ForgeHooks.bonemealHandlers.add(ibonemealhandler);
    }

    public static void registerHoeHandler(IHoeHandler ihoehandler)
    {
        ForgeHooks.hoeHandlers.add(ihoehandler);
    }

    public static void registerDestroyToolHandler(IDestroyToolHandler idestroytoolhandler)
    {
        ForgeHooks.destroyToolHandlers.add(idestroytoolhandler);
    }

    public static void registerCraftingHandler(ICraftingHandler icraftinghandler)
    {
        ForgeHooks.craftingHandlers.add(icraftinghandler);
    }

    public static ItemStack fillCustomBucket(World world, int i, int j, int k)
    {
        for(Iterator iterator = bucketHandlers.iterator(); iterator.hasNext();)
        {
            IBucketHandler ibuckethandler = (IBucketHandler)iterator.next();
            ItemStack itemstack = ibuckethandler.fillCustomBucket(world, i, j, k);
            if(itemstack != null)
            {
                return itemstack;
            }
        }

        return null;
    }

    public static void registerOreHandler(IOreHandler iorehandler)
    {
        oreHandlers.add(iorehandler);
        for(Iterator iterator = oreDict.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            List list = (List)oreDict.get(s);
            Iterator iterator1 = list.iterator();
            while(iterator1.hasNext()) 
            {
                ItemStack itemstack = (ItemStack)iterator1.next();
                iorehandler.registerOre(s, itemstack);
            }
        }

    }

    public static void registerOre(String s, ItemStack itemstack)
    {
        Object obj = (List)oreDict.get(s);
        if(obj == null)
        {
            obj = new ArrayList();
            oreDict.put(s, obj);
        }
        ((List) (obj)).add(itemstack);
        IOreHandler iorehandler;
        for(Iterator iterator = oreHandlers.iterator(); iterator.hasNext(); iorehandler.registerOre(s, itemstack))
        {
            iorehandler = (IOreHandler)iterator.next();
        }

    }

    public static List getOreClass(String s)
    {
        return (List)oreDict.get(s);
    }

    public static OreQuery generateRecipes(Object aobj[])
    {
        return new OreQuery(aobj);
    }

    public static void addGrassPlant(int i, int j, int k)
    {
        ForgeHooks.addPlantGrass(i, j, k);
    }

    public static void addGrassSeed(int i, int j, int k, int l)
    {
        ForgeHooks.addGrassSeed(i, j, k, l);
    }

    public static void setToolClass(Item item, String s, int i)
    {
        ForgeHooks.initTools();
        ForgeHooks.toolClasses.put(Integer.valueOf(item.shiftedIndex), Arrays.asList(new Serializable[] {
            s, Integer.valueOf(i)
        }));
    }

    public static void setBlockHarvestLevel(Block block, int i, String s, int j)
    {
        ForgeHooks.initTools();
        List list = Arrays.asList(new Serializable[] {
            Integer.valueOf(block.blockID), Integer.valueOf(i), s
        });
        ForgeHooks.toolHarvestLevels.put(list, Integer.valueOf(j));
        ForgeHooks.toolEffectiveness.add(list);
    }

    public static void removeBlockEffectiveness(Block block, int i, String s)
    {
        ForgeHooks.initTools();
        List list = Arrays.asList(new Serializable[] {
            Integer.valueOf(block.blockID), Integer.valueOf(i), s
        });
        ForgeHooks.toolEffectiveness.remove(list);
    }

    public static void setBlockHarvestLevel(Block block, String s, int i)
    {
        ForgeHooks.initTools();
        for(int j = 0; j < 16; j++)
        {
            List list = Arrays.asList(new Serializable[] {
                Integer.valueOf(block.blockID), Integer.valueOf(j), s
            });
            ForgeHooks.toolHarvestLevels.put(list, Integer.valueOf(i));
            ForgeHooks.toolEffectiveness.add(list);
        }

    }

    public static void removeBlockEffectiveness(Block block, String s)
    {
        ForgeHooks.initTools();
        for(int i = 0; i < 16; i++)
        {
            List list = Arrays.asList(new Serializable[] {
                Integer.valueOf(block.blockID), Integer.valueOf(i), s
            });
            ForgeHooks.toolEffectiveness.remove(list);
        }

    }

    public static void killMinecraft(String s, String s1)
    {
        throw new RuntimeException((new StringBuilder()).append(s).append(": ").append(s1).toString());
    }

    public static void versionDetect(String s, int i, int j, int k)
    {
        if(i != 1)
        {
            killMinecraft(s, (new StringBuilder()).append("MinecraftForge Major Version Mismatch, expecting ").append(i).append(".x.x").toString());
        } else
        if(j != 2)
        {
            if(j > 2)
            {
                killMinecraft(s, (new StringBuilder()).append("MinecraftForge Too Old, need at least ").append(i).append(".").append(j).append(".").append(k).toString());
            } else
            {
                System.out.println((new StringBuilder()).append(s).append(": MinecraftForge minor version mismatch, expecting ").append(i).append(".").append(j).append(".x, may lead to unexpected behavior").toString());
            }
        } else
        if(k > 3)
        {
            killMinecraft(s, (new StringBuilder()).append("MinecraftForge Too Old, need at least ").append(i).append(".").append(j).append(".").append(k).toString());
        }
    }

    public static void versionDetectStrict(String s, int i, int j, int k)
    {
        if(i != 1)
        {
            killMinecraft(s, (new StringBuilder()).append("MinecraftForge Major Version Mismatch, expecting ").append(i).append(".x.x").toString());
        } else
        if(j != 2)
        {
            if(j > 2)
            {
                killMinecraft(s, (new StringBuilder()).append("MinecraftForge Too Old, need at least ").append(i).append(".").append(j).append(".").append(k).toString());
            } else
            {
                killMinecraft(s, (new StringBuilder()).append("MinecraftForge minor version mismatch, expecting ").append(i).append(".").append(j).append(".x").toString());
            }
        } else
        if(k > 3)
        {
            killMinecraft(s, (new StringBuilder()).append("MinecraftForge Too Old, need at least ").append(i).append(".").append(j).append(".").append(k).toString());
        }
    }

    public static void setDungeonLootTries(int i)
    {
        dungeonLootAttempts = i;
    }

    public static int getDungeonLootTries()
    {
        return dungeonLootAttempts;
    }

    public static float addDungeonMob(String s, float f)
    {
        if(f <= 0.0F)
        {
            throw new IllegalArgumentException("Rarity must be greater then zero");
        }
        for(Iterator iterator = dungeonMobs.iterator(); iterator.hasNext();)
        {
            ObjectPair objectpair = (ObjectPair)iterator.next();
            if(s.equals(objectpair.getValue2()))
            {
                objectpair.setValue1(Float.valueOf(((Float)objectpair.getValue1()).floatValue() + f));
                return ((Float)objectpair.getValue1()).floatValue();
            }
        }

        dungeonMobs.add(new ObjectPair(Float.valueOf(f), s));
        return f;
    }

    public static float removeDungeonMob(String s)
    {
        for(Iterator iterator = dungeonMobs.iterator(); iterator.hasNext();)
        {
            ObjectPair objectpair = (ObjectPair)iterator.next();
            if(s.equals(s))
            {
                dungeonMobs.remove(objectpair);
                return ((Float)objectpair.getValue1()).floatValue();
            }
        }

        return 0.0F;
    }

    public static String getRandomDungeonMob(Random random)
    {
        float f = 0.0F;
        for(Iterator iterator = dungeonMobs.iterator(); iterator.hasNext();)
        {
            ObjectPair objectpair = (ObjectPair)iterator.next();
            f += ((Float)objectpair.getValue1()).floatValue();
        }

        float f1 = random.nextFloat() * f;
        for(Iterator iterator1 = dungeonMobs.iterator(); iterator1.hasNext();)
        {
            ObjectPair objectpair1 = (ObjectPair)iterator1.next();
            if(f1 < ((Float)objectpair1.getValue1()).floatValue())
            {
                return (String)objectpair1.getValue2();
            }
            f1 -= ((Float)objectpair1.getValue1()).floatValue();
        }

        return "";
    }

    public static void addDungeonLoot(ItemStack itemstack, float f)
    {
        addDungeonLoot(itemstack, f, 1, 1);
    }

    public static float addDungeonLoot(ItemStack itemstack, float f, int i, int j)
    {
        for(Iterator iterator = dungeonLoot.iterator(); iterator.hasNext();)
        {
            ObjectPair objectpair = (ObjectPair)iterator.next();
            if(((DungeonLoot)objectpair.getValue2()).equals(itemstack, i, j))
            {
                objectpair.setValue1(Float.valueOf(((Float)objectpair.getValue1()).floatValue() + f));
                return ((Float)objectpair.getValue1()).floatValue();
            }
        }

        dungeonLoot.add(new ObjectPair(Float.valueOf(f), new DungeonLoot(itemstack, i, j)));
        return f;
    }

    public static float removeDungeonLoot(ItemStack itemstack)
    {
        return removeDungeonLoot(itemstack, -1, 0);
    }

    public static float removeDungeonLoot(ItemStack itemstack, int i, int j)
    {
        float f = 0.0F;
        ArrayList arraylist = (ArrayList)dungeonLoot.clone();
        if(i < 0)
        {
            Iterator iterator = arraylist.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                ObjectPair objectpair = (ObjectPair)iterator.next();
                if(((DungeonLoot)objectpair.getValue2()).equals(itemstack))
                {
                    dungeonLoot.remove(objectpair);
                    f += ((Float)objectpair.getValue1()).floatValue();
                }
            } while(true);
        } else
        {
            Iterator iterator1 = arraylist.iterator();
            do
            {
                if(!iterator1.hasNext())
                {
                    break;
                }
                ObjectPair objectpair1 = (ObjectPair)iterator1.next();
                if(((DungeonLoot)objectpair1.getValue2()).equals(itemstack, i, j))
                {
                    dungeonLoot.remove(objectpair1);
                    f += ((Float)objectpair1.getValue1()).floatValue();
                }
            } while(true);
        }
        return f;
    }

    public static ItemStack getRandomDungeonLoot(Random random)
    {
        float f = 0.0F;
        for(Iterator iterator = dungeonLoot.iterator(); iterator.hasNext();)
        {
            ObjectPair objectpair = (ObjectPair)iterator.next();
            f += ((Float)objectpair.getValue1()).floatValue();
        }

        float f1 = random.nextFloat() * f;
        for(Iterator iterator1 = dungeonLoot.iterator(); iterator1.hasNext();)
        {
            ObjectPair objectpair1 = (ObjectPair)iterator1.next();
            if(f1 < ((Float)objectpair1.getValue1()).floatValue())
            {
                return ((DungeonLoot)objectpair1.getValue2()).generateStack(random);
            }
            f1 -= ((Float)objectpair1.getValue1()).floatValue();
        }

        return null;
    }

    static 
    {
        addDungeonMob("Skeleton", 1.0F);
        addDungeonMob("Zombie", 2.0F);
        addDungeonMob("Spider", 1.0F);
        addDungeonLoot(new ItemStack(Item.saddle), 1.0F);
        addDungeonLoot(new ItemStack(Item.ingotIron), 1.0F, 1, 4);
        addDungeonLoot(new ItemStack(Item.bread), 1.0F);
        addDungeonLoot(new ItemStack(Item.wheat), 1.0F, 1, 4);
        addDungeonLoot(new ItemStack(Item.gunpowder), 1.0F, 1, 4);
        addDungeonLoot(new ItemStack(Item.silk), 1.0F, 1, 4);
        addDungeonLoot(new ItemStack(Item.bucketEmpty), 1.0F);
        addDungeonLoot(new ItemStack(Item.appleGold), 0.01F);
        addDungeonLoot(new ItemStack(Item.redstone), 0.5F, 1, 4);
        addDungeonLoot(new ItemStack(Item.record13), 0.05F);
        addDungeonLoot(new ItemStack(Item.recordCat), 0.05F);
        addDungeonLoot(new ItemStack(Item.dyePowder, 1, 3), 1.0F);
    }
}
