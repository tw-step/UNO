package com.tw.uno.serverChannel;

public interface ChannelListener {
    void onError(Channel client, Exception e);
    void onMessage(Channel client, Object message);
    void onConnectionClosed(Channel client);
}
