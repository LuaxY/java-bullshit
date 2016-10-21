package model;

/**
 * Created by Luax on 20/10/2016.
 */

public class Diplodocus extends Dinosaur implements Eatable
{
    int hornSize;

    public Diplodocus()
    {
        super("Diplodocus", 0, 0.0f);
        setHornSize(0);
    }

    public Diplodocus(String name, int age, float weight, int hornSize)
    {
        super(name, age, weight);
        setHornSize(hornSize);
    }

    public int getHornSize()
    {
        return hornSize;
    }

    public void setHornSize(int hornSize)
    {
        this.hornSize = hornSize;
    }

    @Override
    protected void finalize() throws Throwable
    {
        System.out.println("Je meurt !!!");
        super.finalize();
    }

    public String toString()
    {
        return super.toString() + " et j'ai des cornes de " + getHornSize() + "cm.";
    }

    @Override
    public void eat()
    {
        addWeight(0.4f);
    }

    @Override
    public void sleep()
    {
        addWeight(-0.2f);
    }

    @Override
    public void run()
    {
        addWeight(-0.1f);
    }
}
