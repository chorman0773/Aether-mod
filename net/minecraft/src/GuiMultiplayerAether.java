// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiMultiplayer, GuiMainMenu, GuiIngame, GuiButton, 
//            GuiScreen

public class GuiMultiplayerAether extends GuiMultiplayer
{

    private boolean mainMenu;
    private int musicID;
    private GuiScreen parentScreen;

    public GuiMultiplayerAether(GuiScreen guiscreen, int i)
    {
        super(guiscreen);
        mainMenu = false;
        parentScreen = guiscreen;
        musicID = i;
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
        if(mainMenu)
        {
            return;
        } else
        {
            mc.theWorld = null;
            mc.thePlayer = null;
            GuiMainMenu.mmactive = false;
            mc.ingameGUI = new GuiIngame(mc);
            GuiMainMenu.loadingWorld = true;
            GuiMainMenu.musicId = -1;
            return;
        }
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 1)
        {
            mainMenu = true;
            mc.displayGuiScreen(parentScreen);
        } else
        {
            super.actionPerformed(guibutton);
        }
    }
}
