package com.tw.uno.master;

import com.tw.uno.desk.Channel;

public interface GameServerListener {
    void onNewConnection(Channel channel);
    void onError(Exception e);
}
