// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemArmor

public final class EnumArmorMaterial extends Enum
{

    public static final EnumArmorMaterial CLOTH;
    public static final EnumArmorMaterial CHAIN;
    public static final EnumArmorMaterial IRON;
    public static final EnumArmorMaterial GOLD;
    public static final EnumArmorMaterial DIAMOND;
    private int field_40577_f;
    private int field_40578_g[];
    private int enchantability;
    private static final EnumArmorMaterial allArmorMaterials[];
    private static final EnumArmorMaterial $VALUES[]; /* synthetic field */

    public static EnumArmorMaterial[] values()
    {
        return (EnumArmorMaterial[])$VALUES.clone();
    }

    public static EnumArmorMaterial valueOf(String s)
    {
        return (EnumArmorMaterial)Enum.valueOf(net.minecraft.src.EnumArmorMaterial.class, s);
    }

    private EnumArmorMaterial(String s, int i, String s1, int j, int k, int ai[], int l)
    {
        super(s, i);
        field_40577_f = k;
        field_40578_g = ai;
        enchantability = l;
    }

    public int func_40576_a(int i)
    {
        return ItemArmor.func_40436_c()[i] * field_40577_f;
    }

    public int func_40574_b(int i)
    {
        return field_40578_g[i];
    }

    public int getEnchantability()
    {
        return enchantability;
    }

    static 
    {
        CLOTH = new EnumArmorMaterial("CLOTH", 0, "CLOTH", 0, 5, new int[] {
            1, 3, 2, 1
        }, 15);
        CHAIN = new EnumArmorMaterial("CHAIN", 1, "CHAIN", 1, 15, new int[] {
            2, 5, 4, 1
        }, 12);
        IRON = new EnumArmorMaterial("IRON", 2, "IRON", 2, 15, new int[] {
            2, 6, 5, 2
        }, 9);
        GOLD = new EnumArmorMaterial("GOLD", 3, "GOLD", 3, 7, new int[] {
            2, 5, 3, 1
        }, 25);
        DIAMOND = new EnumArmorMaterial("DIAMOND", 4, "DIAMOND", 4, 33, new int[] {
            3, 8, 6, 3
        }, 10);
        $VALUES = (new EnumArmorMaterial[] {
            CLOTH, CHAIN, IRON, GOLD, DIAMOND
        });
        allArmorMaterials = (new EnumArmorMaterial[] {
            CLOTH, CHAIN, IRON, GOLD, DIAMOND
        });
    }
}
