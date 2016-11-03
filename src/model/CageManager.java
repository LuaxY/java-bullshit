package model;

import service.CagePOJO;
import storage.Dao;
import util.CageConverter;

/**
 * Created by Luax on 03/11/2016.
 */

public class CageManager
{
    private int key;
    private Cage model;
    private CagePOJO cagePOJO;
    private Dao<CagePOJO> dao;

    public CageManager(int key, Dao<CagePOJO> dao)
    {
        this.key = key;
        this.dao = dao;
        cagePOJO = dao.read(key);
        model = CageConverter.convert(cagePOJO);
    }

    @Override
    public String toString()
    {
        return "CageManager{" +
                "key=" + key +
                ", model=" + model +
                ", cagePOJO=" + cagePOJO +
                ", dao=" + dao +
                '}';
    }

    public void feed()
    {
        if (model.getOccupant() != null)
        {
            model.feed();
            cagePOJO.setPoids(model.getOccupant().getWeight());
            dao.update(cagePOJO);
        }
    }
}
