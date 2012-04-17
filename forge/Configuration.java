// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package forge;

import java.io.*;
import java.text.DateFormat;
import java.util.*;
import net.minecraft.src.Block;

// Referenced classes of package forge:
//            Property

public class Configuration
{

    private boolean configBlocks[];
    public static final int GENERAL_PROPERTY = 0;
    public static final int BLOCK_PROPERTY = 1;
    public static final int ITEM_PROPERTY = 2;
    File file;
    public TreeMap blockProperties;
    public TreeMap itemProperties;
    public TreeMap generalProperties;

    public Configuration(File file1)
    {
        configBlocks = null;
        blockProperties = new TreeMap();
        itemProperties = new TreeMap();
        generalProperties = new TreeMap();
        file = file1;
    }

    public Property getOrCreateBlockIdProperty(String s, int i)
    {
        if(configBlocks == null)
        {
            configBlocks = new boolean[Block.blocksList.length];
            for(int j = 0; j < configBlocks.length; j++)
            {
                configBlocks[j] = false;
            }

        }
        if(blockProperties.containsKey(s))
        {
            Property property = getOrCreateIntProperty(s, 1, i);
            configBlocks[Integer.parseInt(property.value)] = true;
            return property;
        }
        Property property1 = new Property();
        blockProperties.put(s, property1);
        property1.name = s;
        if(Block.blocksList[i] == null && !configBlocks[i])
        {
            property1.value = Integer.toString(i);
            configBlocks[i] = true;
            return property1;
        }
        for(int k = Block.blocksList.length - 1; k >= 0; k--)
        {
            if(Block.blocksList[k] == null && !configBlocks[k])
            {
                property1.value = Integer.toString(k);
                configBlocks[k] = true;
                return property1;
            }
        }

        throw new RuntimeException((new StringBuilder()).append("No more block ids available for ").append(s).toString());
    }

    public Property getOrCreateIntProperty(String s, int i, int j)
    {
        Property property = getOrCreateProperty(s, i, Integer.toString(j));
        try
        {
            Integer.parseInt(property.value);
            return property;
        }
        catch(NumberFormatException numberformatexception)
        {
            property.value = Integer.toString(j);
        }
        return property;
    }

    public Property getOrCreateBooleanProperty(String s, int i, boolean flag)
    {
        Property property = getOrCreateProperty(s, i, Boolean.toString(flag));
        if("true".equals(property.value.toLowerCase()) || "false".equals(property.value.toLowerCase()))
        {
            return property;
        } else
        {
            property.value = Boolean.toString(flag);
            return property;
        }
    }

    public Property getOrCreateProperty(String s, int i, String s1)
    {
        TreeMap treemap = null;
        switch(i)
        {
        case 0: // '\0'
            treemap = generalProperties;
            break;

        case 1: // '\001'
            treemap = blockProperties;
            break;

        case 2: // '\002'
            treemap = itemProperties;
            break;
        }
        if(treemap.containsKey(s))
        {
            return (Property)treemap.get(s);
        }
        if(s1 != null)
        {
            Property property = new Property();
            treemap.put(s, property);
            property.name = s;
            property.value = s1;
            return property;
        } else
        {
            return null;
        }
    }

    public void load()
    {
        try
        {
            if(file.getParentFile() != null)
            {
                file.getParentFile().mkdirs();
            }
            if(!file.exists() && !file.createNewFile())
            {
                return;
            }
            if(file.canRead())
            {
                FileInputStream fileinputstream = new FileInputStream(file);
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(fileinputstream, "8859_1"));
                TreeMap treemap = null;
                do
                {
                    String s = bufferedreader.readLine();
                    if(s == null)
                    {
                        break;
                    }
                    int i = -1;
                    int j = -1;
                    boolean flag = false;
                    int k = 0;
                    while(k < s.length() && !flag) 
                    {
                        if(Character.isLetterOrDigit(s.charAt(k)) || s.charAt(k) == '.')
                        {
                            if(i == -1)
                            {
                                i = k;
                            }
                            j = k;
                        } else
                        if(!Character.isWhitespace(s.charAt(k)))
                        {
                            switch(s.charAt(k))
                            {
                            case 35: // '#'
                                flag = true;
                                break;

                            case 123: // '{'
                                String s1 = s.substring(i, j + 1);
                                if(s1.equals("general"))
                                {
                                    treemap = generalProperties;
                                    break;
                                }
                                if(s1.equals("block"))
                                {
                                    treemap = blockProperties;
                                    break;
                                }
                                if(s1.equals("item"))
                                {
                                    treemap = itemProperties;
                                } else
                                {
                                    throw new RuntimeException((new StringBuilder()).append("unknown section ").append(s1).toString());
                                }
                                break;

                            case 125: // '}'
                                treemap = null;
                                break;

                            case 61: // '='
                                String s2 = s.substring(i, j + 1);
                                if(treemap == null)
                                {
                                    throw new RuntimeException((new StringBuilder()).append("property ").append(s2).append(" has no scope").toString());
                                }
                                Property property = new Property();
                                property.name = s2;
                                property.value = s.substring(k + 1);
                                k = s.length();
                                treemap.put(s2, property);
                                break;

                            default:
                                throw new RuntimeException((new StringBuilder()).append("unknown character ").append(s.charAt(k)).toString());
                            }
                        }
                        k++;
                    }
                } while(true);
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public void save()
    {
        try
        {
            if(file.getParentFile() != null)
            {
                file.getParentFile().mkdirs();
            }
            if(!file.exists() && !file.createNewFile())
            {
                return;
            }
            if(file.canWrite())
            {
                FileOutputStream fileoutputstream = new FileOutputStream(file);
                BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(fileoutputstream, "8859_1"));
                bufferedwriter.write("# Configuration file\r\n");
                bufferedwriter.write((new StringBuilder()).append("# Generated on ").append(DateFormat.getInstance().format(new Date())).append("\r\n").toString());
                bufferedwriter.write("\r\n");
                bufferedwriter.write("###########\r\n");
                bufferedwriter.write("# General #\r\n");
                bufferedwriter.write("###########\r\n\r\n");
                bufferedwriter.write("general {\r\n");
                writeProperties(bufferedwriter, generalProperties.values());
                bufferedwriter.write("}\r\n\r\n");
                bufferedwriter.write("#########\r\n");
                bufferedwriter.write("# Block #\r\n");
                bufferedwriter.write("#########\r\n\r\n");
                bufferedwriter.write("block {\r\n");
                writeProperties(bufferedwriter, blockProperties.values());
                bufferedwriter.write("}\r\n\r\n");
                bufferedwriter.write("########\r\n");
                bufferedwriter.write("# Item #\r\n");
                bufferedwriter.write("########\r\n\r\n");
                bufferedwriter.write("item {\r\n");
                writeProperties(bufferedwriter, itemProperties.values());
                bufferedwriter.write("}\r\n\r\n");
                bufferedwriter.close();
                fileoutputstream.close();
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    private void writeProperties(BufferedWriter bufferedwriter, Collection collection)
        throws IOException
    {
        for(Iterator iterator = collection.iterator(); iterator.hasNext(); bufferedwriter.write("\r\n"))
        {
            Property property = (Property)iterator.next();
            if(property.comment != null)
            {
                bufferedwriter.write((new StringBuilder()).append("   # ").append(property.comment).append("\r\n").toString());
            }
            bufferedwriter.write((new StringBuilder()).append("   ").append(property.name).append("=").append(property.value).toString());
        }

    }
}
