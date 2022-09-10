package in.wynk.search.session.streams.configuration;

import in.wynk.search.session.streams.handler.StreamProductionExceptionHandler;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class KafkaConfiguration {

  @Bean
  @Primary
  public KafkaProperties appKafkaProperties(KafkaProperties kafkaProperties) {
    updateProducerConfig(kafkaProperties);
    updateConsumerConfig(kafkaProperties);
    updateStreamConfig(kafkaProperties);
    return kafkaProperties;
  }

  private void updateStreamConfig(KafkaProperties kafkaProperties) {
    kafkaProperties
        .getStreams()
        .getProperties()
        .put(
            StreamsConfig.DEFAULT_PRODUCTION_EXCEPTION_HANDLER_CLASS_CONFIG,
            StreamProductionExceptionHandler.class.getName());
    kafkaProperties
        .getStreams()
        .getProperties()
        .put(
            StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG,
            LogAndContinueExceptionHandler.class.getName());
    kafkaProperties
        .getStreams()
        .getProperties()
        .put(
            StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG,
            WallclockTimestampExtractor.class.getName());
  }

  private void updateConsumerConfig(KafkaProperties kafkaProperties) {}

  private void updateProducerConfig(KafkaProperties kafkaProperties) {
    kafkaProperties
        .getProducer()
        .getProperties()
        .put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, String.valueOf(Integer.MAX_VALUE));
  }
}
