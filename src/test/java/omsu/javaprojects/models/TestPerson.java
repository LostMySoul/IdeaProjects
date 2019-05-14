package omsu.javaprojects.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestPerson {
    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSerializers() throws IOException {
        Person ded = new Person("ded", "doed", "alexeevich", "---");
        String json = mapper.writeValueAsString(ded);
        Person deDed = mapper.readValue(json, Person.class);
        assertEquals(ded, deDed);
    }
}
