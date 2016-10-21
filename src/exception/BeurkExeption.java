package exception;

/**
 * Created by Luax on 21/10/2016.
 */
public class BeurkExeption extends Exception
{
    public BeurkExeption()
    {
        super("Beurk !!!");
    }

    public BeurkExeption(String message)
    {
        super(message);
    }

    public BeurkExeption(String eaterName, String eatableName)
    {
        super(eaterName + " ne veux pas manger de " + eatableName);
    }
}
