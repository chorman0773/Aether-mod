// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            EntityPlayer, PlayerAPI, MouseFilter, Session, 
//            World, GuiScreen, GuiChest, GuiDispenser, 
//            GuiEditSign, GuiFurnace, GuiCrafting, PlayerCapabilities, 
//            ItemStack, Item, InventoryPlayer, MovementInput, 
//            PlayerController, AchievementList, StatFileWriter, GuiAchievement, 
//            SoundManager, Potion, PotionEffect, AxisAlignedBB, 
//            FoodStats, MathHelper, MovingObjectPosition, NBTTagCompound, 
//            EnumStatus, GuiWinGame, DamageSource, GuiEnchantment, 
//            EntityCrit2FX, EffectRenderer, GuiIngame, EntityPickupFX, 
//            StatBase, Achievement, GuiBrewingStand, PlayerBase, 
//            Entity, Block, IInventory, TileEntityDispenser, 
//            TileEntitySign, TileEntityFurnace, Material, EntityLiving, 
//            TileEntityBrewingStand, DataWatcher

public class EntityPlayerSP extends EntityPlayer
{

    public MovementInput movementInput;
    protected Minecraft mc;
    protected int sprintToggleTimer;
    public int sprintingTicksLeft;
    public float renderArmYaw;
    public float renderArmPitch;
    public float prevRenderArmYaw;
    public float prevRenderArmPitch;
    private MouseFilter field_21903_bJ;
    private MouseFilter field_21904_bK;
    private MouseFilter field_21902_bL;
    protected final PlayerAPI playerAPI = PlayerAPI.create(this);

    public EntityPlayerSP(Minecraft minecraft, World world, Session session, int i)
    {
        super(world);
        sprintToggleTimer = 0;
        sprintingTicksLeft = 0;
        field_21903_bJ = new MouseFilter();
        field_21904_bK = new MouseFilter();
        field_21902_bL = new MouseFilter();
        PlayerAPI.beforeLocalConstructing(this, minecraft, world, session, i);
        mc = minecraft;
        dimension = i;
        if(session != null && session.username != null && session.username.length() > 0)
        {
            skinUrl = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftSkins/").append(session.username).append(".png").toString();
        }
        username = session.username;
        PlayerAPI.afterLocalConstructing(this, minecraft, world, session, i);
    }

    public final PlayerBase getPlayerBase(String s)
    {
        if(playerAPI != null)
        {
            return playerAPI.getPlayerBase(s);
        } else
        {
            return null;
        }
    }

    public final Set getPlayerBaseIds(String s)
    {
        if(playerAPI != null)
        {
            return playerAPI.getPlayerBaseIds();
        } else
        {
            return Collections.emptySet();
        }
    }

    public void addExhaustion(float f)
    {
        if(playerAPI != null && playerAPI.isAddExhaustionModded)
        {
            PlayerAPI.addExhaustion(this, f);
        } else
        {
            super.addExhaustion(f);
        }
    }

    public final void superAddExhaustion(float f)
    {
        super.addExhaustion(f);
    }

    public final void localAddExhaustion(float f)
    {
        super.addExhaustion(f);
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isAttackEntityFromModded)
        {
            flag = PlayerAPI.attackEntityFrom(this, damagesource, i);
        } else
        {
            flag = super.attackEntityFrom(damagesource, i);
        }
        return flag;
    }

    public final boolean superAttackEntityFrom(DamageSource damagesource, int i)
    {
        return super.attackEntityFrom(damagesource, i);
    }

    public final boolean localAttackEntityFrom(DamageSource damagesource, int i)
    {
        return super.attackEntityFrom(damagesource, i);
    }

    public void attackTargetEntityWithCurrentItem(Entity entity)
    {
        if(playerAPI != null && playerAPI.isAttackTargetEntityWithCurrentItemModded)
        {
            PlayerAPI.attackTargetEntityWithCurrentItem(this, entity);
        } else
        {
            super.attackTargetEntityWithCurrentItem(entity);
        }
    }

    public final void superAttackTargetEntityWithCurrentItem(Entity entity)
    {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    public final void localAttackTargetEntityWithCurrentItem(Entity entity)
    {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    public boolean canHarvestBlock(Block block)
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isCanHarvestBlockModded)
        {
            flag = PlayerAPI.canHarvestBlock(this, block);
        } else
        {
            flag = super.canHarvestBlock(block);
        }
        return flag;
    }

    public final boolean superCanHarvestBlock(Block block)
    {
        return super.canHarvestBlock(block);
    }

    public final boolean localCanHarvestBlock(Block block)
    {
        return super.canHarvestBlock(block);
    }

    protected boolean canTriggerWalking()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isCanTriggerWalkingModded)
        {
            flag = PlayerAPI.canTriggerWalking(this);
        } else
        {
            flag = super.canTriggerWalking();
        }
        return flag;
    }

    public final boolean superCanTriggerWalking()
    {
        return super.canTriggerWalking();
    }

    public final boolean localCanTriggerWalking()
    {
        return super.canTriggerWalking();
    }

    public void closeScreen()
    {
        if(playerAPI != null && playerAPI.isCloseScreenModded)
        {
            PlayerAPI.closeScreen(this);
        } else
        {
            localCloseScreen();
        }
    }

    public final void superCloseScreen()
    {
        super.closeScreen();
    }

    public final void localCloseScreen()
    {
        super.closeScreen();
        mc.displayGuiScreen((GuiScreen)null);
    }

    protected void damageEntity(DamageSource damagesource, int i)
    {
        if(playerAPI != null && playerAPI.isDamageEntityModded)
        {
            PlayerAPI.damageEntity(this, damagesource, i);
        } else
        {
            super.damageEntity(damagesource, i);
        }
    }

    public final void superDamageEntity(DamageSource damagesource, int i)
    {
        super.damageEntity(damagesource, i);
    }

    public final void localDamageEntity(DamageSource damagesource, int i)
    {
        super.damageEntity(damagesource, i);
    }

    public void displayGUIChest(IInventory iinventory)
    {
        if(playerAPI != null && playerAPI.isDisplayGUIChestModded)
        {
            PlayerAPI.displayGUIChest(this, iinventory);
        } else
        {
            localDisplayGUIChest(iinventory);
        }
    }

    public final void superDisplayGUIChest(IInventory iinventory)
    {
        super.displayGUIChest(iinventory);
    }

    public final void localDisplayGUIChest(IInventory iinventory)
    {
        mc.displayGuiScreen(new GuiChest(inventory, iinventory));
    }

    public void displayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        if(playerAPI != null && playerAPI.isDisplayGUIDispenserModded)
        {
            PlayerAPI.displayGUIDispenser(this, tileentitydispenser);
        } else
        {
            localDisplayGUIDispenser(tileentitydispenser);
        }
    }

    public final void superDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        super.displayGUIDispenser(tileentitydispenser);
    }

    public final void localDisplayGUIDispenser(TileEntityDispenser tileentitydispenser)
    {
        mc.displayGuiScreen(new GuiDispenser(inventory, tileentitydispenser));
    }

    public void displayGUIEditSign(TileEntitySign tileentitysign)
    {
        if(playerAPI != null && playerAPI.isDisplayGUIEditSignModded)
        {
            PlayerAPI.displayGUIEditSign(this, tileentitysign);
        } else
        {
            localDisplayGUIEditSign(tileentitysign);
        }
    }

    public final void superDisplayGUIEditSign(TileEntitySign tileentitysign)
    {
        super.displayGUIEditSign(tileentitysign);
    }

    public final void localDisplayGUIEditSign(TileEntitySign tileentitysign)
    {
        mc.displayGuiScreen(new GuiEditSign(tileentitysign));
    }

    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        if(playerAPI != null && playerAPI.isDisplayGUIFurnaceModded)
        {
            PlayerAPI.displayGUIFurnace(this, tileentityfurnace);
        } else
        {
            localDisplayGUIFurnace(tileentityfurnace);
        }
    }

    public final void superDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        super.displayGUIFurnace(tileentityfurnace);
    }

    public final void localDisplayGUIFurnace(TileEntityFurnace tileentityfurnace)
    {
        mc.displayGuiScreen(new GuiFurnace(inventory, tileentityfurnace));
    }

    public void displayWorkbenchGUI(int i, int j, int k)
    {
        if(playerAPI != null && playerAPI.isDisplayWorkbenchGUIModded)
        {
            PlayerAPI.displayWorkbenchGUI(this, i, j, k);
        } else
        {
            localDisplayWorkbenchGUI(i, j, k);
        }
    }

    public final void superDisplayWorkbenchGUI(int i, int j, int k)
    {
        super.displayWorkbenchGUI(i, j, k);
    }

    public final void localDisplayWorkbenchGUI(int i, int j, int k)
    {
        mc.displayGuiScreen(new GuiCrafting(inventory, worldObj, i, j, k));
    }

    public void dropCurrentItem()
    {
        if(playerAPI != null && playerAPI.isDropCurrentItemModded)
        {
            PlayerAPI.dropCurrentItem(this);
        } else
        {
            super.dropCurrentItem();
        }
    }

    public final void superDropCurrentItem()
    {
        super.dropCurrentItem();
    }

    public final void localDropCurrentItem()
    {
        super.dropCurrentItem();
    }

    public void dropPlayerItem(ItemStack itemstack)
    {
        if(playerAPI != null && playerAPI.isDropPlayerItemModded)
        {
            PlayerAPI.dropPlayerItem(this, itemstack);
        } else
        {
            super.dropPlayerItem(itemstack);
        }
    }

    public final void superDropPlayerItem(ItemStack itemstack)
    {
        super.dropPlayerItem(itemstack);
    }

    public final void localDropPlayerItem(ItemStack itemstack)
    {
        super.dropPlayerItem(itemstack);
    }

    public void dropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
        if(playerAPI != null && playerAPI.isDropPlayerItemWithRandomChoiceModded)
        {
            PlayerAPI.dropPlayerItemWithRandomChoice(this, itemstack, flag);
        } else
        {
            super.dropPlayerItemWithRandomChoice(itemstack, flag);
        }
    }

    public final void superDropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
        super.dropPlayerItemWithRandomChoice(itemstack, flag);
    }

    public final void localDropPlayerItemWithRandomChoice(ItemStack itemstack, boolean flag)
    {
        super.dropPlayerItemWithRandomChoice(itemstack, flag);
    }

    protected void fall(float f)
    {
        if(playerAPI != null && playerAPI.isFallModded)
        {
            PlayerAPI.fall(this, f);
        } else
        {
            super.fall(f);
        }
    }

    public final void superFall(float f)
    {
        super.fall(f);
    }

    public final void localFall(float f)
    {
        super.fall(f);
    }

    public float getCurrentPlayerStrVsBlock(Block block)
    {
        float f;
        if(playerAPI != null && playerAPI.isGetCurrentPlayerStrVsBlockModded)
        {
            f = PlayerAPI.getCurrentPlayerStrVsBlock(this, block);
        } else
        {
            f = super.getCurrentPlayerStrVsBlock(block);
        }
        return f;
    }

    public final float superGetCurrentPlayerStrVsBlock(Block block)
    {
        return super.getCurrentPlayerStrVsBlock(block);
    }

    public final float localGetCurrentPlayerStrVsBlock(Block block)
    {
        return super.getCurrentPlayerStrVsBlock(block);
    }

    public double getDistanceSq(double d, double d1, double d2)
    {
        double d3;
        if(playerAPI != null && playerAPI.isGetDistanceSqModded)
        {
            d3 = PlayerAPI.getDistanceSq(this, d, d1, d2);
        } else
        {
            d3 = super.getDistanceSq(d, d1, d2);
        }
        return d3;
    }

    public final double superGetDistanceSq(double d, double d1, double d2)
    {
        return super.getDistanceSq(d, d1, d2);
    }

    public final double localGetDistanceSq(double d, double d1, double d2)
    {
        return super.getDistanceSq(d, d1, d2);
    }

    public double getDistanceSqToEntity(Entity entity)
    {
        double d;
        if(playerAPI != null && playerAPI.isGetDistanceSqToEntityModded)
        {
            d = PlayerAPI.getDistanceSqToEntity(this, entity);
        } else
        {
            d = super.getDistanceSqToEntity(entity);
        }
        return d;
    }

    public final double superGetDistanceSqToEntity(Entity entity)
    {
        return super.getDistanceSqToEntity(entity);
    }

    public final double localGetDistanceSqToEntity(Entity entity)
    {
        return super.getDistanceSqToEntity(entity);
    }

    public float getEntityBrightness(float f)
    {
        float f1;
        if(playerAPI != null && playerAPI.isGetEntityBrightnessModded)
        {
            f1 = PlayerAPI.getEntityBrightness(this, f);
        } else
        {
            f1 = super.getEntityBrightness(f);
        }
        return f1;
    }

    public final float superGetEntityBrightness(float f)
    {
        return super.getEntityBrightness(f);
    }

    public final float localGetEntityBrightness(float f)
    {
        return super.getEntityBrightness(f);
    }

    public int getEntityBrightnessForRender(float f)
    {
        int i;
        if(playerAPI != null && playerAPI.isGetEntityBrightnessForRenderModded)
        {
            i = PlayerAPI.getEntityBrightnessForRender(this, f);
        } else
        {
            i = super.getEntityBrightnessForRender(f);
        }
        return i;
    }

    public final int superGetEntityBrightnessForRender(float f)
    {
        return super.getEntityBrightnessForRender(f);
    }

    public final int localGetEntityBrightnessForRender(float f)
    {
        return super.getEntityBrightnessForRender(f);
    }

    public float getFOVMultiplier()
    {
        float f;
        if(playerAPI != null && playerAPI.isGetFOVMultiplierModded)
        {
            f = PlayerAPI.getFOVMultiplier(this);
        } else
        {
            f = localGetFOVMultiplier();
        }
        return f;
    }

    public final float localGetFOVMultiplier()
    {
        float f = 1.0F;
        if(capabilities.isFlying)
        {
            f *= 1.1F;
        }
        f *= ((landMovementFactor * getSpeedModifier()) / speedOnGround + 1.0F) / 2.0F;
        if(isUsingItem() && getItemInUse().itemID == Item.bow.shiftedIndex)
        {
            int i = getItemInUseDuration();
            float f1 = (float)i / 20F;
            if(f1 > 1.0F)
            {
                f1 = 1.0F;
            } else
            {
                f1 *= f1;
            }
            f *= 1.0F - f1 * 0.15F;
        }
        return f;
    }

    protected String getHurtSound()
    {
        String s;
        if(playerAPI != null && playerAPI.isGetHurtSoundModded)
        {
            s = PlayerAPI.getHurtSound(this);
        } else
        {
            s = super.getHurtSound();
        }
        return s;
    }

    public final String superGetHurtSound()
    {
        return super.getHurtSound();
    }

    public final String localGetHurtSound()
    {
        return super.getHurtSound();
    }

    public int getPlayerArmorValue()
    {
        int i;
        if(playerAPI != null && playerAPI.isGetPlayerArmorValueModded)
        {
            i = PlayerAPI.getPlayerArmorValue(this);
        } else
        {
            i = localGetPlayerArmorValue();
        }
        return i;
    }

    public final int localGetPlayerArmorValue()
    {
        return inventory.getTotalArmorValue();
    }

    public boolean handleLavaMovement()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isHandleLavaMovementModded)
        {
            flag = PlayerAPI.handleLavaMovement(this);
        } else
        {
            flag = super.handleLavaMovement();
        }
        return flag;
    }

    public final boolean superHandleLavaMovement()
    {
        return super.handleLavaMovement();
    }

    public final boolean localHandleLavaMovement()
    {
        return super.handleLavaMovement();
    }

    public boolean handleWaterMovement()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isHandleWaterMovementModded)
        {
            flag = PlayerAPI.handleWaterMovement(this);
        } else
        {
            flag = super.handleWaterMovement();
        }
        return flag;
    }

    public final boolean superHandleWaterMovement()
    {
        return super.handleWaterMovement();
    }

    public final boolean localHandleWaterMovement()
    {
        return super.handleWaterMovement();
    }

    public void heal(int i)
    {
        if(playerAPI != null && playerAPI.isHealModded)
        {
            PlayerAPI.heal(this, i);
        } else
        {
            super.heal(i);
        }
    }

    public final void superHeal(int i)
    {
        super.heal(i);
    }

    public final void localHeal(int i)
    {
        super.heal(i);
    }

    public boolean isEntityInsideOpaqueBlock()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isIsEntityInsideOpaqueBlockModded)
        {
            flag = PlayerAPI.isEntityInsideOpaqueBlock(this);
        } else
        {
            flag = super.isEntityInsideOpaqueBlock();
        }
        return flag;
    }

    public final boolean superIsEntityInsideOpaqueBlock()
    {
        return super.isEntityInsideOpaqueBlock();
    }

    public final boolean localIsEntityInsideOpaqueBlock()
    {
        return super.isEntityInsideOpaqueBlock();
    }

    public boolean isInWater()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isIsInWaterModded)
        {
            flag = PlayerAPI.isInWater(this);
        } else
        {
            flag = super.isInWater();
        }
        return flag;
    }

    public final boolean superIsInWater()
    {
        return super.isInWater();
    }

    public final boolean localIsInWater()
    {
        return super.isInWater();
    }

    public boolean isInsideOfMaterial(Material material)
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isIsInsideOfMaterialModded)
        {
            flag = PlayerAPI.isInsideOfMaterial(this, material);
        } else
        {
            flag = super.isInsideOfMaterial(material);
        }
        return flag;
    }

    public final boolean superIsInsideOfMaterial(Material material)
    {
        return super.isInsideOfMaterial(material);
    }

    public final boolean localIsInsideOfMaterial(Material material)
    {
        return super.isInsideOfMaterial(material);
    }

    public boolean isOnLadder()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isIsOnLadderModded)
        {
            flag = PlayerAPI.isOnLadder(this);
        } else
        {
            flag = super.isOnLadder();
        }
        return flag;
    }

    public final boolean superIsOnLadder()
    {
        return super.isOnLadder();
    }

    public final boolean localIsOnLadder()
    {
        return super.isOnLadder();
    }

    public boolean isSneaking()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isIsSneakingModded)
        {
            flag = PlayerAPI.isSneaking(this);
        } else
        {
            flag = localIsSneaking();
        }
        return flag;
    }

    public final boolean superIsSneaking()
    {
        return super.isSneaking();
    }

    public final boolean localIsSneaking()
    {
        return movementInput.sneak && !sleeping;
    }

    public boolean isSprinting()
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isIsSprintingModded)
        {
            flag = PlayerAPI.isSprinting(this);
        } else
        {
            flag = super.isSprinting();
        }
        return flag;
    }

    public final boolean superIsSprinting()
    {
        return super.isSprinting();
    }

    public final boolean localIsSprinting()
    {
        return super.isSprinting();
    }

    protected void jump()
    {
        if(playerAPI != null && playerAPI.isJumpModded)
        {
            PlayerAPI.jump(this);
        } else
        {
            super.jump();
        }
    }

    public final void superJump()
    {
        super.jump();
    }

    public final void localJump()
    {
        super.jump();
    }

    public void moveEntity(double d, double d1, double d2)
    {
        if(playerAPI != null && playerAPI.isMoveEntityModded)
        {
            PlayerAPI.moveEntity(this, d, d1, d2);
        } else
        {
            localMoveEntity(d, d1, d2);
        }
    }

    public final void superMoveEntity(double d, double d1, double d2)
    {
        super.moveEntity(d, d1, d2);
    }

    public final void localMoveEntity(double d, double d1, double d2)
    {
        super.moveEntity(d, d1, d2);
    }

    public void moveEntityWithHeading(float f, float f1)
    {
        if(playerAPI != null && playerAPI.isMoveEntityWithHeadingModded)
        {
            PlayerAPI.moveEntityWithHeading(this, f, f1);
        } else
        {
            super.moveEntityWithHeading(f, f1);
        }
    }

    public final void superMoveEntityWithHeading(float f, float f1)
    {
        super.moveEntityWithHeading(f, f1);
    }

    public final void localMoveEntityWithHeading(float f, float f1)
    {
        super.moveEntityWithHeading(f, f1);
    }

    public void moveFlying(float f, float f1, float f2)
    {
        if(playerAPI != null && playerAPI.isMoveFlyingModded)
        {
            PlayerAPI.moveFlying(this, f, f1, f2);
        } else
        {
            super.moveFlying(f, f1, f2);
        }
    }

    public final void superMoveFlying(float f, float f1, float f2)
    {
        super.moveFlying(f, f1, f2);
    }

    public final void localMoveFlying(float f, float f1, float f2)
    {
        super.moveFlying(f, f1, f2);
    }

    public void onDeath(DamageSource damagesource)
    {
        if(playerAPI != null && playerAPI.isOnDeathModded)
        {
            PlayerAPI.onDeath(this, damagesource);
        } else
        {
            super.onDeath(damagesource);
        }
    }

    public final void superOnDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);
    }

    public final void localOnDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);
    }

    public void onLivingUpdate()
    {
        if(playerAPI != null && playerAPI.isOnLivingUpdateModded)
        {
            PlayerAPI.onLivingUpdate(this);
        } else
        {
            localOnLivingUpdate();
        }
    }

    public final void superOnLivingUpdate()
    {
        super.onLivingUpdate();
    }

    public final void localOnLivingUpdate()
    {
        if(sprintingTicksLeft > 0)
        {
            sprintingTicksLeft--;
            if(sprintingTicksLeft == 0)
            {
                setSprinting(false);
            }
        }
        if(sprintToggleTimer > 0)
        {
            sprintToggleTimer--;
        }
        if(mc.playerController.func_35643_e())
        {
            posX = posZ = 0.5D;
            posX = 0.0D;
            posZ = 0.0D;
            rotationYaw = (float)ticksExisted / 12F;
            rotationPitch = 10F;
            posY = 68.5D;
            return;
        }
        if(!mc.statFileWriter.hasAchievementUnlocked(AchievementList.openInventory))
        {
            mc.guiAchievement.queueAchievementInformation(AchievementList.openInventory);
        }
        prevTimeInPortal = timeInPortal;
        if(inPortal)
        {
            if(!worldObj.multiplayerWorld && ridingEntity != null)
            {
                mountEntity(null);
            }
            if(mc.currentScreen != null)
            {
                mc.displayGuiScreen((GuiScreen)null);
            }
            if(timeInPortal == 0.0F)
            {
                mc.sndManager.playSoundFX("portal.trigger", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
            }
            timeInPortal += 0.0125F;
            if(timeInPortal >= 1.0F)
            {
                timeInPortal = 1.0F;
                if(!worldObj.multiplayerWorld)
                {
                    timeUntilPortal = 10;
                    mc.sndManager.playSoundFX("portal.travel", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
                    byte byte0 = 0;
                    if(dimension == -1)
                    {
                        byte0 = 0;
                    } else
                    {
                        byte0 = -1;
                    }
                    mc.usePortal(byte0);
                    triggerAchievement(AchievementList.portal);
                }
            }
            inPortal = false;
        } else
        if(isPotionActive(Potion.potionConfusion) && getActivePotionEffect(Potion.potionConfusion).getDuration() > 60)
        {
            timeInPortal += 0.006666667F;
            if(timeInPortal > 1.0F)
            {
                timeInPortal = 1.0F;
            }
        } else
        {
            if(timeInPortal > 0.0F)
            {
                timeInPortal -= 0.05F;
            }
            if(timeInPortal < 0.0F)
            {
                timeInPortal = 0.0F;
            }
        }
        if(timeUntilPortal > 0)
        {
            timeUntilPortal--;
        }
        boolean flag = movementInput.jump;
        float f = 0.8F;
        boolean flag1 = movementInput.moveForward >= f;
        movementInput.updatePlayerMoveState(this);
        if(isUsingItem())
        {
            movementInput.moveStrafe *= 0.2F;
            movementInput.moveForward *= 0.2F;
            sprintToggleTimer = 0;
        }
        if(movementInput.sneak && ySize < 0.2F)
        {
            ySize = 0.2F;
        }
        pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ + (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX - (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ - (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ - (double)width * 0.34999999999999998D);
        pushOutOfBlocks(posX + (double)width * 0.34999999999999998D, boundingBox.minY + 0.5D, posZ + (double)width * 0.34999999999999998D);
        boolean flag2 = (float)getFoodStats().getFoodLevel() > 6F;
        if(onGround && !flag1 && movementInput.moveForward >= f && !isSprinting() && flag2 && !isUsingItem() && !isPotionActive(Potion.potionBlindness))
        {
            if(sprintToggleTimer == 0)
            {
                sprintToggleTimer = 7;
            } else
            {
                setSprinting(true);
                sprintToggleTimer = 0;
            }
        }
        if(isSneaking())
        {
            sprintToggleTimer = 0;
        }
        if(isSprinting() && (movementInput.moveForward < f || isCollidedHorizontally || !flag2))
        {
            setSprinting(false);
        }
        if(capabilities.allowFlying && !flag && movementInput.jump)
        {
            if(flyToggleTimer == 0)
            {
                flyToggleTimer = 7;
            } else
            {
                capabilities.isFlying = !capabilities.isFlying;
                flyToggleTimer = 0;
            }
        }
        if(capabilities.isFlying)
        {
            if(movementInput.sneak)
            {
                motionY -= 0.14999999999999999D;
            }
            if(movementInput.jump)
            {
                motionY += 0.14999999999999999D;
            }
        }
        super.onLivingUpdate();
        if(onGround && capabilities.isFlying)
        {
            capabilities.isFlying = false;
        }
    }

    public void onKillEntity(EntityLiving entityliving)
    {
        if(playerAPI != null && playerAPI.isOnKillEntityModded)
        {
            PlayerAPI.onKillEntity(this, entityliving);
        } else
        {
            super.onKillEntity(entityliving);
        }
    }

    public final void superOnKillEntity(EntityLiving entityliving)
    {
        super.onKillEntity(entityliving);
    }

    public final void localOnKillEntity(EntityLiving entityliving)
    {
        super.onKillEntity(entityliving);
    }

    public void onUpdate()
    {
        if(playerAPI != null && playerAPI.isOnUpdateModded)
        {
            PlayerAPI.onUpdate(this);
        } else
        {
            super.onUpdate();
        }
    }

    public final void superOnUpdate()
    {
        super.onUpdate();
    }

    public final void localOnUpdate()
    {
        super.onUpdate();
    }

    protected boolean pushOutOfBlocks(double d, double d1, double d2)
    {
        boolean flag;
        if(playerAPI != null && playerAPI.isPushOutOfBlocksModded)
        {
            flag = PlayerAPI.pushOutOfBlocks(this, d, d1, d2);
        } else
        {
            flag = localPushOutOfBlocks(d, d1, d2);
        }
        return flag;
    }

    public final boolean superPushOutOfBlocks(double d, double d1, double d2)
    {
        return super.pushOutOfBlocks(d, d1, d2);
    }

    public final boolean localPushOutOfBlocks(double d, double d1, double d2)
    {
        int i = MathHelper.floor_double(d);
        int j = MathHelper.floor_double(d1);
        int k = MathHelper.floor_double(d2);
        double d3 = d - (double)i;
        double d4 = d2 - (double)k;
        if(isBlockTranslucent(i, j, k) || isBlockTranslucent(i, j + 1, k))
        {
            boolean flag = !isBlockTranslucent(i - 1, j, k) && !isBlockTranslucent(i - 1, j + 1, k);
            boolean flag1 = !isBlockTranslucent(i + 1, j, k) && !isBlockTranslucent(i + 1, j + 1, k);
            boolean flag2 = !isBlockTranslucent(i, j, k - 1) && !isBlockTranslucent(i, j + 1, k - 1);
            boolean flag3 = !isBlockTranslucent(i, j, k + 1) && !isBlockTranslucent(i, j + 1, k + 1);
            byte byte0 = -1;
            double d5 = 9999D;
            if(flag && d3 < d5)
            {
                d5 = d3;
                byte0 = 0;
            }
            if(flag1 && 1.0D - d3 < d5)
            {
                d5 = 1.0D - d3;
                byte0 = 1;
            }
            if(flag2 && d4 < d5)
            {
                d5 = d4;
                byte0 = 4;
            }
            if(flag3 && 1.0D - d4 < d5)
            {
                double d6 = 1.0D - d4;
                byte0 = 5;
            }
            float f = 0.1F;
            if(byte0 == 0)
            {
                motionX = -f;
            }
            if(byte0 == 1)
            {
                motionX = f;
            }
            if(byte0 == 4)
            {
                motionZ = -f;
            }
            if(byte0 == 5)
            {
                motionZ = f;
            }
        }
        return false;
    }

    public MovingObjectPosition rayTrace(double d, float f)
    {
        MovingObjectPosition movingobjectposition;
        if(playerAPI != null && playerAPI.isRayTraceModded)
        {
            movingobjectposition = PlayerAPI.rayTrace(this, d, f);
        } else
        {
            movingobjectposition = super.rayTrace(d, f);
        }
        return movingobjectposition;
    }

    public final MovingObjectPosition superRayTrace(double d, float f)
    {
        return super.rayTrace(d, f);
    }

    public final MovingObjectPosition localRayTrace(double d, float f)
    {
        return super.rayTrace(d, f);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        if(playerAPI != null && playerAPI.isReadEntityFromNBTModded)
        {
            PlayerAPI.readEntityFromNBT(this, nbttagcompound);
        } else
        {
            localReadEntityFromNBT(nbttagcompound);
        }
    }

    public final void superReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    public final void localReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        score = nbttagcompound.getInteger("Score");
    }

    public void respawnPlayer()
    {
        if(playerAPI != null && playerAPI.isRespawnPlayerModded)
        {
            PlayerAPI.respawnPlayer(this);
        } else
        {
            localRespawnPlayer();
        }
    }

    public final void superRespawnPlayer()
    {
        super.respawnPlayer();
    }

    public final void localRespawnPlayer()
    {
        mc.respawn(false, 0, false);
    }

    public void sendChatMessage(String s)
    {
        if(playerAPI != null && playerAPI.isSendChatMessageModded)
        {
            PlayerAPI.sendChatMessage(this, s);
        } else
        {
            localSendChatMessage(s);
        }
    }

    public final void localSendChatMessage(String s)
    {
    }

    public void setEntityDead()
    {
        if(playerAPI != null && playerAPI.isSetEntityDeadModded)
        {
            PlayerAPI.setEntityDead(this);
        } else
        {
            super.setEntityDead();
        }
    }

    public final void superSetEntityDead()
    {
        super.setEntityDead();
    }

    public final void localSetEntityDead()
    {
        super.setEntityDead();
    }

    public EnumStatus sleepInBedAt(int i, int j, int k)
    {
        EnumStatus enumstatus;
        if(playerAPI != null && playerAPI.isSleepInBedAtModded)
        {
            enumstatus = PlayerAPI.sleepInBedAt(this, i, j, k);
        } else
        {
            enumstatus = super.sleepInBedAt(i, j, k);
        }
        return enumstatus;
    }

    public final EnumStatus superSleepInBedAt(int i, int j, int k)
    {
        return super.sleepInBedAt(i, j, k);
    }

    public final EnumStatus localSleepInBedAt(int i, int j, int k)
    {
        return super.sleepInBedAt(i, j, k);
    }

    public void updateEntityActionState()
    {
        if(playerAPI != null && playerAPI.isUpdateEntityActionStateModded)
        {
            PlayerAPI.updateEntityActionState(this);
        } else
        {
            localUpdateEntityActionState();
        }
    }

    public final void superUpdateEntityActionState()
    {
        super.updateEntityActionState();
    }

    public final void localUpdateEntityActionState()
    {
        super.updateEntityActionState();
        moveStrafing = movementInput.moveStrafe;
        moveForward = movementInput.moveForward;
        isJumping = movementInput.jump;
        prevRenderArmYaw = renderArmYaw;
        prevRenderArmPitch = renderArmPitch;
        renderArmPitch = (float)((double)renderArmPitch + (double)(rotationPitch - renderArmPitch) * 0.5D);
        renderArmYaw = (float)((double)renderArmYaw + (double)(rotationYaw - renderArmYaw) * 0.5D);
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        if(playerAPI != null && playerAPI.isWriteEntityToNBTModded)
        {
            PlayerAPI.writeEntityToNBT(this, nbttagcompound);
        } else
        {
            localWriteEntityToNBT(nbttagcompound);
        }
    }

    public final void superWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public final void localWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Score", score);
    }

    public void func_6420_o()
    {
    }

    public void func_40182_b(int i)
    {
        if(!worldObj.multiplayerWorld)
        {
            if(dimension == 1 && i == 1)
            {
                triggerAchievement(AchievementList.theEnd2);
                mc.displayGuiScreen(new GuiWinGame());
            } else
            {
                triggerAchievement(AchievementList.theEnd);
                mc.sndManager.playSoundFX("portal.travel", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
                mc.usePortal(1);
            }
        }
    }

    public void setHealth(int i)
    {
        int j = getEntityHealth() - i;
        if(j <= 0)
        {
            setEntityHealth(i);
            if(j < 0)
            {
                heartsLife = heartsHalvesLife / 2;
            }
        } else
        {
            naturalArmorRating = j;
            setEntityHealth(getEntityHealth());
            heartsLife = heartsHalvesLife;
            damageEntity(DamageSource.generic, j);
            hurtTime = maxHurtTime = 10;
        }
    }

    public void func_40181_c(int i, int j, int k)
    {
        mc.displayGuiScreen(new GuiEnchantment(inventory, worldObj, i, j, k));
    }

    public void func_40183_c(Entity entity)
    {
        EntityCrit2FX entitycrit2fx = new EntityCrit2FX(mc.theWorld, entity, "magicCrit");
        mc.effectRenderer.addEffect(entitycrit2fx);
    }

    public void addChatMessage(String s)
    {
        mc.ingameGUI.addChatMessageTranslate(s);
    }

    public void onCriticalHit(Entity entity)
    {
        mc.effectRenderer.addEffect(new EntityCrit2FX(mc.theWorld, entity));
    }

    public void onItemPickup(Entity entity, int i)
    {
        mc.effectRenderer.addEffect(new EntityPickupFX(mc.theWorld, entity, this, -0.5F));
    }

    public void setSprinting(boolean flag)
    {
        super.setSprinting(flag);
        if(!flag)
        {
            sprintingTicksLeft = 0;
        } else
        {
            sprintingTicksLeft = 600;
        }
    }

    public void addStat(StatBase statbase, int i)
    {
        if(statbase == null)
        {
            return;
        }
        if(statbase.isAchievement())
        {
            Achievement achievement = (Achievement)statbase;
            if(achievement.parentAchievement == null || mc.statFileWriter.hasAchievementUnlocked(achievement.parentAchievement))
            {
                if(!mc.statFileWriter.hasAchievementUnlocked(achievement))
                {
                    mc.guiAchievement.queueTakenAchievement(achievement);
                }
                mc.statFileWriter.readStat(statbase, i);
            }
        } else
        {
            mc.statFileWriter.readStat(statbase, i);
        }
    }

    public void func_40180_a(TileEntityBrewingStand tileentitybrewingstand)
    {
        mc.displayGuiScreen(new GuiBrewingStand(inventory, tileentitybrewingstand));
    }

    public void setXPStats(float f, int i, int j)
    {
        currentXP = f;
        totalXP = i;
        playerLevel = j;
    }

    private boolean isBlockTranslucent(int i, int j, int k)
    {
        return worldObj.isBlockNormalCube(i, j, k);
    }

    public final MouseFilter getField_21904_bKField()
    {
        return field_21904_bK;
    }

    public final void setField_21904_bKField(MouseFilter mousefilter)
    {
        field_21904_bK = mousefilter;
    }

    public final boolean getUnused_flagField()
    {
        return unused_flag;
    }

    public final void setUnused_flagField(boolean flag)
    {
        unused_flag = flag;
    }

    public final MouseFilter getField_21903_bJField()
    {
        return field_21903_bJ;
    }

    public final void setField_21903_bJField(MouseFilter mousefilter)
    {
        field_21903_bJ = mousefilter;
    }

    public final double getNewRotationYawField()
    {
        return newRotationYaw;
    }

    public final void setNewRotationYawField(double d)
    {
        newRotationYaw = d;
    }

    public final float getField_9349_DField()
    {
        return field_9349_D;
    }

    public final void setField_9349_DField(float f)
    {
        field_9349_D = f;
    }

    public final float getRandomYawVelocityField()
    {
        return randomYawVelocity;
    }

    public final void setRandomYawVelocityField(float f)
    {
        randomYawVelocity = f;
    }

    public final float getSpeedInAirField()
    {
        return speedInAir;
    }

    public final void setSpeedInAirField(float f)
    {
        speedInAir = f;
    }

    public final boolean getField_9358_yField()
    {
        return field_9358_y;
    }

    public final void setField_9358_yField(boolean flag)
    {
        field_9358_y = flag;
    }

    public final int getSprintToggleTimerField()
    {
        return sprintToggleTimer;
    }

    public final void setSprintToggleTimerField(int i)
    {
        sprintToggleTimer = i;
    }

    public final int getNewPosRotationIncrementsField()
    {
        return newPosRotationIncrements;
    }

    public final void setNewPosRotationIncrementsField(int i)
    {
        newPosRotationIncrements = i;
    }

    public final String getTextureField()
    {
        return texture;
    }

    public final void setTextureField(String s)
    {
        texture = s;
    }

    public final int getNaturalArmorRatingField()
    {
        return naturalArmorRating;
    }

    public final void setNaturalArmorRatingField(int i)
    {
        naturalArmorRating = i;
    }

    public final boolean getIsImmuneToFireField()
    {
        return isImmuneToFire;
    }

    public final void setIsImmuneToFireField(boolean flag)
    {
        isImmuneToFire = flag;
    }

    public final float getMoveSpeedField()
    {
        return moveSpeed;
    }

    public final void setMoveSpeedField(float f)
    {
        moveSpeed = f;
    }

    public final int getField_40129_bAField()
    {
        return carryoverDamage;
    }

    public final void setField_40129_bAField(int i)
    {
        carryoverDamage = i;
    }

    public final float getField_9362_uField()
    {
        return field_9362_u;
    }

    public final void setField_9362_uField(float f)
    {
        field_9362_u = f;
    }

    public final int getFlyToggleTimerField()
    {
        return flyToggleTimer;
    }

    public final void setFlyToggleTimerField(int i)
    {
        flyToggleTimer = i;
    }

    public final int getField_34905_cField()
    {
        return field_34905_c;
    }

    public final void setField_34905_cField(int i)
    {
        field_34905_c = i;
    }

    public final double getNewPosZField()
    {
        return newPosZ;
    }

    public final void setNewPosZField(double d)
    {
        newPosZ = d;
    }

    public final boolean getInWaterField()
    {
        return inWater;
    }

    public final void setInWaterField(boolean flag)
    {
        inWater = flag;
    }

    public final String getEntityTypeField()
    {
        return entityType;
    }

    public final void setEntityTypeField(String s)
    {
        entityType = s;
    }

    public final float getMoveForwardField()
    {
        return moveForward;
    }

    public final void setMoveForwardField(float f)
    {
        moveForward = f;
    }

    public final float getSpeedOnGroundField()
    {
        return speedOnGround;
    }

    public final void setSpeedOnGroundField(float f)
    {
        speedOnGround = f;
    }

    public final boolean getIsInWebField()
    {
        return isInWeb;
    }

    public final void setIsInWebField(boolean flag)
    {
        isInWeb = flag;
    }

    public final float getField_9359_xField()
    {
        return field_9359_x;
    }

    public final void setField_9359_xField(float f)
    {
        field_9359_x = f;
    }

    public final Minecraft getMcField()
    {
        return mc;
    }

    public final void setMcField(Minecraft minecraft)
    {
        mc = minecraft;
    }

    public final HashMap getActivePotionsMapField()
    {
        return activePotionsMap;
    }

    public final void setActivePotionsMapField(HashMap hashmap)
    {
        activePotionsMap = hashmap;
    }

    public final boolean getSleepingField()
    {
        return sleeping;
    }

    public final void setSleepingField(boolean flag)
    {
        sleeping = flag;
    }

    public final float getField_9348_aeField()
    {
        return field_9348_ae;
    }

    public final void setField_9348_aeField(float f)
    {
        field_9348_ae = f;
    }

    public final float getField_9345_FField()
    {
        return field_9345_F;
    }

    public final void setField_9345_FField(float f)
    {
        field_9345_F = f;
    }

    public final float getDefaultPitchField()
    {
        return defaultPitch;
    }

    public final void setDefaultPitchField(float f)
    {
        defaultPitch = f;
    }

    public final FoodStats getFoodStatsField()
    {
        return foodStats;
    }

    public final void setFoodStatsField(FoodStats foodstats)
    {
        foodStats = foodstats;
    }

    public final EntityPlayer getField_34904_bField()
    {
        return field_34904_b;
    }

    public final void setField_34904_bField(EntityPlayer entityplayer)
    {
        field_34904_b = entityplayer;
    }

    public final double getNewPosYField()
    {
        return newPosY;
    }

    public final void setNewPosYField(double d)
    {
        newPosY = d;
    }

    public final float getField_9353_BField()
    {
        return field_9353_B;
    }

    public final void setField_9353_BField(float f)
    {
        field_9353_B = f;
    }

    public final float getMoveStrafingField()
    {
        return moveStrafing;
    }

    public final void setMoveStrafingField(float f)
    {
        moveStrafing = f;
    }

    public final float getField_9360_wField()
    {
        return field_9360_w;
    }

    public final void setField_9360_wField(float f)
    {
        field_9360_w = f;
    }

    public final MouseFilter getField_21902_bLField()
    {
        return field_21902_bL;
    }

    public final void setField_21902_bLField(MouseFilter mousefilter)
    {
        field_21902_bL = mousefilter;
    }

    public final int getField_35171_bJField()
    {
        return field_35171_bJ;
    }

    public final void setField_35171_bJField(int i)
    {
        field_35171_bJ = i;
    }

    public final double getNewRotationPitchField()
    {
        return newRotationPitch;
    }

    public final void setNewRotationPitchField(double d)
    {
        newRotationPitch = d;
    }

    public final boolean getInPortalField()
    {
        return inPortal;
    }

    public final void setInPortalField(boolean flag)
    {
        inPortal = flag;
    }

    public final int getScoreValueField()
    {
        return scoreValue;
    }

    public final void setScoreValueField(int i)
    {
        scoreValue = i;
    }

    public final boolean getIsJumpingField()
    {
        return isJumping;
    }

    public final void setIsJumpingField(boolean flag)
    {
        isJumping = flag;
    }

    public final int getHealthField()
    {
        return health;
    }

    public final void setHealthField(int i)
    {
        health = i;
    }

    public final Random getRandField()
    {
        return rand;
    }

    public final void setRandField(Random random)
    {
        rand = random;
    }

    public final double getNewPosXField()
    {
        return newPosX;
    }

    public final void setNewPosXField(double d)
    {
        newPosX = d;
    }

    public final boolean getField_9355_AField()
    {
        return field_9355_A;
    }

    public final void setField_9355_AField(boolean flag)
    {
        field_9355_A = flag;
    }

    public final int getEntityAgeField()
    {
        return entityAge;
    }

    public final void setEntityAgeField(int i)
    {
        entityAge = i;
    }

    public final DataWatcher getDataWatcherField()
    {
        return dataWatcher;
    }

    public final void setDataWatcherField(DataWatcher datawatcher)
    {
        dataWatcher = datawatcher;
    }

    public final int getNumTicksToChaseTargetField()
    {
        return numTicksToChaseTarget;
    }

    public final void setNumTicksToChaseTargetField(int i)
    {
        numTicksToChaseTarget = i;
    }

    public final float getField_9361_vField()
    {
        return field_9361_v;
    }

    public final void setField_9361_vField(float f)
    {
        field_9361_v = f;
    }
}
