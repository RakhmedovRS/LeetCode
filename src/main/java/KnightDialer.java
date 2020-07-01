import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(id = 935, name = "Knight Dialer", url = "https://leetcode.com/problems/knight-dialer/")
public class KnightDialer
{
	static int MOD = (int) (Math.pow(10, 9) + 7);

	public int knightDialer(int N)
	{
		int[][] moves = new int[10][];
		moves[0] = new int[]{4, 6};
		moves[1] = new int[]{6, 8};
		moves[2] = new int[]{7, 9};
		moves[3] = new int[]{4, 8};
		moves[4] = new int[]{0, 3, 9};
		moves[5] = new int[0];
		moves[6] = new int[]{0, 1, 7};
		moves[7] = new int[]{2, 6};
		moves[8] = new int[]{1, 3};
		moves[9] = new int[]{2, 4};

		long count = 0;
		int[][] memo = new int[10][N];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		for (int num = 0; num < 10; num++)
		{
			count += traverse(moves, num, memo, N - 1);
			count %= MOD;
		}

		return (int) (count % MOD);
	}

	private int traverse(int[][] moves, int currentDigit, int[][] memo, int stepsLeft)
	{
		if (stepsLeft == 0)
		{
			return 1;
		}

		if (currentDigit == 5)
		{
			return 0;
		}

		if (memo[currentDigit][stepsLeft] != -1)
		{
			return memo[currentDigit][stepsLeft];
		}

		int count = 0;
		for (int nextNum : moves[currentDigit])
		{
			count += traverse(moves, nextNum, memo, stepsLeft - 1);
			count %= MOD;
		}

		memo[currentDigit][stepsLeft] = count;

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new KnightDialer().knightDialer(161));
		System.out.println(new KnightDialer().knightDialer(1));
		System.out.println(new KnightDialer().knightDialer(2));
		System.out.println(new KnightDialer().knightDialer(3));
	}
}
