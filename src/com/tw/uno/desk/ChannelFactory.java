package com.tw.uno.desk;

import com.tw.uno.master.GameServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ChannelFactory {


    public GameServer createMessageServer() {
        return new GameServer(this);
    }

    private Socket connectTo(String serverAddress, int port) {
        try {
            Socket socket = new Socket(serverAddress, port);
            socket.setSoTimeout(100);
            return socket;
        } catch (IOException e) {
            throw new RuntimeException("could not connect to "+serverAddress+" at "+port,e);
        }
    }

    public Channel connectTo(String serverAddress, ChannelListener observer){
        return new Channel(connectTo(serverAddress, 9090));
    }

    public Channel acceptFrom(ServerSocket serverSocket){
        try {
            Socket socket = serverSocket.accept();
            socket.setSoTimeout(100);
            return new Channel(socket);
        }
        catch (SocketTimeoutException ste){
            return null;
        }
        catch (IOException e) {
            throw new RuntimeException("could not accept connection",e);
        }
    }

    public ServerSocket createServerSocket() {
        try {

            ServerSocket serverSocket = new ServerSocket(9090);
            serverSocket.setSoTimeout(200);
            return serverSocket;
        } catch (IOException e) {
            throw new RuntimeException("Could not create ",e);
        }
    }
}