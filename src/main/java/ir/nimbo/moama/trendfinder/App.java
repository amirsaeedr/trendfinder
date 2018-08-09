package ir.nimbo.moama.trendfinder;

import com.satori.rtm.RtmClient;
import com.satori.rtm.RtmClientBuilder;
import com.satori.rtm.SubscriptionAdapter;
import com.satori.rtm.SubscriptionMode;
import com.satori.rtm.model.AnyJson;
import com.satori.rtm.model.SubscriptionData;
import ir.nimbo.moama.trendfinder.twitter.satori.TwitterClientAdapter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    static final String endpoint = "wss://open-data.api.satori.com";
    static final String appkey = "aB1bb19a65f2aa0B18ae8acB15c4409a";
    static final String channel = "Twitter-statuses-sample";

    public static void main(String[] args) throws InterruptedException {

        final RtmClient client = new RtmClientBuilder(endpoint, appkey)
                .setListener(new TwitterClientAdapter() {
                    @Override
                    public void onEnterConnected(RtmClient client) {
                        System.out.println("Connected to Satori RTM!");
                    }
                })
                .build();


        SubscriptionAdapter listener = new SubscriptionAdapter() {
            @Override
            public void onSubscriptionData(SubscriptionData data) {

            }
        };

        client.createSubscription(channel, SubscriptionMode.SIMPLE, listener);

        client.start();
    }
}
