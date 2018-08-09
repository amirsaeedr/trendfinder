package ir.nimbo.moama.trendfinder.twitter;

import com.satori.rtm.*;
import ir.nimbo.moama.trendfinder.twitter.satori.TwitterClientAdapter;
import ir.nimbo.moama.trendfinder.util.ConfigManager;
import ir.nimbo.moama.trendfinder.util.PropertyType;

public class TwittReader {
    private ConfigManager configManager;
    private String appKey;
    private String channel;
    private String endPoint;
    private RtmClientAdapter twitterAdapter;
    private SubscriptionAdapter twitterSubscriber;
    private RtmClient client;
    public TwittReader() {
        configManager = ConfigManager.getInstance();
        appKey = configManager.getProperty(PropertyType.TWITTER_APP_KEY);
        channel = configManager.getProperty(PropertyType.TWITTER_CHANNEL);
        endPoint = configManager.getProperty(PropertyType.TWITTER_END_POINT);
        twitterAdapter = new TwitterClientAdapter();
        twitterSubscriber = new SubscriptionAdapter();
        client = new RtmClientBuilder(configManager.getProperty(PropertyType.TWITTER_END_POINT), configManager.getProperty(PropertyType.TWITTER_APP_KEY)).setListener(twitterAdapter).build();
    }
    public void subscribe(){
        client.createSubscription(configManager.getProperty(PropertyType.TWITTER_CHANNEL), SubscriptionMode.SIMPLE ,twitterSubscriber);
    }
}
