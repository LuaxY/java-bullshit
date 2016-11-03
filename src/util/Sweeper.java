package util;

/**
 * Created by Luax on 21/10/2016.
 */

public abstract class Sweeper
{
    public static void cleanTheFloor()
    {
        // Appel du GC pour supprimer l'animal mangé et mise en pause pour que le GC passe par là
        System.gc();
        try
        {
            Thread.sleep(1);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
