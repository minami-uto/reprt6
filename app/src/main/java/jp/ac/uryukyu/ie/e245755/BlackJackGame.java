package jp.ac.uryukyu.ie.e245755;

/**
 * ブラックジャックの実質的なメインとなるクラス。
 */
public class BlackJackGame {
    /**
     * suit、rank、valueの入ったトランプがランダムに組まれた山札。
     * @see Deck
     */
    private Deck deck;
    /**
     * ArrayList<Card>:手札。
     * isDealer: false。
     * @see Player
     */
    private Player player;
    /**
     * ArrayList<Card>:手札。
     * isDealer: true。
     * @see Player
     */
    private Player dealer;

    /**
     * インスタンス生成。
     */
    public BlackJackGame(){
        deck = new Deck();
        player = new Player(false);
        dealer = new Player(true);
    }

    /**
     * 実質的な　Mainメソッド。
     * プレイヤー、ディーラに2枚ずつカードの配布。
     * プレイヤー＝＞ディーラの順に手札を調整。
     * 両者の合計値を判定処理。
     * @see #deck
     * @see #player
     * @see #dealer
     * @see Deck#draw()
     * @see Player#addCard(Card)
     * @see Player#isBust()
     * @see Player#calculateHandValue()
     * @see #determineWinner()
     */
    public void start(){
        //プレイヤーとディーラに初期カードを2枚配布
        dealer.addCard(deck.draw());
        System.out.println(dealer + " + 非公開なカード"); //ディーラの手札1枚目：公開
        dealer.addCard(deck.draw()); //ディーラの手札2枚目：非公開
        player.addCard(deck.draw());
        player.addCard(deck.draw());

        //プレイヤーのターン
        System.out.println(player);
        while (!player.isBust()) {
            System.out.println("カードを引きますか？（Y/N）: ");
            String choice = new java.util.Scanner(System.in).nextLine();
            if(choice.equalsIgnoreCase("Y")){
                player.addCard(deck.draw());
                System.out.println(player);
            } else {
                break;
            }
        }

        //ディーラのターン
        System.out.println("ディーラのターン");
        while ((dealer.calculateHandValue() < 17)) {
            dealer.addCard(deck.draw());
        }
        System.out.println(dealer);

        //勝敗判定
        determineWinner();
    }

    /**
     * 勝敗の判定メソッド。
     * playerValue、dealerValue：手札の合計値
     * プレイヤーのバースト：プレイヤーの負け
     * ディーラのバースト：プレイヤーの勝ち
     * プレイヤー＞ディーラ：プレイヤーの勝ち
     * プレイヤー＜ディーラ：プレイヤーの負け
     * プレイヤー＝ディーラ：引き分け
     * @see #player
     * @see #dealer
     * @see Player#calculateHandValue()
     * @see Player#isBust()
     */
    private void determineWinner(){
        int playerValue = player.calculateHandValue();
        int dealerValue = dealer.calculateHandValue();

        if (player.isBust()) {
            System.out.println("プレイヤーはバーストしました。プレイヤーの負け");
        } else if (dealer.isBust()) {
            System.out.println("ディーラはバーストしました。プレイヤーの勝ち");
        } else if (playerValue > dealerValue) {
            System.out.println("プレイヤーの勝ち");
        } else if (playerValue < dealerValue){
            System.out.println("プレイヤーの負け");
        } else {
            System.out.println("引き分け");
        }
    }
}
