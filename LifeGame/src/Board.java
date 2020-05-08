import java.util.Random;

public class Board {

	protected int boardSize = 6 ;
	protected int[][] board = new int[boardSize][boardSize];
	
	public Board(){
		Random rand = new Random();
		
		for(int i = 0; i < boardSize; i++) {
			this.board[i] = rand.ints(boardSize, 0, 2).toArray();
		}

	}
	
	public void print() {
		for(int i = 0; i < boardSize; i++) {
			System.out.print("|");
			for(int j = 0; j < boardSize; j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.print("\n");
		}
	}
	
	protected int numNeighborsAlive(int i, int j) {
		int sum = - board[i][j];
		
		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				if ((k >= 0) && (k < boardSize) && (l >= 0) && (l < boardSize)) {
					sum += board[k][l];
				}
			}
		}
		
		return sum;
	}
	
	protected int nextCellState(int i, int j) {
		int nAlive = numNeighborsAlive(i, j);
		if ((board[i][j] == 1) && (nAlive < 2 || nAlive > 3))
			return 0;
		if ((board[i][j] == 0) && (nAlive == 3))
			return 1;
		return board[i][j];
	}
	
	public Board nextBoardState() {
		int[][] newBoard = new int[boardSize][boardSize];

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				newBoard[i][j] = nextCellState(i, j);
			}
		}
		
		board = newBoard;
		return this;
	}
}
