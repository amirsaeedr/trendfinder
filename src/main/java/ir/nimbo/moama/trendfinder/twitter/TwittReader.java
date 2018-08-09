package ir.nimbo.moama.trendfinder.twitter;

import com.satori.rtm.*;
import ir.nimbo.moama.trendfinder.twitter.satori.TwitterClientAdapter;
import ir.nimbo.moama.trendfinder.twitter.satori.TwitterSubscriptionAdapter;
import ir.nimbo.moama.trendfinder.util.ConfigManager;
import ir.nimbo.moama.trendfinder.util.PropertyType;

public class TwittReader {
    private String channel;
    private SubscriptionAdapter twitterSubscriber;
    private RtmClient client;
    public TwittReader() {
        ConfigManager configManager = ConfigManager.getInstance();
        String appKey = configManager.getProperty(PropertyType.TWITTER_APP_KEY);
        channel = configManager.getProperty(PropertyType.TWITTER_CHANNEL);
        String endPoint = configManager.getProperty(PropertyType.TWITTER_END_POINT);
        RtmClientAdapter twitterAdapter = new TwitterClientAdapter();
        twitterSubscriber = new TwitterSubscriptionAdapter();
        client = new RtmClientBuilder(endPoint, appKey).setListener(twitterAdapter).build();
    }
    public void subscribe(){
        client.createSubscription(channel, SubscriptionMode.SIMPLE ,twitterSubscriber);
        client.start();
    }
}
