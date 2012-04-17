// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;

// Referenced classes of package net.minecraft.src:
//            World, ChunkCoordinates, IBlockAccess, TileEntity

public class Loc
{

    public final double x;
    public final double y;
    public final double z;

    public Loc()
    {
        this(0, 0, 0);
    }

    public Loc(int i, int j)
    {
        this(i, 0, j);
    }

    public Loc(int i, int j, int k)
    {
        this(i, j, k);
    }

    public Loc(double d, double d1)
    {
        this(d, 0.0D, d1);
    }

    public Loc(World world)
    {
        this(world.getSpawnPoint().posX, world.getSpawnPoint().posY, world.getSpawnPoint().posZ);
    }

    public Loc(Loc loc)
    {
        this(loc.x, loc.y, loc.z);
    }

    public Loc(double d, double d1, double d2)
    {
        x = d;
        y = d1;
        z = d2;
    }

    public int x()
    {
        return (int)x;
    }

    public int y()
    {
        return (int)y;
    }

    public int z()
    {
        return (int)z;
    }

    public Loc add(int i, int j, int k)
    {
        return new Loc(x + (double)i, y + (double)j, z + (double)k);
    }

    public Loc add(double d, double d1, double d2)
    {
        return new Loc(x + d, y + d1, z + d2);
    }

    public Loc add(Loc loc)
    {
        return new Loc(x + loc.x, y + loc.y, z + loc.z);
    }

    public Loc subtract(int i, int j, int k)
    {
        return new Loc(x - (double)i, y - (double)j, z - (double)k);
    }

    public Loc subtract(double d, double d1, double d2)
    {
        return new Loc(x - d, y - d1, z - d2);
    }

    public Loc subtract(Loc loc)
    {
        return new Loc(x - loc.x, y - loc.y, z - loc.z);
    }

    public Loc multiply(double d, double d1, double d2)
    {
        return new Loc(x * d, y * d1, z * d2);
    }

    public Loc getSide(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return new Loc(x, y - 1.0D, z);

        case 1: // '\001'
            return new Loc(x, y + 1.0D, z);

        case 2: // '\002'
            return new Loc(x, y, z - 1.0D);

        case 3: // '\003'
            return new Loc(x, y, z + 1.0D);

        case 4: // '\004'
            return new Loc(x - 1.0D, y, z);

        case 5: // '\005'
            return new Loc(x + 1.0D, y, z);
        }
        return new Loc(x, y, z);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Loc)
        {
            Loc loc = (Loc)obj;
            return x == loc.x && y == loc.y && z == loc.z;
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        return (new StringBuilder("(")).append(x).append(",").append(y).append(",").append(z).append(")").toString();
    }

    public int distSimple(Loc loc)
    {
        return (int)(Math.abs(x - loc.x) + Math.abs(y - loc.y) + Math.abs(z - loc.z));
    }

    public double distAdv(Loc loc)
    {
        return Math.sqrt(Math.pow(x - loc.x, 2D) + Math.pow(y - loc.y, 2D) + Math.pow(z - loc.z, 2D));
    }

    public static Loc[] vecAdjacent()
    {
        Loc aloc[] = {
            new Loc(0, 0, 1), new Loc(0, 0, -1), new Loc(0, 1, 0), new Loc(0, -1, 0), new Loc(1, 0, 0), new Loc(-1, 0, 0)
        };
        return aloc;
    }

    public Loc[] adjacent()
    {
        Loc aloc[] = vecAdjacent();
        for(int i = 0; i < aloc.length; i++)
        {
            aloc[i] = add(aloc[i]);
        }

        return aloc;
    }

    public static Loc[] vecAdjacent2D()
    {
        Loc aloc[] = {
            new Loc(0, 1), new Loc(0, -1), new Loc(1, 0), new Loc(-1, 0)
        };
        return aloc;
    }

    public Loc[] adjacent2D()
    {
        Loc aloc[] = vecAdjacent();
        for(int i = 0; i < aloc.length; i++)
        {
            aloc[i] = add(aloc[i]);
        }

        return aloc;
    }

    public static ArrayList vecInRadius(int i, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Loc loc = new Loc();
        for(int j = -i; j <= i; j++)
        {
            for(int k = -i; k <= i; k++)
            {
                for(int l = -i; l <= i; l++)
                {
                    Loc loc1 = new Loc(j, l, k);
                    double d = flag ? loc.distAdv(loc1) : loc.distSimple(loc1);
                    if(d <= (double)i)
                    {
                        arraylist.add(loc1);
                    }
                }

            }

        }

        return arraylist;
    }

    public ArrayList inRadius(int i, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        for(int j = -i; j <= i; j++)
        {
            for(int k = -i; k <= i; k++)
            {
                for(int l = -i; l <= i; l++)
                {
                    Loc loc = (new Loc(j, l, k)).add(this);
                    double d = flag ? distAdv(loc) : distSimple(loc);
                    if(d <= (double)i)
                    {
                        arraylist.add(loc);
                    }
                }

            }

        }

        return arraylist;
    }

    public static ArrayList vecInRadius2D(int i, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        Loc loc = new Loc();
        for(int j = -i; j <= i; j++)
        {
            for(int k = -i; k <= i; k++)
            {
                Loc loc1 = new Loc(j, k);
                double d = flag ? loc.distAdv(loc1) : loc.distSimple(loc1);
                if(d <= (double)i)
                {
                    arraylist.add(loc1);
                }
            }

        }

        return arraylist;
    }

    public ArrayList inRadius2D(int i, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        for(int j = -i; j <= i; j++)
        {
            for(int k = -i; k <= i; k++)
            {
                Loc loc = (new Loc(j, k)).add(this);
                double d = flag ? distAdv(loc) : distSimple(loc);
                if(d <= (double)i)
                {
                    arraylist.add(loc);
                }
            }

        }

        return arraylist;
    }

    public int getBlock(IBlockAccess iblockaccess)
    {
        return iblockaccess.getBlockId(x(), y(), z());
    }

    public Loc setBlockNotify(World world, int i)
    {
        world.setBlockWithNotify(x(), y(), z(), i);
        return this;
    }

    public Loc setBlock(World world, int i)
    {
        world.setBlock(x(), y(), z(), i);
        return this;
    }

    public int getMeta(IBlockAccess iblockaccess)
    {
        return iblockaccess.getBlockMetadata(x(), y(), z());
    }

    public Loc setMeta(World world, int i)
    {
        world.setBlockMetadata(x(), y(), z(), i);
        return this;
    }

    public Loc setMetaNotify(World world, int i)
    {
        world.setBlockMetadataWithNotify(x(), y(), z(), i);
        return this;
    }

    public Loc setBlockAndMeta(World world, int i, int j)
    {
        world.setBlockAndMetadata(x(), y(), z(), i, j);
        return this;
    }

    public Loc setBlockAndMetaNotify(World world, int i, int j)
    {
        world.setBlockAndMetadataWithNotify(x(), y(), z(), i, j);
        return this;
    }

    public TileEntity getTileEntity(IBlockAccess iblockaccess)
    {
        return iblockaccess.getBlockTileEntity(x(), y(), z());
    }

    public Loc setTileEntity(World world, TileEntity tileentity)
    {
        world.setBlockTileEntity(x(), y(), z(), tileentity);
        return this;
    }

    public Loc removeTileEntity(World world)
    {
        world.removeBlockTileEntity(x(), y(), z());
        return this;
    }

    public int getLight(World world)
    {
        return world.getFullBlockLightValue(x(), y(), z());
    }

    public Loc notify(World world)
    {
        world.notifyBlocksOfNeighborChange(x(), y(), z(), getBlock(world));
        return this;
    }

    public Loc setSpawnPoint(World world)
    {
        world.setSpawnPoint(new ChunkCoordinates(x(), y(), z()));
        return this;
    }
}
