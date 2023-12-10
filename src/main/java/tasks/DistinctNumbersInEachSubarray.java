package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 5/8/2021
 */
@LeetCode(
		id = 1852,
		name = "Distinct Numbers in Each Subarray",
		url = "https://leetcode.com/problems/distinct-numbers-in-each-subarray/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DistinctNumbersInEachSubarray {
	public int[] distinctNumbers(int[] nums, int k) {
		int[] answer = new int[nums.length - k + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (i == k - 1) {
				answer[j++] = map.size();
			}
			else if (i >= k) {
				int rem = nums[i - k];
				int count = map.remove(rem) - 1;
				if (count > 0) {
					map.put(rem, count);
				}

				answer[j++] = map.size();
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		DistinctNumbersInEachSubarray clazz = new DistinctNumbersInEachSubarray();
		System.out.println(Arrays.toString(clazz.distinctNumbers(new int[]{1, 2, 3, 2, 2, 1, 3}, 3)));
	}
}
