package model;

import exception.BeurkExeption;

/**
 * Created by Luax on 20/10/2016.
 */

public class Lion extends Animal
{
    public Lion()
    {
        super("Lion", 0, 0.0f);
    }

    public Lion(String name, int age, float weight)
    {
        super(name, age, weight);
    }

    @Override
    public void eat()
    {
        addWeight(1.9f);
    }

    @Override
    public void sleep()
    {
        addWeight(-0.6f);
    }

    @Override
    public void jump()
    {
        addWeight(-0.8f);
    }

    @Override
    public String yell()
    {
        return "Roaaaaahh !!!";
    }

    @Override
    @Deprecated
    public void eat(Gazelle gazelle)
    {
        addWeight(gazelle.getWeight() / 3);
    }

    @Override
    @Deprecated
    public void eat(Individu individu)
    {
        //addWeight(individu.getWeight() / 3);
    }

    @Override
    public void eat(Eatable eatable) throws BeurkExeption
    {
        addWeight(eatable.getWeight() / 3);
    }
}
