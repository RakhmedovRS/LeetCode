package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 14-Sep-20
 */
@LeetCode(id = 1218, name = "Longest Arithmetic Subsequence of Given Difference", url = "https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/")
public class LongestArithmeticSubsequenceOfGivenDifference
{
	public int longestSubsequence(int[] arr, int difference)
	{
		Map<Integer, Integer> memo = new HashMap<>();
		int max = 1;
		for (int value : arr)
		{
			int count = memo.getOrDefault(value - difference, 0) + 1;
			memo.put(value, count);
			max = Math.max(max, count);
		}

		return max;
	}
}
