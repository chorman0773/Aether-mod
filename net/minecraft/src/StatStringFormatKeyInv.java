// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            IStatStringFormat, GameSettings, KeyBinding

public class StatStringFormatKeyInv
    implements IStatStringFormat
{

    final Minecraft mc;

    public StatStringFormatKeyInv(Minecraft minecraft)
    {
        mc = minecraft;
    }

    public String formatString(String s)
    {
        return String.format(s, new Object[] {
            GameSettings.getKeyDisplayString(mc.gameSettings.keyBindInventory.keyCode)
        });
    }
}
