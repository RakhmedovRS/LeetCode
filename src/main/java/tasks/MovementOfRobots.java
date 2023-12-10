package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 6/10/2023
 */
@LeetCode(
		id = 2731,
		name = "Movement of Robots",
		url = "https://leetcode.com/problems/movement-of-robots/",
		difficulty = Difficulty.MEDIUM
)
public class MovementOfRobots {
	int MOD = 1_000_000_007;

	public int sumDistance(int[] nums, String s, int d) {
		long[] copy = new long[nums.length];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}

		char[] chars = s.toCharArray();
		for (int i = 0; i < copy.length; i++) {
			if (chars[i] == 'L') {
				copy[i] += (-1L * d);
			}
			else {
				copy[i] += d;
			}
		}

		Arrays.sort(copy);
		long sum = 0;
		for (int i = 0; i < copy.length; i++) {
			sum += (i * copy[i]) - ((copy.length - 1 - i) * copy[i]);
			sum %= MOD;
		}

		return (int) sum;
	}
}
