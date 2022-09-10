package in.wynk.search.session.streams.streams;

import com.fasterxml.jackson.databind.JsonNode;
import in.wynk.search.session.streams.constants.Constants;
import in.wynk.search.session.streams.constants.EventType;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
import java.util.function.Function;

@Configuration
@Slf4j
public class AutoSuggestKakfaStream {
  @Bean
  public Function<KStream<String, JsonNode>, KStream<String, JsonNode>> autoSuggestStream() {
    return message ->
        message
            .filter((key, node) -> Objects.nonNull(node) && isValidMessage(node))
            .map(KeyValue::new);
  }

  private boolean isValidMessage(JsonNode node) {
    return node != null
        && !node.isNull()
        && node.hasNonNull(Constants.EVENT_TYPE_KEY)
        && EventType.AUTO_SUGGEST
            .getEventType()
            .equalsIgnoreCase(node.get(Constants.EVENT_TYPE_KEY).textValue());
  }
}
