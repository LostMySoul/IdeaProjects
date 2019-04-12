package javaprojects;

import omsu.javaprojects.exceptions.IllegalIdException;
import omsu.javaprojects.model.Group;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class TestGroup {

    @Test
    public void testConstructDefaultAndGetters() {
        Group obj = new Group();
        assertNotNull(obj);
        assertEquals(obj.getId(), 1);
    }

    @Test
    public void testConstructWithDataAndCopy() {
        Group obj = new Group(100, 1, 2, 3, 4, 5);
        assertNotNull(obj);
        int[] res = {1,2,3,4,5};
        assertEquals(obj.getId(), 100);
        assertEquals(obj.getData().length, res.length);
        Group copyObj = new Group(obj);
        assertNotNull(copyObj);
        assertEquals(copyObj.getId(), 100);
        assertEquals(copyObj.getData().length, res.length);
    }

    @Test
    public void testCopyWithNewIdAndSetters() {
        Group obj = new Group();
        obj.setId(23);
        obj.setData(1, 8, 0, 9);
        int[] res = {1, 8, 0, 9};
        Group copyObj = new Group(obj, 10);
        assertEquals(obj.getData().length, res.length);
        assertEquals(copyObj.getData().length, obj.getData().length);
        assertNotEquals(copyObj.getId(), obj.getId());
    }

    @Test
    public void testLength() {
        Group obj = new Group(23, 10, 18, 0, 9, 3, 1, 0, 7);
        assertEquals(obj.length(), 8);
    }

    @Test(expected = IllegalIdException.class)
    public void testConstructException() {
        Group obj = new Group(-45, 1);
        fail();
    }

    @Test(expected = IllegalIdException.class)
    public void testSetException() {
        Group obj = new Group(54, 1);
        obj.setId(0);
        fail();
    }
}
