package util;

import exception.CageException;
import exception.DoorException;
import model.Animal;
import model.Cage;
import service.CagePOJO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Luax on 03/11/2016.
 */

public abstract class CageConverter
{
    private static final String PACKAGE = "model.";

    public static Cage convert(CagePOJO cagePOJO)
    {
        Cage cage = null;
        Animal animal = null;
        String className = "model.Gazelle";
        Constructor<?> constructor = null;
        Class<?> types[] = null;
        Object values[] = null;

        cage = new Cage(cagePOJO.getX(), cagePOJO.getY());

        if (cagePOJO.getCodeAnimal() != null)
        {
            if (cagePOJO.getCodeAnimal().equals("Gazelle"))
            {
                types  = new Class<?>[4];
                values = new Object[4];

                types[3]  = int.class;
                values[3] = cagePOJO.getGazelle().getLgCorne();
            }
            else
            {
                types  = new Class<?>[3];
                values = new Object[3];
            }

            types[0] = String.class;
            types[1] = int.class;
            types[2] = float.class;

            values[0] = cagePOJO.getNom();
            values[1] = cagePOJO.getAge();
            values[2] = cagePOJO.getAge();

            try
            {
                Class<?> toStudie = Class.forName(PACKAGE + cagePOJO.getCodeAnimal());
                constructor = toStudie.getConstructor(types);
                animal = (Animal) constructor.newInstance(values);
                cage.open();
                cage.getInAnimal(animal);
                cage.close();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (NoSuchMethodException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
            catch (InvocationTargetException e)
            {
                e.printStackTrace();
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

        return cage;
    }
}
