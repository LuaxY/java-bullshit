package exception;

/**
 * Created by Luax on 21/10/2016.
 */
public class CageException extends Exception
{
    public CageException()
    {
        super("Cage pleine");
    }

    public CageException(String message)
    {
        super(message);
    }
}
