// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerEnchanter, FontRenderer, RenderEngine, 
//            TileEntityEnchanter, InventoryPlayer

public class GuiEnchanter extends GuiContainer
{

    private TileEntityEnchanter enchanterInventory;

    public GuiEnchanter(InventoryPlayer inventoryplayer, TileEntityEnchanter tileentityenchanter)
    {
        super(new ContainerEnchanter(inventoryplayer, tileentityenchanter));
        enchanterInventory = tileentityenchanter;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString("Enchanter", 60, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int k = mc.renderEngine.getTexture("/aether/gui/enchanter.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(k);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
        if(enchanterInventory.isBurning())
        {
            int j1 = enchanterInventory.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(l + 57, (i1 + 47) - j1, 176, 12 - j1, 14, j1 + 2);
        }
        int k1 = enchanterInventory.getCookProgressScaled(24);
        drawTexturedModalRect(l + 79, i1 + 35, 176, 14, k1 + 1, 16);
    }
}
