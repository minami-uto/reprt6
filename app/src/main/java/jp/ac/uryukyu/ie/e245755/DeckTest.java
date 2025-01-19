package jp.ac.uryukyu.ie.e245755;

import java.util.ArrayList;

public class DeckTest {
    //Test用
    //任意のカードを用意した山札を作成する
    public static void main(String[] args){}    

    public ArrayList<Card> TestA(ArrayList<Card> a)
    {
        //Aなし//17
        a.add(new Card("♠︎", "2", 2));
        a.add(new Card("♠︎", "5", 5));
        a.add(new Card("♠︎", "J", 10));
        //A=1//17
        a.add(new Card("♠︎", "9", 9));
        a.add(new Card("♠︎", "7", 7));
        a.add(new Card("♠︎", "A", 1));
        //A=11//18
        a.add(new Card("♠︎", "A", 1));
        a.add(new Card("♠︎", "2", 2));
        a.add(new Card("♠︎", "5", 5));
        //A=1//17
        a.add(new Card("♠︎", "A", 1));
        a.add(new Card("♠︎", "2", 2));
        a.add(new Card("♠︎", "J", 10));
        a.add(new Card("♠︎", "4", 4));
        //A=11,A=1//17
        a.add(new Card("♠︎", "A", 1));
        a.add(new Card("♠︎", "5", 5));
        a.add(new Card("♠︎", "A", 1));

        return a;
    } 

}