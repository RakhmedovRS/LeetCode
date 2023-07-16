package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/16/2020
 */
@LeetCode(
		id = 845,
		name = "Longest Mountain in Array",
		url = "https://leetcode.com/problems/longest-mountain-in-array/",
		difficulty = Difficulty.MEDIUM
)
public class LongestMountainInArray
{
	public int longestMountain(int[] A)
	{
		if (A == null || A.length < 3)
		{
			return 0;
		}

		int length = 0;
		for (int middle = 1; middle < A.length - 1; middle++)
		{
			int left = middle;
			int right = middle;

			if (left - 1 >= 0 && A[left - 1] < A[left])
			{
				left--;
			}

			if (right + 1 < A.length && A[right] > A[right + 1])
			{
				right++;
			}

			if (right != middle)
			{
				while (left - 1 >= 0 && A[left - 1] < A[left])
				{
					left--;
				}
			}

			if (left != middle)
			{
				while (right + 1 < A.length && A[right] > A[right + 1])
				{
					right++;
				}
			}

			if (left != middle && right != middle)
			{
				length = Math.max(length, 1 + right - left);
				middle = right - 1;
			}
		}

		return length;
	}
}
