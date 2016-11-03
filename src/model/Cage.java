package model;

import exception.CageException;
import exception.DoorException;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Created by Luax on 21/10/2016.
 */

public class Cage implements Serializable
{
    private Animal occupant;
    private boolean isOpen;
    private int positionX;
    private int positionY;

    public Cage()
    {
        this(0, 0);
    }

    public Cage(int positionX, int positionY)
    {
        occupant = null;
        isOpen = true;

        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String toString()
    {
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add("[");
        stringJoiner.add(Integer.toString(positionX));
        stringJoiner.add(",");
        stringJoiner.add(Integer.toString(positionY));
        stringJoiner.add("]");

        if (occupant != null)
        {
            stringJoiner.add(occupant.toString());
        }
        else
        {
            stringJoiner.add("vide");
        }

        if (isOpen)
        {
            stringJoiner.add("ouverte");
        }
        else
        {
            stringJoiner.add("ferme");
        }

        return stringJoiner.toString();
    }

    public void getInAnimal(Animal animal) throws CageException, DoorException
    {
        if (occupant != null)
        {
            throw new CageException();
        }

        if (!isOpen)
        {
            throw new DoorException();
        }

        occupant = animal;
    }

    public Animal getOutAnimal() throws DoorException
    {
        if (!isOpen)
        {
            throw new DoorException();
        }

        Animal animalTransfert = occupant;
        occupant = null;
        return animalTransfert;
    }

    public void open()
    {
        isOpen = true;
    }

    public void close()
    {
        isOpen = false;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public void feed()
    {
        if (occupant != null)
        {
            occupant.eat();
        }
    }

    public boolean isEmpty()
    {
        return occupant == null;
    }

    public Animal getOccupant()
    {
        return occupant;
    }
}
