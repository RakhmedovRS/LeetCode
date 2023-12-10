package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/22/2020
 */
@LeetCode(
		id = 1663,
		name = "Smallest String With A Given Numeric Value",
		url = "https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/",
		difficulty = Difficulty.MEDIUM
)
public class SmallestStringWithGivenNumericValue {
	public String getSmallestString(int n, int k) {
		char[] chars = new char[n];
		int max;
		for (int i = 1; i <= n; i++) {
			max = 26 * (n - i);
			for (int ch = 1; ch <= 26; ch++) {
				if (k - ch <= max) {
					chars[i - 1] = (char) (ch - 1 + 'a');
					k -= ch;
					break;
				}
			}
		}

		return String.valueOf(chars);
	}

	public static void main(String[] args) throws Exception {
		SmallestStringWithGivenNumericValue clazz = new SmallestStringWithGivenNumericValue();
		System.out.println(clazz.getSmallestString(3, 27));
		System.out.println(clazz.getSmallestString(5, 73));
	}
}
