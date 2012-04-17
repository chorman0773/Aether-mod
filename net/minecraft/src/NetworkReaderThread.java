// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            NetworkManager

class NetworkReaderThread extends Thread
{

    final NetworkManager netManager;

    NetworkReaderThread(NetworkManager networkmanager, String s)
    {
        super(s);
        netManager = networkmanager;
    }

    public void run()
    {
        synchronized(NetworkManager.threadSyncObject)
        {
            NetworkManager.numReadThreads++;
        }
        while(NetworkManager.isRunning(netManager) && !NetworkManager.isServerTerminating(netManager)) 
        {
            while(NetworkManager.readNetworkPacket(netManager)) ;
            try
            {
                sleep(2L);
            }
            catch(InterruptedException interruptedexception) { }
        }
        synchronized(NetworkManager.threadSyncObject)
        {
            NetworkManager.numReadThreads--;
        }
        break MISSING_BLOCK_LABEL_131;
        Exception exception2;
        exception2;
        synchronized(NetworkManager.threadSyncObject)
        {
            NetworkManager.numReadThreads--;
        }
        throw exception2;
    }
}
