package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/8/2020
 */
@LeetCode(
		id = 688,
		name = "Knight Probability in Chessboard",
		url = "https://leetcode.com/problems/knight-probability-in-chessboard/",
		difficulty = Difficulty.MEDIUM
)
public class KnightProbabilityInChessboard
{
	public double knightProbability(int length, int movesLeft, int row, int column)
	{
		int[][] moves = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
		double[][] memo = new double[length][length];
		memo[row][column] = 1;
		int x;
		int y;
		while (movesLeft-- > 0)
		{
			double[][] memo2 = new double[length][length];
			for (int r = 0; r < length; r++)
			{
				for (int c = 0; c < length; c++)
				{
					for (int[] move : moves)
					{
						x = r + move[0];
						y = c + move[1];
						if (x >= 0 && x < length && y >= 0 && y < length)
						{
							memo2[x][y] += memo[r][c] / 8D;
						}
					}
				}
			}

			memo = memo2;
		}

		double answer = 0;
		for (int r = 0; r < length; r++)
		{
			for (int c = 0; c < length; c++)
			{
				answer += memo[r][c];
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new KnightProbabilityInChessboard().knightProbability(8, 30, 6, 4));
		System.out.println(new KnightProbabilityInChessboard().knightProbability(1, 0, 0, 0));
		System.out.println(new KnightProbabilityInChessboard().knightProbability(3, 2, 0, 0));
	}
}
