package in.wynk.search.session.streams.serializer;

import in.wynk.search.session.streams.utils.ObjectMapperUtils;
import org.apache.kafka.common.serialization.Serializer;

public class JsonSerializer<T> implements Serializer<T> {
  @Override
  public byte[] serialize(String s, T t) {
    return ObjectMapperUtils.toBytes(t);
  }
}
