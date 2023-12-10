package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/2/2021
 */
@LeetCode(
		id = 97,
		name = "Interleaving String",
		url = "https://leetcode.com/problems/interleaving-string/",
		difficulty = Difficulty.MEDIUM
)
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		Boolean[][] memo = new Boolean[s1.length()][s2.length()];

		return dfs(0, s1, 0, s2, 0, s3, memo);
	}

	private boolean dfs(int s1Pos, String s1, int s2Pos, String s2, int s3Pos, String s3, Boolean[][] memo) {
		if (s1Pos == s1.length()) {
			return s2.substring(s2Pos).equals(s3.substring(s3Pos));
		}

		if (s2Pos == s2.length()) {
			return s1.substring(s1Pos).equals(s3.substring(s3Pos));
		}

		if (memo[s1Pos][s2Pos] != null) {
			return memo[s1Pos][s2Pos];
		}

		memo[s1Pos][s2Pos] =
				((s1.charAt(s1Pos) == s3.charAt(s3Pos) && dfs(s1Pos + 1, s1, s2Pos, s2, s3Pos + 1, s3, memo))
						|| (s2.charAt(s2Pos) == s3.charAt(s3Pos) && dfs(s1Pos, s1, s2Pos + 1, s2, s3Pos + 1, s3, memo)));

		return memo[s1Pos][s2Pos];
	}
}
