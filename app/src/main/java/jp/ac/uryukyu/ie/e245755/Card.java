package jp.ac.uryukyu.ie.e245755;

public class Card {
    private String suit; //カードのスート
    private String rank; //カードのランク
    private int value; // カードの値

    public Card(String suit, String rank, int value){
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        return suit + rank;
    }
}
