/**
 * Created by Luax on 20/10/2016.
 */

public abstract class Animal extends Individu
{
    public Animal(String nom, int age, float poids)
    {
        super(nom, age, poids);
    }

    @Override
    public String toString()
    {
        return "Je suis un " + getClass().getSimpleName().toLowerCase() + ", je m'appelle " + getNom() + ", j'ai " + getAge() + " ans, je fait " + getPoids() + "Kg";
    }

    public abstract void manger();

    public abstract void dormir();

    public void sauter()
    {
    }

    public String crier()
    {
        return "...";
    }

    public void courrir()
    {
    }

    public void devorer(Gazelle gazelle)
    {
        System.out.println("Beurk!!!");
    }
}
