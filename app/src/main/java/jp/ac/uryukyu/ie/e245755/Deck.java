package jp.ac.uryukyu.ie.e245755;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 山札のインスタンス元のクラス。
 */
public class Deck {
    /**
     * 複数のカードを集めた山札。
     * @see Card
     */
    private ArrayList<Card> cards;
    /**
     * PlayerTest用フラグ。
     * Test:true、Run:false。
     * @see PlayerTest
     */
    boolean TestFlag = false;

    /**
     * 山札を初期化、生成するコンストラクタ。
     * cards：インスタンス。
     * テスト用のコードを含む。
     * TestFlag:true:任意のカードを意図的に山札として上書きする。
     * @see #cards
     * @see #TestFlag
     * @see DeckTest
     * @see DeckTest#DeckTest()
     * @see DeckTest#TestA(ArrayList)
     * @see Card#Card(String, String, int)
     * @see #shuffle()
     */
    public Deck(){
        cards = new ArrayList<>();
        if(TestFlag)
        {   //Test用
            DeckTest a = new DeckTest();
            cards = a.TestA(cards);
        }
        else
        {   //Run用
            String[] suits = {"♠︎","♡","♢","♣︎"};
            String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
            int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};

            for(String suit : suits){
                for(int i=0; i<ranks.length; i++){
                    cards.add(new Card(suit, ranks[i], values[i]));
                }
            }
            shuffle();
        }
    }

    /**
     * 山札のカードをランダムにシャッフルするメソッド。
     * @see #cards
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * 山札の先頭からカードを1枚引くメソッド。
     * @return 山札の先頭1枚目のカードの出力、山札からの消去。
     * @see Card
     * @see #cards
     */
    public Card draw(){
        return cards.remove(0);
    }
}
