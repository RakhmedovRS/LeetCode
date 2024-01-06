package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 1/6/2024
 */
@LeetCode(
		id = 2996,
		name = "Smallest Missing Integer Greater Than Sequential Prefix Sum",
		url = "https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/",
		difficulty = Difficulty.EASY
)
public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
	public int missingInteger(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int prev = nums[0] - 1;
		int longest = 0;
		int sum = 0;
		int max = 0;
		int current = 0;
		for (int num : nums) {
			set.add(num);
		}

		for (int num : nums) {
			if (prev + 1 == num) {
				current++;
				sum += num;
				if (current > longest || (current == longest && sum > max)) {
					max = Math.max(max, sum);
					longest = current;
				}
				prev = num;
			}
			else {
				break;
			}
		}

		while (set.contains(max)) {
			max++;
		}

		return max;
	}
}
