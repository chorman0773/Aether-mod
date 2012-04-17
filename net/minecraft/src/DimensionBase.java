// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            WorldProvider, WorldProviderHell, WorldProviderSurface, Teleporter, 
//            ModLoader, World, EntityPlayerSP, GuiGameOver, 
//            ThreadedChunkLoader, ChunkProvider, SaveHandler, EntityPlayer, 
//            ISaveHandler

public class DimensionBase
{

    public static HashMap providerMap = new HashMap(5, 0.75F);
    public static HashMap dimMap = new HashMap(5, 0.75F);
    public Class worldProvider;
    public Class teleporter;
    public String name;
    public int number;
    public File DimensionDIR;
    public String soundTrigger;
    public String soundTravel;
    public static World normalWorld;

    public static WorldProvider getWorldProvider(int i)
    {
        if(providerMap.containsKey(Integer.valueOf(i)))
        {
            Class class1 = (Class)providerMap.get(Integer.valueOf(i));
            try
            {
                return (WorldProvider)class1.newInstance();
            }
            catch(InstantiationException instantiationexception) { }
            catch(IllegalAccessException illegalaccessexception) { }
        } else
        if(i == -1)
        {
            return new WorldProviderHell();
        }
        return new WorldProviderSurface();
    }

    public Teleporter getTeleporter()
    {
        try
        {
            if(teleporter != null)
            {
                return (Teleporter)teleporter.newInstance();
            }
        }
        catch(InstantiationException instantiationexception) { }
        catch(IllegalAccessException illegalaccessexception) { }
        return null;
    }

    public File GetDimensionSaveDir()
    {
        DimensionDIR = new File(GetSaveDir(), name);
        return DimensionDIR;
    }

    void usePortal()
    {
        System.out.print("use portal");
        DimensionDIR = GetDimensionSaveDir();
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        minecraft.theWorld.setEntityDead(minecraft.thePlayer);
        minecraft.thePlayer.isDead = false;
        World world = null;
        boolean flag = false;
        minecraft.thePlayer.dimension = minecraft.thePlayer.dimension == number ? 0 : number;
        if(minecraft.thePlayer.dimension == number)
        {
            flag = true;
        }
        minecraft.thePlayer.setLocationAndAngles(minecraft.thePlayer.posX, minecraft.thePlayer.posY, minecraft.thePlayer.posZ, minecraft.thePlayer.rotationYaw, minecraft.thePlayer.rotationPitch);
        minecraft.theWorld.updateEntityWithOptionalForce(minecraft.thePlayer, false);
        world = new World(minecraft.theWorld, getWorldProvider(minecraft.thePlayer.dimension));
        if(minecraft.thePlayer.dimension == 0 || minecraft.thePlayer.dimension == -1)
        {
            minecraft.changeWorld(world, ChangeMessage(!flag, name), minecraft.thePlayer);
        } else
        {
            changeWorld(world, ChangeMessage(!flag, name), minecraft.thePlayer);
        }
        minecraft.thePlayer.worldObj = minecraft.theWorld;
        minecraft.theWorld.updateEntityWithOptionalForce(minecraft.thePlayer, false);
        Teleporter teleporter1 = getTeleporter();
        if(teleporter1 == null)
        {
            teleporter1 = new Teleporter();
        }
        teleporter1.placeInPortal(minecraft.theWorld, minecraft.thePlayer);
    }

    public static void usePortal(int i)
    {
        System.out.println(i);
        DimensionBase dimensionbase = (DimensionBase)dimMap.get(Integer.valueOf(i));
        if(dimensionbase == null)
        {
            System.out.println("Why");
        }
        dimensionbase.usePortal();
    }

    private static String ChangeMessage(boolean flag, String s)
    {
        return flag ? (new StringBuilder("Leaving the ")).append(s).toString() : (new StringBuilder("Entering the ")).append(s).toString();
    }

    public static void respawn(boolean flag, int i)
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        if(!minecraft.theWorld.multiplayerWorld && !minecraft.theWorld.worldProvider.canRespawnHere())
        {
            usePortal(i);
        }
        minecraft.respawn(flag, i, false);
        try
        {
            Method method = (net.minecraft.client.Minecraft.class).getDeclaredMethod("d", new Class[] {
                java.lang.String.class
            });
            method.setAccessible(true);
            method.invoke(minecraft, new Object[] {
                "Respawning"
            });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(minecraft.currentScreen instanceof GuiGameOver)
        {
            minecraft.displayGuiScreen(null);
        }
    }

    public void changeWorld(World world, String s, EntityPlayer entityplayer)
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        ThreadedChunkLoader threadedchunkloader = new ThreadedChunkLoader(DimensionDIR);
        world.chunkProvider = new ChunkProvider(world, threadedchunkloader, world.worldProvider.getChunkProvider());
        minecraft.changeWorld(world, s, entityplayer);
    }

    static File GetSaveDir()
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        if(minecraft.theWorld != null)
        {
            SaveHandler savehandler = (SaveHandler)minecraft.theWorld.saveHandler;
            System.out.println(savehandler.getSaveDirectory());
            return savehandler.getSaveDirectory();
        } else
        {
            return null;
        }
    }

    static File GetSaveDir(ISaveHandler isavehandler)
    {
        System.out.println(((SaveHandler)isavehandler).getSaveDirectory());
        return ((SaveHandler)isavehandler).getSaveDirectory();
    }

    public DimensionBase(int i, Class class1, Class class2)
    {
        number = i;
        worldProvider = class1;
        teleporter = class2;
        providerMap.put(Integer.valueOf(number), worldProvider);
        dimMap.put(Integer.valueOf(i), this);
    }

    public File GetDimensionSaveDir(ISaveHandler isavehandler)
    {
        DimensionDIR = new File(GetSaveDir(isavehandler), name);
        return DimensionDIR;
    }

}
