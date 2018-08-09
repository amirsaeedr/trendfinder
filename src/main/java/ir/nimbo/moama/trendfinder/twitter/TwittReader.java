package ir.nimbo.moama.trendfinder.twitter;

import com.satori.rtm.RtmClientAdapter;
import com.satori.rtm.SubscriptionAdapter;
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

    public TwittReader() {
        configManager = ConfigManager.getInstance();
        appKey = configManager.getProperty(PropertyType.TWITTER_APP_KEY);
        channel = configManager.getProperty(PropertyType.TWITTER_CHANNEL);
        endPoint = configManager.getProperty(PropertyType.TWITTER_END_POINT);
        twitterAdapter = new TwitterClientAdapter();
        twitterSubscriber = new SubscriptionAdapter();
    }
    public void subscribe(){

    }
}
