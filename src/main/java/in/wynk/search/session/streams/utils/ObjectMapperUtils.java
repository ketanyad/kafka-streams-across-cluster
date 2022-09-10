package in.wynk.search.session.streams.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

@UtilityClass
public class ObjectMapperUtils {
    public static final ObjectMapper mapper = new ObjectMapper();

    static {
        SimpleModule oidModule = new SimpleModule();
        mapper.registerModule(oidModule);
    }

    public String toJson(Object object) {
        if (Objects.isNull(object)) {
            return null;
        } else {
            try {
                return mapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }

    public byte[] toBytes(Object object) {
        if (Objects.isNull(object)) {
            return null;
        } else {
            try {
                return mapper.writeValueAsBytes(object);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }

    public static <T> T toObject(String string, Class<T> classT) {
        try {
            return ObjectMapperUtils.mapper.readValue(string, classT);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T toObject(byte[] bytes, Class<T> classType) {
        try {
            if (bytes == null) {
                return null;
            }
            return ObjectMapperUtils.mapper.readValue(bytes, classType);
        } catch (IOException e) {
            return null;
        }
    }
}
