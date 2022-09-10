package in.wynk.search.session.streams.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventType {
  ITEM_SEARCH_CONSUMED("ITEM_SEARCH_CONSUMED"),
  AUTO_SUGGEST("AUTO_SUGGEST");
  private final String eventType;
}
