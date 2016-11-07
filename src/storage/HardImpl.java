package storage;

import org.json.simple.parser.ParseException;
import service.CagePOJO;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 * Created by Luax on 03/11/2016.
 */

public class HardImpl implements Dao<CagePOJO>
{
    @Override
    public CagePOJO read(int id)
    {
        List<CagePOJO> cagePOJOs = readAll();
        return cagePOJOs.get(id);
    }

    @Override
    public List<CagePOJO> readAll()
    {
        List<CagePOJO> cagePOJOs = new Vector<>();
        CagePOJO cagePOJO = null;

        try
        {
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(new FileReader("zoo.json"));
            JSONArray cages = (JSONArray) object.get("cages");
            Iterator<JSONObject> iterator = cages.iterator();

            int key = 0;

            while (iterator.hasNext())
            {
                JSONObject cage = iterator.next();

                cagePOJO = new CagePOJO();
                cagePOJO.setIdAnimal(key);
                cagePOJO.setX(Math.toIntExact((Long) cage.get("x")));
                cagePOJO.setY(Math.toIntExact((Long) cage.get("y")));
                cagePOJO.setCodeAnimal((String) cage.get("codeAnimal"));
                cagePOJO.setNom((String) cage.get("nom"));
                cagePOJO.setAge(Math.toIntExact((Long) cage.get("age")));
                cagePOJO.setPoids((double) cage.get("poids"));

                cagePOJOs.add(cagePOJO);

                key++;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

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
    public void insert(CagePOJO object)
    {

    }
}
