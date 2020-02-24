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
        game = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                game[i][j] = arr[i][j];
            }
        }

        headPosition = new int[2];
        headPosition[0] = head[0];
        headPosition[1] = head[1];
    }

    public int[] findTailExhaustive() {
        resetCounters();
        int countChecks = 0;
        int count = 0;
        int length = 0;
        int prevRow;
        int prevCol;
        int nextCol;
        int nextRow;
        int[] outArray = new int[3];
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                countChecks++;
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
                    exhaustiveChecks = countChecks ;
                    outArray[0] = i;
                    outArray[1] = j;
                }





                count = 0;
            }
        }
        outArray[2] = length;

        return outArray;



    }

    public int[] findTailRecursive(){
        return findTailRecursive(headPosition, headPosition);
    }


    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){


        int[] nextPosition = new int [2];

        for (int i = 0; i < currentPosition.length; i++) {
            nextPosition[i] = currentPosition[i];
        }



        int prevRow = currentPosition[0] - 1;
        int prevCol = currentPosition[1] - 1;
        int nextCol = currentPosition[1] + 1;
        int nextRow = currentPosition[0] + 1;
        int xCoordinate = currentPosition[0];
        int yCoordinate = currentPosition[1];


        if (xCoordinate != 0) {
            //Looks up
            if ((game[prevRow][yCoordinate]) && (prevRow != previousPosition[0]) ) {
                nextPosition[0] = prevRow;
                return findTailRecursive(nextPosition, currentPosition);
            }
        }else if (yCoordinate != 0) {
            //Looks left
            if ((game[xCoordinate][prevCol]) && (  prevCol != previousPosition[1])) {
                nextPosition[1] = prevCol;
                return findTailRecursive(nextPosition, currentPosition);
            }

        }else if (yCoordinate != game.length - 1) {
            //Looks right
            if ((game[xCoordinate][nextCol]) && (nextCol != previousPosition[1])){
                nextPosition[1] = nextCol;
                return findTailRecursive(nextPosition, currentPosition);
            }
        }else if (xCoordinate != game.length - 1) {
            //Looks Down
            if ((game[nextRow][yCoordinate]) && ((nextRow != previousPosition[0]) )){
                nextPosition[0] = nextRow;
                return findTailRecursive(nextPosition, currentPosition);
            }
        }else if((currentPosition[0] == headPosition[0]) && (currentPosition[1] == headPosition[1])){
                findTailRecursive(headPosition, headPosition);
            }

        if ((currentPosition[0] == headPosition[0]) && (currentPosition[1] == headPosition[1])) {
                        return findTailRecursive();

        }
        return findTailRecursive(currentPosition, previousPosition);
    }



    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }

    public static int getRecursiveChecks() {
        return recursiveChecks;
    }
}
