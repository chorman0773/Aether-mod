// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            SAPI, ItemStack, Block, Achievement

public class AchievementPage
{

    private static int nextID = 1;
    private final int id;
    public final ItemStack stackIcon;
    public final String title;
    protected ArrayList list;

    public AchievementPage()
    {
        list = new ArrayList();
        id = 0;
        stackIcon = new ItemStack(Block.blocksList[2]);
        title = "Minecraft";
        SAPI.Achievements.addPage(this);
    }

    public AchievementPage(ItemStack itemstack, String s)
    {
        list = new ArrayList();
        id = nextID++;
        stackIcon = itemstack;
        title = s;
        SAPI.Achievements.addPage(this);
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(!(obj instanceof AchievementPage))
        {
            return false;
        } else
        {
            AchievementPage achievementpage = (AchievementPage)obj;
            return id == achievementpage.id;
        }
    }

    public final int getID()
    {
        return id;
    }

    public void addwss(Achievement aachievement[])
    {
        Achievement aachievement1[] = aachievement;
        int i = aachievement.length;
        for(int j = 0; j < i; j++)
        {
            Achievement achievement = aachievement1[j];
            list.add(Integer.valueOf(achievement.statId));
        }

    }

    public int bgGetSprite(Random random, int i, int j)
    {
        int k = random.nextInt(1 + j) + j / 2;
        Block block = Block.blocksList[12];
        if(k > 37 || j == 35)
        {
            block = Block.blocksList[7];
        } else
        if(k == 22)
        {
            block = random.nextInt(2) != 0 ? Block.blocksList[73] : Block.blocksList[56];
        } else
        if(k == 10)
        {
            block = Block.blocksList[15];
        } else
        if(k == 8)
        {
            block = Block.blocksList[16];
        } else
        if(k > 4)
        {
            block = Block.blocksList[1];
        } else
        if(k > 0)
        {
            block = Block.blocksList[3];
        }
        return block.blockIndexInTexture;
    }

}
