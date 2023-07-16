package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/25/2020
 */

@LeetCode(
		id = 769,
		name = "Max Chunks To Make Sorted",
		url = "https://leetcode.com/problems/max-chunks-to-make-sorted/",
		difficulty = Difficulty.MEDIUM
)
public class MaxChunksToMakeSorted
{
	public int maxChunksToSorted(int[] arr)
	{
		int chunks = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++)
		{
			max = Math.max(max, arr[i]);
			if (i == max)
			{
				chunks++;
			}
		}

		return chunks;
	}
}
