package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/9/2020
 */
@LeetCode(id = 795, name = "Number of Subarrays with Bounded Maximum", url = "https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/")
public class NumberOfSubarraysWithBoundedMaximum
{
	public int numSubarrayBoundedMax(int[] A, int L, int R)
	{
		int result = 0;
		int count = 0;
		int j = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (L <= A[i] && A[i] <= R)
			{
				result += i - j + 1;
				count = i - j + 1;
			}
			else if (A[i] < L)
			{
				result += count;
			}
			else
			{
				j = i + 1;
				count = 0;
			}
		}

		return result;
	}
}
