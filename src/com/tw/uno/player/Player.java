package com.tw.uno.player;

import com.tw.uno.desk.Channel;
import com.tw.uno.desk.ChannelFactory;
import com.tw.uno.desk.ChannelListener;

public class Player implements ChannelListener {
    private ChannelFactory factory ;
    private String name;
    private ChannelListener listener;

    public Player(ChannelFactory factory, String name) {
        this.factory = factory;
        this.name = name;
    }

    public void connectTo(String serverAddress) {
        factory.connectTo(serverAddress, this);
    }

    @Override
    public void onError(Channel client, Exception e) {
        throw new RuntimeException(e);
    }

    @Override
    public void onMessage(Channel client, Object message) {

    }

    @Override
    public void onConnectionClosed(Channel client) {

    }

}
