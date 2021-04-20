package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/26/2020
 */
@LeetCode(
	id = 1016,
	name = "Binary String With Substrings Representing 1 To N",
	url = "https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/",
	difficulty = Difficulty.MEDIUM
)
public class BinaryStringWithSubstringsRepresentingOneToN
{
	public boolean queryString(String S, int N)
	{
		for (int i = 1; i <= N; i++)
		{
			if (!S.contains(Integer.toBinaryString(i)))
			{
				return false;
			}
		}

		return true;
	}
}
