package omsu.javaprojects.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestHouse {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSerializers() throws IOException {
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("AAA", "AAA", "AAA", "---");
        people.add(p1);
        Person p2 = new Person("BBB", "BBB", "BBB", "---");
        people.add(p2);
        Flat flat1 = new Flat(11, 100, people);
        ///////////////////////
        people = new ArrayList<>();
        p1 = new Person("CCC", "CCC", "CCC", "---");
        people.add(p1);
        p2 = new Person("DDD", "DDD", "DDD", "---");
        people.add(p2);
        Flat flat2 = new Flat(22, 200, people);
        ///////////////////////
        people = new ArrayList<>();
        p1 = new Person("EEE", "EEE", "EEE", "---");
        people.add(p1);
        p2 = new Person("FFF", "FFF", "FFF", "---");
        people.add(p2);
        Flat flat3 = new Flat(33, 300, people);
        ///////////////////////
        List<Flat> flats = new ArrayList<>();
        flats.add(flat1);
        flats.add(flat2);
        flats.add(flat3);
        Person senior = new Person("Senior", "Senior", "Senior", "---");
        House house = new House("CADASTRAL", "MIRA55A", senior, flats);
        String json = mapper.writeValueAsString(house);
        House deHouse = mapper.readValue(json, House.class);
        ///////////////////////
        assertEquals(house, deHouse);
    }
}
