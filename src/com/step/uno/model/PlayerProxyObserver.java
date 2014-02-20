package com.step.uno.model;

public interface PlayerProxyObserver{
    void onPlayerRegistered(Player player);

    void onPlayerPlayed(Player player, Card card, Colour newColour);

    void onPlayerDrewCard(Player player);

    void onPlayerDeclaredUno(Player player);

    void onPlayerCaughtUno(Player player, int playerIndex);

    void onPlayerDrewTwoCards(Player player);

    void onNoActionOnDrawnCard(Player player);
}
