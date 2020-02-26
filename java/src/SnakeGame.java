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
                    if (game[prevRow][j]) count++;
                }

                if (j != 0) {
                    if (game[i][prevCol]) count++;
                }

                if (j != game.length - 1) {
                    if (game[i][nextCol]) count++;
                }

                if (i != game.length - 1) {
                    if (game[nextRow][j]) count++;
                }

                if (count == 1 && (i != headPosition[0] || j != headPosition[1])) {
                    exhaustiveChecks = countChecks ;
                    outArray[0] = i;
                    outArray[1] = j;
                }

                if (count == 0){
                    exhaustiveChecks = countChecks;
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
        resetCounters();
        int[] tail = findTailRecursive(headPosition, headPosition);
        return new int[]{tail[0], tail[1], getLength()};
    }


    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks++;

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

        if((headPosition[0] == currentPosition[0] && headPosition[1] == currentPosition[1]) && (previousPosition [0] != headPosition[0] && previousPosition[1] != headPosition[1])){
            return findTailRecursive(headPosition, headPosition);
        }if (xCoordinate != 0) {
            //Looks up
            if ((game[prevRow][yCoordinate]) && (prevRow != previousPosition[0]) ) {
                nextPosition[0] = prevRow;
                return findTailRecursive(nextPosition, currentPosition);
            }
        }if (yCoordinate != 0) {
            //Looks left
            if ((game[xCoordinate][prevCol]) && (  prevCol != previousPosition[1])) {
                nextPosition[1] = prevCol;
                return findTailRecursive(nextPosition, currentPosition);
            }

        }if (yCoordinate != game.length - 1) {
            //Looks right
            if ((game[xCoordinate][nextCol]) && (nextCol != previousPosition[1])){
                nextPosition[1] = nextCol;
                return findTailRecursive(nextPosition, currentPosition);
            }
        }if (xCoordinate != game[0].length - 1) {
            //Looks Down
            if ((game[nextRow][yCoordinate]) && ((nextRow != previousPosition[0]) )){
                nextPosition[0] = nextRow;
                return findTailRecursive(nextPosition, currentPosition);

            }
        }
            return currentPosition;

    }

    public int getLength(){
        int count = 0;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                if(game[i][j]) count++;
            }
        }
        return count;
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