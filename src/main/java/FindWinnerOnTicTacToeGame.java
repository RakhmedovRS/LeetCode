import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/7/2020
 */
@LeetCode(
	id = 1275,
	name = "Find Winner on a Tic Tac Toe Game",
	url = "https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class FindWinnerOnTicTacToeGame
{
	public String tictactoe(int[][] moves)
	{
		char[][] table = new char[3][3];
		boolean firstPlayer = true;
		for (int[] move : moves)
		{
			if (setAndCheck(table, move[0], move[1], firstPlayer ? 'X' : 'O'))
			{
				return firstPlayer ? "A" : "B";
			}
			firstPlayer = !firstPlayer;
		}

		return moves.length == 9 ? "Draw" : "Pending";
	}

	private boolean setAndCheck(char[][] table, int row, int column, char ch)
	{
		table[row][column] = ch;
		for (int r = 0, c = 1; r < 3; r++)
		{
			if (table[r][c] != 0 && table[r][c - 1] == table[r][c] && table[r][c] == table[r][c + 1])
			{
				return true;
			}
		}

		for (int r = 1, c = 0; c < 3; c++)
		{
			if (table[r][c] != 0 && table[r-1][c] == table[r][c] && table[r][c] == table[r + 1][c])
			{
				return true;
			}
		}

		if (table[1][1] != 0 && table[0][0] == table[1][1] && table[1][1] == table[2][2])
		{
			return true;
		}

		if (table[1][1] != 0 && table[0][2] == table[1][1] && table[1][1] == table[2][0])
		{
			return true;
		}

		return false;
	}
}
