package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-31
 */
@LeetCode(
		id = 3270,
		name = "Find the Key of the Numbers",
		url = "https://leetcode.com/problems/find-the-key-of-the-numbers/description/",
		difficulty = Difficulty.EASY
)
public class FindTheKeyOfTheNumbers {
	public int generateKey(int num1, int num2, int num3) {
		String a = "" + num1;
		String b = "" + num2;
		String c = "" + num3;
		while (a.length() < 4) {
			a = "0" + a;
		}

		while (b.length() < 4) {
			b = "0" + b;
		}

		while (c.length() < 4) {
			c = "0" + c;
		}

		int num = 0;
		for (int i = 0; i < 4; i++) {
			int min = Math.min((a.charAt(i) - '0'), Math.min((b.charAt(i) - '0'), (c.charAt(i) - '0')));
			num *= 10;
			num += min;
		}
		return num;
	}
}