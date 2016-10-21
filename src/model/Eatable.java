package model;

import exception.BeurkExeption;

/**
 * Created by Luax on 21/10/2016.
 */
public interface Eatable
{
    public default float getWeight()
    {
        return 0;
    }
}
