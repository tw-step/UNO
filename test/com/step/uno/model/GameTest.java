package com.step.uno.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    @Test
    public void initializesGame(){
        List<Player> players = new ArrayList<>();
        players.add(new Player("Gabbar"));
        Game game = new Game(1,players);
    }
}
