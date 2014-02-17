package com.tw.uno.master;

import com.tw.uno.desk.Channel;
import com.tw.uno.desk.ChannelFactory;

import java.io.IOException;
import java.net.ServerSocket;

public class GameServer {
    private final ChannelFactory channelFactory;
    private GameServerListener listener;
    private ServerSocket serverSocket;
    private boolean keepRunning = false;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            infiniteAcceptLoop();
        }
    };
    private Thread acceptThread;

    private void infiniteAcceptLoop() {
        keepRunning = true;
        while (keepRunning) {
            checkForNewConnection();
        }
    }

    private void checkForNewConnection() {
        Channel channel = channelFactory.acceptFrom(serverSocket);
        if (channel != null)
            listener.onNewConnection(channel);
    }

    public GameServer(ChannelFactory channelFactory) {
        this.channelFactory = channelFactory;
        serverSocket = channelFactory.createServerSocket();
    }

    public void startGame(GameServerListener listener) {
        stopRunningThread();
        this.listener = listener;
        startAcceptThread();
    }

    private void startAcceptThread() {
        acceptThread = new Thread(runnable, "accept");
        acceptThread.start();
    }

    private void stopRunningThread() {
        if (keepRunning) {
            keepRunning = false;
            try {
                acceptThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        stopRunningThread();
        try {
            serverSocket.close();
        } catch (IOException e) {
            listener.onError(e);
        }
    }
}