import java.util.*;

public class Problem348 {

	public static void main(String[] args) {

	}

	static class TicTacToe {

		int[] rows;
		int[] cols;
		int lDiag = 0, rDiag = 0;

		public TicTacToe(int n) {
			rows = new int[n];
			cols = new int[n];
		}

		public int move(int row, int col, int player) {
			int n = rows.length;
			int currentPlayer = player == 1 ? 1 : -1;

			rows[row] += currentPlayer;
			cols[col] += currentPlayer;
			
			if(row == col) {
				lDiag += currentPlayer;
			}
			if(row + col == n-1) {
				rDiag += currentPlayer;
			}

			if(Math.abs(rows[row]) == n ||
			   Math.abs(cols[col]) == n ||
			   Math.abs(lDiag) == n     ||
			   Math.abs(rDiag) == n) {
				return player;
			}

			return 0;
		}
	}
}
