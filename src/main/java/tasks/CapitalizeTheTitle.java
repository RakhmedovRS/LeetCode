package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/8/2022
 */
@LeetCode(
		id = 2129,
		name = "Capitalize the Title",
		url = "https://leetcode.com/problems/capitalize-the-title/",
		difficulty = Difficulty.EASY
)
public class CapitalizeTheTitle {
	public String capitalizeTitle(String title) {
		StringBuilder sb = new StringBuilder();
		for (String word : title.split(" ")) {
			if (sb.length() > 0) {
				sb.append(" ");
			}

			char[] chars = word.toLowerCase().toCharArray();

			if (word.length() > 2) {
				chars[0] = Character.toUpperCase(chars[0]);
			}

			sb.append(chars);
		}

		return sb.toString();
	}
}
