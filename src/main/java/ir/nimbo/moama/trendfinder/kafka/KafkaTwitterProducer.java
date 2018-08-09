package ir.nimbo.moama.trendfinder.kafka;

import ir.nimbo.moama.trendfinder.util.ConfigManager;
import ir.nimbo.moama.trendfinder.util.PropertyType;
import org.codehaus.jackson.JsonNode;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaTwitterProducer {
    private ConfigManager configManager;
    private Producer<Integer, JsonNode> producer;
    public KafkaTwitterProducer() {
        configManager = ConfigManager.getInstance();
        Properties properties = new Properties();
        properties.put("bootstrap.servers", PropertyType.KAFKA_BOOTSTRAP);
        properties.put("key.serializer",PropertyType.KAFKA_KEY_SERIALIZER);
        properties.put("value.serializer",PropertyType.KAFKA_VALUE_SERIALIZER);
        producer = new KafkaProducer<>(properties);
    }

    public void pushTwitt(JsonNode jsonNode) {
        producer.send(new ProducerRecord<>(PropertyType.KAFKA_TOPIC.toString(),jsonNode.get("id").asInt(),jsonNode));
    }
}
