// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ItemFood, AetherPoison, ItemStack, World, 
//            EntityPlayer

public class ItemPoisonCure extends ItemFood
    implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/aetherItems.png";
    }

    public ItemPoisonCure(int i, int j, boolean flag)
    {
        super(i, j, flag);
    }

    public ItemStack onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(AetherPoison.curePoison())
        {
            itemstack.stackSize--;
            world.playSoundAtEntity(entityplayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        }
        return itemstack;
    }
}
