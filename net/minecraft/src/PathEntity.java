// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            PathPoint, Entity, Vec3D

public class PathEntity
{

    private final PathPoint points[];
    public final int pathLength;
    private int pathIndex;

    public PathEntity(PathPoint apathpoint[])
    {
        points = apathpoint;
        pathLength = apathpoint.length;
    }

    public void incrementPathIndex()
    {
        pathIndex++;
    }

    public boolean isFinished()
    {
        return pathIndex >= points.length;
    }

    public Vec3D getPosition(Entity entity)
    {
        double d = (double)points[pathIndex].xCoord + (double)(int)(entity.width + 1.0F) * 0.5D;
        double d1 = points[pathIndex].yCoord;
        double d2 = (double)points[pathIndex].zCoord + (double)(int)(entity.width + 1.0F) * 0.5D;
        return Vec3D.createVector(d, d1, d2);
    }
}