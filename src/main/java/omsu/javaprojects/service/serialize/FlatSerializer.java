package omsu.javaprojects.service.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import omsu.javaprojects.models.Flat;
import omsu.javaprojects.models.Person;

import java.io.IOException;

public class FlatSerializer extends StdSerializer<Flat> {
    public FlatSerializer(Class<Flat> t) {
        super(t);
    }

    public FlatSerializer() {
        this(null);
    }

    @Override
    public void serialize(Flat flat, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializeFlat(flat, jsonGenerator, serializerProvider);
        jsonGenerator.close();
    }

    public static void serializeFlat(Flat flat, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("number", flat.getNumber());
        jsonGenerator.writeNumberField("area", flat.getArea());
        jsonGenerator.writeFieldName("owners");
        jsonGenerator.writeStartArray();
        for (Person i : flat.getOwners()) {
            PersonSerializer.serializePerson(i, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
