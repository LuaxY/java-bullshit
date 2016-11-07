package controller;

import exception.BeurkExeption;
import exception.CageException;
import exception.DoorException;
import model.*;
import service.CagePOJO;
import storage.Dao;
import storage.DaoFactory;
import util.Sweeper;

import java.util.List;
import java.util.StringJoiner;
import java.util.Vector;

/**
 * Created by Luax on 21/10/2016.
 */

public class ZooManager
{
    private static ZooManager instance = new ZooManager();

    private List<ManagedCage> cages;
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
        DaoFactory daoFactory = DaoFactory.getInstance();
        Dao<CagePOJO> dao = (Dao<CagePOJO>) daoFactory.getDao();
        List<CagePOJO> cagePOJOs = (List<CagePOJO>) dao.readAll();

        for (CagePOJO cagePOJO : cagePOJOs)
        {
            cages.add(new ManagedCage(cagePOJO.getIdAnimal(), dao));
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

        for (ManagedCage cage : cages)
        {
            displayDinosaursList[dinosaurCounter] = cage.toString();
            dinosaurCounter++;
        }

        return displayDinosaursList;
    }

    public void feed()
    {
        for (ManagedCage cage : cages)
        {
            cage.feed();
        }
    }

    public void entertainment()
    {
        for (ManagedCage cage : cages)
        {
            Animal occupant = cage.getOccupant();
            if (occupant != null) System.out.println(occupant.yell());
        }
    }

    public String eat(int eaterIndex, int eatedIndex)
    {
        ManagedCage eaterCage = cages.get(eaterIndex);
        ManagedCage eatedCage = cages.get(eatedIndex);

        Animal eater = eaterCage.getOccupant();
        Animal eated = null; //eatedCage.getOccupant();

        String result = "";
        StringJoiner stringJoiner = null;

        if (eater != null)
        {
            stringJoiner = new StringJoiner(" ");

            try
            {
                // Open cage, get dino, close cage of eated
                eatedCage.open();
                eated = eatedCage.getOutAnimal();
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
                    eatedCage.getInAnimal(eated);
                    eatedCage.close();

                    stringJoiner.add(eater.getName());
                    stringJoiner.add("ne veut pas manger");
                    stringJoiner.add(eated.getName());
                }
            }
            catch (BeurkExeption e)
            {
                try
                {
                    // Return eated to his chage
                    eatedCage.open();
                    eatedCage.getInAnimal(eated);
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
