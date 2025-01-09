package jp.ac.uryukyu.ie.e245755;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand; //手札
    private boolean isDealer;

    public Player(boolean isDealer){
        this.hand = new ArrayList<>();
        this.isDealer = isDealer;
    }

    public void addCard(Card card){ //カードを手札に加える
        hand.add(card);
    }

    public int calculateHandValue(){ //カードの合計値
        int value = 0;
        for(Card card : hand){
            value += card.getValue();
        }
        return value;
    }

    public boolean isBust(){ //バーストの判定
        return calculateHandValue() > 21;
    }

    public ArrayList<Card> getHand(){ //手札
        return hand;
    }

    public String toString(){
        return (isDealer ? "ディーラ" : "プレイヤー") + "の手札" + hand + "合計値：" + calculateHandValue();
    }
}
