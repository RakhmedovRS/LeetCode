package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11-Aug-20
 */
@LeetCode(
		id = 274,
		name = "H-Index",
		url = "https://leetcode.com/problems/h-index/",
		difficulty = Difficulty.MEDIUM
)
public class HIndex
{
	public int hIndex(int[] citations)
	{
		Arrays.sort(citations);
		int count = 0;
		for (int i = citations.length - 1; i >= 0; i--)
		{
			if (citations[i] > count)
			{
				count++;
			}
			else
			{
				break;
			}
		}

		return count;
	}
}
