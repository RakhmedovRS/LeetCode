package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-May-20
 */
@LeetCode(
		id = 917,
		name = "Reverse Only Letters",
		url = "https://leetcode.com/problems/reverse-only-letters/",
		difficulty = Difficulty.EASY
)
public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = s.length() - 1; i < s.length(); i++) {
			while (j >= 0 && !Character.isAlphabetic(s.charAt(j))) {
				j--;
			}

			if (Character.isAlphabetic(s.charAt(i))) {
				sb.append(s.charAt(j--));
			}
			else {
				sb.append(s.charAt(i));
			}

		}

		return sb.toString();
	}
}
