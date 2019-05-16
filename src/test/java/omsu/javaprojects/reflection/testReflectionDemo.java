package omsu.javaprojects.reflection;

import omsu.javaprojects.exec.Executor;
import omsu.javaprojects.models.Data;
import omsu.javaprojects.models.Group;
import omsu.javaprojects.models.Human;
import omsu.javaprojects.models.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testReflectionDemo {
    @Test
    public void testCountHuman() {
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Human("AAA", "AAA", "AAA", 1998));
        objectList.add(new Human("BBB", "BBB", "BBB", 1997));
        objectList.add(new Human("CCC", "CCC", "CCC", 1995));
        objectList.add(new Group(1, 1, 2, 5));
        objectList.add(new Object());
        objectList.add("someString");
        assertEquals(ReflectionDemo.countHuman(objectList), 3);
    }
    @Test
    public void testListName(){
        List<String> result = new ArrayList<>();
        Group group = new Group(1);
        result.add("getId");
        result.add("setId");
        result.add("setData");
        result.add("getData");
        result.add("length");

        result.add("getClass");
        result.add("hashCode");
        result.add("equals");
        result.add("toString");
        result.add("notify");
        result.add("notifyAll");
        result.add("wait");
        result.add("wait");
        result.add("wait");
        assertTrue(ReflectionDemo.listName(group).containsAll(result));
    }

    @Test
    public   void testSuperClassName(){
        List<String> result = new ArrayList<>();
        Student student = new Student("AAA","BBB","CCC",90,"IMIT");
        result.add("Human");
        result.add("Object");
        assertTrue(result.containsAll(ReflectionDemo.superClassName(student)));
    }
    @Test
    public void testExecutable(){
        List<Object> list = new ArrayList<>();
        list.add(new Executor());
        list.add(new Data("A"));
        list.add(new Human("AAA", "AAA", "AAA", 1233));
        list.add(new Group(1));
        list.add(new Object());
        list.add("someStr");
        assertEquals(ReflectionDemo.findExecutable(list), 2);
    }

    @Test
    public void testGetSetAndGet(){
        List<String> list = new ArrayList();
        list.add("public java.lang.String omsu.javaprojects.models.Human.getName()");
        list.add("public void omsu.javaprojects.models.Human.setName(java.lang.String)");
        list.add("public java.lang.String omsu.javaprojects.models.Human.getSurname()");
        list.add("public void omsu.javaprojects.models.Human.setSurname(java.lang.String)");
        list.add("public java.lang.String omsu.javaprojects.models.Human.getPatronymic()");
        list.add("public void omsu.javaprojects.models.Human.setPatronymic(java.lang.String)");
        list.add("public int omsu.javaprojects.models.Human.getAge()");
        list.add("public void omsu.javaprojects.models.Human.setAge(int)");
        list.add("public final native java.lang.Class java.lang.Object.getClass()");
        System.out.println(ReflectionDemo.getGetAndSet(new Human("AA", "BB", "CC", 99)));
        assertTrue(list.containsAll(ReflectionDemo.getGetAndSet(new Human("AA", "BB", "CC", 99))));
    }
}
