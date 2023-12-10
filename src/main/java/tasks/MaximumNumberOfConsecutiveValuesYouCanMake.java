package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 3/20/2021
 */
@LeetCode(
		id = 1798,
		name = "Maximum Number of Consecutive Values You Can Make",
		url = "https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfConsecutiveValuesYouCanMake {
	public int getMaximumConsecutive(int[] coins) {
		Arrays.sort(coins);
		int count = 1;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] > count) {
				break;
			}

			count += coins[i];
		}
		return count;
	}

	public static void main(String[] args) {
		MaximumNumberOfConsecutiveValuesYouCanMake clazz = new MaximumNumberOfConsecutiveValuesYouCanMake();
		System.out.println(clazz.getMaximumConsecutive(new int[]{1, 3}));
		System.out.println(clazz.getMaximumConsecutive(new int[]{1, 1, 1, 4}));
		System.out.println(clazz.getMaximumConsecutive(new int[]{1, 4, 10, 3, 1}));
	}
}
