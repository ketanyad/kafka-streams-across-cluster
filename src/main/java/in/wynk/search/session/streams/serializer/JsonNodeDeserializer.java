package in.wynk.search.session.streams.serializer;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonNodeDeserializer extends JsonDeserializer<JsonNode> {
    public JsonNodeDeserializer() {
        super(JsonNode.class);
    }
}
