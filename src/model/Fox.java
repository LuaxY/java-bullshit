package model;

/**
 * Created by Luax on 04/11/2016.
 */

public class Fox extends Animal
{

    public Fox()
    {
        super("Fox", 1, 15.0f);
    }

    public Fox(String name, int age, float weight)
    {
        super(name, age, weight);
    }

    @Override
    public void sleep()
    {
        addWeight(-0.2f);
    }

    @Override
    public void eat()
    {
        addWeight(0.4f);
    }
}
