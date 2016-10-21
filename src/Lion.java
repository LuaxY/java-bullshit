/**
 * Created by Luax on 20/10/2016.
 */

public class Lion extends Animal
{
    public Lion()
    {
        super("Lion", 0, 0.0f);
    }

    public Lion(String nom, int age, float poids)
    {
        super(nom, age, poids);
    }

    @Override
    public void manger()
    {
        addPoids(1.9f);
    }

    @Override
    public void dormir()
    {
        addPoids(-0.6f);
    }

    @Override
    public void sauter()
    {
        addPoids(-0.8f);
    }

    @Override
    public String crier()
    {
        return "Roaaaaahh !!!";
    }

    @Override
    public void devorer(Gazelle gazelle)
    {
        addPoids(gazelle.getPoids() / 3);
    }
}
