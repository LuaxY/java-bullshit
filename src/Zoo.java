/**
 * Created by Luax on 20/10/2016.
 */

public class Zoo
{
    private Animal[] animaux;

    private final int NUMBER_OF_ANIMALS;

    public static void main(String[] args)
    {
        Zoo zoo = null;

        zoo = new Zoo();

        System.out.println("Bienvenue dans le Zoo");

        zoo.afficher();

        System.out.println("Le gardien nourrit les animaux");

        zoo.nourrir();

        zoo.afficher();

        zoo.divertissement();

        zoo.devorer();

        zoo.afficher();
    }

    public Zoo()
    {
        NUMBER_OF_ANIMALS = 3;
        animaux = new Animal[NUMBER_OF_ANIMALS];

        remplir();
    }

    public void remplir()
    {
        animaux[0] = new Lion("Léo", 5, 200.3f);
        animaux[1] = new Singe("Harambe", 10, 35.8f);
        animaux[2] = new Gazelle("Gazelle", 4, 56.6f, 20);
    }

    public void afficher()
    {
        for (Animal animal : animaux)
        {
            if (animal != null) System.out.println(animal);
            else System.out.println("Cage vide");
        }
    }

    public void nourrir()
    {
        for (Animal animal : animaux)
        {
            if (animal != null) animal.manger();
        }
    }

    public void divertissement()
    {
        for (Animal animal : animaux)
        {
            if (animal != null) System.out.println(animal.crier());
        }
    }

    public void devorer()
    {
        animaux[0].devorer((Gazelle)animaux[2]);
        animaux[2] = null;
        System.gc();
        try
        {
            Thread.sleep(1);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
