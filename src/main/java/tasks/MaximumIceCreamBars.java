package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 4/18/2021
 */
@LeetCode(
		id = 1833,
		name = "Maximum Ice Cream Bars",
		url = "https://leetcode.com/problems/maximum-ice-cream-bars/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumIceCreamBars {
	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int count = 0;
		for (int cost : costs) {
			coins -= cost;
			if (coins < 0) {
				break;
			}
			count++;
		}
		return count;
	}
}
