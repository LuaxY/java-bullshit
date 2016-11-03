package model;

/**
 * Created by Luax on 21/10/2016.
 */

public class Visitor extends Person
{
    public static final int MAX_VISITOR = 10;
    private static int visitorCounter = 0;

    public Visitor()
    {
        visitorCounter++;
    }

    @Override
    protected void finalize() throws Throwable
    {
        visitorCounter--;
        super.finalize();
    }

    public static int getVisitorCounter()
    {
        return visitorCounter;
    }

    @Override
    public void sleep()
    {

    }

    @Override
    public void jump()
    {

    }

    @Override
    public String yell()
    {
        return null;
    }

    @Override
    public void run()
    {

    }

    @Override
    public void eat()
    {

    }

    @Override
    @Deprecated
    public void eat(Gazelle gazelle)
    {

    }
}
