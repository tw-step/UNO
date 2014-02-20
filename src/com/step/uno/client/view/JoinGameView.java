package com.step.uno.client.view;

import com.step.uno.client.model.GameClient;
import com.step.uno.messages.Snapshot;

public interface JoinGameView{
    PlayerView switchToPlayerView(GameClient gameClient,Snapshot snapshot);
}
