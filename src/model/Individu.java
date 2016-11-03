package model;

import exception.BeurkExeption;

/**
 * Created by Luax on 20/10/2016.
 */

public interface Individu
{
    public void sleep();

    public void jump();

    public String yell();

    public void run();

    public void eat();

    public default void eat(Eatable eatable) throws BeurkExeption
    {
        throw new BeurkExeption(getClass().getSimpleName(), eatable.getClass().getSimpleName());
    }

    // --------------------------------

    @Deprecated
    public default void eat(Gazelle gazelle) throws BeurkExeption
    {
        throw new BeurkExeption();
    }

    @Deprecated
    public default void eat(Individu individu) throws BeurkExeption
    {
        throw new BeurkExeption();
    }
}
