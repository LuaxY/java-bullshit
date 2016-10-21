/**
 * Created by Luax on 20/10/2016.
 */

public class Singe extends Animal
{
    public Singe()
    {
        super("Singe", 0, 0.0f);
    }

    public Singe(String nom, int age, float poids)
    {
        super(nom, age, poids);
    }

    @Override
    public void manger()
    {
        addPoids(1.4f);
    }

    @Override
    public void dormir()
    {
        addPoids(-0.2f);
    }

    @Override
    public void sauter()
    {
        addPoids(-0.1f);
    }

    @Override
    public String crier()
    {
        return "Ouh ouh ah ah !";
    }
}
