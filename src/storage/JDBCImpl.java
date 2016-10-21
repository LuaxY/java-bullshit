package storage;

//import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 * Created by Luax on 21/10/2016.
 */
public class JDBCImpl
{
    public final static String SERVEUR  = "127.0.0.1";
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

            connection.createStatement();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM animal");
            if (result != null)
            {
                while (result.next())
                {
                    System.out.println(result.getString("codeAnimal"));
                }
            }
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
}
