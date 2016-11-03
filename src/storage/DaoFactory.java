package storage;

/**
 * Created by Luax on 03/11/2016.
 */

public class DaoFactory
{
    private static DaoFactory instance = new DaoFactory();

    public static DaoFactory getInstance()
    {
        return instance;
    }

    public Dao<?> getDao(DaoType type)
    {
        Dao<?> dao = null;

        switch (type)
        {
            case JDBC:
                dao = new JDBCImpl();
                break;
            case JPA:
                // TODO just do it
                dao = null;
                break;
            case HARD:
                dao = new HardImpl();
                break;
            default:
                break;
        }

        return dao;
    }
}
