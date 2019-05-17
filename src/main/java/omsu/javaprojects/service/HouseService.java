package omsu.javaprojects.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import omsu.javaprojects.models.Flat;
import omsu.javaprojects.models.House;
import omsu.javaprojects.models.Person;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class HouseService {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void serializeHouse(OutputStream out, House house) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeUTF(house.getCadastralId());
            oos.writeUTF(house.getAdress());
            Person senior = house.getSenior();
            oos.writeUTF(senior.getFirstName());
            oos.writeUTF(senior.getLastName());
            oos.writeUTF(senior.getPatronymic());
            oos.writeUTF(senior.getBirthDate());
            oos.writeInt(house.getFlats().size());
            for (Flat flat : house.getFlats()) {
                oos.writeInt(flat.getNumber());
                oos.writeDouble(flat.getArea());
                oos.writeInt(flat.getOwners().size());
                for (Person person : flat.getOwners()) {
                    oos.writeUTF(person.getFirstName());
                    oos.writeUTF(person.getLastName());
                    oos.writeUTF(person.getPatronymic());
                    oos.writeUTF(person.getBirthDate());
                }
            }
        }
    }

    public static House deserializeHouse(InputStream in) throws IOException {
        try (ObjectInputStream oin = new ObjectInputStream(in)) {
            String cadastral = oin.readUTF();
            String adress = oin.readUTF();
            Person senior = new Person(oin.readUTF(), oin.readUTF(), oin.readUTF(), oin.readUTF());
            int numOfFlats = oin.readInt();
            List<Flat> flats = new ArrayList<>();
            for (int i = 0; i < numOfFlats; i++) {
                int number = oin.readInt();
                double area = oin.readDouble();
                int numOfOwners = oin.readInt();
                List<Person> owners = new ArrayList<>();
                for (int j = 0; j < numOfOwners; j++) {
                    owners.add(new Person(oin.readUTF(), oin.readUTF(), oin.readUTF(), oin.readUTF()));
                }
                flats.add(new Flat(number, area, owners));
            }
            return new House(cadastral, adress, senior, flats);
        }
    }

    public static String toJson(House house) throws JsonProcessingException {
        return mapper.writeValueAsString(house);
    }

    public static House fromJson(String jsonString) throws IOException {
        return mapper.readValue(jsonString, House.class);
    }
}
