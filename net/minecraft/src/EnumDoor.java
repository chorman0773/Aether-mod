// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumDoor extends Enum
{

    public static final EnumDoor OPENING;
    public static final EnumDoor WOOD_DOOR;
    public static final EnumDoor GRATES;
    public static final EnumDoor IRON_DOOR;
    private static final EnumDoor allDoors[];
    private static final EnumDoor $VALUES[]; /* synthetic field */

    public static EnumDoor[] values()
    {
        return (EnumDoor[])$VALUES.clone();
    }

    public static EnumDoor valueOf(String s)
    {
        return (EnumDoor)Enum.valueOf(net.minecraft.src.EnumDoor.class, s);
    }

    private EnumDoor(String s, int i, String s1, int j)
    {
        super(s, i);
    }

    static 
    {
        OPENING = new EnumDoor("OPENING", 0, "OPENING", 0);
        WOOD_DOOR = new EnumDoor("WOOD_DOOR", 1, "WOOD_DOOR", 1);
        GRATES = new EnumDoor("GRATES", 2, "GRATES", 2);
        IRON_DOOR = new EnumDoor("IRON_DOOR", 3, "IRON_DOOR", 3);
        $VALUES = (new EnumDoor[] {
            OPENING, WOOD_DOOR, GRATES, IRON_DOOR
        });
        allDoors = (new EnumDoor[] {
            OPENING, WOOD_DOOR, GRATES, IRON_DOOR
        });
    }
}
