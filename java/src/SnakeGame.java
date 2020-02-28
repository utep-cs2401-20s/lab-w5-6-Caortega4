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
        //Manual copy of the 2D array
        game = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                game[i][j] = arr[i][j];
            }
        }

        //Assign the head's coordinates
        headPosition = new int[2];
        headPosition[0] = head[0];
        headPosition[1] = head[1];
    }

    //Method that will look through the whole game board to find the snake's tail
    public int[] findTailExhaustive() {
        //Set counters to 0
        resetCounters();
        int countChecks = 0;
        int count = 0;
        int length = 0;
        int prevRow;
        int prevCol;
        int nextCol;
        int nextRow;
        int[] outArray = new int[3];

        //Traverse the whole game
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                countChecks++;
                //If the cell is false, jump to the next cell
                if (!game[i][j]) continue;

                //Helper variables
                prevRow = i - 1;
                prevCol = j - 1;
                nextCol = j + 1;
                nextRow = i + 1;


                //If it gets here the cell is true, increment the length
                length++;
                //If statements to check if the cell's neighbors are not out of bounds and to know how many neighbors does it has

                //Checks up
                if (i != 0) {
                    if (game[prevRow][j]) count++;
                }

                //Checks the left
                if (j != 0) {
                    if (game[i][prevCol]) count++;
                }

                //Checks the left
                if (j != game.length - 1) {
                    if (game[i][nextCol]) count++;
                }

                //Checks the right
                if (i != game.length - 1) {
                    if (game[nextRow][j]) count++;
                }

                //If to check if it is the head
                if (count == 1 && (i != headPosition[0] || j != headPosition[1])) {
                    exhaustiveChecks = countChecks ;
                    outArray[0] = i;
                    outArray[1] = j;
                }

                //If for the case where the snake is isze 1
                if (count == 0){
                    exhaustiveChecks = countChecks;
                    outArray[0] = i;
                    outArray[1] = j;
                }




                //Reset the count of neighbors
                count = 0;
            }
        }
        //Assign the length to the last element in the output array
        outArray[2] = length;

        return outArray;



    }

    //Method that will call the private recursive search to start from the head
    public int[] findTailRecursive(){
        //Set checks to 0
        resetCounters();
        int[] tail = findTailRecursive(headPosition, headPosition);
        return new int[]{tail[0], tail[1], getLength()};
    }

    //Recursive method used to follo the snake's body until it gets to the tail
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        //Increment the recursive checks every time this method gets called
        recursiveChecks++;

        //Creates an array where the next position coordinates will be stored
        int[] nextPosition = new int [2];

        //Manual copy of the current position array to the next position
        for (int i = 0; i < currentPosition.length; i++) {
            nextPosition[i] = currentPosition[i];
        }


        //Helper variables
        int prevRow = currentPosition[0] - 1;
        int prevCol = currentPosition[1] - 1;
        int nextCol = currentPosition[1] + 1;
        int nextRow = currentPosition[0] + 1;
        int xCoordinate = currentPosition[0];
        int yCoordinate = currentPosition[1];

        //These ifs check if the corresponding neighbor is alive and if it is ot the previous position, if it is true it will call the method on the next position
        if (xCoordinate != 0) {
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

        //When it does not enters ay if it means that it has no neighbors other than the previous position therefore the current position is the tail
        return currentPosition;

    }

    //Method to get the size of the snake
    public int getLength(){
        int count = 0;
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                if(game[i][j]) count++;
            }
        }
        return count;
    }


    //Method used to reset the checks counters
    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    //Getter for exhaustive checks
    public static int getExhaustiveChecks() {
        return exhaustiveChecks;
    }
    //Getter for recursive checks
    public static int getRecursiveChecks() {
        return recursiveChecks;
    }
}