package omsu.javaprojects.service.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import omsu.javaprojects.models.Person;

import java.io.IOException;

public class PersonDeserializer extends StdDeserializer<Person> {
    public PersonDeserializer(Class<?> vc) {
        super(vc);
    }

    public PersonDeserializer() {
        this(null);
    }

    @Override
    public Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return deserializePerson(jsonParser, deserializationContext);
    }

    public static Person deserializePerson(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String firstName = null,
                lastName = null,
                patronymic = null,
                birthDate = null;
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            if ("fullName".equals(fieldname)) {
                jsonParser.nextToken();
                String[] fName = jsonParser.getText().split("\\s+");
                firstName = fName[0];
                lastName = fName[1];
                patronymic = fName[2];
            }
            if ("birthDate".equals(fieldname)) {
                jsonParser.nextToken();
                String birth = jsonParser.getText();
                birthDate = birth;
            }
        }
        return new Person(firstName, lastName, patronymic, birthDate);
    }
}
