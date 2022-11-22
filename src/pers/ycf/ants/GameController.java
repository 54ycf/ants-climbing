package pers.ycf.ants;

public class GameController {

    static Game game;

    public static void main(String[] args) {
        init();
        int minRes = Integer.MAX_VALUE;
        int maxRes = Integer.MIN_VALUE;
        for (int i = 0; i < 1<<5; i++) {
            resetGame();
            int gameTime = calculateGameTime();
            System.out.println("the game no." + i + " costs time is " + gameTime);
            minRes = Math.min(minRes, gameTime);
            maxRes = Math.max(maxRes, gameTime);
        }
        System.out.println("min time is: " + minRes);
        System.out.println("max time is: " + maxRes);
    }

    private static void init(){
        game = new Game();
    }

    private static void resetGame(){
        game.reset();
    }

    private static int calculateGameTime(){
        int oneTime = 0;
        while (!game.isGameOver()) {
            oneTime += game.exec();
        }
        return oneTime;
    }
}
