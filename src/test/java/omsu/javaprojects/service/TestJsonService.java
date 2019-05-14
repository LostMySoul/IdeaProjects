package omsu.javaprojects.service;

import omsu.javaprojects.models.House;
import omsu.javaprojects.models.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestJsonService {

    @Test
    public void testEquality() throws IOException {
        House house1 = new House("AAA", "AAA", new Person("AAA", "AAA", "AAA", "AAA"), new ArrayList<>());
        House house2 = new House("BBB", "BBB", new Person("BBB", "BBB", "BBB", "BBB"), new ArrayList<>());
        String json1 = HouseService.toJson(house1);
        String json2 = HouseService.toJson(house2);
        House house3 = new House("AAA", "AAA", new Person("AAA", "AAA", "AAA", "AAA"), new ArrayList<>());
        String json3 = HouseService.toJson(house3);
        assertFalse(JsonService.isJsonEquals(json1, json2));
        assertTrue(JsonService.isJsonEquals(json1, json3));
    }
}
