// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            PlayerBase, InventoryAether, ContainerAether, EntityPlayerSP, 
//            World, PlayerAPI, InventoryPlayer, mod_Aether, 
//            GuiMainMenu, DamageSource, EntityLiving, Entity, 
//            GuiScreen, SoundManager, DimensionAether, Potion, 
//            PotionEffect, ItemStack, AetherItems, Item, 
//            NBTTagCompound, NBTTagList, SaveHandler, CompressedStreamTools, 
//            Block

public class PlayerBaseAether extends PlayerBase
{

    public int timeUntilPortal;
    protected boolean inPortal;
    public float timeInPortal;
    public float prevTimeInPortal;
    public int maxHealth;
    public InventoryAether inv;

    public PlayerBaseAether(PlayerAPI playerapi)
    {
        super(playerapi);
        timeUntilPortal = 20;
        inPortal = false;
        maxHealth = 20;
        inv = new InventoryAether(player);
        player.inventorySlots = new ContainerAether(player.inventory, inv, !player.worldObj.multiplayerWorld);
        player.craftingInventory = player.inventorySlots;
        readCustomData();
        mod_Aether.Player = this;
    }

    public void setInPortal()
    {
        if(timeUntilPortal > 0)
        {
            timeUntilPortal = 10;
        } else
        {
            inPortal = true;
        }
    }

    public void increaseMaxHP(int i)
    {
        if(maxHealth <= 40 - i)
        {
            maxHealth += i;
            player.health += i;
        }
    }

    public void heal(int i)
    {
        if(player.health <= 0)
        {
            return;
        }
        player.health += i;
        if(player.health > maxHealth)
        {
            player.health = maxHealth;
        }
        player.heartsLife = player.heartsHalvesLife / 2;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        if(GuiMainMenu.mmactive)
        {
            Entity entity = damagesource.getEntity();
            if(entity != null)
            {
                entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLiving)entity), i);
            }
            return true;
        } else
        {
            return super.attackEntityFrom(damagesource, i);
        }
    }

    public void afterOnUpdate()
    {
        prevTimeInPortal = timeInPortal;
        if(inPortal)
        {
            if(!player.worldObj.multiplayerWorld && player.ridingEntity != null)
            {
                player.mountEntity((Entity)null);
            }
            if(player.mc.currentScreen != null)
            {
                player.mc.displayGuiScreen((GuiScreen)null);
            }
            if(timeInPortal == 0.0F)
            {
                player.mc.sndManager.playSoundFX("portal.trigger", 1.0F, player.rand.nextFloat() * 0.4F + 0.8F);
            }
            timeInPortal += 0.0125F;
            if(timeInPortal >= 1.0F)
            {
                timeInPortal = 1.0F;
                if(!player.worldObj.multiplayerWorld)
                {
                    timeUntilPortal = 10;
                    player.mc.sndManager.playSoundFX("portal.travel", 1.0F, player.rand.nextFloat() * 0.4F + 0.8F);
                    boolean flag = false;
                    mod_Aether.dim.usePortal();
                }
            }
            inPortal = false;
        } else
        if(player.isPotionActive(Potion.potionConfusion) && player.getActivePotionEffect(Potion.potionConfusion).getDuration() > 60)
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
        if(GuiMainMenu.mmactive)
        {
            player.setPosition(player.lastTickPosX, player.lastTickPosY, player.lastTickPosZ);
        }
        if(player.ticksExisted % 400 == 0)
        {
            if(inv.slots[0] != null && inv.slots[0].itemID == AetherItems.ZanitePendant.shiftedIndex)
            {
                inv.slots[0].damageItem(1, player);
                if(inv.slots[0].stackSize < 1)
                {
                    inv.slots[0] = null;
                }
            }
            if(inv.slots[4] != null && inv.slots[4].itemID == AetherItems.ZaniteRing.shiftedIndex)
            {
                inv.slots[4].damageItem(1, player);
                if(inv.slots[4].stackSize < 1)
                {
                    inv.slots[4] = null;
                }
            }
            if(inv.slots[5] != null && inv.slots[5].itemID == AetherItems.ZaniteRing.shiftedIndex)
            {
                inv.slots[5].damageItem(1, player);
                if(inv.slots[5].stackSize < 1)
                {
                    inv.slots[5] = null;
                }
            }
            if(inv.slots[0] != null && inv.slots[0].itemID == AetherItems.IcePendant.shiftedIndex)
            {
                inv.slots[0].damageItem(1, player);
                if(inv.slots[0].stackSize < 1)
                {
                    inv.slots[0] = null;
                }
            }
            if(inv.slots[4] != null && inv.slots[4].itemID == AetherItems.IceRing.shiftedIndex)
            {
                inv.slots[4].damageItem(1, player);
                if(inv.slots[4].stackSize < 1)
                {
                    inv.slots[4] = null;
                }
            }
            if(inv.slots[5] != null && inv.slots[5].itemID == AetherItems.IceRing.shiftedIndex)
            {
                inv.slots[5].damageItem(1, player);
                if(inv.slots[5].stackSize < 1)
                {
                    inv.slots[5] = null;
                }
            }
        }
        if(player.worldObj.difficultySetting == 0 && player.health >= 20 && player.health < maxHealth && player.ticksExisted % 20 == 0)
        {
            player.heal(1);
        }
    }

    public boolean invisible()
    {
        return !player.isSwinging && inv.slots[1] != null && inv.slots[1].itemID == AetherItems.InvisibilityCloak.shiftedIndex;
    }

    public void beforeWriteEntityToNBT(NBTTagCompound nbttagcompound)
    {
        if(!player.worldObj.multiplayerWorld)
        {
            writeCustomData(inv);
        }
    }

    private void writeCustomData(InventoryAether inventoryaether)
    {
        if(player.worldObj.multiplayerWorld)
        {
            return;
        }
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setByte("MaxHealth", (byte)maxHealth);
        nbttagcompound.setTag("Inventory", inventoryaether.writeToNBT(new NBTTagList()));
        try
        {
            File file = new File(((SaveHandler)player.worldObj.saveHandler).getSaveDirectory(), "aether.dat");
            CompressedStreamTools.writeGzippedCompoundToOutputStream(nbttagcompound, new FileOutputStream(file));
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to create player data");
        }
    }

    public void beforeReadEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        if(!player.worldObj.multiplayerWorld)
        {
            readCustomData();
        }
    }

    private void readCustomData()
    {
        if(player.worldObj.multiplayerWorld)
        {
            return;
        }
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        try
        {
            File file = new File(((SaveHandler)player.worldObj.saveHandler).getSaveDirectory(), "aether.dat");
            NBTTagCompound nbttagcompound1 = CompressedStreamTools.loadGzippedCompoundFromOutputStream(new FileInputStream(file));
            maxHealth = nbttagcompound1.getByte("MaxHealth");
            if(maxHealth < 20)
            {
                maxHealth = 20;
            }
            NBTTagList nbttaglist = nbttagcompound1.getTagList("Inventory");
            inv.readFromNBT(nbttaglist);
        }
        catch(IOException ioexception)
        {
            System.out.println("Failed to read player data. Making new");
            maxHealth = 20;
        }
    }

    public void setEntityDead()
    {
        if(GuiMainMenu.mmactive)
        {
            return;
        }
        if(!player.worldObj.multiplayerWorld)
        {
            writeCustomData(new InventoryAether(player));
        }
        super.setEntityDead();
    }

    public double getDistanceSq(double d, double d1, double d2)
    {
        return invisible() ? 1E+040D : super.getDistanceSq(d, d1, d2);
    }

    public boolean isInWater()
    {
        return super.isInWater() && (!wearingNeptuneArmor() || player.isJumping);
    }

    public float getCurrentPlayerStrVsBlock(Block block)
    {
        int i = -1;
        if(inv.slots[0] != null && inv.slots[0].itemID == AetherItems.ZanitePendant.shiftedIndex)
        {
            i = (int)((float)i * (1.0F + (float)inv.slots[0].getItemDamage() / ((float)inv.slots[0].getMaxDamage() * 3F)));
        }
        if(inv.slots[4] != null && inv.slots[4].itemID == AetherItems.ZaniteRing.shiftedIndex)
        {
            i = (int)((float)i * (1.0F + (float)inv.slots[4].getItemDamage() / ((float)inv.slots[4].getMaxDamage() * 3F)));
        }
        if(inv.slots[5] != null && inv.slots[5].itemID == AetherItems.ZaniteRing.shiftedIndex)
        {
            i = (int)((float)i * (1.0F + (float)inv.slots[5].getItemDamage() / ((float)inv.slots[5].getMaxDamage() * 3F)));
        }
        return i != -1 ? i : super.getCurrentPlayerStrVsBlock(block);
    }

    private boolean wearingNeptuneArmor()
    {
        return player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].itemID == AetherItems.NeptuneHelmet.shiftedIndex && player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].itemID == AetherItems.NeptuneChestplate.shiftedIndex && player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].itemID == AetherItems.NeptuneLeggings.shiftedIndex && player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].itemID == AetherItems.NeptuneBoots.shiftedIndex && inv.slots[6] != null && inv.slots[6].itemID == AetherItems.NeptuneGlove.shiftedIndex;
    }
}
