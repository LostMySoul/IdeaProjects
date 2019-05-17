package javaprojects;

import omsu.javaprojects.model.Human;
import omsu.javaprojects.demo.ListDemo;
import omsu.javaprojects.model.Student;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TestListDemo {

    @Test
    public void testGetNumberOfStringsWithSameStartChar() {
        List<String> obj = new ArrayList<>();
        obj.add("Sad");
        obj.add("Star");
        obj.add("Sim");
        //
        obj.add("bad");
        obj.add("true");
        obj.add("false");
        obj.add(" S");
        obj.add("");
        obj.add("_S");
        assertEquals(ListDemo.getNumberOfStringWithChar(obj, 'S'), 3);
    }

    @Test
    public void testGetListSameSurnameWithOne() {
        Human human = new Human("HUMAN", "HUMAN", "HUMAN", 45);
        List<Human> list = new ArrayList<>();
        List<Human> res = new ArrayList<>();
        list.add(new Human(human));
        res.add(new Human(human));
        list.add(new Human("AAA", "AAA", "AAA", 66));
        list.add(new Human("HUMAN", "BBB", "BBB", 25));
        res.add(new Human("HUMAN", "BBB", "BBB", 25));
        list.add(new Human("HUMAN", "CCC", "CCC", 3));
        res.add(new Human("HUMAN", "CCC", "CCC", 3));
        list.add(new Human("HUMAN", "DDD", "DDD", 125));
        res.add(new Human("HUMAN", "DDD", "DDD", 125));
        list.add(new Human("EEE", "EEE", "EEE", 87));
        list.add(new Human("FFF", "FFF", "FFF", 77));
        list.add(new Human("GGG", "GGG", "GGG", 7));
        assertEquals(ListDemo.getListSameSurname(list, human), res);
    }

    @Test
    public void testDeleteOneFromList() {
        Human human = new Human("HUMAN", "HUMAN", "HUMAN", 45);
        List<Human> list = new ArrayList<>();
        List<Human> res = new ArrayList<>();
        list.add(new Human("HUMAN", "HUMAN", "HUMAN", 45));
        list.add(new Human("AAA", "AAA", "AAA", 66));
        list.add(new Human("BBB", "BBB", "BBB", 25));
        list.add(new Human("DDD", "DDD", "DDD", 125));
        list.add(new Human("EEE", "EEE", "EEE", 87));
        list.add(new Human("FFF", "FFF", "FFF", 77));
        list.add(new Human("GGG", "GGG", "GGG", 7));
        res.add(new Human("AAA", "AAA", "AAA", 66));
        res.add(new Human("BBB", "BBB", "BBB", 25));
        res.add(new Human("DDD", "DDD", "DDD", 125));
        res.add(new Human("EEE", "EEE", "EEE", 87));
        res.add(new Human("FFF", "FFF", "FFF", 77));
        res.add(new Human("GGG", "GGG", "GGG", 7));
        assertEquals(ListDemo.getListExcludeOne(list, human), res);
    }

    @Test
    public void testRemoveIntersectSets() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        Set<Integer> set1 = new HashSet<>();//-
        set1.add(1);
        set1.add(9);
        set1.add(0);
        set1.add(91);
        Set<Integer> set2 = new HashSet<>();//+
        set2.add(20);
        set2.add(12);
        set2.add(974);
        set2.add(87);
        set2.add(78);
        set2.add(45);
        Set<Integer> set3 = new HashSet<>();//+
        set3.add(0);
        Set<Integer> set4 = new HashSet<>();//-
        set4.add(1);
        set4.add(2);
        set4.add(3);
        set4.add(4);
        set4.add(5);
        Set<Integer> set5 = new HashSet<>();//-
        set5.add(8);
        set5.add(10);
        set5.add(85);
        set5.add(18);
        set5.add(4);
        set5.add(102);
        Set<Integer> set6 = new HashSet<>();//+
        Set<Integer> set7 = new HashSet<>();//+
        set7.add(45);
        set7.add(123);
        set7.add(1234);
        set7.add(12345);
        List<Set<Integer>> list = new ArrayList<>();
        list.add(set1);
        list.add(set2);
        list.add(set3);
        list.add(set4);
        list.add(set5);
        list.add(set6);
        list.add(set7);
        List<Set<Integer>> res = new ArrayList<>();
        res.add(set2);
        res.add(set3);
        res.add(set6);
        res.add(set7);
        assertEquals(res, ListDemo.removeIntersectSets(list, set));
    }

    @Test
    public void testGetSetOfOldest() {
        List<Human> obj = new ArrayList<>();
        obj.add(new Human("AAA", "AAA", "AAA", 52));
        obj.add(new Human("BBB", "BBB", "BBB", 12));
        obj.add(new Human("CCC", "CCC", "CCC", 42));
        obj.add(new Human("DDD", "DDD", "DDD", 42));
        obj.add(new Human("EEE", "EEE", "EEE", 12));
        obj.add(new Student("FFF", "FFF", "FFF", 42, "FFF"));
        obj.add(new Student("GGG", "GGG", "GGG", 72, "GGG"));
        obj.add(new Human("HHH", "HHH", "HHH", 82));
        obj.add(new Human("III", "III", "III", 82));
        obj.add(new Human("JJJ", "JJJ", "JJJ", 82));
        obj.add(new Human("KKK", "KKK", "KKK", 82));
        obj.add(new Student("LLL", "LLL", "LLL", 82, "LLL"));
        obj.add(new Student("MMM", "MMM", "MMM", 82, "MMM"));
        obj.add(new Student("NNN", "NNN", "NNN", 82, "NNN"));

        Set<Human> res = new HashSet<>();
        res.add(new Human("HHH", "HHH", "HHH", 82));
        res.add(new Human("III", "III", "III", 82));
        res.add(new Human("JJJ", "JJJ", "JJJ", 82));
        res.add(new Human("KKK", "KKK", "KKK", 82));
        res.add(new Student("LLL", "LLL", "LLL", 82, "LLL"));
        res.add(new Student("MMM", "MMM", "MMM", 82, "MMM"));
        res.add(new Student("NNN", "NNN", "NNN", 82, "NNN"));
        assertEquals(ListDemo.getSetOfOldest(obj), res);
    }

    @Test
    public void testIdentifyHumans() {
        Map<Integer, Human> mapId = new HashMap<>();
        Set<Integer> setOfId = new HashSet<>();
        Set<Human> res = new HashSet<>();
        mapId.put(1, new Human("AAA", "AAA", "AAA", 14));
        setOfId.add(1);
        res.add(new Human("AAA", "AAA", "AAA", 14));
        mapId.put(2, new Human("BBB", "BBB", "BBB", 30));
        setOfId.add(2);
        res.add(new Human("BBB", "BBB", "BBB", 30));
        mapId.put(22, new Human("CCC", "CCC", "CCC", 22));
        setOfId.add(22);
        res.add(new Human("CCC", "CCC", "CCC", 22));
        mapId.put(25, new Human("DDD", "DDD", "DDD", 53));
        setOfId.add(25);
        res.add(new Human("DDD", "DDD", "DDD", 53));
        mapId.put(117, new Human("EEE", "EEE", "EEE", 1));
        setOfId.add(117);
        res.add(new Human("EEE", "EEE", "EEE", 1));
        mapId.put(220, new Human("FFF", "FFF", "FFF", 22));
        mapId.put(22475, new Human("GGG", "GGG", "GGG", 22));
        setOfId.add(2774);
        setOfId.add(36);
        setOfId.add(3);
        setOfId.add(87);
        setOfId.add(110);
        setOfId.add(10);
        setOfId.add(19);
        assertEquals(ListDemo.identifyHumans(mapId, setOfId), res);
    }

    @Test
    public void testGetIdAge() {
        Map<Integer, Human> mapId = new HashMap<>();
        Set<Integer> res = new HashSet<>();
        mapId.put(1, new Human("AAA", "AAA", "AAA", 14));
        mapId.put(2, new Human("BBB", "BBB", "BBB", 30));
        res.add(2);
        mapId.put(22, new Human("CCC", "CCC", "CCC", 22));
        res.add(22);
        mapId.put(220, new Human("DDD", "DDD", "DDD", 22));
        res.add(220);
        mapId.put(22475, new Human("EEE", "EEE", "EEE", 17));
        mapId.put(25, new Human("FFF", "FFF", "FFF", 53));
        res.add(25);
        mapId.put(117, new Human("GGG", "GGG", "GGG", 1));
        mapId.put(2117, new Human("HHH", "HHH", "HHH", 18));
        res.add(2117);
        assertEquals(ListDemo.getIdOfFullAged(mapId), res);
    }

    @Test
    public void testIdAgeMap() {
        Map<Integer, Human> mapId = new HashMap<>();
        Map<Integer, Integer> idAgeMap = new HashMap<>();
        mapId.put(1, new Human("AAA", "AAA", "AAA", 14));
        idAgeMap.put(1, 14);
        mapId.put(2, new Human("BBB", "BBB", "BBB", 30));
        idAgeMap.put(2, 30);
        mapId.put(117, new Human("CCC", "CCC", "CCC", 1));
        idAgeMap.put(117, 1);
        mapId.put(2117, new Human("DDD", "DDD", "DDD", 18));
        idAgeMap.put(2117, 18);
        assertEquals(ListDemo.getIdAgeMap(mapId), idAgeMap);
    }

    @Test
    public void getWithAge() {
        Set<Human> input = new HashSet<>();
        Human h1 = new Human("AAA", "AAA", "AAA", 30);
        Human h2 = new Human("BBB", "BBB", "BBB", 22);
        Human h3 = new Human("CCC", "CCC", "CCC", 30);
        Human h4 = new Human("DDD", "DDD", "DDD", 30);
        Human h5 = new Human("EEE", "EEE", "EEE", 53);
        input.add(h1);
        input.add(h2);
        input.add(h3);
        input.add(h4);
        input.add(h5);
        Map<Integer, List<Human>> map = new HashMap<>();

        List<Human> temp = new ArrayList<>();
        temp.add(h1);
        temp.add(h4);
        temp.add(h3);
        map.put(30, temp);

        temp = new ArrayList<>();
        temp.add(h2);
        map.put(22, temp);

        temp = new ArrayList<>();
        temp.add(h5);
        map.put(53, temp);

        assertEquals(ListDemo.getWithAge(input), map);
    }

}
