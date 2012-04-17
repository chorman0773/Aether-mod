// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            BaseMod, INBT, SAPI, ModLoader, 
//            DungeonLoot, ItemStack, Item, PlayerBaseSAPI, 
//            PlayerAPI, GuiLockDifficulty, World, WorldInfo, 
//            GuiAchievements, GuiAchievementsPages, StatFileWriter, GameSettings, 
//            NBTTagCompound, CompressedStreamTools, SaveHandler, GuiScreen, 
//            ISaveHandler

public class mod_SAPI extends BaseMod
    implements INBT
{

    private static World worldObj;
    protected static int lockDifficulty = -1;
    private static int counter = 0;

    public mod_SAPI()
    {
    }

    public String getVersion()
    {
        return "r11";
    }

    public void load()
    {
        ModLoader.SetInGameHook(this, true, true);
        ModLoader.SetInGUIHook(this, true, false);
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[329])));
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[265]), 1, 4));
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[297])));
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[296]), 1, 4));
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[289]), 1, 4));
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[287]), 1, 4));
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[325])));
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[322])), 0.01F);
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[331]), 1, 4), 0.5F);
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[2256])), 0.05F);
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[2257])), 0.05F);
        SAPI.Dungeon.addDungeonLoot(new DungeonLoot(new ItemStack(Item.itemsList[351], 1, 3)));
        SAPI.Dungeon.addMob("Skeleton");
        SAPI.Dungeon.addMob("Zombie", 2.0F);
        SAPI.Dungeon.addMob("Spider");
        SAPI.NBT.add(this);
        PlayerAPI.register("Dimension API", net.minecraft.src.PlayerBaseSAPI.class);
    }

    public boolean OnTickInGame(float f, Minecraft minecraft)
    {
        if(counter == 1)
        {
            counter = 0;
            minecraft.displayGuiScreen(new GuiLockDifficulty(minecraft.theWorld));
        }
        tick(minecraft);
        if(!minecraft.theWorld.multiplayerWorld)
        {
            if(minecraft.theWorld != worldObj)
            {
                if(worldObj != null)
                {
                    saveNBT(worldObj);
                }
                if(minecraft.thePlayer != null)
                {
                    loadNBT(minecraft.theWorld);
                }
                worldObj = minecraft.theWorld;
            }
            if(worldObj != null && worldObj.worldInfo.getWorldTime() % (long)worldObj.autosavePeriod == 0L)
            {
                saveNBT(worldObj);
            }
        }
        return true;
    }

    public boolean OnTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen)
    {
        if(guiscreen != null && guiscreen.getClass() == (net.minecraft.src.GuiAchievements.class))
        {
            try
            {
                minecraft.displayGuiScreen(new GuiAchievementsPages((StatFileWriter)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, (GuiAchievements)guiscreen, "x")));
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        tick(minecraft);
        worldObj = null;
        return true;
    }

    public void tick(Minecraft minecraft)
    {
        lockDifficulty(minecraft);
    }

    public static void updateShouldLock(World world)
    {
        if(world == null)
        {
            lockDifficulty = -1;
        }
    }

    public static void lockDifficulty(Minecraft minecraft)
    {
        if(lockDifficulty == -1)
        {
            return;
        } else
        {
            minecraft.gameSettings.difficulty = lockDifficulty;
            return;
        }
    }

    public static void saveNBT(World world)
    {
        try
        {
            File file = GetWorldSaveLocation(world);
            ArrayList arraylist = SAPI.NBT.getList();
            File file1;
            NBTTagCompound nbttagcompound;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); CompressedStreamTools.writeGzippedCompoundToOutputStream(nbttagcompound, new FileOutputStream(file1)))
            {
                INBT inbt = (INBT)iterator.next();
                file1 = new File(file, inbt.iNBTFilename());
                if(!file1.exists())
                {
                    CompressedStreamTools.writeGzippedCompoundToOutputStream(new NBTTagCompound(), new FileOutputStream(file1));
                }
                nbttagcompound = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(file1));
                inbt.iNBTSave(nbttagcompound);
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        updateShouldLock(world);
    }

    public static void loadNBT(World world)
    {
        try
        {
            File file = GetWorldSaveLocation(world);
            ArrayList arraylist = SAPI.NBT.getList();
            INBT inbt;
            NBTTagCompound nbttagcompound;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); inbt.iNBTLoad(nbttagcompound))
            {
                inbt = (INBT)iterator.next();
                File file1 = new File(file, inbt.iNBTFilename());
                if(!file1.exists())
                {
                    CompressedStreamTools.writeGzippedCompoundToOutputStream(new NBTTagCompound(), new FileOutputStream(file1));
                }
                nbttagcompound = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(file1));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        updateShouldLock(world);
        if(!SAPI.LockDifficulty.listLockingMods().isEmpty() && lockDifficulty == -1)
        {
            counter = 1;
        }
    }

    public static File GetWorldSaveLocation(World world)
    {
        return GetWorldSaveLocation(world.saveHandler);
    }

    public static File GetWorldSaveLocation(ISaveHandler isavehandler)
    {
        return (isavehandler instanceof SaveHandler) ? ((SaveHandler)isavehandler).getSaveDirectory() : null;
    }

    public String iNBTFilename()
    {
        return "SAPI.dat";
    }

    public void iNBTSave(NBTTagCompound nbttagcompound)
    {
        nbttagcompound.setInteger("LockDifficulty", lockDifficulty);
    }

    public void iNBTLoad(NBTTagCompound nbttagcompound)
    {
        lockDifficulty = -1;
        if(nbttagcompound.hasKey("LockDifficulty"))
        {
            lockDifficulty = nbttagcompound.getInteger("LockDifficulty");
        }
    }

}
