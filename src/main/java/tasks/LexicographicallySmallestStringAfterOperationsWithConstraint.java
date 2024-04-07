package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-06
 */
@LeetCode(
		id = 3106,
		name = "Lexicographically Smallest String After Operations With Constraint",
		url = "https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint/description/",
		difficulty = Difficulty.MEDIUM
)
public class LexicographicallySmallestStringAfterOperationsWithConstraint {
	public String getSmallestString(String s, int k) {
		if (k == 0) {
			return s;
		}
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		//ABCDEFGHIJKLMNOPQRSTUVWXYZ
		char[] chars = s.toCharArray();
		outer:
		for (int i = 0; i < chars.length; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				int minDist = calcDistance(alphabet, ch, chars[i]);
				if (minDist <= k) {
					chars[i] = ch;
					k -= minDist;
					continue outer;
				}
			}
		}

		return String.valueOf(chars);
	}

	private int calcDistance(char[] chars, char a, char b) {
		int left = 0;
		int pos = a - 'a';
		while (chars[pos] != b) {
			pos--;
			if (pos < 0) {
				pos = chars.length - 1;
			}
			left++;
		}

		int right = 0;
		pos = a - 'a';
		while (chars[pos] != b) {
			pos++;
			pos %= chars.length;
			right++;
		}

		return Math.min(left, right);
	}
}