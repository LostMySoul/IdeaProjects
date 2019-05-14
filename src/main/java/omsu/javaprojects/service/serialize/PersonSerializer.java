package omsu.javaprojects.service.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import omsu.javaprojects.models.Person;

import java.io.IOException;

public class PersonSerializer extends StdSerializer<Person> {
    public PersonSerializer(Class<Person> t) {
        super(t);
    }

    public PersonSerializer() {
        this(null);
    }

    @Override
    public void serialize(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializePerson(person, jsonGenerator, serializerProvider);
        jsonGenerator.close();
    }

    public static void serializePerson(Person person, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("fullName", person.getFirstName() + ' '
                + person.getLastName() + ' ' + person.getPatronymic());
        jsonGenerator.writeStringField("birthDate", person.getBirthDate());
        jsonGenerator.writeEndObject();
    }
}
