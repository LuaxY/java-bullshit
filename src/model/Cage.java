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
    private Dinosaur occupant;
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

    public void getInDinausor(Dinosaur dinosaur) throws CageException, DoorException
    {
        if (occupant != null)
        {
            throw new CageException();
        }

        if (!isOpen)
        {
            throw new DoorException();
        }

        occupant = dinosaur;
    }

    public Dinosaur getOutDinosaur() throws DoorException
    {
        if (!isOpen)
        {
            throw new DoorException();
        }

        Dinosaur dinosaurTransfert = occupant;
        occupant = null;
        return dinosaurTransfert;
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

    public Dinosaur getOccupant()
    {
        return occupant;
    }
}
