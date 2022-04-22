package norima.bowling;

import java.util.Random;

public class Player {
    private static int playerCount = 0;
    private int overallScore = 0;
    private int playerNumber;
    private Random rnd = new Random();

    public Player() {
        playerCount++;
        this.playerNumber = playerCount;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public static int getPlayerCount() {
        return playerCount;
    }

    public int makeThrow(int maxPins) {
        return rnd.nextInt(0, maxPins + 1);
    }
}
