package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/2/2020
 */
@LeetCode(
		id = 616,
		name = "Add Bold Tag in String",
		url = "https://leetcode.com/problems/add-bold-tag-in-string/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class AddBoldTagInString {
	public String addBoldTag(String S, String[] words) {
		boolean[] bold = new boolean[S.length()];
		char[] chars = S.toCharArray();
		for (String word : words) {
			for (int i = 0; i < chars.length; i++) {
				for (int a = i, b = 0; a < chars.length && b < word.length(); a++, b++) {
					if (chars[a] != word.charAt(b)) {
						break;
					}

					if (b == word.length() - 1) {
						for (int j = i; j <= a; j++) {
							bold[j] = true;
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (bold[i] && (i == 0 || !bold[i - 1])) {
				sb.append("<b>");
			}

			if (!bold[i] && i > 0 && bold[i - 1]) {
				sb.append("</b>");
			}

			sb.append(chars[i]);
		}

		if (bold[chars.length - 1]) {
			sb.append("</b>");
		}

		return sb.toString();
	}
}
