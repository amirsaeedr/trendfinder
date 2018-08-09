package ir.nimbo.moama.trendfinder.twitter.satori;

import com.satori.rtm.SubscriptionAdapter;
import com.satori.rtm.model.*;
import ir.nimbo.moama.trendfinder.kafka.KafkaTwitterProducer;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class TwitterSubscriptionAdapter extends SubscriptionAdapter {
    private KafkaTwitterProducer kafkaProducer;

    public TwitterSubscriptionAdapter() {
        kafkaProducer = new KafkaTwitterProducer();
    }

    @Override
    public void onCreated() {

    }

    @Override
    public void onDeleted() {

    }

    @Override
    public void onEnterUnsubscribed(UnsubscribeRequest request, UnsubscribeReply reply) {

    }

    @Override
    public void onLeaveUnsubscribed(UnsubscribeRequest request, UnsubscribeReply reply) {

    }

    @Override
    public void onEnterSubscribing(SubscribeRequest request) {

    }

    @Override
    public void onLeaveSubscribing(SubscribeRequest request) {

    }

    @Override
    public void onEnterSubscribed(SubscribeRequest request, SubscribeReply reply) {

    }

    @Override
    public void onLeaveSubscribed(SubscribeRequest request, SubscribeReply reply) {

    }

    @Override
    public void onEnterUnsubscribing(UnsubscribeRequest request) {

    }

    @Override
    public void onLeaveUnsubscribing(UnsubscribeRequest request) {

    }

    @Override
    public void onEnterFailed() {

    }

    @Override
    public void onLeaveFailed() {

    }

    @Override
    public void onSubscriptionData(SubscriptionData data) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        for (AnyJson json : data.getMessages()) {
            try {
                jsonNode = mapper.readTree(json.toString());
            } catch (IOException e) {

            }
            if (jsonNode.get("lang").asText().equals("en"))
                kafkaProducer.pushTwitt(jsonNode);
        }
    }

    @Override
    public void onSubscriptionError(SubscriptionError error) {

    }

    @Override
    public void onSubscriptionInfo(SubscriptionInfo info) {

    }
}
