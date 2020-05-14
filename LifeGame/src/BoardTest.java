import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BoardTest extends Board {

    private int x, y, expected;
    private boolean validClass;
    
    public BoardTest(int x, int y, int expected, int[][] board, boolean validClass) {
        this.x = x;
        this.y = y;
        this.expected = expected;
        this.board = board;
        this.validClass = validClass;
    }
    
    
    @Parameters
    public static Collection<Object[]> data() {
    	return Arrays.asList(new Object[][] {
    		{ -1, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, false},
    		{ 0, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 1, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 4, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 5, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 6, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, false},
    		{ 0, -1, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, false},
    		{ 0, 1, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 4, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 5, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 6, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, false},
    		{ 1, 1, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 1, 1, 0, new int[][] {{0,1,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 1, 1, 0, new int[][] {{1,1,1,0,0,0},{1,0,1,0,0,0},{1,1,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 1, 1, 0, new int[][] {{1,1,1,0,0,0},{1,0,1,0,0,0},{1,1,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 1, 0, new int[][] {{1,0,1,0,0,0},{1,0,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 1, 0, new int[][] {{1,0,1,0,0,0},{1,1,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 1, 0, 0, new int[][] {{1,1,0,0,0,0},{0,1,0,0,0,0},{0,1,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 1, 0, 0, new int[][] {{1,1,0,0,0,0},{0,1,0,0,0,0},{1,1,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 5, 4, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,1,1},{0,0,0,1,0,1}}, true},
    		{ 5, 4, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,1,1,1},{0,0,0,1,0,1}}, true},
    		{ 4, 5, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,1,1},{0,0,0,0,1,0},{0,0,0,0,1,0}}, true},
    		{ 4, 5, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,1,1},{0,0,0,0,1,0},{0,0,0,0,1,1}}, true},
    		{ 0, 0, 0, new int[][] {{0,1,0,0,0,0},{0,1,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 0, 1, new int[][] {{0,1,0,0,0,0},{1,1,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 5, 0, new int[][] {{0,0,0,0,1,0},{0,0,0,0,1,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 0, 5, 1, new int[][] {{0,0,0,0,1,0},{0,0,0,0,1,1},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 5, 0, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,1,0,0,0,0},{0,1,0,0,0,0}}, true},
    		{ 5, 0, 1, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{1,1,0,0,0,0},{0,1,0,0,0,0}}, true},
    		{ 5, 5, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,1,0},{0,0,0,0,1,0}}, true},
    		{ 5, 5, 1, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,1,1},{0,0,0,0,1,0}}, true},
    		{ 2, 2, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,1,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 2, 2, 1, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 2, 2, 1, new int[][] {{0,0,0,0,0,0},{0,0,1,0,0,0},{0,1,1,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 2, 2, 0, new int[][] {{0,0,0,0,0,0},{0,0,1,0,0,0},{0,1,1,1,0,0},{0,0,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 2, 2, 0, new int[][] {{0,0,0,0,0,0},{0,0,0,0,0,0},{0,1,0,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 2, 2, 1, new int[][] {{0,0,0,0,0,0},{0,0,1,0,0,0},{0,1,0,1,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    		{ 2, 2, 0, new int[][] {{0,0,0,0,0,0},{0,0,1,0,0,0},{0,1,0,1,0,0},{0,0,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}}, true},
    	});
    }

    
    @Test
    public void testValid() {
    	assumeTrue(validClass);
        assertEquals(expected, this.nextCellState(x, y));
    }
    
    @Test
    public void testInvalid() {
    	assumeFalse(validClass);
    	try {
    		this.nextCellState(x, y);
    		fail();
    	} catch (Exception e) {
    		assertNotNull(e);
    	}
    }
}