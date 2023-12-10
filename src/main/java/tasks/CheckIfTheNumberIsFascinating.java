package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 6/10/2023
 */
@LeetCode(
		id = 2729,
		name = "Check if The Number is Fascinating",
		url = "https://leetcode.com/problems/check-if-the-number-is-fascinating/",
		difficulty = Difficulty.EASY
)
public class CheckIfTheNumberIsFascinating {
	public boolean isFascinating(int n) {
		Set<Character> set = new HashSet<>();
		for (char ch : (n + "").toCharArray()) {
			if (ch == '0') {
				return false;
			}

			if (!set.add(ch)) {
				return false;
			}
		}

		for (char ch : ((n * 2) + "").toCharArray()) {
			if (ch == '0') {
				return false;
			}

			if (!set.add(ch)) {
				return false;
			}
		}

		for (char ch : ((n * 3) + "").toCharArray()) {
			if (ch == '0') {
				return false;
			}

			if (!set.add(ch)) {
				return false;
			}
		}

		return set.size() == 9;
	}
}
