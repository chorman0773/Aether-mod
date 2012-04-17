// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiCreateWorld, GuiMainMenu, GuiScreen, GuiButton

public class GuiCreateWorldAether extends GuiCreateWorld
{

    private int musicID;

    public GuiCreateWorldAether(GuiScreen guiscreen, int i)
    {
        super(guiscreen);
        musicID = i;
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        mc.changeWorld1(null);
        mc.theWorld = null;
        mc.thePlayer = null;
        GuiMainMenu.mmactive = false;
        GuiMainMenu.musicId = -1;
        GuiMainMenu.loadingWorld = true;
        super.actionPerformed(guibutton);
    }
}
