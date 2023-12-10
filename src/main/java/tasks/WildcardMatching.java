package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Mar-20
 */
@LeetCode(
		id = 44,
		name = "Wildcard Matching",
		url = "https://leetcode.com/problems/wildcard-matching/",
		difficulty = Difficulty.HARD
)
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if (s == null && p == null) {
			return true;
		}
		else if (s != null && s.length() == 0 && p != null && p.length() == 0) {
			return true;
		}
		else if (s == null || p == null) {
			return false;
		}

		char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();
		int currentPos = 0;
		boolean firstStar = true;
		for (int pos = 0; pos < pattern.length; pos++) {
			if (pattern[pos] == '*') {
				if (firstStar) {
					pattern[currentPos++] = pattern[pos];
					firstStar = false;
				}
			}
			else {
				pattern[currentPos++] = pattern[pos];
				firstStar = true;
			}
		}


		boolean[][] memo = new boolean[string.length + 1][currentPos + 1];
		memo[0][0] = true;
		if (currentPos > 0 && pattern[0] == '*') {
			memo[0][1] = true;
		}

		for (int row = 1; row < memo.length; row++) {
			for (int column = 1; column < memo[row].length; column++) {
				char ch = pattern[column - 1];
				if (ch == '?' || string[row - 1] == ch) {
					memo[row][column] = memo[row - 1][column - 1];
				}
				else if (ch == '*') {
					memo[row][column] = memo[row - 1][column] || memo[row][column - 1];
				}
				else {
					memo[row][column] = false;
				}
			}
		}

		return memo[string.length][currentPos];
	}

	public static void main(String[] args) {
		System.out.println(new WildcardMatching().isMatch("ho", "**ho"));
		System.out.println(new WildcardMatching().isMatch("a", ""));
		System.out.println(new WildcardMatching().isMatch("", "*"));
		System.out.println(new WildcardMatching().isMatch("", ""));
		System.out.println(new WildcardMatching().isMatch("aa", "a"));
		System.out.println(new WildcardMatching().isMatch("adceb", "*a*b"));
		System.out.println(new WildcardMatching().isMatch("acdcb", "a*c?b"));
	}
}
