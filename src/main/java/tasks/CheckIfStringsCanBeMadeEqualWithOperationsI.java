package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/2/2023
 */
@LeetCode(
		id = 2839,
		name = "Check if Strings Can be Made Equal With Operations I",
		url = "https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/",
		difficulty = Difficulty.EASY
)
public class CheckIfStringsCanBeMadeEqualWithOperationsI {
	public boolean canBeEqual(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();

		for (int i = 0; i < 2; i++) {
			if (a1[i] > a1[i + 2]) {
				char temp = a1[i];
				a1[i] = a1[i + 2];
				a1[i + 2] = temp;
			}
		}

		for (int i = 0; i < 2; i++) {
			if (a2[i] > a2[i + 2]) {
				char temp = a2[i];
				a2[i] = a2[i + 2];
				a2[i + 2] = temp;
			}
		}

		return String.valueOf(a1).equals(String.valueOf(a2));
	}
}
