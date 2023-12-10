package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Jul-20
 */
@LeetCode(id = 1513, name = "Number of Substrings With Only 1s", url = "https://leetcode.com/problems/number-of-substrings-with-only-1s/")
public class NumberOfSubstringsWithOnly1s {
	public int numSub(String s) {
		long ones = 0;
		int mod = (int) Math.pow(10, 9) + 7;
		String[] parts = s.split("0");
		for (String part : parts) {
			int i = 1;
			while (i <= part.length()) {
				ones += i;
				i++;
			}
			ones %= mod;
		}

		return (int) ones;
	}
}
