package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
		id = 1672,
		name = "Richest Customer Wealth",
		url = "https://leetcode.com/problems/richest-customer-wealth/",
		difficulty = Difficulty.EASY
)
public class RichestCustomerWealth {
	public int maximumWealth(int[][] accounts) {
		int max = 0;
		int sum;
		for (int[] account : accounts) {
			sum = 0;
			for (int amount : account) {
				sum += amount;
			}

			max = Math.max(max, sum);
		}
		return max;
	}
}
