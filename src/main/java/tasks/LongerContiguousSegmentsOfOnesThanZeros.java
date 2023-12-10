package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/23/2021
 */
@LeetCode(
		id = 1869,
		name = "Longer Contiguous Segments of Ones than Zeros",
		url = "https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/",
		difficulty = Difficulty.EASY
)
public class LongerContiguousSegmentsOfOnesThanZeros {
	public boolean checkZeroOnes(String s) {
		int longestZeros = 0;
		int longestOnes = 0;

		int zeros = 0;
		int ones = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				if (zeros != 0) {
					longestZeros = Math.max(longestZeros, zeros);
					zeros = 0;
				}
				ones++;
			}
			else {
				if (ones != 0) {
					longestOnes = Math.max(longestOnes, ones);
					ones = 0;
				}
				zeros++;
			}

			if (i == s.length() - 1) {
				longestZeros = Math.max(longestZeros, zeros);
				longestOnes = Math.max(longestOnes, ones);
			}
		}


		return longestOnes > longestZeros;
	}
}
