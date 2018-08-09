package ir.nimbo.moama.trendfinder.util;

public enum PropertyType {
    TWITTER_APP_KEY("twitter.key"), TWITTER_END_POINT("twitter.endpoint"), TWITTER_CHANNEL("twitter.channel"),KAFKA_TOPIC("kafka.topic"),KAFKA_KEY_SERIALIZER("kafka.key.serializer"),KAFKA_VALUE_SERIALIZER("kafka.value.serializer"),KAFKA_BOOTSTRAP("kafka.bootstrap");

    private String type;

    PropertyType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
