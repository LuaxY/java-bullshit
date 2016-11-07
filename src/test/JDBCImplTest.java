package test;

import junit.framework.TestCase;
import service.CagePOJO;
import storage.JDBCImpl;

import java.util.List;

/**
 * Created by Luax on 03/11/2016.
 */

public class JDBCImplTest extends TestCase
{
    public void testRead() throws Exception
    {
        JDBCImpl jdbc = new JDBCImpl();
        CagePOJO cagePOJO = jdbc.read(2);

        assertEquals("GAGAG", cagePOJO.getNom());
        assertEquals(34, cagePOJO.getGazelle().getLgCornes());
    }

    public void testReadAll() throws Exception
    {
        JDBCImpl jdbc = new JDBCImpl();
        List<CagePOJO> cagePOJOs = jdbc.readAll();

        assertEquals(5, cagePOJOs.size());
        assertEquals("clarence", cagePOJOs.get(0).getNom());
    }

    public void testUpdate() throws Exception
    {
        CagePOJO before = null;
        float weight = 0;

        JDBCImpl jdbc = new JDBCImpl();

        before = jdbc.read(1);
        weight = before.getPoids();
        //assertEquals(172.3f, before.getPoids(), 0.0); // not sure about the weight in DB
        before.setPoids(175.4f);
        jdbc.update(before);
        before = jdbc.read(1);
        assertEquals(175.4f, before.getPoids());
        before.setPoids(170.4f);
        jdbc.update(before);
        before = jdbc.read(1);
        assertEquals(170.4f, before.getPoids());
    }

}