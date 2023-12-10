package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Jun-20
 */
@LeetCode(
		id = 482,
		name = "License Key Formatting",
		url = "https://leetcode.com/problems/license-key-formatting/",
		difficulty = Difficulty.EASY
)
public class LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
		if (S == null || S.isEmpty() || K == 0) {
			return S;
		}

		StringBuilder stringBuilder = new StringBuilder();
		int groupSize = 0;
		for (int i = S.length() - 1; i >= 0; i--) {
			char ch = S.charAt(i);
			if (ch == '-') {
				continue;
			}
			else if (Character.isAlphabetic(ch)) {
				stringBuilder.append(Character.toUpperCase(ch));
			}
			else {
				stringBuilder.append(ch);
			}
			groupSize++;
			if (groupSize % K == 0) {
				stringBuilder.append('-');
			}

		}

		if (stringBuilder.length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '-') {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}

		return stringBuilder.reverse().toString();
	}
}
