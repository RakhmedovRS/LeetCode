package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/16/2021
 */
@LeetCode(
		id = 1864,
		name = "Minimum Number of Swaps to Make the Binary String Alternating",
		url = "https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfSwapsToMakeTheBinaryStringAlternating {
	public int minSwaps(String s) {
		char[] chars = s.toCharArray();
		int[] onesAndZeroes = new int[2];
		for (char ch : chars) {
			onesAndZeroes[ch - '0']++;
		}

		if (Math.abs(onesAndZeroes[0] - onesAndZeroes[1]) > 1) {
			return -1;
		}

		int steps = 0;
		char[] mask;
		if (onesAndZeroes[0] > onesAndZeroes[1]) {
			mask = createMask(chars.length, 0);
			steps = countSteps(chars, mask);
		}
		else if (onesAndZeroes[0] < onesAndZeroes[1]) {
			mask = createMask(chars.length, 1);
			steps = countSteps(chars, mask);
		}
		else {
			int steps1 = 0;
			int steps2 = 0;
			mask = createMask(chars.length, 0);
			steps1 = countSteps(chars, mask);

			mask = createMask(chars.length, 1);
			steps2 = countSteps(s.toCharArray(), mask);

			steps = Math.min(steps1, steps2);
		}

		return steps;
	}

	private void swap(char[] chars, int a, int b) {
		char temp = chars[a];
		chars[a] = chars[b];
		chars[b] = temp;
	}

	private char[] createMask(int n, int firstBit) {
		char[] mask = new char[n];
		for (int bit = firstBit, i = 0; i < n; i++, bit++) {
			mask[i] = bit % 2 == 0 ? '0' : '1';
		}

		return mask;
	}

	private int countSteps(char[] chars, char[] mask) {
		int steps = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != mask[i]) {
				steps++;

				for (int j = i + 1; j < chars.length; j++) {
					if (chars[j] != mask[j] && chars[j] != chars[i]) {
						swap(chars, i, j);
						break;
					}
				}
			}
		}

		return steps;
	}
}
