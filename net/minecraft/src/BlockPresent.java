// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            AetherBlock, Material, ModLoader, World, 
//            EntityPlayer, EntityXPOrb, ItemStack, AetherItems, 
//            EntityTNTPresent

public class BlockPresent extends AetherBlock
{

    public static int sprTop = 47;
    public static int sprSide = 48;
    int rarity;
    int randStart;
    int randEnd;
    long range;
    long fraction;
    int randomNumber;
    int crateType;

    protected BlockPresent(int i)
    {
        super(i, 48, Material.wood);
        randStart = 6;
        randEnd = 9;
        range = ((long)randEnd - (long)randStart) + 1L;
    }

    public void onBlockPlaced(World world, int i, int j, int k, int l)
    {
        Random random = new Random();
        fraction = (long)((double)range * random.nextDouble());
        randomNumber = (int)(fraction + (long)randStart);
        crateType = random.nextInt(4);
        rarity = random.nextInt(9);
    }

    public int getBlockTextureFromSide(int i)
    {
        return i != 0 ? i != 1 ? sprSide : sprTop : sprTop;
    }

    public int func_40198_a(int i, Random random)
    {
        return quantityDropped(random);
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int idDropped(int i, Random random, int j)
    {
        return 0;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        EntityPlayerSP entityplayersp = minecraft.thePlayer;
        Random random = new Random();
        int i1 = 6;
        int j1 = 9;
        long l1 = ((long)j1 - (long)i1) + 1L;
        long l2 = (long)((double)l1 * random.nextDouble());
        int k1 = (int)(l2 + (long)i1);
        int i2 = random.nextInt(4);
        if(i2 == 0)
        {
            for(int j2 = 1; j2 <= k1; j2++)
            {
                world.spawnEntityInWorld(new EntityXPOrb(world, i, j, k, 1));
            }

        } else
        if(i2 == 1)
        {
            if(random.nextInt(9) == 0)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(AetherItems.CandySword, 1));
            } else
            {
                for(int k2 = 1; k2 <= k1; k2++)
                {
                    dropBlockAsItem_do(world, i, j, k, new ItemStack(AetherItems.GingerBreadMan, 1));
                }

            }
        } else
        {
            EntityTNTPresent entitytntpresent = new EntityTNTPresent(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
            world.spawnEntityInWorld(entitytntpresent);
            world.playSoundAtEntity(entitytntpresent, "random.fuse", 1.0F, 1.0F);
        }
    }

}
