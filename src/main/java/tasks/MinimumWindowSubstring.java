package tasks;

import common.Difficulty;
import common.LeetCode;


/**
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
@LeetCode(
		id = 76,
		name = "Minimum Window Substring",
		url = "https://leetcode.com/problems/minimum-window-substring/",
		difficulty = Difficulty.HARD
)
public class MinimumWindowSubstring
{
	public String minWindow(String s, String t)
	{
		char[] string = s.toCharArray();

		int[] pMemo = buildTable(t);
		int[] sMemo = new int['z' - 'A' + 1];

		String minWindow = null;
		int left = 0;
		int right = 0;
		while (right < s.length())
		{
			sMemo[string[right++] - 'A']++;
			while (containsPattern(sMemo, pMemo))
			{
				if (minWindow == null || minWindow.length() > right - left)
				{
					minWindow = s.substring(left, right);
				}
				sMemo[string[left++] - 'A']--;
			}
		}


		return minWindow == null ? "" : minWindow;
	}

	private int[] buildTable(String word)
	{
		int[] table = new int['z' - 'A' + 1];
		for (char ch : word.toCharArray())
		{
			table[ch - 'A']++;
		}

		return table;
	}

	private boolean containsPattern(int[] sMemo, int[] pMemo)
	{
		for (int i = 0; i < sMemo.length; i++)
		{
			if (pMemo[i] > sMemo[i])
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumWindowSubstring().minWindow("ab", "a"));
		System.out.println(new MinimumWindowSubstring().minWindow("a", "a"));
		System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
	}
}
