package test;

import controller.ZooManager;
import junit.framework.TestCase;
import model.Visitor;

/**
 * Created by Luax on 21/10/2016.
 */
public class ZooManagerTest extends TestCase
{
    public void testIn() throws Exception
    {
        assertEquals(0, ZooManager.getInstance().getNumberOfVisitor());
        ZooManager.getInstance().in();
        assertEquals(1, ZooManager.getInstance().getNumberOfVisitor());

        for (int i = 0; i < Visitor.MAX_VISITOR + 5; i++)
        {
            ZooManager.getInstance().in();
        }

        assertEquals(Visitor.MAX_VISITOR, ZooManager.getInstance().getNumberOfVisitor());

        for (int i = 0; i < Visitor.MAX_VISITOR + 5; i++)
        {
            ZooManager.getInstance().out();
        }

        assertEquals(0, ZooManager.getInstance().getNumberOfVisitor());
    }

    public void testOut() throws Exception
    {
        assertEquals(0, ZooManager.getInstance().getNumberOfVisitor());
        ZooManager.getInstance().out();
        assertEquals(0, ZooManager.getInstance().getNumberOfVisitor());
        ZooManager.getInstance().in();
        assertEquals(1, ZooManager.getInstance().getNumberOfVisitor());

        for (int i = 0; i < Visitor.MAX_VISITOR + 5; i++)
        {
            ZooManager.getInstance().out();
        }

        assertEquals(0, ZooManager.getInstance().getNumberOfVisitor());
    }

}