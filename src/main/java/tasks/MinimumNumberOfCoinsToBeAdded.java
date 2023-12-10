package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/2/2023
 */
@LeetCode(
		id = 2952,
		name = "Minimum Number of Coins to be Added",
		url = "https://leetcode.com/problems/minimum-number-of-coins-to-be-added/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfCoinsToBeAdded {
	public int minimumAddedCoins(int[] coins, int target) {
		int add = 0;
		Arrays.sort(coins);
		int max = 0;
		for (int coin : coins) {
			while (coin > max + 1) {
				max += max + 1;
				add++;
			}

			max += coin;

			if (max >= target) {
				return add;
			}
		}

		while (max < target) {
			max += max + 1;
			add++;
		}

		return add;
	}
}
