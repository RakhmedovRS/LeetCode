package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 21-Jun-20
 */
@LeetCode(id = 697, name = "Degree of an Array", url = "https://leetcode.com/problems/degree-of-an-array/")
public class DegreeOfArray {
	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int num : nums) {
			int count = map.getOrDefault(num, 0) + 1;
			if (count > max) {
				max = count;
			}
			map.put(num, count);
		}

		if (max == 1) {
			return 1;
		}

		int min = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max) {
				int left = 0;
				int right = nums.length - 1;
				while (nums[left] != entry.getKey()) {
					left++;
				}
				while (nums[right] != entry.getKey()) {
					right--;
				}
				min = Math.min(min, 1 + right - left);
			}
		}

		return min;
	}
}
