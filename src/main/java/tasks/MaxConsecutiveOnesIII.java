package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Sep-20
 */
@LeetCode(id = 1004, name = "Max Consecutive Ones III", url = "https://leetcode.com/problems/max-consecutive-ones-iii/")
public class MaxConsecutiveOnesIII
{
	public int longestOnes(int[] A, int K)
	{
		int max = 0;
		int left = 0;
		for (int right = 0; right < A.length; right++)
		{
			if (A[right] == 0)
			{
				K--;
				while (K < 0)
				{
					if (A[left] == 0)
					{
						K++;
					}
					left++;
				}
			}

			max = Math.max(max, 1 + right - left);
		}

		return max;
	}
}
