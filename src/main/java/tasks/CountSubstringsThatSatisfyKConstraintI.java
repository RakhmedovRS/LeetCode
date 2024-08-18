package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-17
 */
@LeetCode(
		id = 3258,
		name = "Count Substrings That Satisfy K-Constraint I",
		url = "https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/",
		difficulty = Difficulty.EASY
)
public class CountSubstringsThatSatisfyKConstraintI {
	public int countKConstraintSubstrings(String s, int k) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] bits = new int[2];
			for (int j = i; j < s.length(); j++) {
				bits[s.charAt(j) - '0']++;
				if (bits[0] <= k || bits[1] <= k) {
					res++;
				} else {
					break;
				}
			}
		}
		return res;
	}
}