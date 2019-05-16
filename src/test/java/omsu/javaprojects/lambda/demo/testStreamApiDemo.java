package omsu.javaprojects.lambda.demo;

import omsu.javaprojects.lambda.models.Gender;
import omsu.javaprojects.lambda.models.Human;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class testStreamApiDemo {
    private final Human[] arr = {
            new Human("AAA", "AAA", "AAA", Gender.MALE, 35),
            new Human("BBB", "BBB", "BBB", Gender.FEMALE, 23),
            new Human("CCC", "CCC", "CCC", Gender.MALE, 13),
            new Human("DDD", "CCC", "DDD", Gender.FEMALE, 44)
    };

    @Test
    public void testNotNullList() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("S");
        list.add("Str");
        list.add(null);
        list.add(new Human("", "", "", Gender.FEMALE, 1));
        list.add(null);
        list.add("another Str");
        assertEquals(StreamApiDemo.removeNull.get(list).size(), 4);
    }

    @Test
    public void testPositiveCount() {
        Set<Integer> ints = new HashSet<>();
        ints.add(1);
        ints.add(3);
        ints.add(33);
        ints.add(32);
        ints.add(301);
        ints.add(-5);
        ints.add(-3);
        ints.add(-1);
        assertEquals(StreamApiDemo.positiveCount.get(ints), 5);
    }

    @Test
    public void testLastElements() {
        List<Object> list = Arrays.asList("A", "B", "C", "D");
        assertEquals(StreamApiDemo.lastElements.get(list).size(), 3);
    }

    @Test
    public void testFirstEven() {
        List<Integer> list = Arrays.asList(1, 3, 4, 2);
        assertEquals(StreamApiDemo.firstEven.get(list), new Integer(4));
        list = Arrays.asList(2, 3, 4, 2);
        assertEquals(StreamApiDemo.firstEven.get(list), new Integer(2));
        list = Arrays.asList(1, 3, 5);
        assertNull(StreamApiDemo.firstEven.get(list));
    }

    @Test
    public void testQuadSet() {
        Integer[] list = {1, 3, 3, 4, 5};
        Integer[] expected = {1, 9, 16, 25};
        assertEquals(StreamApiDemo.quadSet.get(list), Arrays.asList(expected));
    }

    @Test
    public void testNotEmptyString() {
        List<String> list = Arrays.asList("A", "B", "", "C", "D", "");
        List<String> expected = Arrays.asList("A", "B", "C", "D");
        assertEquals(StreamApiDemo.notEmptyStringList.get(list), expected);
    }

    @Test
    public void testSetToSortedList() {
        Set<String> strs = new HashSet<>();
        strs.add("eee");
        strs.add("ddd");
        strs.add("aaa");
        strs.add("bbb");
        strs.add("ccc");
        List<String> expected = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        assertEquals(StreamApiDemo.setToSortedList.get(strs), expected);
    }

    @Test
    public void testQuadSum() {
        Set<Integer> ints = new HashSet<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(5);
        ints.add(10);
        assertEquals(StreamApiDemo.quadSum.get(ints), new Integer(139));
    }

    @Test
    public void testMaxAge() {
        assertEquals(StreamApiDemo.maxAge.get(Arrays.asList(arr)), new Integer(44));
    }

    @Test
    public void testGenderAgeSorted(){
        assertEquals(
                Arrays.asList(arr[2],arr[0],arr[1],arr[3]),
                StreamApiDemo.genderAgeSorted.get(Arrays.asList(arr))
        );
    }

}
