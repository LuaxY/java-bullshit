package model;

/**
 * Created by Luax on 04/11/2016.
 */

public class Chicken extends Animal implements Eatable
{
    public Chicken()
    {
        super("Chicken", 1, 2.0f);
    }

    public Chicken(String name, int age, float weight)
    {
        super(name, age, weight);
    }

    @Override
    public void sleep()
    {
        addWeight(-0.01f);
    }

    @Override
    public void eat()
    {
        addWeight(0.06f);
    }
}
