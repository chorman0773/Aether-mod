// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiAchievements, SAPI, GuiButton, ModLoader, 
//            RenderHelper, AchievementPage, FontRenderer, RenderItem, 
//            MathHelper, RenderEngine, StatFileWriter, AchievementList, 
//            Achievement, StatCollector, Tessellator, ItemStack

public class GuiAchievementsPages extends GuiAchievements
{

    private boolean draw;
    protected static RenderItem itemRenderer = new RenderItem();

    public GuiAchievementsPages(StatFileWriter statfilewriter)
    {
        super(statfilewriter);
        draw = true;
    }

    public void GuiScreen_a(int i, int j, float f)
    {
        for(int k = 0; k < controlList.size(); k++)
        {
            GuiButton guibutton = (GuiButton)controlList.get(k);
            guibutton.drawButton(mc, i, j);
        }

    }

    public void drawScreen(int i, int j, float f)
    {
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        try
        {
            k = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "s")).intValue();
            l = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "t")).intValue();
            i1 = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "u")).intValue();
            j1 = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "v")).intValue();
            k1 = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, this, "w")).intValue();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(Mouse.isButtonDown(0))
        {
            int l1 = (width - achievementsPaneWidth) / 2;
            int i2 = (height - achievementsPaneHeight) / 2;
            int j2 = l1 + 8;
            int l2 = i2 + 17;
            if((k1 == 0 || k1 == 1) && i >= j2 && i < j2 + 224 && j >= l2 && j < l2 + 155)
            {
                if(k1 == 0)
                {
                    try
                    {
                        ModLoader.setPrivateValue(net.minecraft.src.GuiAchievements.class, this, "w", Integer.valueOf(1));
                    }
                    catch(Exception exception2)
                    {
                        exception2.printStackTrace();
                    }
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
            if(field_27112_q < (double)k)
            {
                field_27112_q = k;
            }
            if(field_27111_r < (double)l)
            {
                field_27111_r = l;
            }
            if(field_27112_q >= (double)i1)
            {
                field_27112_q = i1 - 1;
            }
            if(field_27111_r >= (double)j1)
            {
                field_27111_r = j1 - 1;
            }
        } else
        {
            try
            {
                ModLoader.setPrivateValue(net.minecraft.src.GuiAchievements.class, this, "w", Integer.valueOf(0));
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
        }
        drawDefaultBackground();
        genAchievementBackground(i, j, f);
        ArrayList arraylist = SAPI.Achievements.getPages();
        AchievementPage achievementpage = SAPI.Achievements.current();
        int k2 = (width - achievementsPaneWidth) / 2;
        int i3 = (height - achievementsPaneHeight) / 2;
        int j3 = k2 - 18;
        int k3 = i3 + 2;
        int l3 = 0;
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDepthFunc(515);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glPushMatrix();
        GL11.glRotatef(120F, 1.0F, 0.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glPopMatrix();
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        Iterator iterator = arraylist.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            AchievementPage achievementpage1 = (AchievementPage)iterator.next();
            if(achievementpage1.equals(achievementpage) || getIsMouseOverSlot(j3, k3, i, j))
            {
                drawGradientRect(j3 - 2, k3 - 2, j3 + 18, k3 + 18, 0x66ffffff, 0x66ffffff);
            } else
            {
                drawGradientRect(j3 - 2, k3 - 2, j3 + 18, k3 + 18, 0x66000000, 0x66000000);
            }
            if(getIsMouseOverSlot(j3, k3, i, j) && Mouse.isButtonDown(0))
            {
                SAPI.Achievements.setPage(achievementpage1);
            }
            drawItemStack(achievementpage1.stackIcon, j3, k3);
            k3 += 20;
            if(++l3 >= achievementsPaneHeight / 20)
            {
                j3 -= achievementsPaneWidth / 20;
                k3 -= 20 * (achievementsPaneHeight / 20);
                l3 -= achievementsPaneHeight / 20;
            }
        } while(true);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        RenderHelper.disableStandardItemLighting();
        j3 = k2 - 18;
        k3 = i3 + 2;
        l3 = 0;
        iterator = arraylist.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            AchievementPage achievementpage2 = (AchievementPage)iterator.next();
            if(getIsMouseOverSlot(j3, k3, i, j))
            {
                drawGradientRect(j3 - 2, k3 - 2, j3 + 18, k3 + 18, 0x66ffffff, 0x66ffffff);
                String s = achievementpage2.title;
                int i4 = fontRenderer.getStringWidth(s);
                drawGradientRect(k2 - i4 / 2 - 3, i3 - 8 - 6, k2 + i4 / 2 + 3, i3, 0xc0000000, 0xc0000000);
                fontRenderer.drawStringWithShadow(s, k2 - i4 / 2, i3 - 8 - 3, -1);
            }
            k3 += 20;
            if(++l3 >= 5)
            {
                j3 -= 20;
                k3 -= 100;
                l3 -= 5;
            }
        } while(true);
        func_27110_k();
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
    }

    protected void drawItemStack(ItemStack itemstack, int i, int j)
    {
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(2884 /*GL_CULL_FACE*/);
        itemRenderer.renderItemIntoGUI(fontRenderer, mc.renderEngine, itemstack, i, j);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
    }

    private boolean getIsMouseOverSlot(int i, int j, int k, int l)
    {
        return k >= i - 2 && k < i + 2 + 16 && l >= j - 2 && l < j + 2 + 16;
    }

    protected void genAchievementBackground(int i, int j, float f)
    {
        int k = MathHelper.floor_double(field_27116_m + (guiMapX - field_27116_m) * (double)f);
        int l = MathHelper.floor_double(field_27115_n + (guiMapY - field_27115_n) * (double)f);
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        int l1 = 0;
        try
        {
            i1 = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "s")).intValue();
            j1 = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "t")).intValue();
            k1 = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "u")).intValue();
            l1 = ((Integer)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, null, "v")).intValue();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(k < i1)
        {
            k = i1;
        }
        if(l < j1)
        {
            l = j1;
        }
        if(k >= k1)
        {
            k = k1 - 1;
        }
        if(l >= l1)
        {
            l = l1 - 1;
        }
        int i2 = mc.renderEngine.getTexture("/terrain.png");
        int j2 = mc.renderEngine.getTexture("/achievement/bg.png");
        int k2 = (width - achievementsPaneWidth) / 2;
        int l2 = (height - achievementsPaneHeight) / 2;
        int i3 = k2 + 16;
        int j3 = l2 + 17;
        zLevel = 0.0F;
        GL11.glDepthFunc(518);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200F);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        mc.renderEngine.bindTexture(i2);
        int k3 = k + 288 >> 4;
        int l3 = l + 288 >> 4;
        int i4 = (k + 288) % 16;
        int j4 = (l + 288) % 16;
        Random random = new Random();
        for(int k4 = 0; k4 * 16 - j4 < 155; k4++)
        {
            float f1 = 0.6F - ((float)(l3 + k4) / 25F) * 0.3F;
            GL11.glColor4f(f1, f1, f1, 1.0F);
            for(int i5 = 0; i5 * 16 - i4 < 224; i5++)
            {
                random.setSeed(1234 + k3 + i5);
                random.nextInt();
                int j5 = SAPI.Achievements.current().bgGetSprite(random, k3 + i5, l3 + k4);
                if(j5 >= 0)
                {
                    drawTexturedModalRect((i3 + i5 * 16) - i4, (j3 + k4 * 16) - j4, j5 % 16 << 4, (j5 >> 4) << 4, 16, 16);
                }
            }

        }

        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDepthFunc(515);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        StatFileWriter statfilewriter = null;
        try
        {
            statfilewriter = (StatFileWriter)ModLoader.getPrivateValue(net.minecraft.src.GuiAchievements.class, this, "x");
        }
        catch(Exception exception1)
        {
            exception1.printStackTrace();
        }
        for(int l4 = 0; l4 < AchievementList.achievementList.size(); l4++)
        {
            Achievement achievement1 = (Achievement)AchievementList.achievementList.get(l4);
            if(achievement1.parentAchievement == null)
            {
                continue;
            }
            int k5 = (achievement1.displayColumn * 24 - k) + 11 + i3;
            int i6 = (achievement1.displayRow * 24 - l) + 11 + j3;
            int j6 = (achievement1.parentAchievement.displayColumn * 24 - k) + 11 + i3;
            int l6 = (achievement1.parentAchievement.displayRow * 24 - l) + 11 + j3;
            int k7 = 0;
            boolean flag = statfilewriter.hasAchievementUnlocked(achievement1);
            boolean flag1 = statfilewriter.canUnlockAchievement(achievement1);
            char c = Math.sin(((double)(System.currentTimeMillis() % 600L) / 600D) * 3.1415926535897931D * 2D) <= 0.59999999999999998D ? '\202' : '\377';
            if(flag)
            {
                k7 = 0xff707070;
            } else
            if(flag1)
            {
                k7 = 65280 + (c << 24);
            } else
            {
                k7 = 0xff000000;
            }
            draw = isVisibleLine(achievement1);
            func_27100_a(k5, j6, i6, k7);
            func_27099_b(j6, i6, l6, k7);
        }

        Achievement achievement = null;
        RenderItem renderitem = new RenderItem();
        RenderHelper.func_41089_c();
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glEnable(32826 /*GL_RESCALE_NORMAL_EXT*/);
        GL11.glEnable(2903 /*GL_COLOR_MATERIAL*/);
        for(int l5 = 0; l5 < AchievementList.achievementList.size(); l5++)
        {
            Achievement achievement3 = (Achievement)AchievementList.achievementList.get(l5);
            if(!isVisibleAchievement(achievement3, 1))
            {
                continue;
            }
            int k6 = achievement3.displayColumn * 24 - k;
            int i7 = achievement3.displayRow * 24 - l;
            if(k6 < -24 || i7 < -24 || k6 > 224 || i7 > 155)
            {
                continue;
            }
            if(statfilewriter.hasAchievementUnlocked(achievement3))
            {
                float f2 = 1.0F;
                GL11.glColor4f(f2, f2, f2, 1.0F);
            } else
            if(statfilewriter.canUnlockAchievement(achievement3))
            {
                float f3 = Math.sin(((double)(System.currentTimeMillis() % 600L) / 600D) * 3.1415926535897931D * 2D) >= 0.59999999999999998D ? 0.8F : 0.6F;
                GL11.glColor4f(f3, f3, f3, 1.0F);
            } else
            {
                float f4 = 0.3F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
            }
            mc.renderEngine.bindTexture(j2);
            int l7 = i3 + k6;
            int j8 = j3 + i7;
            if(achievement3.getSpecial())
            {
                drawTexturedModalRect(l7 - 2, j8 - 2, 26, 202, 26, 26);
            } else
            {
                drawTexturedModalRect(l7 - 2, j8 - 2, 0, 202, 26, 26);
            }
            if(!statfilewriter.canUnlockAchievement(achievement3))
            {
                float f5 = 0.1F;
                GL11.glColor4f(f5, f5, f5, 1.0F);
                renderitem.field_27004_a = false;
            }
            GL11.glEnable(2896 /*GL_LIGHTING*/);
            GL11.glEnable(2884 /*GL_CULL_FACE*/);
            renderitem.renderItemIntoGUI(mc.fontRenderer, mc.renderEngine, achievement3.theItemStack, l7 + 3, j8 + 3);
            GL11.glDisable(2896 /*GL_LIGHTING*/);
            if(!statfilewriter.canUnlockAchievement(achievement3))
            {
                renderitem.field_27004_a = true;
            }
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(i >= i3 && j >= j3 && i < i3 + 224 && j < j3 + 155 && i >= l7 && i <= l7 + 22 && j >= j8 && j <= j8 + 22)
            {
                achievement = achievement3;
            }
        }

        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(j2);
        drawTexturedModalRect(k2, l2, 0, 0, achievementsPaneWidth, achievementsPaneHeight);
        GL11.glPopMatrix();
        zLevel = 0.0F;
        GL11.glDepthFunc(515);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GuiScreen_a(i, j, f);
        if(achievement != null)
        {
            Achievement achievement2 = achievement;
            String s = achievement2.statName;
            String s1 = achievement2.getDescription();
            int j7 = i + 12;
            int i8 = j - 4;
            if(statfilewriter.canUnlockAchievement(achievement2))
            {
                int k8 = Math.max(fontRenderer.getStringWidth(s), 120);
                int i9 = fontRenderer.splitStringWidth(s1, k8);
                if(statfilewriter.hasAchievementUnlocked(achievement2))
                {
                    i9 += 12;
                }
                drawGradientRect(j7 - 3, i8 - 3, j7 + k8 + 3, i8 + i9 + 3 + 12, 0xc0000000, 0xc0000000);
                fontRenderer.drawSplitString(s1, j7, i8 + 12, k8, 0xffa0a0a0);
                if(statfilewriter.hasAchievementUnlocked(achievement2))
                {
                    fontRenderer.drawStringWithShadow(StatCollector.translateToLocal("achievement.taken"), j7, i8 + i9 + 4, 0xff9090ff);
                }
            } else
            {
                int l8 = Math.max(fontRenderer.getStringWidth(s), 120);
                String s2 = StatCollector.translateToLocalFormatted("achievement.requires", new Object[] {
                    achievement2.parentAchievement.statName
                });
                int j9 = fontRenderer.splitStringWidth(s2, l8);
                drawGradientRect(j7 - 3, i8 - 3, j7 + l8 + 3, i8 + j9 + 12 + 3, 0xc0000000, 0xc0000000);
                fontRenderer.drawSplitString(s2, j7, i8 + 12, l8, 0xff705050);
            }
            fontRenderer.drawStringWithShadow(s, j7, i8, statfilewriter.canUnlockAchievement(achievement2) ? achievement2.getSpecial() ? -128 : -1 : achievement2.getSpecial() ? 0xff808040 : 0xff808080);
        }
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        RenderHelper.disableStandardItemLighting();
    }

    protected void drawRect(int i, int j, int k, int l, int i1)
    {
        if(i < k)
        {
            int j1 = i;
            i = k;
            k = j1;
        }
        if(j < l)
        {
            int k1 = j;
            j = l;
            l = k1;
        }
        float f = (float)(i1 >> 24 & 0xff) / 255F;
        float f1 = (float)(i1 >> 16 & 0xff) / 255F;
        float f2 = (float)(i1 >> 8 & 0xff) / 255F;
        float f3 = (float)(i1 & 0xff) / 255F;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        if(draw)
        {
            tessellator.startDrawingQuads();
            tessellator.addVertex(i, l, 0.0D);
            tessellator.addVertex(k, l, 0.0D);
            tessellator.addVertex(k, j, 0.0D);
            tessellator.addVertex(i, j, 0.0D);
            tessellator.draw();
        }
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        GL11.glDisable(3042 /*GL_BLEND*/);
    }

    public boolean isVisibleAchievement(Achievement achievement, int i)
    {
        if(checkHidden(achievement))
        {
            return false;
        }
        int j = SAPI.Achievements.getPage(achievement).getID();
        if(j == SAPI.Achievements.current().getID())
        {
            return true;
        }
        if(i >= 1)
        {
            ArrayList arraylist = new ArrayList(AchievementList.achievementList);
            for(int k = 0; k < arraylist.size(); k++)
            {
                Achievement achievement1 = (Achievement)arraylist.get(k);
                if(achievement1.statId == achievement.statId)
                {
                    arraylist.remove(k--);
                    continue;
                }
                if(achievement1.parentAchievement == null)
                {
                    arraylist.remove(k--);
                    continue;
                }
                if(achievement1.parentAchievement.statId != achievement.statId)
                {
                    arraylist.remove(k--);
                }
            }

            for(int l = 0; l < arraylist.size(); l++)
            {
                Achievement achievement2 = (Achievement)arraylist.get(l);
                if(isVisibleAchievement(achievement2, i - 1))
                {
                    return true;
                }
            }

        }
        return false;
    }

    public boolean isVisibleLine(Achievement achievement)
    {
        return achievement.parentAchievement != null && isVisibleAchievement(achievement, 1) && isVisibleAchievement(achievement.parentAchievement, 1);
    }

    public boolean checkHidden(Achievement achievement)
    {
        if(mc.statFileWriter.hasAchievementUnlocked(achievement))
        {
            return false;
        }
        if(SAPI.Achievements.isHidden(achievement))
        {
            return true;
        }
        if(achievement.parentAchievement == null)
        {
            return false;
        } else
        {
            return checkHidden(achievement.parentAchievement);
        }
    }

}
