package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/30/2020
 */
@LeetCode(
		id = 1283,
		name = "Find the Smallest Divisor Given a Threshold",
		url = "https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheSmallestDivisorGivenThreshold {
	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = Integer.MAX_VALUE - 1;
		int middle;
		int answer = 0;
		while (left <= right) {
			middle = (left + right) / 2;
			if (sumOfRest(nums, middle) > threshold) {
				left = middle + 1;
			}
			else {
				answer = middle;
				right = middle - 1;
			}
		}

		return answer;
	}

	private int sumOfRest(int[] nums, int div) {
		int sum = 0;
		for (int num : nums) {
			if (num % div == 0) {
				sum += num / div;
			}
			else {
				sum += 1 + num / div;
			}
		}

		return sum;
	}
}
