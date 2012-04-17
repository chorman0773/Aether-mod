// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import java.util.LinkedList;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

// Referenced classes of package forge:
//            ForgeHooksClient, ICustomItemRenderer, IHighlightHandler, IRenderContextHandler

public class MinecraftForgeClient
{

    private static ICustomItemRenderer customItemRenderers[];

    public MinecraftForgeClient()
    {
    }

    public static void registerHighlightHandler(IHighlightHandler ihighlighthandler)
    {
        ForgeHooksClient.highlightHandlers.add(ihighlighthandler);
    }

    public static void registerRenderContextHandler(String s, int i, IRenderContextHandler irendercontexthandler)
    {
        ForgeHooksClient.registerRenderContextHandler(s, i, irendercontexthandler);
    }

    public static void bindTexture(String s, int i)
    {
        ForgeHooksClient.bindTexture(s, i);
    }

    public static void bindTexture(String s)
    {
        ForgeHooksClient.bindTexture(s, 0);
    }

    public static void unbindTexture()
    {
        ForgeHooksClient.unbindTexture();
    }

    public static void preloadTexture(String s)
    {
        ModLoader.getMinecraftInstance().renderEngine.getTexture(s);
    }

    public static void renderBlock(RenderBlocks renderblocks, Block block, int i, int j, int k)
    {
        ForgeHooksClient.beforeBlockRender(block, renderblocks);
        renderblocks.renderBlockByRenderType(block, i, j, k);
        ForgeHooksClient.afterBlockRender(block, renderblocks);
    }

    public static int getRenderPass()
    {
        return ForgeHooksClient.renderPass;
    }

    public static void registerCustomItemRenderer(int i, ICustomItemRenderer icustomitemrenderer)
    {
        customItemRenderers[i] = icustomitemrenderer;
    }

    public static ICustomItemRenderer getCustomItemRenderer(int i)
    {
        return customItemRenderers[i];
    }

    static 
    {
        customItemRenderers = new ICustomItemRenderer[Item.itemsList.length];
    }
}
