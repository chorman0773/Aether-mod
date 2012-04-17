// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumToolMaterial extends Enum
{

    public static final EnumToolMaterial WOOD;
    public static final EnumToolMaterial STONE;
    public static final EnumToolMaterial IRON;
    public static final EnumToolMaterial EMERALD;
    public static final EnumToolMaterial GOLD;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;
    private static final EnumToolMaterial allToolMaterials[];
    private static final EnumToolMaterial $VALUES[]; /* synthetic field */

    public static EnumToolMaterial[] values()
    {
        return (EnumToolMaterial[])$VALUES.clone();
    }

    public static EnumToolMaterial valueOf(String s)
    {
        return (EnumToolMaterial)Enum.valueOf(net.minecraft.src.EnumToolMaterial.class, s);
    }

    private EnumToolMaterial(String s, int i, String s1, int j, int k, int l, float f, 
            int i1, int j1)
    {
        super(s, i);
        harvestLevel = k;
        maxUses = l;
        efficiencyOnProperMaterial = f;
        damageVsEntity = i1;
        enchantability = j1;
    }

    public int getMaxUses()
    {
        return maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return harvestLevel;
    }

    public int getEnchantability()
    {
        return enchantability;
    }

    static 
    {
        WOOD = new EnumToolMaterial("WOOD", 0, "WOOD", 0, 0, 59, 2.0F, 0, 15);
        STONE = new EnumToolMaterial("STONE", 1, "STONE", 1, 1, 131, 4F, 1, 5);
        IRON = new EnumToolMaterial("IRON", 2, "IRON", 2, 2, 250, 6F, 2, 14);
        EMERALD = new EnumToolMaterial("EMERALD", 3, "EMERALD", 3, 3, 1561, 8F, 3, 10);
        GOLD = new EnumToolMaterial("GOLD", 4, "GOLD", 4, 0, 32, 12F, 0, 22);
        $VALUES = (new EnumToolMaterial[] {
            WOOD, STONE, IRON, EMERALD, GOLD
        });
        allToolMaterials = (new EnumToolMaterial[] {
            WOOD, STONE, IRON, EMERALD, GOLD
        });
    }
}
