package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 5/1/2022
 */
@LeetCode(
		id = 2261,
		name = "K Divisible Elements Subarrays",
		url = "https://leetcode.com/problems/k-divisible-elements-subarrays/",
		difficulty = Difficulty.MEDIUM
)
public class KDivisibleElementsSubarrays {
	public int countDistinct(int[] nums, int k, int p) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] % p == 0) {
					count++;
				}

				if (count > k) {
					break;
				}

				set.add(Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
			}
		}

		return set.size();
	}
}
