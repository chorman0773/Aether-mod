// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material, EntityPlayer, World, 
//            MathHelper, EntitySentry, EntityValkyrie, AetherBlocks, 
//            Block, Entity

public class BlockTrap extends BlockBreakable
    implements ITextureProvider
{

    public static int sprBronze = 5;
    public static int sprSilver = 4;
    public static int sprGold = 18;

    public String getTextureFile()
    {
        return "/aetherBlocks.png";
    }

    public BlockTrap(int i)
    {
        super(i, sprBronze, Material.rock, false);
        setTickOnLoad(true);
    }

    public boolean isOpaqueCube()
    {
        return true;
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(j == 2)
        {
            return sprGold;
        }
        if(j == 1)
        {
            return sprSilver;
        } else
        {
            return sprBronze;
        }
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, "aether.sound.other.dungeontrap.activateTrap", 1.0F, 1.0F);
            int l = MathHelper.floor_double(i);
            int i1 = MathHelper.floor_double(j);
            int j1 = MathHelper.floor_double(k);
            switch(world.getBlockMetadata(i, j, k))
            {
            case 0: // '\0'
                EntitySentry entitysentry = new EntitySentry(world);
                entitysentry.setPosition((double)l + 0.5D, (double)i1 + 1.5D, (double)j1 + 0.5D);
                world.spawnEntityInWorld(entitysentry);
                break;

            case 1: // '\001'
                EntityValkyrie entityvalkyrie = new EntityValkyrie(world);
                entityvalkyrie.setPosition((double)l + 0.5D, (double)i1 + 1.5D, (double)j1 + 0.5D);
                world.spawnEntityInWorld(entityvalkyrie);
                break;
            }
            world.setBlockAndMetadataWithNotify(i, j, k, AetherBlocks.LockedDungeonStone.blockID, world.getBlockMetadata(i, j, k));
        }
    }

    protected int damageDropped(int i)
    {
        return i;
    }

}
