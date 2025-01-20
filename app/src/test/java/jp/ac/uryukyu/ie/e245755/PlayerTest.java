package jp.ac.uryukyu.ie.e245755;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * {@link Player#calculateHandValue()}のTest用クラス。
 * 手札に"A"を含むときの合計値の処理（"A"は場合に合わせて"1"または"11"とする）が想定通りの算出になるかをテストする。
 * {@link DeckTest#TestA(java.util.ArrayList)}にて任意のカードを設定する。
 */
class PlayerTest {

    /**
     * {@link PlayerTest}
     * 【case1:rank[2,5,J],value[2,5,10]。合計値17。：手札に"A"を含まない。】
     * 【case2:rank[9,7,A],value[9,7,1]。合計値17。："A"以外の合計値が11以上のため"1"で算出。】
     * 【case3:rank[5,2,A],value[5,2,1]=>[5,2,11]。合計値18。："A"以外の合計値が11未満のため"11"で算出。】
     * 【case4:rank[A,2,J,4],value[1,2]=>[11,2]=>[11,2,10]=>[1,2,10]=>[1,2,10,4]。合計値17。：(手札2枚)"A"以外の合計値が11未満のため"11"で算出。(手札3枚〜)"A"以外の合計値が11を超えたため"1"で再算出。】
     * 【case5:rank[A,5,A],value[1,5,1]=>[11,5,1]。合計値17。：(1枚目のA)(手札2枚)"A"以外の合計値が11未満のため"11"で算出。(2枚目のA)(手札3枚)"A"以外の合計値が11以上のため"1"で算出。】
     * @see Player
     * @see Player#Player(boolean)
     * @see Player#addCard(Card)
     * @see Player#calculateHandValue()
     * @see Deck
     * @see Deck#Deck()
     * @see Deck#draw()
     */
    @Test
    void calculateHandValueTest(){
        Player demoPlayerA = new Player(false);
        Player demoPlayerB = new Player(false);
        Player demoPlayerC = new Player(false);
        Player demoPlayerD = new Player(false);
        Player demoPlayerE = new Player(false);

        Deck deck = new Deck();

        //case1
        demoPlayerA.addCard(deck.draw());
        demoPlayerA.addCard(deck.draw());
        demoPlayerA.addCard(deck.draw());
        assertEquals(17, demoPlayerA.calculateHandValue());

        //case2
        demoPlayerB.addCard(deck.draw());
        demoPlayerB.addCard(deck.draw());
        demoPlayerB.addCard(deck.draw());
        assertEquals(17, demoPlayerB.calculateHandValue());

        //case3
        demoPlayerC.addCard(deck.draw());
        demoPlayerC.addCard(deck.draw());
        demoPlayerC.addCard(deck.draw());
        assertEquals(18, demoPlayerC.calculateHandValue());

        //case4
        demoPlayerD.addCard(deck.draw());
        demoPlayerD.addCard(deck.draw());
        demoPlayerD.addCard(deck.draw());
        demoPlayerD.addCard(deck.draw());
        assertEquals(17, demoPlayerD.calculateHandValue());

        //case5
        demoPlayerE.addCard(deck.draw());
        demoPlayerE.addCard(deck.draw());
        demoPlayerE.addCard(deck.draw());
        assertEquals(17, demoPlayerE.calculateHandValue());
    }
}
