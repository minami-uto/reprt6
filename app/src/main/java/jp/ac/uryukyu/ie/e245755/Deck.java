package jp.ac.uryukyu.ie.e245755;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    //山札の生成
    public Deck(){
        cards = new ArrayList<>();
        //Test用
        boolean TestFlag = true; //Test:true Run:false
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

    //山札のシャッフル
    public void shuffle(){
        Collections.shuffle(cards);
    }

    //山札の先頭から1枚引く
    public Card draw(){
        return cards.remove(0);
    }
}
