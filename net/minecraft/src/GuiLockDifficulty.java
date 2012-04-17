// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, SAPI, GuiSmallButton, GuiButton, 
//            GameSettings, mod_SAPI, StatList, StatFileWriter, 
//            GuiMainMenu, World

public class GuiLockDifficulty extends GuiScreen
{

    public World world;

    public GuiLockDifficulty(World world1)
    {
        world = world1;
    }

    public void initGui()
    {
        controlList.add(new GuiSmallButton(0, (width / 2 - 155) + 0, height / 6 + 96, "Okay"));
        controlList.add(new GuiSmallButton(1, (width / 2 - 155) + 160, height / 6 + 96, "Cancel"));
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 0)
        {
            mod_SAPI.lockDifficulty = mc.gameSettings.difficulty;
            mod_SAPI.saveNBT(mc.theWorld);
            mc.displayGuiScreen(null);
        } else
        {
            mc.statFileWriter.readStat(StatList.leaveGameStat, 1);
            mc.changeWorld1(null);
            mc.displayGuiScreen(new GuiMainMenu());
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        drawDefaultBackground();
        drawCenteredString(fontRenderer, "Warning: Difficulty will be locked in place, because of these mods:", width / 2, 70, 0xffffff);
        drawCenteredString(fontRenderer, SAPI.LockDifficulty.listLockingMods(), width / 2, 90, 0xffffff);
        super.drawScreen(i, j, f);
    }
}
