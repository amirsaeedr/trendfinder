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
    private Producer<Integer, String> producer;

    public KafkaTwitterProducer() {
        configManager = ConfigManager.getInstance();
        Properties properties = new Properties();
        properties.put("bootstrap.servers", configManager.getProperty(PropertyType.KAFKA_BOOTSTRAP));
        properties.put("key.serializer", configManager.getProperty(PropertyType.KAFKA_KEY_SERIALIZER));
        properties.put("value.serializer", configManager.getProperty(PropertyType.KAFKA_VALUE_SERIALIZER));
        producer = new KafkaProducer<>(properties);
    }

    public void pushTweet(JsonNode jsonNode) {
        producer.send(new ProducerRecord<>(configManager.getProperty(PropertyType.KAFKA_TOPIC), jsonNode.get("id").asInt(), jsonNode.toString()));
    }
}
