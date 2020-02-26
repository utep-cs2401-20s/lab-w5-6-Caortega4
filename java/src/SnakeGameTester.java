import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    @Test

    //Tests both findTail methods on a not straight snake
    public void testSnakeGame1(){
        boolean[][] testArr = {
                {false, false,false, false, false},
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, true},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{3, 4});
        Assert.assertArrayEquals(new int[]{1, 3, 4}, test.findTailExhaustive());
        Assert.assertArrayEquals(new int[]{1, 3, 4}, test.findTailRecursive());


    }

    @Test
    //Tests both findTail methods on a straight snake
    public void testSnakeGame2(){
        boolean[][] testArr = {
                {false, false, false},
                {true, true,true},
                {false, false,false},

        };

        SnakeGame test = new SnakeGame(testArr, new int[]{1, 0});
        Assert.assertArrayEquals(new int[]{1, 2, 3}, test.findTailExhaustive());
        Assert.assertArrayEquals(new int[]{1, 2, 3}, test.findTailRecursive());
    }

    @Test
    //Tests exhaustive and recursive checks
    public void testSnakeGame3(){
        boolean[][] testArr = {
                {false, false,true, false, false},
                {false, false,true, false, false},
                {false, true,true, false, false},
                {true, true,false, false, false},
                {true, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{4, 0});
        Assert.assertArrayEquals(new int[]{0, 2, 7}, test.findTailRecursive());
        assertEquals(7, test.getRecursiveChecks());
        Assert.assertArrayEquals(new int[]{0, 2, 7}, test.findTailExhaustive());
        assertEquals(3, test.getExhaustiveChecks());


    }

    @Test
    //Tests recursive and exhaustive checks
    public void testSnakeGame4(){
        boolean[][] testArr = {
                {true, true, true, true, true},
                {true, false,false, false, true},
                {true, false, true, true, true},
                {true, false,false, false, false},
                {true, true, true, true, true},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{4, 4});
        Assert.assertArrayEquals(new int[]{2, 2, 17}, test.findTailRecursive());
        assertEquals(17, test.getRecursiveChecks());
        Assert.assertArrayEquals(new int[]{2, 2, 17}, test.findTailExhaustive());
        assertEquals(13, test.getExhaustiveChecks());
    }

    @Test
    public void testSnakeGame5(){
        boolean[][] testArr = {
                {false, false,false, false, false},
                {false, false,false, false, false},
                {false, false,true, false, false},
                {false, false,false, false, false},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{2, 2});
        Assert.assertArrayEquals(new int[]{2, 2, 1}, test.findTailRecursive());
        assertEquals(1, test.getRecursiveChecks());
        Assert.assertArrayEquals(new int[]{2, 2, 1}, test.findTailExhaustive());
        assertEquals(13, test.getExhaustiveChecks());
    }


}
