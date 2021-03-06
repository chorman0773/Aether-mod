// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiContainer, ContainerChest, IInventory, FontRenderer, 
//            RenderEngine

public class GuiTreasureChest extends GuiContainer
{

    private IInventory upperChestInventory;
    private IInventory lowerChestInventory;
    private int inventoryRows;
    private String name;

    public GuiTreasureChest(IInventory iinventory, IInventory iinventory1, int i)
    {
        super(new ContainerChest(iinventory, iinventory1));
        inventoryRows = 0;
        upperChestInventory = iinventory;
        lowerChestInventory = iinventory1;
        allowUserInput = false;
        char c = '\336';
        int j = c - 108;
        inventoryRows = iinventory1.getSizeInventory() / 9;
        ySize = j + inventoryRows * 18;
        switch(i)
        {
        case 1: // '\001'
            name = "Bronze Treasure Chest";
            break;

        case 3: // '\003'
            name = "Silver Treasure Chest";
            break;

        case 5: // '\005'
            name = "Gold Treasure Chest";
            break;
        }
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(name, 8, 6, 0x404040);
        fontRenderer.drawString(upperChestInventory.getInvName(), 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        int k = mc.renderEngine.getTexture("/gui/container.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(k);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, inventoryRows * 18 + 17);
        drawTexturedModalRect(l, i1 + inventoryRows * 18 + 17, 0, 126, xSize, 96);
    }
}
