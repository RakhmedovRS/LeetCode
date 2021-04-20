package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Jul-20
 */
@LeetCode(id = 1053, name = "Previous Permutation With One Swap", url = "https://leetcode.com/problems/previous-permutation-with-one-swap/")
public class PreviousPermutationWithOneSwap
{
	public int[] prevPermOpt1(int[] A)
	{
		if (A.length < 2)
		{
			return A;
		}

		int idx = -1;
		for (int i = A.length - 1; i >= 1; i--)
		{
			if (A[i - 1] > A[i])
			{
				idx = i - 1;
				break;
			}
		}

		if (idx == -1)
		{
			return A;
		}

		for (int i = A.length - 1; i > idx; i--)
		{
			if (A[i] < A[idx] && A[i] != A[i - 1])
			{
				swap(A, idx, i);
				break;
			}
		}

		return A;
	}

	private void swap(int[] A, int left, int right)
	{
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}
}
