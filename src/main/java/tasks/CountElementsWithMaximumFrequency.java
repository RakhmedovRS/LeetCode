package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/14/2024
 */
@LeetCode(
		id = 3005,
		name = "Count Elements With Maximum Frequency",
		url = "https://leetcode.com/problems/count-elements-with-maximum-frequency/description/",
		difficulty = Difficulty.EASY
)
public class CountElementsWithMaximumFrequency {
	public int maxFrequencyElements(int[] nums) {
		int[] freq = new int[101];
		for (int num : nums) {
			freq[num]++;
		}

		int maxFreq = 0;
		int count = 0;
		for (int f : freq) {
			if (f > maxFreq) {
				maxFreq = f;
				count = f;
			} else if (f == maxFreq) {
				count += f;
			}
		}


		return count;
	}
}
