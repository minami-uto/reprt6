package jp.ac.uryukyu.ie.e245755;

import java.util.ArrayList;

/**
 * PlayerTest用。
 * 任意のカードを意図的に組んだ山札を生成するクラス。
 */
public class DeckTest {
    /**
     * 任意のカードを意図的に組んだ山札を生成するメソッド。
     * @param a Test用の山札。
     * @return　Test用に作成された山札。
     * @see Card#Card(String, String, int)
     */
    public ArrayList<Card> TestA(ArrayList<Card> a){
        //case1//Aなし//17
        a.add(new Card("♠︎", "2", 2));
        a.add(new Card("♠︎", "5", 5));
        a.add(new Card("♠︎", "J", 10));
        //case2//A=1//17
        a.add(new Card("♠︎", "9", 9));
        a.add(new Card("♠︎", "7", 7));
        a.add(new Card("♠︎", "A", 1));
        //case3//A=11//18
        a.add(new Card("♠︎", "A", 1));
        a.add(new Card("♠︎", "2", 2));
        a.add(new Card("♠︎", "5", 5));
        //case4//A=1//17
        a.add(new Card("♠︎", "A", 1));
        a.add(new Card("♠︎", "2", 2));
        a.add(new Card("♠︎", "J", 10));
        a.add(new Card("♠︎", "4", 4));
        //case5//A=11,A=1//17
        a.add(new Card("♠︎", "A", 1));
        a.add(new Card("♠︎", "5", 5));
        a.add(new Card("♠︎", "A", 1));

        return a;
    } 

}