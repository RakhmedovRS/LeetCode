package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12-Feb-20
 */
@LeetCode(id = 1222, name = "Queens That Can Attack the King", url = "https://leetcode.com/problems/queens-that-can-attack-the-king/")
public class QueensThatCanAttackKing
{
	public boolean[][] createBoard(int[][] queens)
	{
		boolean[][] board = new boolean[8][8];
		for (int[] queen : queens)
		{
			board[queen[0]][queen[1]] = true;
		}
		return board;
	}

	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king)
	{
		List<List<Integer>> result = new LinkedList<>();
		boolean[][] board = createBoard(queens);

		for (int x = king[0] + 1; x < 8; x++)
		{
			if (board[x][king[1]])
			{
				result.add(Arrays.asList(x, king[1]));
				break;
			}
		}

		for (int x = king[0] - 1; x >= 0; x--)
		{
			if (board[x][king[1]])
			{
				result.add(Arrays.asList(x, king[1]));
				break;
			}
		}

		for (int x = king[1] + 1; x < 8; x++)
		{
			if (board[king[0]][x])
			{
				result.add(Arrays.asList(king[0], x));
				break;
			}
		}

		for (int x = king[1] - 1; x >= 0; x--)
		{
			if (board[king[0]][x])
			{
				result.add(Arrays.asList(king[0], x));
				break;
			}
		}

		for (int x = king[0] + 1, y = king[1] + 1; x < 8 && y < 8; x++, y++)
		{
			if (board[x][y])
			{
				result.add(Arrays.asList(x, y));
				break;
			}
		}

		for (int x = king[0] - 1, y = king[1] - 1; x >= 0 && y >= 0; x--, y--)
		{
			if (board[x][y])
			{
				result.add(Arrays.asList(x, y));
				break;
			}
		}

		for (int x = king[0] - 1, y = king[1] + 1; x >= 0 && y < 8; x--, y++)
		{
			if (board[x][y])
			{
				result.add(Arrays.asList(x, y));
				break;
			}
		}

		for (int x = king[0] + 1, y = king[1] - 1; x < 8 && y >= 0; x++, y--)
		{
			if (board[x][y])
			{
				result.add(Arrays.asList(x, y));
				break;
			}
		}

		return result;
	}
}
