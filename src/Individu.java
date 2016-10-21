/**
 * Created by Luax on 20/10/2016.
 */

public class Individu
{
    String nom;
    int age;
    float poids;

    public Individu(String nom, int age, float poids)
    {
        setNom(nom);
        setAge(age);
        setPoids(poids);
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
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

    public float getPoids()
    {
        return poids;
    }

    public void setPoids(float poids)
    {
        if (poids >= 0)
        {
            this.poids = poids;
        }
    }

    public void addPoids(float poids)
    {
        setPoids(getPoids() + poids);
    }
}
