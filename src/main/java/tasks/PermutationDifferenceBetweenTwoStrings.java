package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-11
 */
@LeetCode(
		id = 3146,
		name = "Permutation Difference between Two Strings",
		url = "https://leetcode.com/problems/permutation-difference-between-two-strings/description/",
		difficulty = Difficulty.EASY
)
public class PermutationDifferenceBetweenTwoStrings {
	public int findPermutationDifference(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}

		int sum = 0;
		for (int i = 0; i < t.length(); i++) {
			sum += Math.abs(map.get(t.charAt(i)) - i);
		}

		return sum;
	}
}