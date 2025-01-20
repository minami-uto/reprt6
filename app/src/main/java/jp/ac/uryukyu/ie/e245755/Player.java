package jp.ac.uryukyu.ie.e245755;

import java.util.ArrayList;

/**
 * プレイヤー、ディーラのインスタント元のクラス。
 */
public class Player {
    /**
     * 手札。
     * @see Card
     */
    private ArrayList<Card> hand;
    /**
     * プレイヤー：false、ディーラ：true。
     */
    private boolean isDealer;

    /**
     * コンストラクタ。
     * @param isDealer {@link #isDealer}　プレイヤーかディーラの判断。
     * @see #hand
     */
    public Player(boolean isDealer){
        this.hand = new ArrayList<>();
        this.isDealer = isDealer;
    }

    /**
     * カードを手札に追加するメソッド
     * @param card 1枚のトランプカード。
     * @see #hand
     * @see Card
     * @see #addCard(Card)
     */
    public void addCard(Card card){
        hand.add(card);
    }

    /**
     * 手札の合計値を算出するメソッド。
     * 手札に"A"を含む：場合に分けてvalueを"1"または"11"とする。
     * aceValue：手札に含まれた"A"の枚数をカウント。
     * @return 手札の合計値。
     * @see #hand
     * @see #toString()
     * @see Card#getValue()
     */
    public int calculateHandValue(){ 
        int value = 0;
        int aceValue = 0;
        for(Card card : hand){
            value += card.getValue();
            if(card.toString().contains("A")){ //手札にAが含まれるか
                aceValue ++;
            }
        }
        while (aceValue > 0 && value <= 11) { //手札にAが含まれる　かつ　合計値が11未満
            //"A"の値を11として換算する
            value += 10;
            aceValue --;
        }
        while (aceValue > 0 && value > 21) { //手札にAが含まれる　かつ　合計値が21以上
            value -= 10; // "A" の値を 11 -> 1 に調整
            aceValue--;
        }
            
        
        return value;
    }
   
    /**
     * バーストの判定メソッド。
     * true:バーストしている、false:バーストしていない。
     * @return 手札の合計値が"21"より大きい場合:true。
     * @see #calculateHandValue()
     */
    public boolean isBust(){
        return calculateHandValue() > 21;
    }

    /**
     * 手札のカードを出力するメソッド。
     * @return {@link #hand}
     * @see Card
     */
    public ArrayList<Card> getHand(){
        return hand;
    }

    /**
     * 手札と合計値を出力するメソッド。
     * @see #hand
     * @see #isDealer
     * @see #calculateHandValue()
     */
    public String toString(){
        return (isDealer ? "ディーラ" : "プレイヤー") + "の手札" + hand + "合計値：" + calculateHandValue();
    }
}
