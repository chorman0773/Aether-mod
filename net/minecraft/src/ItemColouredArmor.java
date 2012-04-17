// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemArmor, EnumArmorMaterial

public class ItemColouredArmor extends ItemArmor
{

    private int colour;

    public ItemColouredArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k, int l)
    {
        super(i, enumarmormaterial, j, k);
        colour = l;
    }

    public int getColorFromDamage(int i)
    {
        return colour;
    }
}
