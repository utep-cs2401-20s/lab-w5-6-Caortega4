public class SnakeGame {

    //Elements of the game
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //Constructors
    SnakeGame(){
        game = new boolean[1][1];
    }

    SnakeGame(boolean[][] arr, int[] head){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                game[i][j] = arr[i][j];
            }
        }

        headPosition[0] = head[0];
        headPosition[1] = head[1];
    }

    public int[] findTailExhaustive(){

    }
}
