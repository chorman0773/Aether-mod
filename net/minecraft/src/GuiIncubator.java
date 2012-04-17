// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerIncubator, FontRenderer, RenderEngine, 
//            TileEntityIncubator, InventoryPlayer

public class GuiIncubator extends GuiContainer
{

    private TileEntityIncubator IncubatorInventory;

    public GuiIncubator(InventoryPlayer inventoryplayer, TileEntityIncubator tileentityincubator)
    {
        super(new ContainerIncubator(inventoryplayer, tileentityincubator));
        IncubatorInventory = tileentityincubator;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Incubator", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int k = mc.renderEngine.getTexture("/aether/gui/incubator.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(k);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
        if(IncubatorInventory.isBurning())
        {
            int j1 = IncubatorInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(l + 74, (i1 + 47) - j1, 176, 12 - j1, 14, j1 + 2);
        }
        int k1 = IncubatorInventory.getCookProgressScaled(54);
        drawTexturedModalRect(l + 103, (i1 + 70) - k1, 179, 70 - k1, 10, k1);
    }
}
