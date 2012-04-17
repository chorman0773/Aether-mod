// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ForgeHooks;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerController, SAPI, EntityPlayer, EntityPlayerSP, 
//            ItemStack, Item, World, Block, 
//            StepSound, SoundManager, GuiIngame, RenderGlobal

public class PlayerControllerSP extends PlayerController
{

    private int curBlockX;
    private int curBlockY;
    private int curBlockZ;
    private float curBlockDamage;
    private float prevBlockDamage;
    private float blockDestroySoundCounter;
    private int blockHitWait;

    public PlayerControllerSP(Minecraft minecraft)
    {
        super(minecraft);
        curBlockX = -1;
        curBlockY = -1;
        curBlockZ = -1;
        curBlockDamage = 0.0F;
        prevBlockDamage = 0.0F;
        blockDestroySoundCounter = 0.0F;
        blockHitWait = 0;
    }

    public void flipPlayer(EntityPlayer entityplayer)
    {
        entityplayer.rotationYaw = -180F;
    }

    public boolean shouldDrawHUD()
    {
        return true;
    }

    public boolean onPlayerDestroyBlock(int i, int j, int k, int l)
    {
        ItemStack itemstack = mc.thePlayer.getCurrentEquippedItem();
        if(itemstack != null && itemstack.getItem().onBlockStartBreak(itemstack, i, j, k, mc.thePlayer))
        {
            return false;
        }
        int i1 = mc.theWorld.getBlockId(i, j, k);
        int j1 = mc.theWorld.getBlockMetadata(i, j, k);
        boolean flag = super.onPlayerDestroyBlock(i, j, k, l);
        boolean flag1 = Block.blocksList[i1].canHarvestBlock(mc.thePlayer, j1);
        if(itemstack != null)
        {
            itemstack.onDestroyBlock(i1, i, j, k, mc.thePlayer);
            if(itemstack.stackSize == 0)
            {
                itemstack.onItemDestroyedByUse(mc.thePlayer);
                mc.thePlayer.destroyCurrentEquippedItem();
            }
        }
        if(flag && flag1)
        {
            if(SAPI.Harvest.intercept(mc.theWorld, mc.thePlayer, i, j, k, i1, j1))
            {
                return flag;
            }
            Block.blocksList[i1].harvestBlock(mc.theWorld, mc.thePlayer, i, j, k, j1);
        }
        return flag;
    }

    public void clickBlock(int i, int j, int k, int l)
    {
        if(!mc.thePlayer.canPlayerEdit(i, j, k))
        {
            return;
        }
        mc.theWorld.onBlockHit(mc.thePlayer, i, j, k, l);
        int i1 = mc.theWorld.getBlockId(i, j, k);
        if(i1 > 0 && curBlockDamage == 0.0F)
        {
            Block.blocksList[i1].onBlockClicked(mc.theWorld, i, j, k, mc.thePlayer);
        }
        if(i1 > 0 && Block.blocksList[i1].blockStrength(mc.theWorld, mc.thePlayer, i, j, k) >= 1.0F)
        {
            onPlayerDestroyBlock(i, j, k, l);
        }
    }

    public void resetBlockRemoving()
    {
        curBlockDamage = 0.0F;
        blockHitWait = 0;
    }

    public void onPlayerDamageBlock(int i, int j, int k, int l)
    {
        if(blockHitWait > 0)
        {
            blockHitWait--;
            return;
        }
        if(i == curBlockX && j == curBlockY && k == curBlockZ)
        {
            int i1 = mc.theWorld.getBlockId(i, j, k);
            if(!mc.thePlayer.canPlayerEdit(i, j, k))
            {
                return;
            }
            if(i1 == 0)
            {
                return;
            }
            Block block = Block.blocksList[i1];
            curBlockDamage += block.blockStrength(mc.theWorld, mc.thePlayer, i, j, k);
            if(blockDestroySoundCounter % 4F == 0.0F && block != null)
            {
                mc.sndManager.playSound(block.stepSound.stepSoundDir2(), (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, (block.stepSound.getVolume() + 1.0F) / 8F, block.stepSound.getPitch() * 0.5F);
            }
            blockDestroySoundCounter++;
            if(curBlockDamage >= 1.0F)
            {
                onPlayerDestroyBlock(i, j, k, l);
                curBlockDamage = 0.0F;
                prevBlockDamage = 0.0F;
                blockDestroySoundCounter = 0.0F;
                blockHitWait = 5;
            }
        } else
        {
            curBlockDamage = 0.0F;
            prevBlockDamage = 0.0F;
            blockDestroySoundCounter = 0.0F;
            curBlockX = i;
            curBlockY = j;
            curBlockZ = k;
        }
    }

    public void setPartialTime(float f)
    {
        if(curBlockDamage <= 0.0F)
        {
            mc.ingameGUI.damageGuiPartialTime = 0.0F;
            mc.renderGlobal.damagePartialTime = 0.0F;
        } else
        {
            float f1 = prevBlockDamage + (curBlockDamage - prevBlockDamage) * f;
            mc.ingameGUI.damageGuiPartialTime = f1;
            mc.renderGlobal.damagePartialTime = f1;
        }
    }

    public float getBlockReachDistance()
    {
        return SAPI.Reach.getReach(false);
    }

    public void onWorldChange(World world)
    {
        super.onWorldChange(world);
    }

    public EntityPlayer createPlayer(World world)
    {
        EntityPlayer entityplayer = super.createPlayer(world);
        return entityplayer;
    }

    public void updateController()
    {
        prevBlockDamage = curBlockDamage;
        mc.sndManager.playRandomMusicIfReady();
    }

    public boolean onPlayerRightClick(EntityPlayer entityplayer, World world, ItemStack itemstack, int i, int j, int k, int l)
    {
        if(itemstack != null)
        {
            Item item = itemstack.getItem();
            if(item.onItemUseFirst(itemstack, entityplayer, world, i, j, k, l))
            {
                return true;
            }
        }
        int i1 = world.getBlockId(i, j, k);
        if(i1 > 0 && Block.blocksList[i1].blockActivated(world, i, j, k, entityplayer))
        {
            return true;
        }
        if(itemstack == null)
        {
            return false;
        }
        if(!itemstack.useItem(entityplayer, world, i, j, k, l))
        {
            return false;
        }
        if(itemstack.stackSize == 0)
        {
            ForgeHooks.onDestroyCurrentItem(entityplayer, itemstack);
        }
        return true;
    }

    public boolean func_35642_f()
    {
        return true;
    }
}
