import jp.ac.uryukyu.ie.e245755.BlackJackGame;

/**
 * BlackJackMain　クラスは簡易ブラックジャックを実行するメインクラス。
 * 
 * 山札を生成し、プレイヤーとディーラ（NPC）が対戦する基本的な形まで実装済み。
 * "A"の処理：標準はvalue="1"。手札の合計値が11未満の場合value="11"に変換。
 *           3枚目以降合計値が21を超えた時手札の"A"をvalue="1"に再変換(実装途中)。
 */
public class BlackJackMain {
    /**
     * ゲームの初期化、開始。
     * @param args　Mainメソッド。
     */
    public static void main(String[] args){
        BlackJackGame game = new BlackJackGame();
        game.start();
    }
}
