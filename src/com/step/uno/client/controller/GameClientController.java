package com.step.uno.client.controller;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.view.PlayerView;
import com.step.uno.messages.GameSnapshot;
import com.step.uno.messages.Introduction;

import java.lang.reflect.InvocationTargetException;

public class GameClientController implements MessageChannelListener {
    private CommunicationFactory factory;
    private PlayerView view;
    private MessageChannel channel;

    public GameClientController(CommunicationFactory factory, PlayerView view) {

        this.factory = factory;
        this.view = view;

    }


    public void join(String serverAddress) {
        channel = factory.connectTo(serverAddress,this);
        channel.startListeningForMessages(this);
        channel.send(new Introduction());
    }

    @Override
    public void onError(MessageChannel client, Exception e) {

    }

    private void handle(GameSnapshot snapshot){
        view.update(snapshot);
    }

    @Override
    public void onMessage(MessageChannel client, Object message) {

        try {
            getClass().getDeclaredMethod("handle",message.getClass()).invoke(this,message);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel client) {
        client.stop();
        view.showDisconnected();
    }
}
