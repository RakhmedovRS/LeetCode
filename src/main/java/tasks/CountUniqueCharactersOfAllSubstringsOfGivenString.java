package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/27/2020
 */
@LeetCode(id = 828, name = "Count Unique Characters of All Substrings of a Given String", url = "https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/")
public class CountUniqueCharactersOfAllSubstringsOfGivenString {
	public int uniqueLetterString(String s) {
		int mod = 1_000_000_007;
		long count = 0;
		char[] chars = s.toCharArray();
		int[][] memo = new int[26][2];
		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}

		int pos;
		for (int i = 0; i < chars.length; i++) {
			pos = chars[i] - 'A';
			count = (count + (i - memo[pos][1]) * (memo[pos][1] - memo[pos][0]) % mod) % mod;
			memo[pos] = new int[]{memo[pos][1], i};
		}

		for (int i = 0; i < 26; i++) {
			count = (count + (chars.length - memo[i][1]) * (memo[i][1] - memo[i][0]) % mod) % mod;
		}

		return (int) (count % mod);
	}
}
