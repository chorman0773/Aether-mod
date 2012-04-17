// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ForgeHooks;

// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, ItemStack, Block, 
//            EntityLiving, Entity

public class ItemTool extends Item
{

    private Block blocksEffectiveAgainst[];
    public float efficiencyOnProperMaterial;
    public int damageVsEntity;
    protected EnumToolMaterial toolMaterial;

    protected ItemTool(int i, int j, EnumToolMaterial enumtoolmaterial, Block ablock[])
    {
        super(i);
        efficiencyOnProperMaterial = 4F;
        toolMaterial = enumtoolmaterial;
        blocksEffectiveAgainst = ablock;
        maxStackSize = 1;
        setMaxDamage(enumtoolmaterial.getMaxUses());
        efficiencyOnProperMaterial = enumtoolmaterial.getEfficiencyOnProperMaterial();
        damageVsEntity = j + enumtoolmaterial.getDamageVsEntity();
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i] == block)
            {
                return efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block, int i)
    {
        if(ForgeHooks.isToolEffective(itemstack, block, i))
        {
            return efficiencyOnProperMaterial;
        } else
        {
            return getStrVsBlock(itemstack, block);
        }
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(2, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
}