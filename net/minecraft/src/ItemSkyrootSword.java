// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import forge.ITextureProvider;

// Referenced classes of package net.minecraft.src:
//            ItemSword, EnumToolMaterial

public class ItemSkyrootSword extends ItemSword
    implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/aetherItems.png";
    }

    public ItemSkyrootSword(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
}
