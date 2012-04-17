// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, ModLoader, EntityPlayerSP, GuiAchievementAether, 
//            GuiIngameAether, SoundManager, GameSettings, StringTranslate, 
//            PlayerControllerSP, WorldSettings, World, GuiAetherButton, 
//            GuiButton, SaveFormatComparator, MathHelper, ISaveFormat, 
//            GuiOptions, GuiSelectWorldAether, GuiMultiplayerAether, GuiTexturePacks, 
//            Tessellator, RenderEngine, FontRenderer, mod_Aether, 
//            GuiAchievement

public class GuiMainMenu extends GuiScreen
{

    private static final Random rand = new Random();
    public static boolean mmactive = false;
    private float updateCounter;
    private String splashText;
    private GuiButton multiplayerButton;
    public static boolean renderOption;
    public static boolean themeOption;
    private List saveList;
    private int selectedWorld;
    public int renderSplit;
    public int closeTicks;
    public static int musicId = -1;
    private String hoverText;
    public static boolean loadingWorld = false;
    public static GuiAchievement ach;

    public GuiMainMenu()
    {
        updateCounter = 0.0F;
        splashText = "missingno";
        renderSplit = 4;
        hoverText = "";
        try
        {
            ArrayList arraylist = new ArrayList();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.GuiMainMenu.class).getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
            String s = "";
            do
            {
                String s1;
                if((s1 = bufferedreader.readLine()) == null)
                {
                    break;
                }
                s1 = s1.trim();
                if(s1.length() > 0)
                {
                    arraylist.add(s1);
                }
            } while(true);
            splashText = (String)arraylist.get(rand.nextInt(arraylist.size()));
        }
        catch(Exception exception) { }
    }

    public boolean OnTickInGame(Minecraft minecraft)
    {
        closeTicks++;
        return true;
    }

    public void updateScreen()
    {
        updateCounter++;
        if(renderOption && ModLoader.getMinecraftInstance().thePlayer != null && !ModLoader.getMinecraftInstance().thePlayer.isDead)
        {
            ModLoader.getMinecraftInstance().thePlayer.rotationYaw += 0.2F;
            ModLoader.getMinecraftInstance().thePlayer.rotationPitch = 0.0F;
            ModLoader.getMinecraftInstance().thePlayer.fallDistance = 0.0F;
        }
    }

    protected void keyTyped(char c, int i)
    {
    }

    public void initGui()
    {
        mmactive = true;
        mc.guiAchievement = new GuiAchievementAether(mc);
        mc.ingameGUI = new GuiIngameAether(mc);
        if(musicId == -1 && !loadingWorld)
        {
            mc.sndManager.playSoundFX("aether.music.menu", 1.0F, 1.0F);
            try
            {
                musicId = Integer.valueOf(((Integer)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "e")).intValue()).intValue();
                ModLoader.setPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "i", Integer.valueOf(0x3b9ac9ff));
            }
            catch(Exception exception)
            {
                if(exception instanceof NoSuchFieldException)
                {
                    try
                    {
                        musicId = Integer.valueOf(((Integer)ModLoader.getPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "latestSoundID")).intValue()).intValue();
                        ModLoader.setPrivateValue(net.minecraft.src.SoundManager.class, mc.sndManager, "ticksBeforeMusic", Integer.valueOf(0x3b9ac9ff));
                    }
                    catch(Exception exception1)
                    {
                        exception1.printStackTrace();
                    }
                } else
                {
                    exception.printStackTrace();
                }
            }
        }
        if(loadingWorld)
        {
            loadingWorld = false;
        }
        ModLoader.getMinecraftInstance().gameSettings.hideGUI = true;
        ModLoader.getMinecraftInstance().gameSettings.thirdPersonView = 1;
        StringTranslate stringtranslate = StringTranslate.getInstance();
        if(renderOption)
        {
            mc.playerController = new PlayerControllerSP(mc);
            if(mc.theWorld == null)
            {
                loadSaves();
                String s = getSaveFileName(0);
                String s1 = getSaveName(0);
                if(s1 == null || s == null)
                {
                    renderOption = false;
                } else
                {
                    mc.startWorld(s, s1, new WorldSettings(0L, 0, true, false));
                    mc.theWorld.autosavePeriod = 0x3b9ac9ff;
                }
            }
        } else
        if(themeOption)
        {
            drawAetherDefaultBackground();
        } else
        {
            drawDefaultBackground();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if(calendar.get(2) + 1 == 11 && calendar.get(5) == 9)
        {
            splashText = "Happy birthday, ez!";
        } else
        if(calendar.get(2) + 1 == 6 && calendar.get(5) == 1)
        {
            splashText = "Happy birthday, Notch!";
        } else
        if(calendar.get(2) + 1 == 12 && calendar.get(5) == 24)
        {
            splashText = "Merry X-mas!";
        } else
        if(calendar.get(2) + 1 == 1 && calendar.get(5) == 1)
        {
            splashText = "Happy new year!";
        } else
        if(calendar.get(2) + 1 == 8 && calendar.get(5) == 3)
        {
            splashText = "We miss you, Ripsand :(";
        }
        if(renderOption)
        {
            int i = height / 4 + 20;
            controlList.clear();
            controlList.add(new GuiAetherButton(1, width / 4 - 100, i, stringtranslate.translateKey("menu.singleplayer")));
            controlList.add(multiplayerButton = new GuiAetherButton(2, width / 4 - 100, i + 24, stringtranslate.translateKey("menu.multiplayer")));
            controlList.add(new GuiAetherButton(3, width / 4 - 100, i + 48, stringtranslate.translateKey("menu.mods")));
            controlList.add(new GuiButton(5, width - 24, 4, 20, 20, stringtranslate.translateKey("W")));
            controlList.add(new GuiButton(6, width - 48, 4, 20, 20, stringtranslate.translateKey("T")));
            controlList.add(new GuiAetherButton(0, width / 4 - 100, i + 72, stringtranslate.translateKey("menu.options")));
            controlList.add(new GuiAetherButton(4, width / 4 - 100, i + 96, stringtranslate.translateKey("menu.quit")));
            if(mc.session == null)
            {
                multiplayerButton.enabled = false;
            }
        } else
        if(!renderOption)
        {
            int j = height / 4 + 40;
            int k = width / 2 + 100;
            controlList.clear();
            controlList.add(new GuiAetherButton(1, width / 2 - 110, j, stringtranslate.translateKey("menu.singleplayer")));
            controlList.add(multiplayerButton = new GuiAetherButton(2, width / 2 - 110, j + 24, stringtranslate.translateKey("menu.multiplayer")));
            controlList.add(new GuiAetherButton(3, width / 2 - 110, j + 48, stringtranslate.translateKey("menu.mods")));
            controlList.add(new GuiButton(5, width - 24, 4, 20, 20, stringtranslate.translateKey("W")));
            controlList.add(new GuiButton(6, width - 48, 4, 20, 20, stringtranslate.translateKey("T")));
            controlList.add(new GuiAetherButton(0, width / 2 - 110, j + 72, 98, 20, stringtranslate.translateKey("menu.options")));
            controlList.add(new GuiAetherButton(4, (width / 2 + 2) - 10, j + 72, 98, 20, stringtranslate.translateKey("menu.quit")));
            if(mc.session == null)
            {
                multiplayerButton.enabled = false;
            }
        }
    }

    protected String getSaveName(int i)
    {
        if(saveList.size() < i + 1)
        {
            return null;
        }
        String s = ((SaveFormatComparator)saveList.get(i)).getDisplayName();
        if(s == null || MathHelper.stringNullOrLengthZero(s))
        {
            StringTranslate stringtranslate = StringTranslate.getInstance();
            s = (new StringBuilder()).append(stringtranslate.translateKey("selectWorld.world")).append(" ").append(i + 1).toString();
        }
        return s;
    }

    private void loadSaves()
    {
        ISaveFormat isaveformat = mc.getSaveLoader();
        saveList = isaveformat.getSaveList();
        Collections.sort(saveList);
        selectedWorld = -1;
    }

    protected String getSaveFileName(int i)
    {
        if(saveList.size() < i + 1)
        {
            return null;
        } else
        {
            return ((SaveFormatComparator)saveList.get(i)).getFileName();
        }
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 0)
        {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if(guibutton.id == 1)
        {
            mc.displayGuiScreen(new GuiSelectWorldAether(this, musicId));
        }
        if(guibutton.id == 2)
        {
            mc.displayGuiScreen(new GuiMultiplayerAether(this, musicId));
        }
        if(guibutton.id == 3)
        {
            mc.displayGuiScreen(new GuiTexturePacks(this));
        }
        if(guibutton.id == 4)
        {
            mc.shutdown();
        }
        if(guibutton.id == 6)
        {
            themeOption = !themeOption;
        }
        if(guibutton.id == 7)
        {
            mc.displayGuiScreen(null);
            mmactive = false;
            musicId = -1;
        }
        if(guibutton.id == 5)
        {
            changeWorldRender();
        }
    }

    public void changeWorldRender()
    {
        StringTranslate stringtranslate = StringTranslate.getInstance();
        if(!renderOption)
        {
            renderOption = true;
            loadSaves();
            String s = getSaveFileName(0);
            String s1 = getSaveName(0);
            if(s1 == null)
            {
                renderOption = false;
                return;
            }
            mc.startWorld(s, s1, new WorldSettings(0L, 0, true, false));
            int j = height / 4 + 20;
            controlList.clear();
            controlList.add(new GuiAetherButton(1, width / 4 - 100, j, stringtranslate.translateKey("menu.singleplayer")));
            controlList.add(multiplayerButton = new GuiAetherButton(2, width / 4 - 100, j + 24, stringtranslate.translateKey("menu.multiplayer")));
            controlList.add(new GuiAetherButton(3, width / 4 - 100, j + 48, stringtranslate.translateKey("menu.mods")));
            controlList.add(new GuiButton(5, width - 24, 4, 20, 20, stringtranslate.translateKey("W")));
            controlList.add(new GuiButton(6, width - 48, 4, 20, 20, stringtranslate.translateKey("T")));
            controlList.add(new GuiAetherButton(0, width / 4 - 100, j + 72, stringtranslate.translateKey("menu.options")));
            controlList.add(new GuiAetherButton(4, width / 4 - 100, j + 96, stringtranslate.translateKey("menu.quit")));
            if(mc.session == null)
            {
                multiplayerButton.enabled = false;
            }
        } else
        {
            renderOption = false;
            mc.theWorld = null;
            mc.thePlayer = null;
            int i = height / 4 + 40;
            controlList.clear();
            controlList.add(new GuiAetherButton(1, width / 2 - 110, i, stringtranslate.translateKey("menu.singleplayer")));
            controlList.add(multiplayerButton = new GuiAetherButton(2, width / 2 - 110, i + 24, stringtranslate.translateKey("menu.multiplayer")));
            controlList.add(new GuiAetherButton(3, width / 2 - 110, i + 48, stringtranslate.translateKey("menu.mods")));
            controlList.add(new GuiButton(5, width - 24, 4, 20, 20, stringtranslate.translateKey("W")));
            controlList.add(new GuiButton(6, width - 48, 4, 20, 20, stringtranslate.translateKey("T")));
            controlList.add(new GuiAetherButton(0, width / 2 - 110, i + 72, 98, 20, stringtranslate.translateKey("menu.options")));
            controlList.add(new GuiAetherButton(4, (width / 2 + 2) - 10, i + 72, 98, 20, stringtranslate.translateKey("menu.quit")));
            if(mc.session == null)
            {
                multiplayerButton.enabled = false;
            }
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        if(themeOption)
        {
            if(renderOption)
            {
                Tessellator tessellator = Tessellator.instance;
                boolean flag = true;
                byte byte0 = 15;
                byte byte1 = 15;
                GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/aether/title/mclogomod1.png"));
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                drawTexturedModalRect(byte0 + 0, byte1 + 0, 0, 0, 155, 44);
                drawTexturedModalRect(byte0 + 155, byte1 + 0, 0, 45, 155, 44);
                tessellator.setColorOpaque_I(0xffffff);
                String s2 = "Minecraft 1.0";
                drawString(fontRenderer, s2, width - fontRenderer.getStringWidth(s2) - 5, height - 20, 0xffffff);
                String s3 = "Copyright Mojang AB. Do not distribute.";
                drawString(fontRenderer, s3, width - fontRenderer.getStringWidth(s3) - 5, height - 10, 0x505050);
            } else
            {
                drawAetherDefaultBackground();
                Tessellator tessellator1 = Tessellator.instance;
                char c = '\u0112';
                int k = width / 2 - c / 2;
                byte byte2 = 30;
                GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/aether/title/mclogomod1.png"));
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                drawTexturedModalRect(k + 30, byte2 + 0, 0, 0, 155, 44);
                drawTexturedModalRect(k + 185, byte2 + 0, 0, 45, 155, 44);
                tessellator1.setColorOpaque_I(0xffffff);
                GL11.glPushMatrix();
                GL11.glTranslatef(width / 2 + 90, 70F, 0.0F);
                GL11.glRotatef(-20F, 0.0F, 0.0F, 1.0F);
                float f1 = 1.8F - MathHelper.abs(MathHelper.sin(((float)(System.currentTimeMillis() % 1000L) / 1000F) * 3.141593F * 2.0F) * 0.1F);
                f1 = (f1 * 100F) / (float)(fontRenderer.getStringWidth(splashText) + 32);
                GL11.glScalef(f1, f1, f1);
                drawCenteredString(fontRenderer, splashText, 0, -8, 0xffff00);
                GL11.glPopMatrix();
                drawString(fontRenderer, "Minecraft 1.0", 2, 2, 0x505050);
                String s4 = "Copyright Mojang AB. Do not distribute.";
                drawString(fontRenderer, s4, width - fontRenderer.getStringWidth(s4) - 2, height - 10, 0xffffff);
            }
        } else
        if(renderOption)
        {
            Tessellator tessellator2 = Tessellator.instance;
            boolean flag1 = true;
            String s = "Minecraft 1.0";
            drawString(fontRenderer, s, width - fontRenderer.getStringWidth(s) - 5, height - 20, 0xffffff);
            String s1 = "Copyright Mojang AB. Do not distribute.";
            drawString(fontRenderer, s1, width - fontRenderer.getStringWidth(s1) - 5, height - 10, 0x505050);
            drawMiniLogo();
        } else
        {
            drawDefaultBackground();
            Tessellator tessellator3 = Tessellator.instance;
            char c1 = '\u0112';
            int l = width / 2 - c1 / 2;
            byte byte3 = 30;
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/title/mclogo.png"));
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            drawTexturedModalRect(l + 0, byte3 + 0, 0, 0, 155, 44);
            drawTexturedModalRect(l + 155, byte3 + 0, 0, 45, 155, 44);
            tessellator3.setColorOpaque_I(0xffffff);
            GL11.glPushMatrix();
            GL11.glTranslatef(width / 2 + 90, 70F, 0.0F);
            GL11.glRotatef(-20F, 0.0F, 0.0F, 1.0F);
            float f2 = 1.8F - MathHelper.abs(MathHelper.sin(((float)(System.currentTimeMillis() % 1000L) / 1000F) * 3.141593F * 2.0F) * 0.1F);
            f2 = (f2 * 100F) / (float)(fontRenderer.getStringWidth(splashText) + 32);
            GL11.glScalef(f2, f2, f2);
            drawCenteredString(fontRenderer, splashText, 0, -8, 0xffff00);
            GL11.glPopMatrix();
            drawString(fontRenderer, "Minecraft 1.0", 2, 2, 0x505050);
            String s5 = "Copyright Mojang AB. Do not distribute.";
            drawString(fontRenderer, s5, width - fontRenderer.getStringWidth(s5) - 2, height - 10, 0xffffff);
        }
        drawString(fontRenderer, hoverText, width - 72, 28, 0xffffff);
        super.drawScreen(i, j, f);
    }

    protected void mouseMovedOrUp(int i, int j, int k)
    {
        hoverText = "";
        for(int l = 0; l < controlList.size(); l++)
        {
            GuiButton guibutton = (GuiButton)controlList.get(l);
            if(i >= guibutton.xPosition && j >= guibutton.yPosition && i < guibutton.xPosition + guibutton.width && j < guibutton.yPosition + guibutton.height)
            {
                switch(guibutton.id)
                {
                default:
                    break;

                case 5: // '\005'
                    hoverText = "Toggle World";
                    break;

                case 6: // '\006'
                    if(themeOption)
                    {
                        hoverText = "Normal Theme";
                    } else
                    {
                        hoverText = "Aether Theme";
                    }
                    break;

                case 7: // '\007'
                    hoverText = "Quick Load";
                    break;
                }
            }
        }

    }

    public void drawMiniLogo()
    {
        Tessellator tessellator = Tessellator.instance;
        byte byte0 = 15;
        byte byte1 = 15;
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/title/mclogo.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPushMatrix();
        GL11.glScalef(0.8F, 0.8F, 0.8F);
        drawTexturedModalRect(byte0 + 0, byte1 + 0, 0, 0, 155, 44);
        drawTexturedModalRect(byte0 + 155, byte1 + 0, 0, 45, 155, 44);
        GL11.glPopMatrix();
        tessellator.setColorOpaque_I(0xffffff);
    }

    public void drawAetherDefaultBackground()
    {
        drawAetherWorldBackground(0);
    }

    public void drawAetherWorldBackground(int i)
    {
        drawAetherBackground(i);
    }

    public void drawAetherBackground(int i)
    {
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glDisable(2912 /*GL_FOG*/);
        Tessellator tessellator = Tessellator.instance;
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, mc.renderEngine.getTexture("/aether/gui/aetherBG.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f = 32F;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x999999);
        tessellator.addVertexWithUV(0.0D, height, 0.0D, 0.0D, (float)height / f + (float)i);
        tessellator.addVertexWithUV(width, height, 0.0D, (float)width / f, (float)height / f + (float)i);
        tessellator.addVertexWithUV(width, 0.0D, 0.0D, (float)width / f, 0 + i);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0 + i);
        tessellator.draw();
    }

    public boolean doesGuiPauseGame()
    {
        return closeTicks >= 30;
    }

    public void onGuiClosed()
    {
        mc.gameSettings.hideGUI = false;
        mc.gameSettings.thirdPersonView = 0;
    }

    static 
    {
        renderOption = mod_Aether.worldMenu;
        themeOption = mod_Aether.aetherMenu;
    }
}
