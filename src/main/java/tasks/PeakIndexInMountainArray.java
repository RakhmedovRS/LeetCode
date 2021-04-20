package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(id = 852, name = "Peak Index in a Mountain Array", url = "https://leetcode.com/problems/peak-index-in-a-mountain-array/")
public class PeakIndexInMountainArray
{
	public int peakIndexInMountainArray(int[] A)
	{
		int target = 1;
		for (;target < A.length - 1; target++)
		{
			if (A[target] > A[target -1] && A[target] < A[target + 1])
			{
				continue;
			}
			else
			{
				break;
			}
		}

		return target;
	}
}
