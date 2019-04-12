package javaprojects;

import omsu.javaprojects.model.Human;
import omsu.javaprojects.model.PhoneBook;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPhoneBook {

    @Test
    public void testConstruct() {
        PhoneBook obj = new PhoneBook();
        assertNotNull(obj);
    }

    @Test
    public void testAddPhoneAndFindHumanWithPhone() {
        PhoneBook obj = new PhoneBook();
        Human human = new Human("Abc", "Qwe", "Woops", 25);
        obj.addPhone("88005553535", human);
        obj.addPhone("80976986859", human);
        obj.addPhone("80145986859", human);
        obj.addPhone("80546465869", new Human("Asd", "Bob", "Epsol", 22));
        obj.addPhone("23213753165", new Human("AdDsd", "Bodasdb", "Epsol", 22));
        obj.addPhone("68148945643", new Human("AsAsd", "Bsob", "Epasol", 22));
        assertEquals(obj.findHumanWithPhone("88005553535"), human);
        assertEquals(obj.findHumanWithPhone("80976986859"), human);
        assertEquals(obj.findHumanWithPhone("80145986859"), human);
    }

    @Test
    public void testDeletePhoneAndGetPhonesOfHuman() {
        PhoneBook obj = new PhoneBook();
        Human human = new Human("Abc", "Qwe", "Woops", 25);
        obj.addPhone("88005553535", human);
        obj.addPhone("80976986859", human);
        obj.addPhone("80145986859", human);
        obj.addPhone("80546465869", new Human("Asd", "Bob", "Epsol", 20));
        obj.addPhone("23213753165", new Human("AdDsd", "Bodasdb", "Epsol", 24));
        obj.addPhone("68148945643", new Human("AsAsd", "Bsob", "Epasol", 87));
        obj.deletePhone("88005553535");
        List<String> res = new ArrayList<>();
        res.add("80976986859");
        res.add("80145986859");
        assertEquals(obj.getPhonesOfHuman(human), res);
    }

    @Test
    public void testGetPhonesWithPeopleWhereSurnameStartsWith() {
        PhoneBook obj = new PhoneBook();
        Human human = new Human("AAA", "BBB", "CCC", 25);
        obj.addPhone("88005553535", human);
        obj.addPhone("80976986859", human);
        obj.addPhone("80145986859", human);
        Map<Human, List<String>> res = new HashMap<>();
        List<String> temp = new ArrayList<>();
        temp.add("88005553535");
        temp.add("80976986859");
        temp.add("80145986859");
        res.put(human, temp);
        human = new Human("AAD", "CCC", "DDD", 34);
        obj.addPhone("88024553535", human);
        obj.addPhone("80116986859", human);
        temp = new ArrayList<>();
        temp.add("88024553535");
        temp.add("80116986859");
        res.put(human, temp);
        human = new Human("SSS", "CCC", "DDD", 34);
        obj.addPhone("88044553535", human);
        obj.addPhone("80222986859", human);
        assertEquals(obj.getPhonesWithPeopleWhereSurnameStartsWith("AA"), res);
    }


}
