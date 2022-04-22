package norima.bowling;

import java.util.ArrayList;
import java.util.Scanner;

public class Bowling {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        GameManager bowlingGM = new GameManager();
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("How many players?: ");
        int noOfPlayers = scan.nextInt();

        players = new ArrayList<>(bowlingGM.initializePlayers(noOfPlayers));

        for (int i = 0; i < GameManager.FRAMES; i++) {
            for (Player player : players) {
                bowlingGM.playFrame(player);
            }
            System.out.println("");
        }

        bowlingGM.showScores(players);
    }
}
