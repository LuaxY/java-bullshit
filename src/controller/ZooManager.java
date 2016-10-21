package controller;

import exception.BeurkExeption;
import exception.CageException;
import exception.DoorException;
import model.*;
import utils.Sweeper;

import java.util.List;
import java.util.StringJoiner;
import java.util.Vector;

/**
 * Created by Luax on 21/10/2016.
 */

public class ZooManager
{
    private static ZooManager instance = new ZooManager();

    private List<Cage> cages;
    private Visitor[] vistors;

    private ZooManager()
    {
        cages = new Vector<>();
        vistors = new Visitor[Visitor.MAX_VISITOR];
        init();
    }

    public static ZooManager getInstance()
    {
        return instance;
    }

    private void init()
    {
        Cage cage = null;

        try
        {
            cage = new Cage(1, 1);
            cage.getInDinausor(new TRex("TRex", 5, 200.3f));
            cage.close();
            cages.add(cage);

            cage = new Cage(2, 2);
            cage.getInDinausor(new Triceratops("Triceraptos", 10, 35.8f));
            cage.close();
            cages.add(cage);

            cage = new Cage(3, 3);
            cage.getInDinausor(new Diplodocus("Diplodocus", 4, 56.6f, 20));
            cage.close();
            cages.add(cage);
        }
        catch (CageException e)
        {
            e.printStackTrace();
        }
        catch (DoorException e)
        {
            e.printStackTrace();
        }
    }

    public void in()
    {
        if (Visitor.getVisitorCounter() < Visitor.MAX_VISITOR)
        {
            vistors[Visitor.getVisitorCounter()] = new Visitor();
        }
    }

    public void out()
    {
        if (Visitor.getVisitorCounter() > 0)
        {
            vistors[Visitor.getVisitorCounter() - 1] = null;
            Sweeper.cleanTheFloor();
        }
    }

    public int getNumberOfVisitor()
    {
        return Visitor.getVisitorCounter();
    }

    public String[] getCages()
    {
        String[] displayDinosaursList = new String[cages.size()];

        int dinosaurCounter = 0;

        for (Cage cage : cages)
        {
            displayDinosaursList[dinosaurCounter] = cage.toString();
            dinosaurCounter++;
        }

        return displayDinosaursList;
    }

    public void feed()
    {
        for (Cage cage : cages)
        {
            cage.feed();
        }
    }

    public void entertainment()
    {
        for (Cage cage : cages)
        {
            Dinosaur occupant = cage.getOccupant();
            if (occupant != null) System.out.println(occupant.yell());
        }
    }

    public String eat(int eaterIndex, int eatedIndex)
    {
        Cage eaterCage = cages.get(eaterIndex);
        Cage eatedCage = cages.get(eatedIndex);

        Dinosaur eater = eaterCage.getOccupant();
        Dinosaur eated = null; //eatedCage.getOccupant();

        String result = "";
        StringJoiner stringJoiner = null;

        if (eater != null)
        {
            stringJoiner = new StringJoiner(" ");

            try
            {
                // Open cage, get dino, close cage of eated
                eatedCage.open();
                eated = eatedCage.getOutDinosaur();
                eatedCage.close();

                if (eated instanceof Eatable)
                {
                    // Feed eater with eated
                    eater.eat((Eatable) eated);

                    Sweeper.cleanTheFloor();

                    stringJoiner.add(eater.getName());
                    stringJoiner.add("viens de manger");
                    stringJoiner.add(eated.getName());
                }
                else
                {
                    // Return eated to his chage
                    eatedCage.open();
                    eatedCage.getInDinausor(eated);
                    eatedCage.close();

                    stringJoiner.add(eater.getName());
                    stringJoiner.add("ne veux pas manger");
                    stringJoiner.add(eated.getName());
                }
            }
            catch (BeurkExeption e)
            {
                try
                {
                    // Return eated to his chage
                    eatedCage.open();
                    eatedCage.getInDinausor(eated);
                    eatedCage.close();
                }
                catch (CageException e1)
                {
                    e1.printStackTrace();
                }
                catch (DoorException e1)
                {
                    e1.printStackTrace();
                }

                stringJoiner.add(eater.getName());
                stringJoiner.add(e.getMessage());
            }
            catch (DoorException e)
            {
                e.printStackTrace();
            }
            catch (CageException e)
            {
                e.printStackTrace();
            }

            result = stringJoiner.toString();
        }

        return result;
    }
}
