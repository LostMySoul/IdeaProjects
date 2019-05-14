package omsu.javaprojects.service.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import omsu.javaprojects.models.Flat;
import omsu.javaprojects.models.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlatDeserializer extends StdDeserializer<Flat> {
    public FlatDeserializer(Class<?> vc) {
        super(vc);
    }

    public FlatDeserializer() {
        this(null);
    }

    @Override
    public Flat deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return deserializeFlat(jsonParser, deserializationContext);
    }

    public static Flat deserializeFlat(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int number = 0;
        double area = 0;
        List<Person> owners = new ArrayList<>();
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            if ("number".equals(fieldname)) {
                jsonParser.nextToken();
                number = jsonParser.getIntValue();
            }
            if ("area".equals(fieldname)) {
                jsonParser.nextToken();
                area = jsonParser.getDoubleValue();
            }
            if ("owners".equals(fieldname)) {
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    owners.add(PersonDeserializer.deserializePerson(jsonParser, deserializationContext));
                }
            }
        }
        return new Flat(number, area, owners);
    }
}
