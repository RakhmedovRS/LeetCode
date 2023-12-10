package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Sep-20
 */
@LeetCode(id = 1573, name = "Number of Ways to Split a String", url = "https://leetcode.com/problems/number-of-ways-to-split-a-string/")
public class NumberOfWaysToSplitString {
	public int numWays(String s) {
		int MOD = (int) (Math.pow(10, 9) + 7);
		int ones = 0;
		int n = s.length();
		for (int i = 0; i < s.length(); ++i) {
			ones += s.charAt(i) - '0';
		}
		if (ones == 0) {
			return (int) ((n - 2L) * (n - 1) / 2 % MOD);
		}
		if (ones % 3 != 0) {
			return 0;
		}
		ones /= 3;
		long left = 0;
		long right = 0;
		int count = 0;
		for (int i = 0; i < s.length(); ++i) {
			count += s.charAt(i) - '0';
			if (count == ones) {
				left++;
			}
			else if (count == 2 * ones) {
				right++;
			}
		}
		return (int) (left * right % MOD);
	}

	public static void main(String[] args) {
		System.out.println(new NumberOfWaysToSplitString().numWays("00000000"));
		System.out.println(new NumberOfWaysToSplitString().numWays("100100010100110"));
		System.out.println(new NumberOfWaysToSplitString().numWays("0000"));
		System.out.println(new NumberOfWaysToSplitString().numWays("10101"));
	}
}
