// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import java.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package forge:
//            IHighlightHandler, IRenderWorldLastHandler, IMultipassRender, IRenderContextHandler, 
//            ITextureProvider, ICustomItemRenderer

public class ForgeHooksClient
{
    private static class TesKey
        implements Comparable
    {

        public int tex;
        public int sub;

        public int compareTo(TesKey teskey)
        {
            if(sub == teskey.sub)
            {
                return tex - teskey.tex;
            } else
            {
                return sub - teskey.sub;
            }
        }

        public boolean equals(Object obj)
        {
            return compareTo((TesKey)obj) == 0;
        }

        public int hashCode()
        {
            int i = Integer.valueOf(tex).hashCode();
            int j = Integer.valueOf(sub).hashCode();
            return i + 31 * j;
        }

        public int compareTo(Object obj)
        {
            return compareTo((TesKey)obj);
        }

        public TesKey(int i, int j)
        {
            tex = i;
            sub = j;
        }
    }


    static LinkedList highlightHandlers = new LinkedList();
    static LinkedList renderWorldLastHandlers = new LinkedList();
    static HashMap tessellators = new HashMap();
    static HashMap textures = new HashMap();
    static boolean inWorld = false;
    static TreeSet renderTextures = new TreeSet();
    static Tessellator defaultTessellator = null;
    static HashMap renderHandlers = new HashMap();
    static int renderPass = -1;

    public ForgeHooksClient()
    {
    }

    public static boolean onBlockHighlight(RenderGlobal renderglobal, EntityPlayer entityplayer, MovingObjectPosition movingobjectposition, int i, ItemStack itemstack, float f)
    {
        for(Iterator iterator = highlightHandlers.iterator(); iterator.hasNext();)
        {
            IHighlightHandler ihighlighthandler = (IHighlightHandler)iterator.next();
            if(ihighlighthandler.onBlockHighlight(renderglobal, entityplayer, movingobjectposition, i, itemstack, f))
            {
                return true;
            }
        }

        return false;
    }

    public static void onRenderWorldLast(RenderGlobal renderglobal, float f)
    {
        IRenderWorldLastHandler irenderworldlasthandler;
        for(Iterator iterator = renderWorldLastHandlers.iterator(); iterator.hasNext(); irenderworldlasthandler.onRenderWorldLast(renderglobal, f))
        {
            irenderworldlasthandler = (IRenderWorldLastHandler)iterator.next();
        }

    }

    public static boolean canRenderInPass(Block block, int i)
    {
        if(block instanceof IMultipassRender)
        {
            IMultipassRender imultipassrender = (IMultipassRender)block;
            return imultipassrender.canRenderInPass(i);
        }
        return i == block.getRenderBlockPass();
    }

    protected static void registerRenderContextHandler(String s, int i, IRenderContextHandler irendercontexthandler)
    {
        Integer integer = (Integer)textures.get(s);
        if(integer == null)
        {
            integer = Integer.valueOf(ModLoader.getMinecraftInstance().renderEngine.getTexture(s));
            textures.put(s, integer);
        }
        renderHandlers.put(new TesKey(integer.intValue(), i), irendercontexthandler);
    }

    protected static void bindTessellator(int i, int j)
    {
        TesKey teskey = new TesKey(i, j);
        Tessellator tessellator = (Tessellator)tessellators.get(teskey);
        if(tessellator == null)
        {
            tessellator = new Tessellator();
            tessellators.put(teskey, tessellator);
        }
        if(inWorld && !renderTextures.contains(teskey))
        {
            renderTextures.add(teskey);
            tessellator.startDrawingQuads();
            tessellator.setTranslationD(defaultTessellator.xOffset, defaultTessellator.yOffset, defaultTessellator.zOffset);
        }
        Tessellator.instance = tessellator;
    }

    protected static void bindTexture(String s, int i)
    {
        Integer integer = (Integer)textures.get(s);
        if(integer == null)
        {
            integer = Integer.valueOf(ModLoader.getMinecraftInstance().renderEngine.getTexture(s));
            textures.put(s, integer);
        }
        if(!inWorld)
        {
            if(Tessellator.instance.isDrawing)
            {
                int j = Tessellator.instance.drawMode;
                Tessellator.instance.draw();
                Tessellator.instance.startDrawing(j);
            }
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, integer.intValue());
            return;
        } else
        {
            bindTessellator(integer.intValue(), i);
            return;
        }
    }

    protected static void unbindTexture()
    {
        if(inWorld)
        {
            Tessellator.instance = defaultTessellator;
        } else
        {
            if(Tessellator.instance.isDrawing)
            {
                int i = Tessellator.instance.drawMode;
                Tessellator.instance.draw();
                Tessellator.instance.startDrawing(i);
            }
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, ModLoader.getMinecraftInstance().renderEngine.getTexture("/terrain.png"));
            return;
        }
    }

    public static void beforeRenderPass(int i)
    {
        renderPass = i;
        defaultTessellator = Tessellator.instance;
        Tessellator.renderingWorldRenderer = true;
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, ModLoader.getMinecraftInstance().renderEngine.getTexture("/terrain.png"));
        renderTextures.clear();
        inWorld = true;
    }

    public static void afterRenderPass(int i)
    {
        renderPass = -1;
        inWorld = false;
        for(Iterator iterator = renderTextures.iterator(); iterator.hasNext();)
        {
            TesKey teskey = (TesKey)iterator.next();
            IRenderContextHandler irendercontexthandler = (IRenderContextHandler)renderHandlers.get(teskey);
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, teskey.tex);
            Tessellator tessellator = (Tessellator)tessellators.get(teskey);
            if(irendercontexthandler == null)
            {
                tessellator.draw();
            } else
            {
                Tessellator.instance = tessellator;
                irendercontexthandler.beforeRenderContext();
                tessellator.draw();
                irendercontexthandler.afterRenderContext();
            }
        }

        GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, ModLoader.getMinecraftInstance().renderEngine.getTexture("/terrain.png"));
        Tessellator.renderingWorldRenderer = false;
        Tessellator.instance = defaultTessellator;
    }

    public static void beforeBlockRender(Block block, RenderBlocks renderblocks)
    {
        if((block instanceof ITextureProvider) && renderblocks.overrideBlockTexture == -1)
        {
            ITextureProvider itextureprovider = (ITextureProvider)block;
            bindTexture(itextureprovider.getTextureFile(), 0);
        }
    }

    public static void afterBlockRender(Block block, RenderBlocks renderblocks)
    {
        if((block instanceof ITextureProvider) && renderblocks.overrideBlockTexture == -1)
        {
            unbindTexture();
        }
    }

    public static void overrideTexture(Object obj)
    {
        if(obj instanceof ITextureProvider)
        {
            GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, ModLoader.getMinecraftInstance().renderEngine.getTexture(((ITextureProvider)obj).getTextureFile()));
        }
    }

    public static String getTexture(String s, Object obj)
    {
        if(obj instanceof ITextureProvider)
        {
            return ((ITextureProvider)obj).getTextureFile();
        } else
        {
            return s;
        }
    }

    public static void renderCustomItem(ICustomItemRenderer icustomitemrenderer, RenderBlocks renderblocks, int i, int j, float f)
    {
        Tessellator tessellator = Tessellator.instance;
        if(renderblocks.useInventoryTint)
        {
            int k = 0xffffff;
            float f1 = (float)(k >> 16 & 0xff) / 255F;
            float f2 = (float)(k >> 8 & 0xff) / 255F;
            float f3 = (float)(k & 0xff) / 255F;
            GL11.glColor4f(f1 * f, f2 * f, f3 * f, 1.0F);
        }
        icustomitemrenderer.renderInventory(renderblocks, i, j);
    }

}
