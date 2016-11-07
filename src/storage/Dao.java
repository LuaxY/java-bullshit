package storage;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Luax on 03/11/2016.
 */

public interface Dao<T>
{
    public T read(int id);

    public List<T> readAll();

    public void update(T object);

    public void delete(T object);

    public void insert(T object);
}
