package jp.ac.uryukyu.ie.e245755;

/**
 * トランプカード1枚ずつの情報を持つクラス。
 */
public class Card {
    /**
     * カードのスート。"♠︎"、"♡"、"♢"、"♣︎"。
     */
    private String suit;
    /**
     * カードのランク。"A"、"2"~"10"、"J"、"Q"、"K"。
     */
    private String rank;
    /**
     * カードの値。"A"=1or11、"2"~"10"=数値通り、"J"Q"K"=10。
     */
    private int value;

    /**
     * コンストラクタ。
     * @param suit {@link #suit}
     * @param rank {@link #rank}
     * @param value {@link #value}
     */
    public Card(String suit, String rank, int value){
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    /**
     * カードの値を返すメソッド。
     * @return {@link #value}
     */
    public int getValue(){
        return value;
    }

    /**
     * トランプカードを返すメソッド。
     * @return {@link #suit}{@link #rank}
     */
    public String toString(){
        return suit + rank;
    }
}
