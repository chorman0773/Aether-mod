// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, AchievementList, Achievement, GuiSmallButton, 
//            StatCollector, GuiButton, GameSettings, KeyBinding, 
//            FontRenderer, MathHelper, RenderEngine, Block, 
//            StatFileWriter, RenderItem, RenderHelper

public class GuiAchievements extends GuiScreen
{

    private static final int guiMapTop;
    private static final int guiMapLeft;
    private static final int guiMapBottom;
    private static final int guiMapRight;
    protected int achievementsPaneWidth;
    protected int achievementsPaneHeight;
    protected int mouseX;
    protected int mouseY;
    protected double field_27116_m;
    protected double field_27115_n;
    protected double guiMapX;
    protected double guiMapY;
    protected double field_27112_q;
    protected double field_27111_r;
    private int isMouseButtonDown;
    private StatFileWriter statFileWriter;

    public GuiAchievements(StatFileWriter statfilewriter)
    {
        achievementsPaneWidth = 256;
        achievementsPaneHeight = 202;
        mouseX = 0;
        mouseY = 0;
        isMouseButtonDown = 0;
        statFileWriter = statfilewriter;
        char c = '\215';
        char c1 = '\215';
        field_27116_m = guiMapX = field_27112_q = AchievementList.openInventory.displayColumn * 24 - c / 2 - 12;
        field_27115_n = guiMapY = field_27111_r = AchievementList.openInventory.displayRow * 24 - c1 / 2;
    }

    public void initGui()
    {
        controlList.clear();
        controlList.add(new GuiSmallButton(1, width / 2 + 24, height / 2 + 74, 80, 20, StatCollector.translateToLocal("gui.done")));
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 1)
        {
            mc.displayGuiScreen(null);
            mc.setIngameFocus();
        }
        super.actionPerformed(guibutton);
    }

    protected void keyTyped(char c, int i)
    {
        if(i == mc.gameSettings.keyBindInventory.keyCode)
        {
            mc.displayGuiScreen(null);
            mc.setIngameFocus();
        } else
        {
            super.keyTyped(c, i);
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        if(Mouse.isButtonDown(0))
        {
            int k = (width - achievementsPaneWidth) / 2;
            int l = (height - achievementsPaneHeight) / 2;
            int i1 = k + 8;
            int j1 = l + 17;
            if((isMouseButtonDown == 0 || isMouseButtonDown == 1) && i >= i1 && i < i1 + 224 && j >= j1 && j < j1 + 155)
            {
                if(isMouseButtonDown == 0)
                {
                    isMouseButtonDown = 1;
                } else
                {
                    guiMapX -= i - mouseX;
                    guiMapY -= j - mouseY;
                    field_27112_q = field_27116_m = guiMapX;
                    field_27111_r = field_27115_n = guiMapY;
                }
                mouseX = i;
                mouseY = j;
            }
            if(field_27112_q < (double)guiMapTop)
            {
                field_27112_q = guiMapTop;
            }
            if(field_27111_r < (double)guiMapLeft)
            {
                field_27111_r = guiMapLeft;
            }
            if(field_27112_q >= (double)guiMapBottom)
            {
                field_27112_q = guiMapBottom - 1;
            }
            if(field_27111_r >= (double)guiMapRight)
            {
                field_27111_r = guiMapRight - 1;
            }
        } else
        {
            isMouseButtonDown = 0;
        }
        drawDefaultBackground();
        genAchievementBackground(i, j, f);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        func_27110_k();
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
    }

    public void updateScreen()
    {
        field_27116_m = guiMapX;
        field_27115_n = guiMapY;
        double d = field_27112_q - guiMapX;
        double d1 = field_27111_r - guiMapY;
        if(d * d + d1 * d1 < 4D)
        {
            guiMapX += d;
            guiMapY += d1;
        } else
        {
            guiMapX += d * 0.84999999999999998D;
            guiMapY += d1 * 0.84999999999999998D;
        }
    }

    protected void func_27110_k()
    {
        int i = (width - achievementsPaneWidth) / 2;
        int j = (height - achievementsPaneHeight) / 2;
        fontRenderer.drawString("Achievements", i + 15, j + 5, 0x404040);
    }

    protected void genAchievementBackground(int i, int j, float f)
    {
        int k = MathHelper.floor_double(field_27116_m + (guiMapX - field_27116_m) * (double)f);
        int l = MathHelper.floor_double(field_27115_n + (guiMapY - field_27115_n) * (double)f);
        if(k < guiMapTop)
        {
            k = guiMapTop;
        }
        if(l < guiMapLeft)
        {
            l = guiMapLeft;
        }
        if(k >= guiMapBottom)
        {
            k = guiMapBottom - 1;
        }
        if(l >= guiMapRight)
        {
            l = guiMapRight - 1;
        }
        int i1 = mc.renderEngine.getTexture("/terrain.png");
        int j1 = mc.renderEngine.getTexture("/achievement/bg.png");
        int k1 = (width - achievementsPaneWidth) / 2;
        int l1 = (height - achievementsPaneHeight) / 2;
        int i2 = k1 + 16;
        int j2 = l1 + 17;
        zLevel = 0.0F;
        GL11.glDepthFunc(518);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        mc.renderEngine.bindTexture(i1);
        int k2 = k + 288 >> 4;
        int l2 = l + 288 >> 4;
        int i3 = (k + 288) % 16;
        int j3 = (l + 288) % 16;
        Random random = new Random();
        for(int k3 = 0; k3 * 16 - j3 < 155; k3++)
        {
            float f1 = 0.6F - ((float)(l2 + k3) / 25F) * 0.3F;
            GL11.glColor4f(f1, f1, f1, 1.0F);
            for(int i4 = 0; i4 * 16 - i3 < 224; i4++)
            {
                random.setSeed(1234 + k2 + i4);
                random.nextInt();
                int l4 = random.nextInt(1 + l2 + k3) + (l2 + k3) / 2;
                int j5 = Block.sand.blockIndexInTexture;
                if(l4 > 37 || l2 + k3 == 35)
                {
                    j5 = Block.bedrock.blockIndexInTexture;
                } else
                if(l4 == 22)
                {
                    if(random.nextInt(2) == 0)
                    {
                        j5 = Block.oreDiamond.blockIndexInTexture;
                    } else
                    {
                        j5 = Block.oreRedstone.blockIndexInTexture;
                    }
                } else
                if(l4 == 10)
                {
                    j5 = Block.oreIron.blockIndexInTexture;
                } else
                if(l4 == 8)
                {
                    j5 = Block.oreCoal.blockIndexInTexture;
                } else
                if(l4 > 4)
                {
                    j5 = Block.stone.blockIndexInTexture;
                } else
                if(l4 > 0)
                {
                    j5 = Block.dirt.blockIndexInTexture;
                }
                drawTexturedModalRect((i2 + i4 * 16) - i3, (j2 + k3 * 16) - j3, j5 % 16 << 4, (j5 >> 4) << 4, 16, 16);
            }

        }

        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDepthFunc(515);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        for(int l3 = 0; l3 < AchievementList.achievementList.size(); l3++)
        {
            Achievement achievement1 = (Achievement)AchievementList.achievementList.get(l3);
            if(achievement1.parentAchievement == null)
            {
                continue;
            }
            int j4 = (achievement1.displayColumn * 24 - k) + 11 + i2;
            int i5 = (achievement1.displayRow * 24 - l) + 11 + j2;
            int k5 = (achievement1.parentAchievement.displayColumn * 24 - k) + 11 + i2;
            int i6 = (achievement1.parentAchievement.displayRow * 24 - l) + 11 + j2;
            int l6 = 0;
            boolean flag = statFileWriter.hasAchievementUnlocked(achievement1);
            boolean flag1 = statFileWriter.canUnlockAchievement(achievement1);
            char c = Math.sin(((double)(System.currentTimeMillis() % 600L) / 600D) * 3.1415926535897931D * 2D) > 0.59999999999999998D ? '\377' : '\202';
            if(flag)
            {
                l6 = 0xff707070;
            } else
            if(flag1)
            {
                l6 = 65280 + (c << 24);
            } else
            {
                l6 = 0xff000000;
            }
            func_27100_a(j4, k5, i5, l6);
            func_27099_b(k5, i5, i6, l6);
        }

        Achievement achievement = null;
        RenderItem renderitem = new RenderItem();
        RenderHelper.func_41089_c();
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        for(int k4 = 0; k4 < AchievementList.achievementList.size(); k4++)
        {
            Achievement achievement3 = (Achievement)AchievementList.achievementList.get(k4);
            int l5 = achievement3.displayColumn * 24 - k;
            int j6 = achievement3.displayRow * 24 - l;
            if(l5 < -24 || j6 < -24 || l5 > 224 || j6 > 155)
            {
                continue;
            }
            if(statFileWriter.hasAchievementUnlocked(achievement3))
            {
                float f2 = 1.0F;
                GL11.glColor4f(f2, f2, f2, 1.0F);
            } else
            if(statFileWriter.canUnlockAchievement(achievement3))
            {
                float f3 = Math.sin(((double)(System.currentTimeMillis() % 600L) / 600D) * 3.1415926535897931D * 2D) < 0.59999999999999998D ? 0.6F : 0.8F;
                GL11.glColor4f(f3, f3, f3, 1.0F);
            } else
            {
                float f4 = 0.3F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
            }
            mc.renderEngine.bindTexture(j1);
            int i7 = i2 + l5;
            int k7 = j2 + j6;
            if(achievement3.getSpecial())
            {
                drawTexturedModalRect(i7 - 2, k7 - 2, 26, 202, 26, 26);
            } else
            {
                drawTexturedModalRect(i7 - 2, k7 - 2, 0, 202, 26, 26);
            }
            if(!statFileWriter.canUnlockAchievement(achievement3))
            {
                float f5 = 0.1F;
                GL11.glColor4f(f5, f5, f5, 1.0F);
                renderitem.field_27004_a = false;
            }
            GL11.glEnable(2896 /*GL_LIGHTING*/);
            GL11.glEnable(2884 /*GL_CULL_FACE*/);
            renderitem.renderItemIntoGUI(mc.fontRenderer, mc.renderEngine, achievement3.theItemStack, i7 + 3, k7 + 3);
            GL11.glDisable(2896 /*GL_LIGHTING*/);
            if(!statFileWriter.canUnlockAchievement(achievement3))
            {
                renderitem.field_27004_a = true;
            }
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(i >= i2 && j >= j2 && i < i2 + 224 && j < j2 + 155 && i >= i7 && i <= i7 + 22 && j >= k7 && j <= k7 + 22)
            {
                achievement = achievement3;
            }
        }

        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(j1);
        drawTexturedModalRect(k1, l1, 0, 0, achievementsPaneWidth, achievementsPaneHeight);
        GL11.glPopMatrix();
        zLevel = 0.0F;
        GL11.glDepthFunc(515);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        super.drawScreen(i, j, f);
        if(achievement != null)
        {
            Achievement achievement2 = achievement;
            String s = achievement2.statName;
            String s1 = achievement2.getDescription();
            int k6 = i + 12;
            int j7 = j - 4;
            if(statFileWriter.canUnlockAchievement(achievement2))
            {
                int l7 = Math.max(fontRenderer.getStringWidth(s), 120);
                int j8 = fontRenderer.splitStringWidth(s1, l7);
                if(statFileWriter.hasAchievementUnlocked(achievement2))
                {
                    j8 += 12;
                }
                drawGradientRect(k6 - 3, j7 - 3, k6 + l7 + 3, j7 + j8 + 3 + 12, 0xc0000000, 0xc0000000);
                fontRenderer.drawSplitString(s1, k6, j7 + 12, l7, 0xffa0a0a0);
                if(statFileWriter.hasAchievementUnlocked(achievement2))
                {
                    fontRenderer.drawStringWithShadow(StatCollector.translateToLocal("achievement.taken"), k6, j7 + j8 + 4, 0xff9090ff);
                }
            } else
            {
                int i8 = Math.max(fontRenderer.getStringWidth(s), 120);
                String s2 = StatCollector.translateToLocalFormatted("achievement.requires", new Object[] {
                    achievement2.parentAchievement.statName
                });
                int k8 = fontRenderer.splitStringWidth(s2, i8);
                drawGradientRect(k6 - 3, j7 - 3, k6 + i8 + 3, j7 + k8 + 12 + 3, 0xc0000000, 0xc0000000);
                fontRenderer.drawSplitString(s2, k6, j7 + 12, i8, 0xff705050);
            }
            fontRenderer.drawStringWithShadow(s, k6, j7, statFileWriter.canUnlockAchievement(achievement2) ? achievement2.getSpecial() ? -128 : -1 : achievement2.getSpecial() ? 0xff808040 : 0xff808080);
        }
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        RenderHelper.disableStandardItemLighting();
    }

    public boolean doesGuiPauseGame()
    {
        return true;
    }

    static 
    {
        guiMapTop = AchievementList.minDisplayColumn * 24 - 112;
        guiMapLeft = AchievementList.minDisplayRow * 24 - 112;
        guiMapBottom = AchievementList.maxDisplayColumn * 24 - 77;
        guiMapRight = AchievementList.maxDisplayRow * 24 - 77;
    }
}
