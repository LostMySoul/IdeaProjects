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
        obj.add("SsssaSSSS");
        obj.add("Sdsadasd");
        obj.add("SSSSSSSSssqffqf");
        obj.add("SSSSdsadasSss");
        obj.add("SsSsSsSs");
        //
        obj.add("ADs");
        obj.add("sAdasfddv");
        obj.add("qwddsfSdsfas");
        obj.add("ddsdasdSsSsSs");
        obj.add("ddsadad");
        obj.add(" S");
        obj.add("");
        obj.add("_S");
        obj.add("dsdasdS");
        assertEquals(ListDemo.getNumberOfStringWithChar(obj, 'S'), 5);
    }

    @Test
    public void testGetListSameSurnameWithOne() {
        Human human = new Human("Jhonson", "Henry", "Baker", 45);
        List<Human> list = new ArrayList<>();
        List<Human> res = new ArrayList<>();
        list.add(new Human(human));
        res.add(new Human(human));
        list.add(new Human("Ivanov", "Ivan", "Ivanovich", 66));
        list.add(new Human("Jhonson", "Timmy", "Cloud", 25));
        res.add(new Human("Jhonson", "Timmy", "Cloud", 25));
        list.add(new Human("Jhonson", "Boris", "Petrovich", 125));
        res.add(new Human("Jhonson", "Boris", "Petrovich", 125));
        list.add(new Human("Jhonsons", "Boriz", "Zovich", 87));
        list.add(new Human("Rainbower", "Zins", "Chovich", 77));
        list.add(new Human("Watson", "Reobert", "Grober", 7));
        assertEquals(ListDemo.getListSameSurname(list, human), res);
    }

    @Test
    public void testDeleteOneFromList() {
        Human human = new Human("Jhonson", "Henry", "Baker", 45);
        List<Human> list = new ArrayList<>();
        List<Human> res = new ArrayList<>();
        list.add(new Human("Jhonson", "Henry", "Baker", 45));
        list.add(new Human("Ivanov", "Ivan", "Ivanovich", 66));
        res.add(new Human("Ivanov", "Ivan", "Ivanovich", 66));
        list.add(new Human("Jhonson", "Timmy", "Cloud", 25));
        res.add(new Human("Jhonson", "Timmy", "Cloud", 25));
        list.add(new Human("Jhonson", "Boris", "Petrovich", 125));
        res.add(new Human("Jhonson", "Boris", "Petrovich", 125));
        list.add(new Human("Jhonsons", "Boriz", "Zovich", 87));
        res.add(new Human("Jhonsons", "Boriz", "Zovich", 87));
        list.add(new Human("Rainbower", "Zins", "Chovich", 77));
        res.add(new Human("Rainbower", "Zins", "Chovich", 77));
        list.add(new Human("Jhonson", "Reobert", "Grober", 7));
        res.add(new Human("Jhonson", "Reobert", "Grober", 7));
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
        obj.add(new Student("Kllda", "Adsds", "Qqadsa", 42, "Ll"));
        obj.add(new Student("Sllda", "Adsds", "Qqadsa", 42, "Ll"));
        obj.add(new Student("Zllda", "Adsds", "Qqadsa", 42, "Ll"));
        obj.add(new Human("Kll", "Ads", "Dsa", 12));
        obj.add(new Human("Kll", "Ads", "Dsa", 42));
        obj.add(new Human("Sdll", "Ads", "Dsa", 42));
        obj.add(new Human("SdKll", "Ads", "Dsa", 12));
        obj.add(new Human("SdKll", "Ads", "Dsa", 12));
        obj.add(new Student("Kllda", "Adsds", "Qqadsa", 42, "Ll"));
        obj.add(new Student("Kllda", "Adsds", "Qqadsa", 72, "Ll"));
        obj.add(new Human("SdKll", "Ads", "Dsa", 12));
        obj.add(new Human("SdKll", "Ads", "Dsa", 12));
        obj.add(new Human("dsdKllda", "sAdsds", "Qqadsa", 52));
        obj.add(new Student("Kllda", "Adsds", "Qqadsa", 82, "Ll"));
        obj.add(new Student("QqKllda", "Adsds", "Qqadsa", 82, "LlD"));
        obj.add(new Student("QqKllda", "Adsds", "Qqadsa", 82, "Ll"));
        obj.add(new Student("Kllda", "Adsds", "Qqadsa", 82, "Ll"));
        obj.add(new Human("Adsllda", "aAdsds", "Qqadsa", 82));
        obj.add(new Human("AdsKllda", "Adsds", "Qqadsa", 82));
        obj.add(new Human("Kllda", "Adsds", "Qqadsa", 82));
        obj.add(new Human("Qllda", "Xdsds", "Cqadsa", 82));

        Set<Human> res = new HashSet<>();
        res.add(new Human("Kllda", "Adsds", "Qqadsa", 82));
        res.add(new Human("Qllda", "Xdsds", "Cqadsa", 82));
        res.add(new Human("Adsllda", "aAdsds", "Qqadsa", 82));
        res.add(new Human("AdsKllda", "Adsds", "Qqadsa", 82));
        res.add(new Student("Kllda", "Adsds", "Qqadsa", 82, "Ll"));
        res.add(new Student("QqKllda", "Adsds", "Qqadsa", 82, "Ll"));
        res.add(new Student("QqKllda", "Adsds", "Qqadsa", 82, "LlD"));
        assertEquals(ListDemo.getSetOfOldest(obj), res);
    }

    @Test
    public void testMakeListFromSet() {
        List<Human> res = new ArrayList<>();
        Set<Human> obj = new HashSet<>();
        obj.add(new Human("A", "Bbc", "Cdd", 18));
        obj.add(new Human("A", "Aac", "Cdd", 78));
        obj.add(new Human("A", "Abc", "Vdd", 178));
        obj.add(new Human("Zebcd", "Abc", "Cdd", 14));
        obj.add(new Human("A", "Dbc", "Cdd", 32));
        obj.add(new Human("Esbcd", "Abc", "Cdd", 8));
        obj.add(new Student("Esbcd", "Abc", "DDD", 87, "Ff"));
        obj.add(new Student("Asbcd", "Abc", "Cdd", 82, "Fa"));
        obj.add(new Human("A", "Bbc", "Cdd", 7));
        obj.add(new Student("Esbcd", "Abc", "Add", 28, "FE"));
        res.add(new Human("A", "Aac", "Cdd", 78));
        res.add(new Human("A", "Abc", "Vdd", 178));
        res.add(new Human("A", "Bbc", "Cdd", 18));
        res.add(new Human("A", "Bbc", "Cdd", 7));
        res.add(new Human("A", "Dbc", "Cdd", 32));
        res.add(new Student("Asbcd", "Abc", "Cdd", 82, "Fa"));
        res.add(new Student("Esbcd", "Abc", "Add", 28, "FE"));
        res.add(new Human("Esbcd", "Abc", "Cdd", 8));
        res.add(new Student("Esbcd", "Abc", "DDD", 87, "Ff"));
        res.add(new Human("Zebcd", "Abc", "Cdd", 14));
        assertEquals(ListDemo.makeListFromSet(obj), res);
    }

    @Test
    public void testIdentifyHumans() {
        Map<Integer, Human> mapId = new HashMap<>();
        Set<Integer> setOfId = new HashSet<>();
        Set<Human> res = new HashSet<>();
        mapId.put(1, new Human("Fdd", "Adds", "Acss", 14));
        setOfId.add(1);
        res.add(new Human("Fdd", "Adds", "Acss", 14));
        mapId.put(2, new Human("Edd", "Redsds", "Vbss", 30));
        setOfId.add(2);
        res.add(new Human("Edd", "Redsds", "Vbss", 30));
        mapId.put(22, new Human("Zss", "Forsds", "Qrss", 22));
        setOfId.add(22);
        res.add(new Human("Zss", "Forsds", "Qrss", 22));
        mapId.put(25, new Human("Oppsd", "Klos", "Lks", 53));
        setOfId.add(25);
        res.add(new Human("Oppsd", "Klos", "Lks", 53));
        mapId.put(117, new Human("Black", "Monds", "Qwre", 1));
        setOfId.add(117);
        res.add(new Human("Black", "Monds", "Qwre", 1));
        mapId.put(220, new Human("AsdfZss", "Forsds", "Qrss", 22));
        mapId.put(22475, new Human("QrZss", "GfsdForsds", "SDdQrss", 22));
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
        mapId.put(1, new Human("Fdd", "Adds", "Acss", 14));
        mapId.put(2, new Human("Edd", "Redsds", "Vbss", 30));
        res.add(2);
        mapId.put(22, new Human("Zss", "Forsds", "Qrss", 22));
        res.add(22);
        mapId.put(220, new Human("AsdfZss", "Forsds", "Qrss", 22));
        res.add(220);
        mapId.put(22475, new Human("QrZss", "GfsdForsds", "SDdQrss", 17));
        mapId.put(25, new Human("Oppsd", "Klos", "Lks", 53));
        res.add(25);
        mapId.put(117, new Human("Black", "Monds", "Qwre", 1));
        mapId.put(2117, new Human("Redflack", "Monds", "Qwre", 18));
        res.add(2117);
        assertEquals(ListDemo.getIdOfFullAged(mapId), res);
    }

    @Test
    public void testIdAgeMap() {
        Map<Integer, Human> mapId = new HashMap<>();
        Map<Integer, Integer> idAgeMap = new HashMap<>();
        mapId.put(1, new Human("Fdd", "Adds", "Acss", 14));
        idAgeMap.put(1, 14);
        mapId.put(2, new Human("Edd", "Redsds", "Vbss", 30));
        idAgeMap.put(2, 30);
        mapId.put(117, new Human("Black", "Monds", "Qwre", 1));
        idAgeMap.put(117, 1);
        mapId.put(2117, new Human("Redflack", "Monds", "Qwre", 18));
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

    @Test
    public void getWithAgeAndChar() {
        Set<Human> input = new HashSet<>();
        Human h1 = new Human("AAA", "AAA", "AAA", 30);
        Human h2 = new Human("BBB", "BBB", "BBB", 22);
        Human h3 = new Human("ACC", "CCC", "CCC", 30);
        Human h4 = new Human("DDD", "DDD", "DDD", 30);
        Human h5 = new Human("EEE", "EEE", "EEE", 53);
        input.add(h1);
        input.add(h2);
        input.add(h3);
        input.add(h4);
        input.add(h5);
        Map<Integer, Map<Character, List<Human>>> map = new HashMap<>();

        List<Human> temp = new ArrayList<>();
        temp.add(h3);
        temp.add(h1);
        Map<Character, List<Human>> charMap = new HashMap<>();
        charMap.put('A',temp);
        map.put(30, charMap);

        temp = new ArrayList<>();
        temp.add(h4);
        charMap.put('D',temp);
        map.put(30, charMap);


        temp = new ArrayList<>();
        temp.add(h2);
        charMap = new HashMap<>();
        charMap.put('B',temp);
        map.put(22, charMap);

        temp = new ArrayList<>();
        temp.add(h5);
        charMap = new HashMap<>();
        charMap.put('E',temp);
        map.put(53, charMap);

        assertEquals(ListDemo.ageCharMap(input), map);
    }
}
