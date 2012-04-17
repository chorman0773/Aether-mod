// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiSelectWorld, GuiButton, GuiMainMenu, GuiScreen

public class GuiSelectWorldAether extends GuiSelectWorld
{

    private int musicID;

    public GuiSelectWorldAether(GuiScreen guiscreen, int i)
    {
        super(guiscreen);
        musicID = i;
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(!guibutton.enabled)
        {
            return;
        }
        if(guibutton.id == 2)
        {
            unloadbackround();
        }
        super.actionPerformed(guibutton);
    }

    protected void unloadbackround()
    {
        mc.changeWorld1(null);
        mc.theWorld = null;
        mc.thePlayer = null;
    }

    public void selectWorld(int i)
    {
        unloadbackround();
        GuiMainMenu.mmactive = false;
        GuiMainMenu.musicId = -1;
        GuiMainMenu.loadingWorld = true;
        super.selectWorld(i);
    }
}
