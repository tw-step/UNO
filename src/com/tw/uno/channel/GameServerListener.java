package com.tw.uno.channel;

public interface GameServerListener {
    void onNewConnection(Channel channel);
    void onError(Exception e);
}
