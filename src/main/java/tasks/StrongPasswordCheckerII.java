package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/14/2022
 */
@LeetCode(
		id = 2299,
		name = "Strong Password Checker II",
		url = "https://leetcode.com/problems/strong-password-checker-ii/",
		difficulty = Difficulty.EASY
)
public class StrongPasswordCheckerII {
	public boolean strongPasswordCheckerII(String password) {
		if (password.length() < 8) {
			return false;
		}

		boolean seenLowerCase = false;
		boolean seenUpperCase = false;
		boolean seenDigit = false;
		boolean seenSpecialCharacter = false;
		Character prev = null;
		for (char ch : password.toCharArray()) {
			if (Character.isDigit(ch)) {
				seenDigit = true;
			}

			if (Character.isLowerCase(ch)) {
				seenLowerCase = true;
			}

			if (Character.isUpperCase(ch)) {
				seenUpperCase = true;
			}

			if ("!@#$%^&*()-+".contains("" + ch)) {
				seenSpecialCharacter = true;
			}

			if (prev != null && prev == ch) {
				return false;
			}

			prev = ch;
		}

		return seenLowerCase && seenUpperCase && seenDigit && seenSpecialCharacter;
	}
}
