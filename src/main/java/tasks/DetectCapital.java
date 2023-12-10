package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-May-20
 */
@LeetCode(
		id = 520,
		name = "Detect Capital",
		url = "https://leetcode.com/problems/detect-capital/submissions/",
		difficulty = Difficulty.EASY
)
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		boolean allCapital = Character.isUpperCase(word.charAt(0));
		boolean fistCapital = Character.isUpperCase(word.charAt(0));
		boolean allSmall = Character.isLowerCase(word.charAt(0));
		for (int i = 1; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i))) {
				allSmall = false;
				fistCapital = false;
			}
			else {
				allCapital = false;
			}
		}

		return allCapital || fistCapital || allSmall;
	}
}
