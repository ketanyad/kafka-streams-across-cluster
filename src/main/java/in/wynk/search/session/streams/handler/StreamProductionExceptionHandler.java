package in.wynk.search.session.streams.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.errors.DefaultProductionExceptionHandler;

@Slf4j
public class StreamProductionExceptionHandler extends DefaultProductionExceptionHandler {
  public ProductionExceptionHandlerResponse handle(
      ProducerRecord<byte[], byte[]> record, Exception exception) {
    log.error("Error while producing record ", exception);
    return ProductionExceptionHandlerResponse.CONTINUE;
  }
}
