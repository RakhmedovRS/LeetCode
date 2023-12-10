package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 01-Aug-20
 */
@LeetCode(
		id = 1234,
		name = "Replace the Substring for Balanced String",
		url = "https://leetcode.com/problems/replace-the-substring-for-balanced-string/",
		difficulty = Difficulty.MEDIUM
)
public class ReplaceTheSubstringForBalancedString {
	public int balancedString(String s) {
		int[] memo = new int[26];
		char[] chars = s.toCharArray();
		int qPos = 'Q' - 'A';
		int wPos = 'W' - 'A';
		int ePos = 'E' - 'A';
		int rPos = 'R' - 'A';
		for (char ch : chars) {
			memo[ch - 'A']++;
		}

		int targetLength = Math.max(1, s.length() / 4);
		memo[qPos] = Math.max(0, memo[qPos] - targetLength);
		memo[wPos] = Math.max(0, memo[wPos] - targetLength);
		memo[ePos] = Math.max(0, memo[ePos] - targetLength);
		memo[rPos] = Math.max(0, memo[rPos] - targetLength);
		if (memo[qPos] == 0 && memo[wPos] == 0 && memo[ePos] == 0 && memo[rPos] == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int minLen = s.length();
		int[] seen = new int[26];
		while (left <= right) {
			if (seen[qPos] >= memo[qPos] && seen[wPos] >= memo[wPos] && seen[ePos] >= memo[ePos] && seen[rPos] >= memo[rPos]) {
				minLen = Math.min(minLen, right - left);
				seen[chars[left++] - 'A']--;
			}
			else {
				if (right == chars.length) {
					break;
				}
				seen[chars[right++] - 'A']++;
			}
		}

		return minLen;
	}

	public static void main(String[] args) {
		System.out.println(new ReplaceTheSubstringForBalancedString().balancedString("QQWE"));
		System.out.println(new ReplaceTheSubstringForBalancedString().balancedString("QQQQ"));
		System.out.println(new ReplaceTheSubstringForBalancedString().balancedString("QWER"));
	}
}
