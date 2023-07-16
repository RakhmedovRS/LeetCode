package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/10/2022
 */
@LeetCode(
		id = 2433,
		name = "Find The Original Array of Prefix Xor",
		url = "https://leetcode.com/problems/find-the-original-array-of-prefix-xor/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheOriginalArrayOfPrefixXor
{
	public int[] findArray(int[] pref)
	{
		int[] answer = new int[pref.length];
		answer[0] = pref[0];
		for (int i = 1; i < pref.length; i++)
		{
			answer[i] = pref[i - 1] ^ pref[i];
		}

		return answer;
	}
}
