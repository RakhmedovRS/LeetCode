package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(
	id = 935,
	name = "Knight Dialer",
	url = "https://leetcode.com/problems/knight-dialer/",
	difficulty = Difficulty.MEDIUM
)
public class KnightDialer
{
	public int knightDialer(int N)
	{
		if (N == 0)
		{
			return 0;
		}

		int MOD = 1_000_000_007;
		int[][] numPad =
			{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 0, 11}
			};
		Integer[][] memo = new Integer[N + 1][12];
		for (int i = 0; i < 10; i++)
		{
			memo[0][i] = 1;
		}
		int[][] steps = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
		int prevRow;
		int prevColumn;
		for (int n = 1; n <= N; n++)
		{
			Arrays.fill(memo[n], 0);
			for (int row = 0; row < numPad.length; row++)
			{
				for (int column = 0; column < numPad[0].length; column++)
				{
					if (numPad[row][column] == 10 || numPad[row][column] == 11)
					{
						continue;
					}

					for (int[] step : steps)
					{
						prevRow = row + step[0];
						prevColumn = column + step[1];
						if (isValidMove(prevRow, prevColumn, numPad))
						{
							memo[n][numPad[row][column]] += memo[n - 1][numPad[prevRow][prevColumn]] % MOD;
							memo[n][numPad[row][column]] %= MOD;
						}
					}
				}
			}
		}

		long result = 0;
		for (int row = 0; row < numPad.length; row++)
		{
			for (int column = 0; column < numPad[0].length; column++)
			{
				if (numPad[row][column] == 10 || numPad[row][column] == 11)
				{
					continue;
				}

				result += memo[N - 1][numPad[row][column]] % MOD;
				result %= MOD;
			}
		}

		return (int) (result % MOD);
	}

	private boolean isValidMove(int row, int column, int[][] numPad)
	{
		return row >= 0
			&& row < numPad.length
			&& column >= 0
			&& column < numPad[row].length
			&& numPad[row][column] != 10
			&& numPad[row][column] != 11;
	}

	public static void main(String[] args)
	{
		System.out.println(new KnightDialer().knightDialer(161));
		System.out.println(new KnightDialer().knightDialer(1));
		System.out.println(new KnightDialer().knightDialer(2));
		System.out.println(new KnightDialer().knightDialer(3));
	}
}
