/**
 * Created by Luax on 20/10/2016.
 */

public class Gazelle extends Animal
{
    int tailleCornes;

    public Gazelle()
    {
        super("Gazelle", 0, 0.0f);
        setTailleCornes(0);
    }

    public Gazelle(String nom, int age, float poids, int tailleCornes)
    {
        super(nom, age, poids);
        setTailleCornes(tailleCornes);
    }

    public int getTailleCornes()
    {
        return tailleCornes;
    }

    public void setTailleCornes(int tailleCornes)
    {
        this.tailleCornes = tailleCornes;
    }

    @Override
    protected void finalize() throws Throwable
    {
        System.out.println("Je meurt !!!");
        super.finalize();
    }

    public String toString()
    {
        return super.toString() + " et j'ai des cornes de " + getTailleCornes() + "cm.";
    }

    @Override
    public void manger()
    {
        addPoids(0.4f);
    }

    @Override
    public void dormir()
    {
        addPoids(-0.2f);
    }

    @Override
    public void courrir()
    {
        addPoids(-0.1f);
    }
}
