package model;

import exception.CageException;
import exception.DoorException;
import service.CagePOJO;
import service.GazellePOJO;
import storage.Dao;
import util.CageConverter;

/**
 * Created by Luax on 03/11/2016.
 */

public class ManagedCage
{
    private int key;
    private Cage model;
    private CagePOJO cagePOJO;
    private Dao<CagePOJO> dao;

    public ManagedCage(int key, Dao<CagePOJO> dao)
    {
        this.key = key;
        this.dao = dao;
        cagePOJO = dao.read(key);
        model = CageConverter.convert(cagePOJO);
    }

    @Override
    public String toString()
    {
        return "ManagedCage{" +
                "key=" + key +
                ", model=" + model +
                ", cagePOJO=" + cagePOJO +
                ", dao=" + dao +
                '}';
    }

    public void feed()
    {
        if (model != null && model.getOccupant() != null)
        {
            model.feed();
            cagePOJO.setPoids(model.getOccupant().getWeight());
            dao.update(cagePOJO);
        }
    }

    public Animal getOccupant()
    {
        if (model != null)
        {
            return model.getOccupant();
        }

        return null;
    }

    public void open()
    {
        if (model != null) model.open();
    }

    public void close()
    {
        if (model != null) model.close();
    }

    public Animal getOutAnimal() throws DoorException
    {
        Animal animal = model.getOutAnimal();

        cagePOJO.setCodeAnimal(null);
        cagePOJO.setNom(null);
        cagePOJO.setAge(0);
        cagePOJO.setPoids(0.0f);
        cagePOJO.setGazelle(null);

        dao.update(cagePOJO);

        return animal;
    }

    public void getInAnimal(Animal animal) throws CageException, DoorException
    {
        GazellePOJO gazellePOJO = null;

        try
        {
            model.getInAnimal(animal);

            cagePOJO.setCodeAnimal(animal.getClass().getSimpleName());
            cagePOJO.setNom(animal.getName());
            cagePOJO.setAge(animal.getAge());
            cagePOJO.setPoids(animal.getWeight());

            if (animal instanceof Gazelle)
            {
                gazellePOJO = new GazellePOJO();
                gazellePOJO.setLgCornes(((Gazelle) animal).hornSize);
                gazellePOJO.setIdAnimal(cagePOJO.getIdAnimal());
                cagePOJO.setGazelle(gazellePOJO);
            }

            dao.update(cagePOJO);
        }
        catch (CageException e)
        {
            e.printStackTrace();
            throw e;
        }
        catch (DoorException e)
        {
            e.printStackTrace();
            throw e;
        }
    }
}
