package omsu.javaprojects.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonService {
    private static ObjectMapper mapper = new ObjectMapper();

    public static boolean isJsonEquals(String j1, String j2) throws IOException {
        final JsonNode tree1 = mapper.readTree(j1);
        final JsonNode tree2 = mapper.readTree(j2);
        return tree1.equals(tree2);
    }
}
