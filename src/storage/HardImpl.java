package storage;

import model.Cage;
import model.Gazelle;
import model.Lion;
import model.Monkey;
import service.CagePOJO;
import service.GazellePOJO;

import java.util.List;
import java.util.Vector;

/**
 * Created by Luax on 03/11/2016.
 */

public class HardImpl implements Dao<CagePOJO>
{
    @Override
    public CagePOJO read(int id)
    {
        return null;
    }

    @Override
    public List<CagePOJO> readAll()
    {
        List<CagePOJO> cagePOJOs = new Vector<>();
        CagePOJO cagePOJO = null;

        cagePOJO = new CagePOJO();
        cagePOJO.setIdAnimal(0);
        cagePOJO.setX(0);
        cagePOJO.setY(0);
        cagePOJO.setCodeAnimal("Lion");
        cagePOJO.setNom("Leon");
        cagePOJO.setAge(10);
        cagePOJO.setPoids(70.4f);
        cagePOJOs.add(cagePOJO);

        cagePOJO = new CagePOJO();
        cagePOJO.setIdAnimal(1);
        cagePOJO.setX(1);
        cagePOJO.setY(1);
        cagePOJO.setCodeAnimal("Monkey");
        cagePOJO.setNom("Harambe");
        cagePOJO.setAge(7);
        cagePOJO.setPoids(200.8f);
        cagePOJOs.add(cagePOJO);

        cagePOJO = new CagePOJO();
        cagePOJO.setIdAnimal(2);
        cagePOJO.setX(2);
        cagePOJO.setY(2);
        cagePOJO.setCodeAnimal("Gazelle");
        cagePOJO.setNom("Speedy");
        cagePOJO.setAge(4);
        cagePOJO.setPoids(37.2f);
        GazellePOJO gazellePOJO = new GazellePOJO();
        gazellePOJO.setLgCorne(4);
        cagePOJO.setGazelle(gazellePOJO);
        cagePOJOs.add(cagePOJO);

        return cagePOJOs;
    }

    @Override
    public void update(CagePOJO object)
    {

    }

    @Override
    public void delete(CagePOJO object)
    {

    }

    @Override
    public void store(CagePOJO object)
    {

    }
}
