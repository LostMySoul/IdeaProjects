package omsu.javaprojects.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFlat {
    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSerializers() throws IOException {
        List<Person> people = new ArrayList<>();
        Person ded = new Person("ded", "doed", "alexeevich", "---");
        people.add(ded);
        Person son = new Person("sina", "korzina", "mikhailovich", "---");
        people.add(son);
        Flat flat = new Flat(11, 100, people);
        String json = mapper.writeValueAsString(flat);
        Flat deFlat = mapper.readValue(json, Flat.class);
        assertEquals(flat,deFlat);
    }
}
