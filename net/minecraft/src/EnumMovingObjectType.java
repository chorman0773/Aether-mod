// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumMovingObjectType extends Enum
{

    public static final EnumMovingObjectType TILE;
    public static final EnumMovingObjectType ENTITY;
    private static final EnumMovingObjectType allMovingObjectTypes[];
    private static final EnumMovingObjectType $VALUES[]; /* synthetic field */

    public static EnumMovingObjectType[] values()
    {
        return (EnumMovingObjectType[])$VALUES.clone();
    }

    public static EnumMovingObjectType valueOf(String s)
    {
        return (EnumMovingObjectType)Enum.valueOf(net.minecraft.src.EnumMovingObjectType.class, s);
    }

    private EnumMovingObjectType(String s, int i, String s1, int j)
    {
        super(s, i);
    }

    static 
    {
        TILE = new EnumMovingObjectType("TILE", 0, "TILE", 0);
        ENTITY = new EnumMovingObjectType("ENTITY", 1, "ENTITY", 1);
        $VALUES = (new EnumMovingObjectType[] {
            TILE, ENTITY
        });
        allMovingObjectTypes = (new EnumMovingObjectType[] {
            TILE, ENTITY
        });
    }
}
