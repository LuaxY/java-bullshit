package service;

/**
 * Created by Luax on 03/11/2016.
 */

public class GazellePOJO
{
    private int id; // primary key
    private int idAnimal;
    private int lgCorne;

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

    public int getLgCorne()
    {
        return lgCorne;
    }

    public void setLgCorne(int lgCorne)
    {
        this.lgCorne = lgCorne;
    }
}
