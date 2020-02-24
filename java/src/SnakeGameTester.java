import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    @Test
    public void testSnakeGame1(){
        boolean[][] testArr = {
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, false},
                {false, false,false, true, true},
                {false, false,false, false, false},
        };

        SnakeGame test = new SnakeGame(testArr, new int[]{0, 3});
        Assert.assertArrayEquals(new int[]{3, 4, 5}, test.findTailRecursive());
    }


}
