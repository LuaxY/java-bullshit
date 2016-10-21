package model;

/**
 * Created by Luax on 20/10/2016.
 */

public abstract class Dinosaur implements Individu
{
    String name;
    int    age;
    float  weight;

    public Dinosaur(String name, int age, float weight)
    {
        setName(name);
        setAge(age);
        setWeight(weight);
    }

    @Override
    public String toString()
    {
        return "Je suis un " + getClass().getSimpleName().toLowerCase() + ", je m'appelle " + getName() + ", j'ai " + getAge() + " ans, je fait " + getWeight() + "Kg";
    }

    public void jump()
    {
    }

    public String yell()
    {
        return "...";
    }

    public void run()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        if (age >= 0)
        {
            this.age = age;
        }
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        if (weight >= 0)
        {
            this.weight = weight;
        }
    }

    public void addWeight(float weight)
    {
        setWeight(getWeight() + weight);
    }
}
