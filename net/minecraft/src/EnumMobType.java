// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumMobType extends Enum
{

    public static final EnumMobType everything;
    public static final EnumMobType mobs;
    public static final EnumMobType players;
    private static final EnumMobType allMobTypes[];
    private static final EnumMobType $VALUES[]; /* synthetic field */

    public static EnumMobType[] values()
    {
        return (EnumMobType[])$VALUES.clone();
    }

    public static EnumMobType valueOf(String s)
    {
        return (EnumMobType)Enum.valueOf(net.minecraft.src.EnumMobType.class, s);
    }

    private EnumMobType(String s, int i, String s1, int j)
    {
        super(s, i);
    }

    static 
    {
        everything = new EnumMobType("everything", 0, "everything", 0);
        mobs = new EnumMobType("mobs", 1, "mobs", 1);
        players = new EnumMobType("players", 2, "players", 2);
        $VALUES = (new EnumMobType[] {
            everything, mobs, players
        });
        allMobTypes = (new EnumMobType[] {
            everything, mobs, players
        });
    }
}
