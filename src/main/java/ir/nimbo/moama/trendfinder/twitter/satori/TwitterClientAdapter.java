package ir.nimbo.moama.trendfinder.twitter.satori;

import com.satori.rtm.RtmClient;
import com.satori.rtm.RtmClientAdapter;
import com.satori.rtm.RtmClientListener;

public class TwitterClientAdapter extends RtmClientAdapter {
    @Override
    public void onConnectingError(RtmClient rtmClient, Exception e) {

    }

    @Override
    public void onTransportError(RtmClient rtmClient, Exception e) {

    }

    @Override
    public void onError(RtmClient rtmClient, Exception e) {

    }

    @Override
    public void onEnterStopped(RtmClient rtmClient) {

    }

    @Override
    public void onLeaveStopped(RtmClient rtmClient) {

    }

    @Override
    public void onEnterConnecting(RtmClient rtmClient) {

    }

    @Override
    public void onLeaveConnecting(RtmClient rtmClient) {

    }

    @Override
    public void onEnterConnected(RtmClient rtmClient) {
        System.out.println("Connected to satori Twitter");
    }

    @Override
    public void onLeaveConnected(RtmClient rtmClient) {

    }

    @Override
    public void onEnterAwaiting(RtmClient rtmClient) {

    }

    @Override
    public void onLeaveAwaiting(RtmClient rtmClient) {

    }
}
