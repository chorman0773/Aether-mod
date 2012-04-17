// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumElement extends Enum
{

    public static final EnumElement Fire;
    public static final EnumElement Lightning;
    public static final EnumElement Holy;
    private static final EnumElement $VALUES[]; /* synthetic field */

    public static EnumElement[] values()
    {
        return (EnumElement[])$VALUES.clone();
    }

    public static EnumElement valueOf(String s)
    {
        return (EnumElement)Enum.valueOf(net.minecraft.src.EnumElement.class, s);
    }

    private EnumElement(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        Fire = new EnumElement("Fire", 0);
        Lightning = new EnumElement("Lightning", 1);
        Holy = new EnumElement("Holy", 2);
        $VALUES = (new EnumElement[] {
            Fire, Lightning, Holy
        });
    }
}
