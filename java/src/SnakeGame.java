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

    public int[] findTailExhaustive() {
        resetCounters();
        int count = 0;
        int length = 0;
        int prevRow;
        int prevCol;
        int nextCol;
        int nextRow;
        int[] outArray = new int[3];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                exhaustiveChecks++;
                //If the cell is false, jump to the next cell
                if (!game[i][j]) continue;

                prevRow = i - 1;
                prevCol = j - 1;
                nextCol = j + 1;
                nextRow = i + 1;


                //If it gets here the cell is true, increment the length
                length++;
                //If statements to check if the cell's neighbors are not out of bounds


                if (i != 0) {
                    if (game[prevRow][j] == true) count++;
                }

                if (j != 0) {
                    if (game[i][prevCol] == true) count++;
                }

                if (j != game.length - 1) {
                    if (game[i][nextCol] == true) count++;
                }

                if (i != game.length - 1) {
                    if (game[nextRow][j] == true) count++;
                }

                if (count == 1 && (i != headPosition[0] && j != headPosition[1])) {
                    outArray[0] = i;
                    outArray[1] = j;
                }





                count = 0;
            }
        }
        outArray[2] = length;

        return outArray;



    }

    /*
    public int[] findTailRecursive(){
        int length = 0;
        length++;
        resetCounters();

    }
    */


    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }
}
