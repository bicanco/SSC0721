import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BoardTest extends Board {

    private int x, y;
    private int expected;
    
    public BoardTest(int x, int y, int expected, int[][] board) {
        this.x = x;
        this.y = y;
        this.expected = expected;
        this.board = board;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
    	return Arrays.asList(new Object[][] {
    		{ 0, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}},
    	});
    }

    
    @Test
    public void test() {
         assertEquals(expected, this.nextCellState(x, y));
    }
}