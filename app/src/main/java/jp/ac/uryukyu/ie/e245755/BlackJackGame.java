package jp.ac.uryukyu.ie.e245755;

public class BlackJackGame {
    private Deck deck;
    private Player player;
    private Player dealer;

    public BlackJackGame(){
        deck = new Deck();
        player = new Player(false);
        dealer = new Player(true);
    }

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
