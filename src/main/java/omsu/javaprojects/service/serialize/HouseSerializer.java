package omsu.javaprojects.service.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import omsu.javaprojects.models.Flat;
import omsu.javaprojects.models.House;
import omsu.javaprojects.models.Person;

import java.io.IOException;

public class HouseSerializer extends StdSerializer<House> {
    public HouseSerializer(Class<House> t) {
        super(t);
    }

    public HouseSerializer() {
        this(null);
    }

    @Override
    public void serialize(House house, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("cadastralId", house.getCadastralId());
        jsonGenerator.writeStringField("adress", house.getAdress());
        jsonGenerator.writeFieldName("senior");
        jsonGenerator.writeStartObject();
        Person senior = house.getSenior();
        jsonGenerator.writeStringField("fullName", senior.getFirstName() + ' '
                + senior.getLastName() + ' ' + senior.getPatronymic());
        jsonGenerator.writeStringField("birthDate", senior.getBirthDate());
        jsonGenerator.writeEndObject();
        jsonGenerator.writeFieldName("flats");
        jsonGenerator.writeStartArray();
        for (Flat flat : house.getFlats()) {
            FlatSerializer.serializeFlat(flat, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.close();
    }
}
