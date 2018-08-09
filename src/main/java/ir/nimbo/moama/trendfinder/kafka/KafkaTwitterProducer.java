package ir.nimbo.moama.trendfinder.kafka;

import ir.nimbo.moama.trendfinder.util.ConfigManager;
import org.codehaus.jackson.JsonNode;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaTwitterProducer {
    private ConfigManager configManager;
    public KafkaTwitterProducer() {
        configManager = ConfigManager.getInstance();

    }

    public void pushTwitt(JsonNode jsonNode) {

    }
}
