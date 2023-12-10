package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(
		id = 791,
		name = "Custom Sort String",
		url = "https://leetcode.com/problems/custom-sort-string/",
		difficulty = Difficulty.MEDIUM
)
public class CustomSortString {
	public String customSortString(String order, String str) {
		int[] memo = new int[26];
		for (char ch : str.toCharArray()) {
			memo[ch - 'a']++;
		}

		Set<Character> seen = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for (char ch : order.toCharArray()) {
			seen.add(ch);
			while (memo[ch - 'a']-- > 0) {
				sb.append(ch);
			}
		}

		for (char ch : str.toCharArray()) {
			if (!seen.contains(ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}
}
