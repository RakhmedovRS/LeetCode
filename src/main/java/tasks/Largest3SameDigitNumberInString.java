package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/8/2022
 */
@LeetCode(
		id = 2264,
		name = "Largest 3-Same-Digit Number in String",
		url = "https://leetcode.com/problems/largest-3-same-digit-number-in-string/",
		difficulty = Difficulty.EASY
)
public class Largest3SameDigitNumberInString {
	public String largestGoodInteger(String num) {
		String answer = "";

		for (int i = 1; i < num.length() - 1; i++) {
			if (num.charAt(i - 1) == num.charAt(i) && num.charAt(i) == num.charAt(i + 1)) {
				if (answer.equals("") || answer.charAt(0) < num.charAt(i)) {
					answer = "" + num.charAt(i) + num.charAt(i) + num.charAt(i);
				}
			}
		}

		return answer;
	}
}
