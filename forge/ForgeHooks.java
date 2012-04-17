// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
import net.minecraft.src.*;

// Referenced classes of package forge:
//            ICraftingHandler, IDestroyToolHandler, IBonemealHandler, IHoeHandler, 
//            ISleepHandler, MinecraftForge

public class ForgeHooks
{
    static class ProbableItem
    {

        int wstart;
        int wend;
        int itemid;
        int meta;
        int qty;

        public ProbableItem(int i, int j, int k, int l, int i1)
        {
            wstart = l;
            wend = i1;
            itemid = i;
            meta = j;
            qty = k;
        }
    }


    static LinkedList craftingHandlers = new LinkedList();
    static LinkedList destroyToolHandlers = new LinkedList();
    static LinkedList bonemealHandlers = new LinkedList();
    static LinkedList hoeHandlers = new LinkedList();
    static LinkedList sleepHandlers = new LinkedList();
    static List plantGrassList;
    static int plantGrassWeight = 30;
    static List seedGrassList;
    static int seedGrassWeight = 10;
    public static final int majorVersion = 1;
    public static final int minorVersion = 2;
    public static final int revisionVersion = 3;
    static boolean toolInit = false;
    static HashMap toolClasses = new HashMap();
    static HashMap toolHarvestLevels = new HashMap();
    static HashSet toolEffectiveness = new HashSet();

    public ForgeHooks()
    {
    }

    public static void onTakenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
    {
        ICraftingHandler icraftinghandler;
        for(Iterator iterator = craftingHandlers.iterator(); iterator.hasNext(); icraftinghandler.onTakenFromCrafting(entityplayer, itemstack, iinventory))
        {
            icraftinghandler = (ICraftingHandler)iterator.next();
        }

    }

    public static void onDestroyCurrentItem(EntityPlayer entityplayer, ItemStack itemstack)
    {
        IDestroyToolHandler idestroytoolhandler;
        for(Iterator iterator = destroyToolHandlers.iterator(); iterator.hasNext(); idestroytoolhandler.onDestroyCurrentItem(entityplayer, itemstack))
        {
            idestroytoolhandler = (IDestroyToolHandler)iterator.next();
        }

    }

    public static boolean onUseBonemeal(World world, int i, int j, int k, int l)
    {
        for(Iterator iterator = bonemealHandlers.iterator(); iterator.hasNext();)
        {
            IBonemealHandler ibonemealhandler = (IBonemealHandler)iterator.next();
            if(ibonemealhandler.onUseBonemeal(world, i, j, k, l))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean onUseHoe(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k)
    {
        for(Iterator iterator = hoeHandlers.iterator(); iterator.hasNext();)
        {
            IHoeHandler ihoehandler = (IHoeHandler)iterator.next();
            if(ihoehandler.onUseHoe(itemstack, entityplayer, world, i, j, k))
            {
                return true;
            }
        }

        return false;
    }

    public static EnumStatus sleepInBedAt(EntityPlayer entityplayer, int i, int j, int k)
    {
        for(Iterator iterator = sleepHandlers.iterator(); iterator.hasNext();)
        {
            ISleepHandler isleephandler = (ISleepHandler)iterator.next();
            EnumStatus enumstatus = isleephandler.sleepInBedAt(entityplayer, i, j, k);
            if(enumstatus != null)
            {
                return enumstatus;
            }
        }

        return null;
    }

    static ProbableItem getRandomItem(List list, int i)
    {
        int j = Collections.binarySearch(list, Integer.valueOf(i), new Comparator() {

            public int compare(Object obj, Object obj1)
            {
                ProbableItem probableitem = (ProbableItem)obj;
                Integer integer = (Integer)obj1;
                if(integer.intValue() < probableitem.wstart)
                {
                    return 1;
                }
                return integer.intValue() < probableitem.wend ? 0 : -1;
            }

        }
);
        if(j < 0)
        {
            return null;
        } else
        {
            return (ProbableItem)list.get(j);
        }
    }

    public static void plantGrassPlant(World world, int i, int j, int k)
    {
        int l = world.rand.nextInt(plantGrassWeight);
        ProbableItem probableitem = getRandomItem(plantGrassList, l);
        if(probableitem == null)
        {
            return;
        } else
        {
            world.setBlockAndMetadataWithNotify(i, j, k, probableitem.itemid, probableitem.meta);
            return;
        }
    }

    public static void addPlantGrass(int i, int j, int k)
    {
        plantGrassList.add(new ProbableItem(i, j, 1, plantGrassWeight, plantGrassWeight + k));
        plantGrassWeight += k;
    }

    public static ItemStack getGrassSeed(World world)
    {
        int i = world.rand.nextInt(seedGrassWeight);
        ProbableItem probableitem = getRandomItem(seedGrassList, i);
        if(probableitem == null)
        {
            return null;
        } else
        {
            return new ItemStack(probableitem.itemid, probableitem.qty, probableitem.meta);
        }
    }

    public static void addGrassSeed(int i, int j, int k, int l)
    {
        seedGrassList.add(new ProbableItem(i, j, k, seedGrassWeight, seedGrassWeight + l));
        seedGrassWeight += l;
    }

    public static boolean canHarvestBlock(Block block, EntityPlayer entityplayer, int i)
    {
        if(block.blockMaterial.getIsHarvestable())
        {
            return true;
        }
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if(itemstack == null)
        {
            return false;
        }
        List list = (List)toolClasses.get(Integer.valueOf(itemstack.itemID));
        if(list == null)
        {
            return itemstack.canHarvestBlock(block);
        }
        Object aobj[] = list.toArray();
        String s = (String)aobj[0];
        int j = ((Integer)aobj[1]).intValue();
        Integer integer = (Integer)toolHarvestLevels.get(Arrays.asList(new Serializable[] {
            Integer.valueOf(block.blockID), Integer.valueOf(i), s
        }));
        if(integer == null)
        {
            return itemstack.canHarvestBlock(block);
        }
        return integer.intValue() <= j;
    }

    public static float blockStrength(Block block, EntityPlayer entityplayer, int i)
    {
        float f = block.getHardness(i);
        if(f < 0.0F)
        {
            return 0.0F;
        }
        if(!canHarvestBlock(block, entityplayer, i))
        {
            return 1.0F / f / 100F;
        } else
        {
            return entityplayer.getCurrentPlayerStrVsBlock(block, i) / f / 30F;
        }
    }

    public static boolean isToolEffective(ItemStack itemstack, Block block, int i)
    {
        List list = (List)toolClasses.get(Integer.valueOf(itemstack.itemID));
        if(list == null)
        {
            return false;
        } else
        {
            Object aobj[] = list.toArray();
            String s = (String)aobj[0];
            return toolEffectiveness.contains(Arrays.asList(new Serializable[] {
                Integer.valueOf(block.blockID), Integer.valueOf(i), s
            }));
        }
    }

    static void initTools()
    {
        if(toolInit)
        {
            return;
        }
        toolInit = true;
        MinecraftForge.setToolClass(Item.pickaxeWood, "pickaxe", 0);
        MinecraftForge.setToolClass(Item.pickaxeStone, "pickaxe", 1);
        MinecraftForge.setToolClass(Item.pickaxeSteel, "pickaxe", 2);
        MinecraftForge.setToolClass(Item.pickaxeGold, "pickaxe", 0);
        MinecraftForge.setToolClass(Item.pickaxeDiamond, "pickaxe", 3);
        MinecraftForge.setToolClass(Item.axeWood, "axe", 0);
        MinecraftForge.setToolClass(Item.axeStone, "axe", 1);
        MinecraftForge.setToolClass(Item.axeSteel, "axe", 2);
        MinecraftForge.setToolClass(Item.axeGold, "axe", 0);
        MinecraftForge.setToolClass(Item.axeDiamond, "axe", 3);
        MinecraftForge.setToolClass(Item.shovelWood, "shovel", 0);
        MinecraftForge.setToolClass(Item.shovelStone, "shovel", 1);
        MinecraftForge.setToolClass(Item.shovelSteel, "shovel", 2);
        MinecraftForge.setToolClass(Item.shovelGold, "shovel", 0);
        MinecraftForge.setToolClass(Item.shovelDiamond, "shovel", 3);
        MinecraftForge.setBlockHarvestLevel(Block.obsidian, "pickaxe", 3);
        MinecraftForge.setBlockHarvestLevel(Block.oreDiamond, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.blockDiamond, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.oreGold, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.blockGold, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.oreIron, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.blockSteel, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.oreLapis, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.blockLapis, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Block.oreRedstone, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(Block.oreRedstoneGlowing, "pickaxe", 2);
        MinecraftForge.removeBlockEffectiveness(Block.oreRedstone, "pickaxe");
        MinecraftForge.removeBlockEffectiveness(Block.obsidian, "pickaxe");
        MinecraftForge.removeBlockEffectiveness(Block.oreRedstoneGlowing, "pickaxe");
        Block ablock[] = {
            Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreCoal, Block.ice, Block.netherrack, Block.oreLapis, 
            Block.blockLapis
        };
        Block ablock1[] = ablock;
        int i = ablock1.length;
        for(int j = 0; j < i; j++)
        {
            Block block = ablock1[j];
            MinecraftForge.setBlockHarvestLevel(block, "pickaxe", 0);
        }

        ablock1 = (new Block[] {
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium
        });
        Block ablock2[] = ablock1;
        int k = ablock2.length;
        for(int l = 0; l < k; l++)
        {
            Block block1 = ablock2[l];
            MinecraftForge.setBlockHarvestLevel(block1, "shovel", 0);
        }

        ablock2 = (new Block[] {
            Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stairDouble, Block.stairSingle, Block.pumpkin, Block.pumpkinLantern
        });
        Block ablock3[] = ablock2;
        int i1 = ablock3.length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            Block block2 = ablock3[j1];
            MinecraftForge.setBlockHarvestLevel(block2, "axe", 0);
        }

    }

    static 
    {
        plantGrassList = new ArrayList();
        plantGrassList.add(new ProbableItem(Block.plantYellow.blockID, 0, 1, 0, 20));
        plantGrassList.add(new ProbableItem(Block.plantRed.blockID, 0, 1, 20, 30));
        seedGrassList = new ArrayList();
        seedGrassList.add(new ProbableItem(Item.seeds.shiftedIndex, 0, 1, 0, 10));
        System.out.printf("MinecraftForge V%d.%d.%d Initialized\n", new Object[] {
            Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)
        });
    }
}
