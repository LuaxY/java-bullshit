package storage;

//import com.mysql.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.Gazelle;
import service.CagePOJO;
import service.GazellePOJO;

/**
 * Created by Luax on 21/10/2016.
 */

public class JDBCImpl implements Dao<CagePOJO>
{
    public final static String URL      = "jdbc:mysql://localhost:3306/zoo?useSSL=false";
    public final static String USER     = "root";
    public final static String PASSWORD = "root";
    public final static String DRIVER   = "com.mysql.jdbc.Driver";

    private Connection connection;

    public JDBCImpl()
    {
        try
        {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private CagePOJO createPOJO(ResultSet result)
    {
        CagePOJO cagePOJO = null;
        GazellePOJO gazellePOJO = null;
        String className = null;

        if (result != null)
        {
            try
            {
                className = result.getString("codeAnimal");

                cagePOJO = new CagePOJO();
                cagePOJO.setX(result.getInt("x"));
                cagePOJO.setY(result.getInt("y"));
                cagePOJO.setIdAnimal(result.getInt("idAnimal"));

                if (className != null)
                {
                    cagePOJO.setCodeAnimal(result.getString("codeAnimal"));
                    cagePOJO.setNom(result.getString("nom"));
                    cagePOJO.setAge(result.getInt("age"));
                    cagePOJO.setPoids(result.getFloat("poids"));

                    if (className.equals("Gazelle"))
                    {
                        gazellePOJO = new GazellePOJO();
                        gazellePOJO.setId(result.getInt("id"));
                        gazellePOJO.setLgCorne(result.getInt("lgCornes"));

                        cagePOJO.setGazelle(gazellePOJO);
                    }
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return cagePOJO;
    }

    @Override
    public CagePOJO read(int id)
    {
        CagePOJO cagePOJO = null;
        ResultSet result = null;

        try
        {
            connection.createStatement();
            Statement statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM animal as a LEFT JOIN gazelle as g on a.idAnimal = g.idAnimal WHERE a.idAnimal = " + id);

            if (result != null)
            {
                result.next();
                cagePOJO = createPOJO(result);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return cagePOJO;
    }

    @Override
    public List<CagePOJO> readAll()
    {
        List<CagePOJO> listCagePOJO = new Vector<>();

        try
        {
            connection.createStatement();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM animal as a LEFT JOIN gazelle as g on a.idAnimal = g.idAnimal ORDER BY a.idAnimal");

            while (result.next())
            {
                CagePOJO cagePOJO = createPOJO(result);

                listCagePOJO.add(cagePOJO);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return listCagePOJO;
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
