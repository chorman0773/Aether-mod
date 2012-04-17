// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;


public class ObjectPair
{

    private Object object1;
    private Object object2;

    public ObjectPair(Object obj, Object obj1)
    {
        object1 = obj;
        object2 = obj1;
    }

    public Object getValue1()
    {
        return object1;
    }

    public Object getValue2()
    {
        return object2;
    }

    public void setValue1(Object obj)
    {
        object1 = obj;
    }

    public void setValue2(Object obj)
    {
        object2 = obj;
    }
}
