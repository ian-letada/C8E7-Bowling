package norima.bowling;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    public static final int THROW_PER_FRAME = 2;
    public static final int FRAMES = 10;
    public static final int TOTAL_PINS = 10;

    public List<Player> initializePlayers(int noOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player());
        }
        return players;
    }

    public void playFrame(Player player) {
        int pinsLeft = TOTAL_PINS;
        int throwsLeft = 1;
        int tempScore = 0;

        while (pinsLeft > 0 && throwsLeft <= 2) {
            int pinsKnocked = player.makeThrow(pinsLeft);
            pinsLeft -= pinsKnocked;

            if (throwsLeft == 1 && pinsLeft == 0) {
                tempScore = 20;
            } else if (throwsLeft == 2 && pinsLeft == 0) {
                tempScore = 15;
            } else {
                tempScore += pinsKnocked;
            }

            System.out.format("[THROW #%d] Player #%d knocked down %d pins!%n", throwsLeft, player.getPlayerNumber(),
                    pinsKnocked);
            throwsLeft++;
        }

        System.out.format("Player #%d scored %d this frame!%n", player.getPlayerNumber(), tempScore);
        int playerNewScore = tempScore + player.getOverallScore();
        player.setOverallScore(playerNewScore);
    }

    public void showScores(List<Player> listOfPlayers) {
        for (Player player : listOfPlayers) {
            System.out.format("Player #%d scored a total of %d for this game!%n", player.getPlayerNumber(),
                    player.getOverallScore());
        }
    }
}