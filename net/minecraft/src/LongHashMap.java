// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            LongHashMapEntry

public class LongHashMap
{

    private transient LongHashMapEntry playerListEntries[];
    private transient int numHashElements;
    private int capacity;
    private final float percent = 0.75F;
    private volatile transient int field_35581_e;

    public LongHashMap()
    {
        capacity = 12;
        playerListEntries = new LongHashMapEntry[16];
    }

    private static int getHashedKey(long l)
    {
        return hash((int)(l ^ l >>> 32));
    }

    private static int hash(int i)
    {
        i ^= i >>> 20 ^ i >>> 12;
        return i ^ i >>> 7 ^ i >>> 4;
    }

    private static int getHashIndex(int i, int j)
    {
        return i & j - 1;
    }

    public int getNumHashElements()
    {
        return numHashElements;
    }

    public Object getValueByKey(long l)
    {
        int i = getHashedKey(l);
        for(LongHashMapEntry longhashmapentry = playerListEntries[getHashIndex(i, playerListEntries.length)]; longhashmapentry != null; longhashmapentry = longhashmapentry.nextEntry)
        {
            if(longhashmapentry.key == l)
            {
                return longhashmapentry.value;
            }
        }

        return null;
    }

    public boolean containsKey(long l)
    {
        return getEntry(l) != null;
    }

    final LongHashMapEntry getEntry(long l)
    {
        int i = getHashedKey(l);
        for(LongHashMapEntry longhashmapentry = playerListEntries[getHashIndex(i, playerListEntries.length)]; longhashmapentry != null; longhashmapentry = longhashmapentry.nextEntry)
        {
            if(longhashmapentry.key == l)
            {
                return longhashmapentry;
            }
        }

        return null;
    }

    public void add(long l, Object obj)
    {
        int i = getHashedKey(l);
        int j = getHashIndex(i, playerListEntries.length);
        for(LongHashMapEntry longhashmapentry = playerListEntries[j]; longhashmapentry != null; longhashmapentry = longhashmapentry.nextEntry)
        {
            if(longhashmapentry.key == l)
            {
                longhashmapentry.value = obj;
            }
        }

        field_35581_e++;
        createKey(i, l, obj, j);
    }

    private void resizeTable(int i)
    {
        LongHashMapEntry alonghashmapentry[] = playerListEntries;
        int j = alonghashmapentry.length;
        if(j == 0x40000000)
        {
            capacity = 0x7fffffff;
            return;
        } else
        {
            LongHashMapEntry alonghashmapentry1[] = new LongHashMapEntry[i];
            copyHashTableTo(alonghashmapentry1);
            playerListEntries = alonghashmapentry1;
            capacity = (int)((float)i * 0.75F);
            return;
        }
    }

    private void copyHashTableTo(LongHashMapEntry alonghashmapentry[])
    {
        LongHashMapEntry alonghashmapentry1[] = playerListEntries;
        int i = alonghashmapentry.length;
        for(int j = 0; j < alonghashmapentry1.length; j++)
        {
            LongHashMapEntry longhashmapentry = alonghashmapentry1[j];
            if(longhashmapentry == null)
            {
                continue;
            }
            alonghashmapentry1[j] = null;
            do
            {
                LongHashMapEntry longhashmapentry1 = longhashmapentry.nextEntry;
                int k = getHashIndex(longhashmapentry.field_35831_d, i);
                longhashmapentry.nextEntry = alonghashmapentry[k];
                alonghashmapentry[k] = longhashmapentry;
                longhashmapentry = longhashmapentry1;
            } while(longhashmapentry != null);
        }

    }

    public Object remove(long l)
    {
        LongHashMapEntry longhashmapentry = removeKey(l);
        return longhashmapentry == null ? null : longhashmapentry.value;
    }

    final LongHashMapEntry removeKey(long l)
    {
        int i = getHashedKey(l);
        int j = getHashIndex(i, playerListEntries.length);
        LongHashMapEntry longhashmapentry = playerListEntries[j];
        LongHashMapEntry longhashmapentry1;
        LongHashMapEntry longhashmapentry2;
        for(longhashmapentry1 = longhashmapentry; longhashmapentry1 != null; longhashmapentry1 = longhashmapentry2)
        {
            longhashmapentry2 = longhashmapentry1.nextEntry;
            if(longhashmapentry1.key == l)
            {
                field_35581_e++;
                numHashElements--;
                if(longhashmapentry == longhashmapentry1)
                {
                    playerListEntries[j] = longhashmapentry2;
                } else
                {
                    longhashmapentry.nextEntry = longhashmapentry2;
                }
                return longhashmapentry1;
            }
            longhashmapentry = longhashmapentry1;
        }

        return longhashmapentry1;
    }

    private void createKey(int i, long l, Object obj, int j)
    {
        LongHashMapEntry longhashmapentry = playerListEntries[j];
        playerListEntries[j] = new LongHashMapEntry(i, l, obj, longhashmapentry);
        if(numHashElements++ >= capacity)
        {
            resizeTable(2 * playerListEntries.length);
        }
    }

    static int getHashCode(long l)
    {
        return getHashedKey(l);
    }
}
