package service;

/**
 * Created by Luax on 03/11/2016.
 */

public class CagePOJO
{
    private int idAnimal; // primary key
    private int x;
    private int y;
    private String codeAnimal;
    private String nom;
    private int age;
    private float poids;
    private GazellePOJO gazelle;

    public CagePOJO()
    {
    }

    public int getIdAnimal()
    {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal)
    {
        this.idAnimal = idAnimal;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public String getCodeAnimal()
    {
        return codeAnimal;
    }

    public void setCodeAnimal(String codeAnimal)
    {
        this.codeAnimal = codeAnimal;
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
        this.age = age;
    }

    public float getPoids()
    {
        return poids;
    }

    public void setPoids(float poids)
    {
        this.poids = poids;
    }

    public GazellePOJO getGazelle()
    {
        return gazelle;
    }

    public void setGazelle(GazellePOJO gazelle)
    {
        this.gazelle = gazelle;
    }
}
