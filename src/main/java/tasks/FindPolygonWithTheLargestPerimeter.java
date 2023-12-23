package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/23/2023
 */
@LeetCode(
		id = 2971,
		name = "Find Polygon With the Largest Perimeter",
		url = "https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/",
		difficulty = Difficulty.MEDIUM
)
public class FindPolygonWithTheLargestPerimeter {
	public long largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		long ans = -1;
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum - nums[nums.length - 1] > nums[nums.length - 1]) {
			return sum;
		}

		long tempSum = sum;
		int right = nums.length - 1;
		while (right >= 2) {
			if (tempSum - nums[right] > nums[right]) {
				ans = Math.max(ans, tempSum);
				break;
			}

			tempSum -= nums[right--];
		}

		return ans;
	}
}
