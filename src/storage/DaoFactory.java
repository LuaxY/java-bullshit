package storage;

import service.CagePOJO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Luax on 03/11/2016.
 */

public class DaoFactory
{
    private static DaoFactory instance = new DaoFactory();

    Class<?> daoClass = null;

    public DaoFactory()
    {
        Properties properties = new Properties();

        try
        {
            properties.load(new FileInputStream("dao.properties"));
            String className = properties.getProperty("className");
            String packageName = properties.getProperty("packageName");
            daoClass = Class.forName(packageName + "." + className);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public static DaoFactory getInstance()
    {
        return instance;
    }

    public Dao<?> getDao()
    {
        Dao<?> dao = null;

        try
        {
            dao = (Dao<?>) daoClass.newInstance();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return dao;
    }
}
