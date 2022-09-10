package in.wynk.search.session.streams.serializer;

import in.wynk.search.session.streams.utils.ObjectMapperUtils;
import org.apache.kafka.common.serialization.Deserializer;

public class JsonDeserializer<T> implements Deserializer<T> {
  private final Class<T> classType;

  public JsonDeserializer(Class<T> classType) {
    this.classType = classType;
  }

  @Override
  public T deserialize(String s, byte[] bytes) {
    if (classType == null) {
      return null;
    }
    return ObjectMapperUtils.toObject(bytes, classType);
  }
}
