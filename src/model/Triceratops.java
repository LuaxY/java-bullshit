package model;

/**
 * Created by Luax on 20/10/2016.
 */

public class Triceratops extends Dinosaur
{
    public Triceratops()
    {
        super("Triceratops", 0, 0.0f);
    }

    public Triceratops(String name, int age, float weight)
    {
        super(name, age, weight);
    }

    @Override
    public void eat()
    {
        addWeight(1.4f);
    }

    @Override
    public void sleep()
    {
        addWeight(-0.2f);
    }

    @Override
    public void jump()
    {
        addWeight(-0.1f);
    }

    @Override
    public String yell()
    {
        return "Ouh ouh ah ah !";
    }
}
