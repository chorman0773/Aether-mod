// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTTagCompound, CompressedStreamTools, mod_Aether, World, 
//            SaveHandler

public class AetherNBT
{

    public AetherNBT()
    {
    }

    public static void save(World world)
    {
        try
        {
            File file = GetWorldSaveLocation(world);
            File file1 = new File(file, "aether.dat");
            if(!file1.exists())
            {
                CompressedStreamTools.writeGzippedCompoundToOutputStream(new NBTTagCompound(), new FileOutputStream(file1));
            }
            NBTTagCompound nbttagcompound = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(file1));
            nbttagcompound.setBoolean("LoreOverworld", mod_Aether.hasLoreOverworld);
            nbttagcompound.setBoolean("LoreNether", mod_Aether.hasLoreNether);
            nbttagcompound.setBoolean("LoreAether", mod_Aether.hasLoreAether);
            CompressedStreamTools.writeGzippedCompoundToOutputStream(nbttagcompound, new FileOutputStream(file1));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void load(World world)
    {
        try
        {
            File file = GetWorldSaveLocation(world);
            File file1 = new File(file, "aether.dat");
            if(!file1.exists())
            {
                CompressedStreamTools.writeGzippedCompoundToOutputStream(new NBTTagCompound(), new FileOutputStream(file1));
            }
            NBTTagCompound nbttagcompound = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(file1));
            mod_Aether.hasLoreOverworld = nbttagcompound.getBoolean("LoreOverworld");
            mod_Aether.hasLoreNether = nbttagcompound.getBoolean("LoreNether");
            mod_Aether.hasLoreAether = nbttagcompound.getBoolean("LoreAether");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static File GetWorldSaveLocation(World world)
    {
        return (world.saveHandler instanceof SaveHandler) ? ((SaveHandler)world.saveHandler).getSaveDirectory() : null;
    }
}
