package omsu.javaprojects.service.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import omsu.javaprojects.models.Flat;
import omsu.javaprojects.models.House;
import omsu.javaprojects.models.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HouseDeserializer extends StdDeserializer<House> {
    public HouseDeserializer(Class<?> vc) {
        super(vc);
    }

    public HouseDeserializer() {
        this(null);
    }

    @Override
    public House deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        Person senior = null;
        String cadastralId = null;
        String adress = null;
        List<Flat> flats = new ArrayList<>();
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String houseField = jsonParser.getCurrentName();
            if ("cadastralId".equals(houseField)) {
                jsonParser.nextToken();
                cadastralId = jsonParser.getText();
            }
            if ("adress".equals(houseField)) {
                jsonParser.nextToken();
                adress = jsonParser.getText();
            }
            if ("senior".equals(houseField)) {
                jsonParser.nextToken();
                senior = PersonDeserializer.deserializePerson(jsonParser, deserializationContext);
            }
            if ("flats".equals(houseField)) {
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    flats.add(FlatDeserializer.deserializeFlat(jsonParser,deserializationContext));
                }
            }
        }
        jsonParser.close();
        return new House(cadastralId, adress, senior, flats);
    }
}
