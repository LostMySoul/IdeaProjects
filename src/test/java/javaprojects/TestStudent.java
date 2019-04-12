package javaprojects;

import omsu.javaprojects.model.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestStudent {
    @Test
    public void testConstruct() {
        Student obj = new Student("Abc", "Abc", "Abc", 1, "Gg");
        assertNotNull(obj);
        Student obj2 = new Student(obj);
        assertNotNull(obj2);
        assertEquals(obj.getFacultyName(), obj2.getFacultyName());
    }

    @Test
    public void testSettersAndGetters() {
        Student obj = new Student("abc", "ad", "s", 10, "Ff");
        obj.setFacultyName("Gg");
        assertEquals(obj.getFacultyName(), "Gg");
    }
}
