package exception;

/**
 * Created by Luax on 21/10/2016.
 */

public class DoorException extends Exception
{
    public DoorException()
    {
        super("La porte n'est pas ouverte");
    }

    public DoorException(String message)
    {
        super(message);
    }
}
