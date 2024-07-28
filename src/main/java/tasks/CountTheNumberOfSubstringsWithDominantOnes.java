package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-27
 */
@LeetCode(
		id = 3234,
		name = "Count the Number of Substrings With Dominant Ones",
		url = "https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/",
		difficulty = Difficulty.MEDIUM
)
public class CountTheNumberOfSubstringsWithDominantOnes {
	public int numberOfSubstrings(String s) {
		int[] leftToRight = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			leftToRight[i] += s.charAt(i) - '0';
			if (i > 0) {
				leftToRight[i] += leftToRight[i - 1];
			}
		}

		int ans = 0;
		for (int left = 0; left < s.length(); left++) {
			for (int right = left; right < s.length(); right++) {
				int ones = leftToRight[right];
				if (left != 0) {
					ones -= leftToRight[left - 1];
				}

				int len = 1 + right - left;
				int zeroes = len - ones;
				if (ones >= zeroes * zeroes) {
					int sqrt = (int) Math.sqrt(ones);
					ans++;
					if (sqrt > zeroes) {
						ans += (right + (sqrt - zeroes)) >= s.length() ? s.length() - right - 1 : sqrt - zeroes;
						right += (sqrt - zeroes);
					}
				} else {
					right = Math.max(right, left + (zeroes * zeroes) - 1);
				}
			}
		}
		return ans;
	}
}