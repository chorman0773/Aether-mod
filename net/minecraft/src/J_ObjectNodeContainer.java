// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            J_NodeContainer, J_JsonObjectNodeBuilder, J_JsonListenerToJdomAdapter, J_JsonNodeBuilder, 
//            J_JsonFieldBuilder

class J_ObjectNodeContainer
    implements J_NodeContainer
{

    final J_JsonObjectNodeBuilder nodeBuilder;
    final J_JsonListenerToJdomAdapter listenerToJdomAdapter;

    J_ObjectNodeContainer(J_JsonListenerToJdomAdapter j_jsonlistenertojdomadapter, J_JsonObjectNodeBuilder j_jsonobjectnodebuilder)
    {
        listenerToJdomAdapter = j_jsonlistenertojdomadapter;
        nodeBuilder = j_jsonobjectnodebuilder;
    }

    public void addNode(J_JsonNodeBuilder j_jsonnodebuilder)
    {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a node to an object.");
    }

    public void addField(J_JsonFieldBuilder j_jsonfieldbuilder)
    {
        nodeBuilder.withFieldBuilder(j_jsonfieldbuilder);
    }
}
