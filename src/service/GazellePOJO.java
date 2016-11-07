package service;

import javax.persistence.*;

/**
 * Created by Luax on 03/11/2016.
 */

@Entity
@Table(name = "gazelle")
public class GazellePOJO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // primary key

    private int idAnimal;

    private int lgCornes;

    public GazellePOJO()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getIdAnimal()
    {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal)
    {
        this.idAnimal = idAnimal;
    }

    public int getLgCornes()
    {
        return lgCornes;
    }

    public void setLgCornes(int lgCornes)
    {
        this.lgCornes = lgCornes;
    }
}
