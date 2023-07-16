package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/30/2023
 */
@LeetCode(
		id = 2657,
		name = "Find the Prefix Common Array of Two Arrays",
		url = "https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/",
		difficulty = Difficulty.MEDIUM
)
public class FindThePrefixCommonArrayOfTwoArrays
{
	public int[] findThePrefixCommonArray(int[] A, int[] B)
	{
		boolean[] arr1 = new boolean[51];
		boolean[] arr2 = new boolean[51];
		int[] ans = new int[A.length];
		for (int i = 0; i < A.length; i++)
		{
			arr1[A[i]] = true;
			arr2[B[i]] = true;
			ans[i] = common(arr1, arr2);
		}

		return ans;
	}

	private int common(boolean[] arr1, boolean[] arr2)
	{
		int count = 0;
		for (int i = 0; i < arr1.length; i++)
		{
			if (arr1[i] && arr2[i])
			{
				count++;
			}
		}

		return count;
	}
}
