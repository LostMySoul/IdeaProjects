package omsu.javaprojects.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import omsu.javaprojects.models.House;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;


public class HouseService {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void serializeHouse(OutputStream out, House house) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeObject(house);
        }
    }

    public static House deserializeHouse(InputStream in) throws IOException, ClassNotFoundException {
        try(ObjectInputStream oin = new ObjectInputStream(in)){
            return (House) oin.readObject();
        }
    }

    public static String toJson(House house) throws JsonProcessingException {
        return mapper.writeValueAsString(house);
    }

    public static House fromJson(String jsonString) throws IOException {
        return mapper.readValue(jsonString, House.class);
    }
}
