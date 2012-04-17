// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            ModLoader, EntityPlayerSP, ItemStack, IReach, 
//            DungeonLoot, INBT, ILockDifficulty, IHarvest, 
//            World, EntityPlayer, IBlockSet, AchievementPage, 
//            Achievement

public class SAPI
{
    public static class Reach
    {

        private static ArrayList reach = new ArrayList();

        public static void add(IReach ireach)
        {
            reach.add(ireach);
        }

        public static ArrayList getList()
        {
            return new ArrayList(reach);
        }

        public static float getReach(boolean flag)
        {
            ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.getHeldItem();
            for(Iterator iterator = reach.iterator(); iterator.hasNext();)
            {
                IReach ireach = (IReach)iterator.next();
                if(ireach.iReachMatches(flag, itemstack))
                {
                    return ireach.iReachGet(flag, itemstack);
                }
            }

            return flag ? 3F : 4F;
        }


        public Reach()
        {
        }
    }

    private static class PairFloatString
    {

        private float f;
        private String s;



        public PairFloatString(float f1, String s1)
        {
            f = f1;
            s = s1;
        }
    }

    private static class PairFloatDungeonLoot
    {

        private float f;
        private DungeonLoot dl;



        public PairFloatDungeonLoot(float f1, DungeonLoot dungeonloot)
        {
            f = f1;
            dl = dungeonloot;
        }
    }

    public static class NBT
    {

        private static ArrayList nbt = new ArrayList();

        public static void add(INBT inbt)
        {
            nbt.add(inbt);
        }

        public static ArrayList getList()
        {
            return new ArrayList(nbt);
        }


        public NBT()
        {
        }
    }

    public static class LockDifficulty
    {

        private static ArrayList mods = new ArrayList();

        public static void add(ILockDifficulty ilockdifficulty)
        {
            mods.add(ilockdifficulty);
        }

        public static String listLockingMods()
        {
            String s = "";
            if(mods.isEmpty())
            {
                return s;
            }
            Iterator iterator = mods.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                ILockDifficulty ilockdifficulty = (ILockDifficulty)iterator.next();
                if(ilockdifficulty.iLockShouldLock())
                {
                    if(!s.isEmpty())
                    {
                        s = (new StringBuilder(String.valueOf(s))).append(",").toString();
                    }
                    s = (new StringBuilder(String.valueOf(s))).append(ilockdifficulty.iLockModName()).toString();
                }
            } while(true);
            return s;
        }


        public LockDifficulty()
        {
        }
    }

    public static class Harvest
    {

        private static ArrayList harvest = new ArrayList();

        public static void add(IHarvest iharvest)
        {
            harvest.add(iharvest);
        }

        public static ArrayList getList()
        {
            return new ArrayList(harvest);
        }

        public static boolean intercept(World world, EntityPlayer entityplayer, int i, int j, int k, int l, int i1)
        {
            for(Iterator iterator = harvest.iterator(); iterator.hasNext();)
            {
                IHarvest iharvest = (IHarvest)iterator.next();
                if(iharvest.iHarvest(world, entityplayer, i, j, k, l, i1))
                {
                    return true;
                }
            }

            return false;
        }


        public Harvest()
        {
        }
    }

    public static class Dungeon
    {

        private static ArrayList loot = new ArrayList();
        private static ArrayList mobs = new ArrayList();

        public static void addDungeonLoot(DungeonLoot dungeonloot)
        {
            addDungeonLoot(dungeonloot, 1.0F);
        }

        public static void addDungeonLoot(DungeonLoot dungeonloot, float f)
        {
            loot.add(new PairFloatDungeonLoot(f, dungeonloot));
        }

        public static void addMob(String s)
        {
            addMob(s, 1.0F);
        }

        public static void addMob(String s, float f)
        {
            mobs.add(new PairFloatString(f, s));
        }

        private static float lootGetMaxRandom()
        {
            float f = 0.0F;
            for(Iterator iterator = loot.iterator(); iterator.hasNext();)
            {
                PairFloatDungeonLoot pairfloatdungeonloot = (PairFloatDungeonLoot)iterator.next();
                f += pairfloatdungeonloot.f;
            }

            return f;
        }

        private static DungeonLoot lootGetFromRandomFloat(float f)
        {
            for(Iterator iterator = loot.iterator(); iterator.hasNext();)
            {
                PairFloatDungeonLoot pairfloatdungeonloot = (PairFloatDungeonLoot)iterator.next();
                if(f < pairfloatdungeonloot.f)
                {
                    return pairfloatdungeonloot.dl;
                }
                f -= pairfloatdungeonloot.f;
            }

            return null;
        }

        public static DungeonLoot lootGet(Random random)
        {
            return lootGetFromRandomFloat(random.nextFloat() * lootGetMaxRandom());
        }

        private static float mobGetMaxRandom()
        {
            float f = 0.0F;
            for(Iterator iterator = mobs.iterator(); iterator.hasNext();)
            {
                PairFloatString pairfloatstring = (PairFloatString)iterator.next();
                f += pairfloatstring.f;
            }

            return f;
        }

        private static String mobGetFromRandomFloat(float f)
        {
            for(Iterator iterator = mobs.iterator(); iterator.hasNext();)
            {
                PairFloatString pairfloatstring = (PairFloatString)iterator.next();
                if(f < pairfloatstring.f)
                {
                    return pairfloatstring.s;
                }
                f -= pairfloatstring.f;
            }

            return null;
        }

        public static String mobGet(Random random)
        {
            return mobGetFromRandomFloat(random.nextFloat() * mobGetMaxRandom());
        }


        public Dungeon()
        {
        }
    }

    public static class BlockSet
    {

        private static ArrayList blockset = new ArrayList();

        public static void add(IBlockSet iblockset)
        {
            blockset.add(iblockset);
        }

        public static ArrayList getList()
        {
            return new ArrayList(blockset);
        }

        public static IBlockSet getIntercept(World world, int i, int j, int k, int l)
        {
            for(Iterator iterator = blockset.iterator(); iterator.hasNext();)
            {
                IBlockSet iblockset = (IBlockSet)iterator.next();
                if(iblockset.iBlockMatches(world, i, j, k, l))
                {
                    return iblockset;
                }
            }

            return null;
        }


        public BlockSet()
        {
        }
    }

    public static class Achievements
    {

        private static ArrayList pages = new ArrayList();
        private static ArrayList hidden = new ArrayList();
        private static int current = 0;
        protected static AchievementPage defaultPage = new AchievementPage();

        public static void addPage(AchievementPage achievementpage)
        {
            pages.add(achievementpage);
        }

        public static AchievementPage getPage(Achievement achievement)
        {
            if(achievement == null)
            {
                return null;
            }
            for(Iterator iterator = pages.iterator(); iterator.hasNext();)
            {
                AchievementPage achievementpage = (AchievementPage)iterator.next();
                if(achievementpage.list.contains(Integer.valueOf(achievement.statId)))
                {
                    return achievementpage;
                }
            }

            return defaultPage;
        }

        public static void hide(Achievement aachievement[])
        {
            Achievement aachievement1[];
            int i = (aachievement1 = aachievement).length;
            for(int j = 0; j < i; j++)
            {
                Achievement achievement = aachievement1[j];
                hidden.add(Integer.valueOf(achievement.statId));
            }

        }

        public static void unhide(Achievement aachievement[])
        {
            Achievement aachievement1[];
            int i = (aachievement1 = aachievement).length;
            for(int j = 0; j < i; j++)
            {
                Achievement achievement = aachievement1[j];
                hidden.remove(Integer.valueOf(achievement.statId));
            }

        }

        public static boolean isHidden(Achievement achievement)
        {
            for(Iterator iterator = hidden.iterator(); iterator.hasNext();)
            {
                int i = ((Integer)iterator.next()).intValue();
                if(achievement.statId == i)
                {
                    return true;
                }
            }

            return false;
        }

        public static ArrayList getPages()
        {
            return new ArrayList(pages);
        }

        public static AchievementPage current()
        {
            return (AchievementPage)pages.get(current);
        }

        public static void setPage(AchievementPage achievementpage)
        {
            for(int i = 0; i < pages.size(); i++)
            {
                if(((AchievementPage)pages.get(i)).equals(achievementpage))
                {
                    current = i;
                    return;
                }
            }

        }


        public Achievements()
        {
        }
    }


    public SAPI()
    {
    }
}
