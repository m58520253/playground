package pl.embe.mongo.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.bson.types.ObjectId;

import java.io.IOException;

/**
 * Created by Michal_Bucki on 05/03/2015.
 */

public class ObjectIdDeserializer extends JsonDeserializer<Object> {
    @Override
    public Object deserialize(JsonParser jsonParser,
                            DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return new ObjectId(node.textValue());
    }
}