package com.tw.uno.serverChannel;

public interface GameServerListener {
    void onNewConnection(Channel channel);
    void onError(Exception e);
}
