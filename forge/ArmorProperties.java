// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;


public class ArmorProperties
{

    public int damageRemove;
    public boolean allowRegularComputation;

    public ArmorProperties()
    {
        damageRemove = 0;
        allowRegularComputation = false;
    }

    public ArmorProperties(int i, boolean flag)
    {
        damageRemove = 0;
        allowRegularComputation = false;
        damageRemove = i;
        allowRegularComputation = flag;
    }
}
