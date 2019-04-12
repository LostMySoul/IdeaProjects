package javaprojects;

import omsu.javaprojects.iter.DataIterator;
import omsu.javaprojects.model.Data;
import omsu.javaprojects.model.Group;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestDataIterator {

    @Test
    public void testConstruct() {
        Data obj = new Data("Luis", new Group(1, 2, 3, 4));
        DataIterator iter = new DataIterator(obj);
        assertNotNull(iter);
    }

    @Test
    public void testHasNext() {
        Data obj = new Data("Luis", new Group(1, 2, 3, 4), new Group(2, 2, 2),
                new Group(5, 8, 72));
        DataIterator iter = new DataIterator(obj);
        for (int i = 0; i < 7; i++) {
            assertTrue(iter.hasNext());
            iter.next();
        }
    }

    @Test
    public void testNext() {
        Data obj = new Data("Luis", new Group(1, 1, 2, 3), new Group(2, 4, 5),
                new Group(5, 6, 7));
        DataIterator iter = new DataIterator(obj);
        int counter = 0;
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        while (iter.hasNext()) {
            assertEquals(iter.next(), (Integer) arr[counter]);
            counter++;
        }
        assertEquals(counter, 7);
    }
}
