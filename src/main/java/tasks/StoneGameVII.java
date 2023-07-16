package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/13/2020
 */
@LeetCode(
		id = 1690,
		name = "Stone Game VII",
		url = "https://leetcode.com/problems/stone-game-vii/",
		difficulty = Difficulty.MEDIUM
)
public class StoneGameVII
{
	public int stoneGameVII(int[] stones)
	{
		int sum = 0;
		for (int stone : stones)
		{
			sum += stone;
		}

		return game(stones, 0, stones.length - 1, sum, true, new Integer[stones.length][stones.length]);
	}

	private int game(int[] stones, int left, int right, int sum, boolean aliceTurn, Integer[][] memo)
	{
		if (left == right)
		{
			return 0;
		}

		if (memo[left][right] != null)
		{
			return memo[left][right];
		}

		if (aliceTurn)
		{
			memo[left][right] =
					Math.max(
							sum - stones[left] + game(stones, left + 1, right, sum - stones[left], false, memo),
							sum - stones[right] + game(stones, left, right - 1, sum - stones[right], false, memo)
					);
		}
		else
		{
			memo[left][right] =
					Math.min(
							game(stones, left + 1, right, sum - stones[left], true, memo) - (sum - stones[left]),
							game(stones, left, right - 1, sum - stones[right], true, memo) - (sum - stones[right])
					);
		}

		return memo[left][right];
	}

	public static void main(String[] args)
	{
		System.out.println(new StoneGameVII().stoneGameVII(new int[]{5, 3, 1, 4, 2}));
		System.out.println(new StoneGameVII().stoneGameVII(new int[]{792, 195, 697, 271, 743, 51, 836, 322, 135, 550, 399, 182, 988, 25, 395, 254, 480, 931, 513, 772, 798, 102, 110, 915, 794, 330, 597, 220, 789, 462}));
		System.out.println(new StoneGameVII().stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
	}
}
