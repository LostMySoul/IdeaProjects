package javaprojects;

import omsu.javaprojects.model.Data;
import omsu.javaprojects.model.Group;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestData {

    @Test
    public void testConstructNoParam() {
        Data obj = new Data();
        assertNotNull(obj);
        assertEquals(obj.getNameOfSet(), "Default Data");
        assertNull(obj.getGroups());
    }

    @Test
    public void testConstruct() {
        Data obj = new Data("Jhonny", new Group(),
                new Group(1, 1, 2, 3), new Group(2, 2, 8));
        Group[] res= { new Group(),
                new Group(1, 1, 2, 3), new Group(2, 2, 8)};
        assertNotNull(obj);
        assertEquals(obj.getGroups().length, res.length);
        assertEquals(obj.getNameOfSet(), "Jhonny");
    }

    @Test
    public void testConstructCopyAndCopyWithName() {
        Data obj = new Data("Jhonny", new Group(),
                new Group(1, 1, 2, 3), new Group(2, 2, 8));
        Data copyObj = new Data(obj);
        assertNotNull(copyObj);
        assertEquals(obj.getNameOfSet(), copyObj.getNameOfSet());
        assertEquals(copyObj.getGroups(), obj.getGroups());
        obj = new Data(copyObj, "Willy");
        assertNotNull(obj);
        assertEquals(obj.getGroups(), copyObj.getGroups());
        assertNotEquals(obj.getNameOfSet(), copyObj.getNameOfSet());
        assertEquals(obj.getNameOfSet(), "Willy");
    }

    @Test
    public void testSetters() {
        Data obj = new Data();
        obj.setNameOfSet("Polly");
        Group[] gr = {new Group(),new Group(1, 1, 2, 3),new Group(2, 2, 8)};
        obj.setGroups(gr);
        assertEquals(obj.getNameOfSet(), "Polly");
        assertEquals(obj.getGroups().length, gr.length);
    }

    @Test
    public void testIterator() {
        Data obj = new Data("Jhonny", new Group(),
                new Group(1, 23, 2, 3), new Group(2, 2, 8));
        assertNotNull(obj.iterator());
        assertTrue(obj.iterator().hasNext());
        assertEquals(obj.iterator().next(), (Integer) 23);
    }
}
