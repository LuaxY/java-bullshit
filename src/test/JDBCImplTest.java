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
        assertEquals(34, cagePOJO.getGazelle().getLgCorne());
    }

    public void testReadAll() throws Exception
    {
        JDBCImpl jdbc = new JDBCImpl();
        List<CagePOJO> cagePOJOs = jdbc.readAll();

        assertEquals(5, cagePOJOs.size());
        assertEquals("clarence", cagePOJOs.get(0).getNom());
    }

}