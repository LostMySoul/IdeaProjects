package omsu.javaprojects.service;

import omsu.javaprojects.models.House;
import omsu.javaprojects.models.Person;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testHouseService {

    @Test
    public void testSerializeDeserializeUsingObjectOutputStream() throws IOException, ClassNotFoundException {
        House house = new House("AAA", "AAA",
                new Person("AAA", "AAA", "AAA", "AAA"),
                new ArrayList<>());
        HouseService.serializeHouse(new FileOutputStream("test.out"), house);
        House res = HouseService.deserializeHouse(new FileInputStream("test.out"));
        assertEquals(house,res);
    }


    @Test
    public void testHouseJsonSerializeDeserialize() throws IOException {
        House house = new House("AAA", "AAA",
                new Person("AAA", "AAA", "AAA", "AAA"),
                new ArrayList<>());
        String json = HouseService.toJson(house);
        House res = HouseService.fromJson(json);
        assertEquals(house, res);
    }
}
