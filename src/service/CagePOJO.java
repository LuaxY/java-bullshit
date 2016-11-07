package service;

import javax.persistence.*;

/**
 * Created by Luax on 03/11/2016.
 */

@Entity
@Table(name = "animal")
@NamedQueries({
    @NamedQuery(name = "all",  query = "SELECT cage FROM CagePOJO as cage"),
    @NamedQuery(name = "find", query = "SELECT cage FROM CagePOJO as cage WHERE cage.idAnimal = :key"),
})

public class CagePOJO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAnimal; // primary key

    private int x;

    private int y;

    private String codeAnimal;

    private String nom;

    private int age;

    private float poids;

    @OneToOne
    @JoinColumn(referencedColumnName = "idAnimal", name = "idAnimal", updatable = false, insertable = false)
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

    public void setPoids(double poids)
    {
        this.poids = (float) poids;
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
