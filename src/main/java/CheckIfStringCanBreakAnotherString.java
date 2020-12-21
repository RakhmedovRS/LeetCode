import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12/21/2020
 */
@LeetCode(
	id = 1433,
	name = "Check If a String Can Break Another String",
	url = "https://leetcode.com/problems/check-if-a-string-can-break-another-string/",
	difficulty = Difficulty.MEDIUM
)
public class CheckIfStringCanBreakAnotherString
{
	public boolean checkIfCanBreak(String s1, String s2)
	{
		int[] table1 = new int[26];
		int[] table2 = new int[26];

		fillTable(s1, table1);
		fillTable(s2, table2);

		return canBeat(Arrays.copyOf(table1, 26), Arrays.copyOf(table2, 26)) || canBeat(table2, table1);
	}

	private boolean canBeat(int[] table1, int[] table2)
	{
		int t1 = 25;
		int t2 = 25;
		int min;
		while (t1 >= 0 && t2 >= 0)
		{
			while (t1 >= 0 && table1[t1] == 0)
			{
				t1--;
			}

			while (t2 >= 0 && table2[t2] == 0)
			{
				t2--;
			}

			if (t1 < t2)
			{
				return false;
			}

			if (t1 < 0 || t2 < 0)
			{
				break;
			}

			min = Math.min(table1[t1], table2[t2]);
			table1[t1] -= min;
			table2[t2] -= min;
		}

		return t1 == t2;
	}

	private void fillTable(String s, int[] table)
	{
		for (char ch : s.toCharArray())
		{
			table[ch - 'a']++;
		}
	}
}
