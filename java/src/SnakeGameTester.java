import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    @Test
    public void testSnakeGame1(){
        boolean[][] testArr = {
                {false, false,false, false, false},
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, true},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{3, 4});
        Assert.assertArrayEquals(new int[]{1, 3, 4}, test.findTailRecursive());
    }

    @Test
    public void testSnakeGame2(){
        boolean[][] testArr = {
                {false, false,false, false, false},
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, true},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{3, 4});
        Assert.assertArrayEquals(new int[]{1, 3}, test.findTailRecursive());
    }

    @Test
    public void testSnakeGame3(){
        boolean[][] testArr = {
                {false, false,false, false, false},
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, true},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{3, 4});
        Assert.assertArrayEquals(new int[]{1, 3}, test.findTailRecursive());
    }

    @Test
    public void testSnakeGame4(){
        boolean[][] testArr = {
                {false, false,false, false, false},
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, true},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{3, 4});
        Assert.assertArrayEquals(new int[]{1, 3}, test.findTailRecursive());
    }

    @Test
    public void testSnakeGame5(){
        boolean[][] testArr = {
                {false, false,false, false, false},
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, true},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{3, 4});
        Assert.assertArrayEquals(new int[]{1, 3}, test.findTailRecursive());
    }


}
