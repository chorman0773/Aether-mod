// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumOS2 extends Enum
{

    public static final EnumOS2 linux;
    public static final EnumOS2 solaris;
    public static final EnumOS2 windows;
    public static final EnumOS2 macos;
    public static final EnumOS2 unknown;
    private static final EnumOS2 allOSes[];
    private static final EnumOS2 $VALUES[]; /* synthetic field */

    public static EnumOS2[] values()
    {
        return (EnumOS2[])$VALUES.clone();
    }

    public static EnumOS2 valueOf(String s)
    {
        return (EnumOS2)Enum.valueOf(net.minecraft.src.EnumOS2.class, s);
    }

    private EnumOS2(String s, int i, String s1, int j)
    {
        super(s, i);
    }

    static 
    {
        linux = new EnumOS2("linux", 0, "linux", 0);
        solaris = new EnumOS2("solaris", 1, "solaris", 1);
        windows = new EnumOS2("windows", 2, "windows", 2);
        macos = new EnumOS2("macos", 3, "macos", 3);
        unknown = new EnumOS2("unknown", 4, "unknown", 4);
        $VALUES = (new EnumOS2[] {
            linux, solaris, windows, macos, unknown
        });
        allOSes = (new EnumOS2[] {
            linux, solaris, windows, macos, unknown
        });
    }
}
