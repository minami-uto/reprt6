package jp.ac.uryukyu.ie.e245755;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void calculateHandValueTest(){
        Player demoPlayerA = new Player(false);
        Player demoPlayerB = new Player(false);
        Player demoPlayerC = new Player(false);
        Player demoPlayerD = new Player(false);
        Player demoPlayerE = new Player(false);

        Deck deck = new Deck();

        demoPlayerA.addCard(deck.draw());
        demoPlayerA.addCard(deck.draw());
        demoPlayerA.addCard(deck.draw());
        assertEquals(17, demoPlayerA.calculateHandValue());

        demoPlayerB.addCard(deck.draw());
        demoPlayerB.addCard(deck.draw());
        demoPlayerB.addCard(deck.draw());
        assertEquals(17, demoPlayerB.calculateHandValue());

        demoPlayerC.addCard(deck.draw());
        demoPlayerC.addCard(deck.draw());
        demoPlayerC.addCard(deck.draw());
        assertEquals(18, demoPlayerC.calculateHandValue());

        demoPlayerD.addCard(deck.draw());
        demoPlayerD.addCard(deck.draw());
        demoPlayerD.addCard(deck.draw());
        demoPlayerD.addCard(deck.draw());
        assertEquals(17, demoPlayerD.calculateHandValue());

        demoPlayerE.addCard(deck.draw());
        demoPlayerE.addCard(deck.draw());
        demoPlayerE.addCard(deck.draw());
        assertEquals(17, demoPlayerE.calculateHandValue());
    }
}
