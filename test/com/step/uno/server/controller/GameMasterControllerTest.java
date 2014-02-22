package com.step.uno.server.controller;

import com.step.communication.factory.UnoServerFactory;
import com.step.communication.server.MessageServer;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Game;
import com.step.uno.model.Player;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

class GameStub extends Game {
    boolean initializeCalled = false;
    boolean playCardCalled = false;
    public GameStub(int packs, List<Player> givenPlayers) {
        super(packs, givenPlayers);
    }

    @Override
    public void initialize() {
        initializeCalled = true;
    }

    @Override
    public void playCard(Player player, Card card, Colour newColour) {
        playCardCalled = true;
    }
}

public class GameMasterControllerTest {
    UnoServerFactory factory = mock(UnoServerFactory.class);
    GameMasterController controller = new GameMasterController(1, 1, factory);
    final Game mockedGame = mock(Game.class);

    @Test
    public void startsGameWhenAsked() {
        final List<Player> players = new ArrayList<>();
        final GameStub stub = new GameStub(1, players);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return stub;
            }
        }).when(factory).createGame(1, players);

        controller.startGame();
        verify(factory).createGame(1, players);
        assertTrue(stub.initializeCalled);
    }

    @Test
    public void waitsForConnectionsToStartTheGame() {
        final MessageServer messageServer = mock(MessageServer.class);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return messageServer;
            }
        }).when(factory).createMessageServer();

        controller.waitForConnections();

        verify(factory).createMessageServer();
        verify(messageServer).startListeningForConnections(controller);
    }

    @Test
    public void startsGameWhenAllPlayersRegistered() {
        final List<Player> players = new ArrayList<>();
        players.add(new Player("taj"));
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return mockedGame;
            }
        }).when(factory).createGame(anyInt(), eq(players));

        controller.onPlayerRegistered(players.get(0));

        verify(factory).createGame(1, players);
    }

    @Test
    public void handlesWhenANewCardIsPlayed() {
        final List<Player> players = new ArrayList<>();
        final GameStub stub = new GameStub(1, players);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return stub;
            }
        }).when(factory).createGame(1, players);
        Card card = new Card();


        controller.startGame();
        controller.onPlayerPlayed(new Player("Gabbar"), card, Colour.Black);

        assertTrue(stub.playCardCalled);
    }

    @Test
    public void handlesWhenPlayerDrawsACard() {
        Player gabbar = new Player("Gabbar");
        ArrayList<Player> players = new ArrayList<>();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return mockedGame;
            }
        }).when(factory).createGame(1, players);

        controller.startGame();
        controller.onPlayerDrewCard(gabbar);

        verify(mockedGame,times(1)).drawCard(gabbar);
    }

    @Test
    public void sendsDeclareUnoRequestWhenInvoked() {
        Player gabbar = new Player("Gabbar");
        ArrayList<Player> players = new ArrayList<>();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return mockedGame;
            }
        }).when(factory).createGame(1, players);

        controller.startGame();
        controller.onPlayerDeclaredUno(gabbar);

        verify(mockedGame,times(1)).declareUno(gabbar);
    }

    @Test
    public void sendsCatchUnoRequestWhenInvoked() {
        Player gabbar = new Player("Gabbar");
        ArrayList<Player> players = new ArrayList<>();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return mockedGame;
            }
        }).when(factory).createGame(1, players);

        controller.startGame();
        controller.onPlayerCaughtUno(gabbar, 2);

        verify(mockedGame,times(1)).catchUno(gabbar, 2);
    }

    @Test
    public void sendsDrawCardRequestWhenRequired() {
        Player gabbar = new Player("Gabbar");
        ArrayList<Player> players = new ArrayList<>();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return mockedGame;
            }
        }).when(factory).createGame(1, players);

        controller.startGame();
        controller.onPlayerDrewCard(gabbar);

        verify(mockedGame,times(1)).drawCard(gabbar);
    }
    @Test
    public void sendsDrawTwoCardsRequestWhenRequired() {
        Player gabbar = new Player("Gabbar");
        ArrayList<Player> players = new ArrayList<>();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return mockedGame;
            }
        }).when(factory).createGame(1, players);

        controller.startGame();
        controller.onPlayerDrewTwoCards(gabbar);

        verify(mockedGame,times(1)).drawTwoCards(gabbar);
    }

    @Test
    public void gameMovesForwardIfNoActionDoneByPlayer() {
        Player gabbar = new Player("Gabbar");
        ArrayList<Player> players = new ArrayList<>();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                return mockedGame;
            }
        }).when(factory).createGame(1, players);

        controller.startGame();
        controller.onNoActionOnDrawnCard(gabbar);

        verify(mockedGame,times(1)).moveForwardAsPlayerTookNoActionOnDrawnCard();
    }
}