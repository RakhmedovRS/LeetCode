package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Sep-20
 */
@LeetCode(id = 1156, name = "Swap For Longest Repeated Character Substring", url = "https://leetcode.com/problems/swap-for-longest-repeated-character-substring/")
public class SwapForLongestRepeatedCharacterSubstring
{
	public int maxRepOpt1(String text)
	{
		int[] memo = new int[26];
		char[] chars = text.toCharArray();
		for (char ch : chars)
		{
			memo[ch - 'a']++;
		}

		int[] max = {1};
		for (int i = 0; i < text.length(); i++)
		{
			dfs(chars, i, i + 1, 1, true, memo, max);
		}

		return max[0];
	}

	private void dfs(char[] chars, int left, int right, int count, boolean canSwap, int[] memo, int[] max)
	{
		max[0] = Math.max(max[0], (canSwap && memo[chars[left] - 'a'] > count) ? count + 1 : count);
		if (right == chars.length || count >= memo[chars[left] - 'a'])
		{
			return;
		}

		if (chars[left] == chars[right])
		{
			dfs(chars, left, right + 1, count + 1, canSwap, memo, max);
		}
		else if (canSwap)
		{
			dfs(chars, left, right + 1, count + 1, false, memo, max);
		}
	}
}
