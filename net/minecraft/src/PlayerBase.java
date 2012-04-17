// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerAPI, EntityPlayerSP, MovingObjectPosition, EnumStatus, 
//            World, Session, DamageSource, Entity, 
//            Block, IInventory, TileEntityDispenser, TileEntitySign, 
//            TileEntityFurnace, ItemStack, Material, EntityLiving, 
//            NBTTagCompound

public abstract class PlayerBase
{

    protected final EntityPlayerSP player;
    private final PlayerAPI playerAPI;

    public PlayerBase(PlayerAPI playerapi)
    {
        playerAPI = playerapi;
        player = playerapi.player;
    }

    public void beforeLocalConstructing(Minecraft minecraft, World world, Session session, int i)
    {
    }

    public void afterLocalConstructing(Minecraft minecraft, World world, Session session, int i)
    {
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    public void beforeAddExhaustion(float f)
    {
    }

    public void addExhaustion(float f)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenAddExhaustion(this);
        if(playerbase == null)
        {
            player.localAddExhaustion(f);
        } else
        if(playerbase != this)
        {
            playerbase.addExhaustion(f);
        }
    }

    public void afterAddExhaustion(float f)
    {
    }

    public void beforeAttackEntityFrom(DamageSource damagesource, int i)
    {
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenAttackEntityFrom(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localAttackEntityFrom(damagesource, i);
        } else
        if(playerbase != this)
        {
            flag = playerbase.attackEntityFrom(damagesource, i);
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterAttackEntityFrom(DamageSource damagesource, int i)
    {
    }

    public void beforeAttackTargetEntityWithCurrentItem(Entity entity)
    {
    }

    public void attackTargetEntityWithCurrentItem(Entity entity)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenAttackTargetEntityWithCurrentItem(this);
        if(playerbase == null)
        {
            player.localAttackTargetEntityWithCurrentItem(entity);
        } else
        if(playerbase != this)
        {
            playerbase.attackTargetEntityWithCurrentItem(entity);
        }
    }

    public void afterAttackTargetEntityWithCurrentItem(Entity entity)
    {
    }

    public void beforeCanHarvestBlock(Block block)
    {
    }

    public boolean canHarvestBlock(Block block)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenCanHarvestBlock(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localCanHarvestBlock(block);
        } else
        if(playerbase != this)
        {
            flag = playerbase.canHarvestBlock(block);
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterCanHarvestBlock(Block block)
    {
    }

    public void beforeCanTriggerWalking()
    {
    }

    public boolean canTriggerWalking()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenCanTriggerWalking(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localCanTriggerWalking();
        } else
        if(playerbase != this)
        {
            flag = playerbase.canTriggerWalking();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterCanTriggerWalking()
    {
    }

    public void beforeCloseScreen()
    {
    }

    public void closeScreen()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenCloseScreen(this);
        if(playerbase == null)
        {
            player.localCloseScreen();
        } else
        if(playerbase != this)
        {
            playerbase.closeScreen();
        }
    }

    public void afterCloseScreen()
    {
    }

    public void beforeDamageEntity(DamageSource damagesource, int i)
    {
    }

    public void damageEntity(DamageSource damagesource, int i)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDamageEntity(this);
        if(playerbase == null)
        {
            player.localDamageEntity(damagesource, i);
        } else
        if(playerbase != this)
        {
            playerbase.damageEntity(damagesource, i);
        }
    }

    public void afterDamageEntity(DamageSource damagesource, int i)
    {
    }

    public void beforeDisplayGUIChest(IInventory iinventory)
    {
    }

    public void displayGUIChest(IInventory iinventory)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayGUIChest(this);
        if(playerbase == null)
        {
            player.localDisplayGUIChest(iinventory);
        } else
        if(playerbase != this)
        {
            playerbase.displayGUIChest(iinventory);
        }
    }

    public void afterDisplayGUIChest(IInventory iinventory)
    {
    }

    public void beforeDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
    }

    public void displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayGUIDispenser(this);
        if(playerbase == null)
        {
            player.localDisplayGUIDispenser(tileentitydispenser);
        } else
        if(playerbase != this)
        {
            playerbase.displayGUIDispenser(tileentitydispenser);
        }
    }

    public void afterDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
    }

    public void beforeDisplayGUIEditSign(TileEntitySign tileentitysign)
    {
    }

    public void displayGUIEditSign(TileEntitySign tileentitysign)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayGUIEditSign(this);
        if(playerbase == null)
        {
            player.localDisplayGUIEditSign(tileentitysign);
        } else
        if(playerbase != this)
        {
            playerbase.displayGUIEditSign(tileentitysign);
        }
    }

    public void afterDisplayGUIEditSign(TileEntitySign tileentitysign)
    {
    }

    public void beforeDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayGUIFurnace(this);
        if(playerbase == null)
        {
            player.localDisplayGUIFurnace(tileentityfurnace);
        } else
        if(playerbase != this)
        {
            playerbase.displayGUIFurnace(tileentityfurnace);
        }
    }

    public void afterDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
    }

    public void beforeDisplayWorkbenchGUI(int i, int j, int k)
    {
    }

    public void displayWorkbenchGUI(int i, int j, int k)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDisplayWorkbenchGUI(this);
        if(playerbase == null)
        {
            player.localDisplayWorkbenchGUI(i, j, k);
        } else
        if(playerbase != this)
        {
            playerbase.displayWorkbenchGUI(i, j, k);
        }
    }

    public void afterDisplayWorkbenchGUI(int i, int j, int k)
    {
    }

    public void beforeDropCurrentItem()
    {
    }

    public void dropCurrentItem()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDropCurrentItem(this);
        if(playerbase == null)
        {
            player.localDropCurrentItem();
        } else
        if(playerbase != this)
        {
            playerbase.dropCurrentItem();
        }
    }

    public void afterDropCurrentItem()
    {
    }

    public void beforeDropPlayerItem(ItemStack itemstack)
    {
    }

    public void dropPlayerItem(ItemStack itemstack)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDropPlayerItem(this);
        if(playerbase == null)
        {
            player.localDropPlayerItem(itemstack);
        } else
        if(playerbase != this)
        {
            playerbase.dropPlayerItem(itemstack);
        }
    }

    public void afterDropPlayerItem(ItemStack itemstack)
    {
    }

    public void beforeDropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
    }

    public void dropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenDropPlayerItemWithRandomChoice(this);
        if(playerbase == null)
        {
            player.localDropPlayerItemWithRandomChoice(itemstack, flag);
        } else
        if(playerbase != this)
        {
            playerbase.dropPlayerItemWithRandomChoice(itemstack, flag);
        }
    }

    public void afterDropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
    }

    public void beforeFall(float f)
    {
    }

    public void fall(float f)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenFall(this);
        if(playerbase == null)
        {
            player.localFall(f);
        } else
        if(playerbase != this)
        {
            playerbase.fall(f);
        }
    }

    public void afterFall(float f)
    {
    }

    public void beforeGetCurrentPlayerStrVsBlock(Block block)
    {
    }

    public float getCurrentPlayerStrVsBlock(Block block)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
        float f;
        if(playerbase == null)
        {
            f = player.localGetCurrentPlayerStrVsBlock(block);
        } else
        if(playerbase != this)
        {
            f = playerbase.getCurrentPlayerStrVsBlock(block);
        } else
        {
            f = 0.0F;
        }
        return f;
    }

    public void afterGetCurrentPlayerStrVsBlock(Block block)
    {
    }

    public void beforeGetDistanceSq(double d, double d1, double d2)
    {
    }

    public double getDistanceSq(double d, double d1, double d2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetDistanceSq(this);
        double d3;
        if(playerbase == null)
        {
            d3 = player.localGetDistanceSq(d, d1, d2);
        } else
        if(playerbase != this)
        {
            d3 = playerbase.getDistanceSq(d, d1, d2);
        } else
        {
            d3 = 0.0D;
        }
        return d3;
    }

    public void afterGetDistanceSq(double d, double d1, double d2)
    {
    }

    public void beforeGetDistanceSqToEntity(Entity entity)
    {
    }

    public double getDistanceSqToEntity(Entity entity)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetDistanceSqToEntity(this);
        double d;
        if(playerbase == null)
        {
            d = player.localGetDistanceSqToEntity(entity);
        } else
        if(playerbase != this)
        {
            d = playerbase.getDistanceSqToEntity(entity);
        } else
        {
            d = 0.0D;
        }
        return d;
    }

    public void afterGetDistanceSqToEntity(Entity entity)
    {
    }

    public void beforeGetEntityBrightness(float f)
    {
    }

    public float getEntityBrightness(float f)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetEntityBrightness(this);
        float f1;
        if(playerbase == null)
        {
            f1 = player.localGetEntityBrightness(f);
        } else
        if(playerbase != this)
        {
            f1 = playerbase.getEntityBrightness(f);
        } else
        {
            f1 = 0.0F;
        }
        return f1;
    }

    public void afterGetEntityBrightness(float f)
    {
    }

    public void beforeGetEntityBrightnessForRender(float f)
    {
    }

    public int getEntityBrightnessForRender(float f)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetEntityBrightnessForRender(this);
        int i;
        if(playerbase == null)
        {
            i = player.localGetEntityBrightnessForRender(f);
        } else
        if(playerbase != this)
        {
            i = playerbase.getEntityBrightnessForRender(f);
        } else
        {
            i = 0;
        }
        return i;
    }

    public void afterGetEntityBrightnessForRender(float f)
    {
    }

    public void beforeGetFOVMultiplier()
    {
    }

    public float getFOVMultiplier()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetFOVMultiplier(this);
        float f;
        if(playerbase == null)
        {
            f = player.localGetFOVMultiplier();
        } else
        if(playerbase != this)
        {
            f = playerbase.getFOVMultiplier();
        } else
        {
            f = 0.0F;
        }
        return f;
    }

    public void afterGetFOVMultiplier()
    {
    }

    public void beforeGetHurtSound()
    {
    }

    public String getHurtSound()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetHurtSound(this);
        String s;
        if(playerbase == null)
        {
            s = player.localGetHurtSound();
        } else
        if(playerbase != this)
        {
            s = playerbase.getHurtSound();
        } else
        {
            s = null;
        }
        return s;
    }

    public void afterGetHurtSound()
    {
    }

    public void beforeGetPlayerArmorValue()
    {
    }

    public int getPlayerArmorValue()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenGetPlayerArmorValue(this);
        int i;
        if(playerbase == null)
        {
            i = player.localGetPlayerArmorValue();
        } else
        if(playerbase != this)
        {
            i = playerbase.getPlayerArmorValue();
        } else
        {
            i = 0;
        }
        return i;
    }

    public void afterGetPlayerArmorValue()
    {
    }

    public void beforeHandleLavaMovement()
    {
    }

    public boolean handleLavaMovement()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenHandleLavaMovement(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localHandleLavaMovement();
        } else
        if(playerbase != this)
        {
            flag = playerbase.handleLavaMovement();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterHandleLavaMovement()
    {
    }

    public void beforeHandleWaterMovement()
    {
    }

    public boolean handleWaterMovement()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenHandleWaterMovement(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localHandleWaterMovement();
        } else
        if(playerbase != this)
        {
            flag = playerbase.handleWaterMovement();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterHandleWaterMovement()
    {
    }

    public void beforeHeal(int i)
    {
    }

    public void heal(int i)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenHeal(this);
        if(playerbase == null)
        {
            player.localHeal(i);
        } else
        if(playerbase != this)
        {
            playerbase.heal(i);
        }
    }

    public void afterHeal(int i)
    {
    }

    public void beforeIsEntityInsideOpaqueBlock()
    {
    }

    public boolean isEntityInsideOpaqueBlock()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsEntityInsideOpaqueBlock(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localIsEntityInsideOpaqueBlock();
        } else
        if(playerbase != this)
        {
            flag = playerbase.isEntityInsideOpaqueBlock();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterIsEntityInsideOpaqueBlock()
    {
    }

    public void beforeIsInWater()
    {
    }

    public boolean isInWater()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsInWater(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localIsInWater();
        } else
        if(playerbase != this)
        {
            flag = playerbase.isInWater();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterIsInWater()
    {
    }

    public void beforeIsInsideOfMaterial(Material material)
    {
    }

    public boolean isInsideOfMaterial(Material material)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsInsideOfMaterial(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localIsInsideOfMaterial(material);
        } else
        if(playerbase != this)
        {
            flag = playerbase.isInsideOfMaterial(material);
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterIsInsideOfMaterial(Material material)
    {
    }

    public void beforeIsOnLadder()
    {
    }

    public boolean isOnLadder()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsOnLadder(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localIsOnLadder();
        } else
        if(playerbase != this)
        {
            flag = playerbase.isOnLadder();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterIsOnLadder()
    {
    }

    public void beforeIsSneaking()
    {
    }

    public boolean isSneaking()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsSneaking(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localIsSneaking();
        } else
        if(playerbase != this)
        {
            flag = playerbase.isSneaking();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterIsSneaking()
    {
    }

    public void beforeIsSprinting()
    {
    }

    public boolean isSprinting()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenIsSprinting(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localIsSprinting();
        } else
        if(playerbase != this)
        {
            flag = playerbase.isSprinting();
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterIsSprinting()
    {
    }

    public void beforeJump()
    {
    }

    public void jump()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenJump(this);
        if(playerbase == null)
        {
            player.localJump();
        } else
        if(playerbase != this)
        {
            playerbase.jump();
        }
    }

    public void afterJump()
    {
    }

    public void beforeMoveEntity(double d, double d1, double d2)
    {
    }

    public void moveEntity(double d, double d1, double d2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenMoveEntity(this);
        if(playerbase == null)
        {
            player.localMoveEntity(d, d1, d2);
        } else
        if(playerbase != this)
        {
            playerbase.moveEntity(d, d1, d2);
        }
    }

    public void afterMoveEntity(double d, double d1, double d2)
    {
    }

    public void beforeMoveEntityWithHeading(float f, float f1)
    {
    }

    public void moveEntityWithHeading(float f, float f1)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenMoveEntityWithHeading(this);
        if(playerbase == null)
        {
            player.localMoveEntityWithHeading(f, f1);
        } else
        if(playerbase != this)
        {
            playerbase.moveEntityWithHeading(f, f1);
        }
    }

    public void afterMoveEntityWithHeading(float f, float f1)
    {
    }

    public void beforeMoveFlying(float f, float f1, float f2)
    {
    }

    public void moveFlying(float f, float f1, float f2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenMoveFlying(this);
        if(playerbase == null)
        {
            player.localMoveFlying(f, f1, f2);
        } else
        if(playerbase != this)
        {
            playerbase.moveFlying(f, f1, f2);
        }
    }

    public void afterMoveFlying(float f, float f1, float f2)
    {
    }

    public void beforeOnDeath(DamageSource damagesource)
    {
    }

    public void onDeath(DamageSource damagesource)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnDeath(this);
        if(playerbase == null)
        {
            player.localOnDeath(damagesource);
        } else
        if(playerbase != this)
        {
            playerbase.onDeath(damagesource);
        }
    }

    public void afterOnDeath(DamageSource damagesource)
    {
    }

    public void beforeOnLivingUpdate()
    {
    }

    public void onLivingUpdate()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnLivingUpdate(this);
        if(playerbase == null)
        {
            player.localOnLivingUpdate();
        } else
        if(playerbase != this)
        {
            playerbase.onLivingUpdate();
        }
    }

    public void afterOnLivingUpdate()
    {
    }

    public void beforeOnKillEntity(EntityLiving entityliving)
    {
    }

    public void onKillEntity(EntityLiving entityliving)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnKillEntity(this);
        if(playerbase == null)
        {
            player.localOnKillEntity(entityliving);
        } else
        if(playerbase != this)
        {
            playerbase.onKillEntity(entityliving);
        }
    }

    public void afterOnKillEntity(EntityLiving entityliving)
    {
    }

    public void beforeOnUpdate()
    {
    }

    public void onUpdate()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenOnUpdate(this);
        if(playerbase == null)
        {
            player.localOnUpdate();
        } else
        if(playerbase != this)
        {
            playerbase.onUpdate();
        }
    }

    public void afterOnUpdate()
    {
    }

    public void beforePushOutOfBlocks(double d, double d1, double d2)
    {
    }

    public boolean pushOutOfBlocks(double d, double d1, double d2)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenPushOutOfBlocks(this);
        boolean flag;
        if(playerbase == null)
        {
            flag = player.localPushOutOfBlocks(d, d1, d2);
        } else
        if(playerbase != this)
        {
            flag = playerbase.pushOutOfBlocks(d, d1, d2);
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void afterPushOutOfBlocks(double d, double d1, double d2)
    {
    }

    public void beforeRayTrace(double d, float f)
    {
    }

    public MovingObjectPosition rayTrace(double d, float f)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenRayTrace(this);
        MovingObjectPosition movingobjectposition;
        if(playerbase == null)
        {
            movingobjectposition = player.localRayTrace(d, f);
        } else
        if(playerbase != this)
        {
            movingobjectposition = playerbase.rayTrace(d, f);
        } else
        {
            movingobjectposition = null;
        }
        return movingobjectposition;
    }

    public void afterRayTrace(double d, float f)
    {
    }

    public void beforeReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenReadEntityFromNBT(this);
        if(playerbase == null)
        {
            player.localReadEntityFromNBT(nbttagcompound);
        } else
        if(playerbase != this)
        {
            playerbase.readEntityFromNBT(nbttagcompound);
        }
    }

    public void afterReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    public void beforeRespawnPlayer()
    {
    }

    public void respawnPlayer()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenRespawnPlayer(this);
        if(playerbase == null)
        {
            player.localRespawnPlayer();
        } else
        if(playerbase != this)
        {
            playerbase.respawnPlayer();
        }
    }

    public void afterRespawnPlayer()
    {
    }

    public void beforeSendChatMessage(String s)
    {
    }

    public void sendChatMessage(String s)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenSendChatMessage(this);
        if(playerbase == null)
        {
            player.localSendChatMessage(s);
        } else
        if(playerbase != this)
        {
            playerbase.sendChatMessage(s);
        }
    }

    public void afterSendChatMessage(String s)
    {
    }

    public void beforeSetEntityDead()
    {
    }

    public void setEntityDead()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenSetEntityDead(this);
        if(playerbase == null)
        {
            player.localSetEntityDead();
        } else
        if(playerbase != this)
        {
            playerbase.setEntityDead();
        }
    }

    public void afterSetEntityDead()
    {
    }

    public void beforeSleepInBedAt(int i, int j, int k)
    {
    }

    public EnumStatus sleepInBedAt(int i, int j, int k)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenSleepInBedAt(this);
        EnumStatus enumstatus;
        if(playerbase == null)
        {
            enumstatus = player.localSleepInBedAt(i, j, k);
        } else
        if(playerbase != this)
        {
            enumstatus = playerbase.sleepInBedAt(i, j, k);
        } else
        {
            enumstatus = null;
        }
        return enumstatus;
    }

    public void afterSleepInBedAt(int i, int j, int k)
    {
    }

    public void beforeUpdateEntityActionState()
    {
    }

    public void updateEntityActionState()
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenUpdateEntityActionState(this);
        if(playerbase == null)
        {
            player.localUpdateEntityActionState();
        } else
        if(playerbase != this)
        {
            playerbase.updateEntityActionState();
        }
    }

    public void afterUpdateEntityActionState()
    {
    }

    public void beforeWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        PlayerBase playerbase = playerAPI.GetOverwrittenWriteEntityToNBT(this);
        if(playerbase == null)
        {
            player.localWriteEntityToNBT(nbttagcompound);
        } else
        if(playerbase != this)
        {
            playerbase.writeEntityToNBT(nbttagcompound);
        }
    }

    public void afterWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }
}
