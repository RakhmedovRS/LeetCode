package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 3/6/2021
 */
@LeetCode(
		id = 1781,
		name = "Sum of Beauty of All Substrings",
		url = "https://leetcode.com/problems/sum-of-beauty-of-all-substrings/",
		difficulty = Difficulty.MEDIUM
)
public class SumOfBeautyOfAllSubstrings
{
	public int beautySum(String s)
	{
		char[] chars = s.toCharArray();
		int[] table = new int[26];
		for (char ch : chars)
		{
			table[ch - 'a']++;
		}

		return dfs(chars, 0, chars.length - 1, table, new Boolean[chars.length][chars.length]);
	}

	private int dfs(char[] chars, int left, int right, int[] table, Boolean[][] memo)
	{
		if (left == right)
		{
			return 0;
		}

		if (memo[left][right] != null)
		{
			return 0;
		}

		memo[left][right] = true;

		int[] tableCopyA = Arrays.copyOf(table, table.length);
		tableCopyA[chars[left] - 'a']--;

		int[] tableCopyB = Arrays.copyOf(table, table.length);
		tableCopyB[chars[right] - 'a']--;

		return calcBeauty(table) + dfs(chars, left + 1, right, tableCopyA, memo) + dfs(chars, left, right - 1, tableCopyB, memo);
	}

	private int calcBeauty(int[] table)
	{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int count : table)
		{
			if (count > 0)
			{
				min = Math.min(min, count);
				max = Math.max(max, count);
			}
		}

		return max - min;
	}

	public static void main(String[] args)
	{
		SumOfBeautyOfAllSubstrings clazz = new SumOfBeautyOfAllSubstrings();
		System.out.println(clazz.beautySum("aabcb"));
		System.out.println(clazz.beautySum("aabcbaa"));
	}
}
