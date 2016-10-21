package view;

import controller.ZooManager;

/**
 * Created by Luax on 20/10/2016.
 */

public class Zoo
{
    public static void main(String[] args)
    {
        Zoo jurassicPark = new Zoo();

        System.out.println("Bienvenue dans Jurassic Park");

        jurassicPark.display();

        System.out.println("Le gardien nourrit les animaux");

        jurassicPark.feed();

        jurassicPark.display();

        System.out.println("Des visiteurs entrent dans le parc");

        jurassicPark.in();
        jurassicPark.in();

        System.out.println("Le parc comporte " + jurassicPark.getNumberOfVisitor() + " visiteurs");

        System.out.println("Les visiteur passent devant les cages");

        jurassicPark.entertainment();

        // la Diplodocus (2) mange le TRex (0)
        jurassicPark.eat(2, 0);

        // le TRex (0) mange la Diplodocus (2)
        jurassicPark.eat(0, 2);

        // le Singe (1) ce mange lui même
        jurassicPark.eat(1, 1);

        jurassicPark.display();

        System.out.println("Des visiteurs partent du Zoo");

        jurassicPark.out();
        jurassicPark.out();

        System.out.println("Le parc comporte " + jurassicPark.getNumberOfVisitor() + " visiteurs");
    }

    public Zoo()
    {
    }

    public void in()
    {
        ZooManager.getInstance().in();
    }

    public void out()
    {
        ZooManager.getInstance().out();
    }

    public int getNumberOfVisitor()
    {
        return ZooManager.getInstance().getNumberOfVisitor();
    }

    public void display()
    {
        String[] animals = ZooManager.getInstance().getCages();

        for (String animal : animals)
        {
            System.out.println(animal);
        }
    }

    public void feed()
    {
        ZooManager.getInstance().feed();
    }

    public void entertainment()
    {
        ZooManager.getInstance().entertainment();
    }

    public void eat(int eaterIndex, int eatedIndex)
    {
        System.out.println(ZooManager.getInstance().eat(eaterIndex, eatedIndex));
    }
}
