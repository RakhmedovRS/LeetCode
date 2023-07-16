package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Apr-20
 */
@LeetCode(
		id = 905,
		name = "Sort Array By Parity",
		url = "https://leetcode.com/problems/sort-array-by-parity/",
		difficulty = Difficulty.EASY
)
public class SortArrayByParity
{
	public int[] sortArrayByParity(int[] A)
	{
		int right = A.length - 1;
		for (int left = 0; left < right; left++)
		{
			if (A[left] % 2 != 0)
			{
				while (right > left && A[right] % 2 != 0)
				{
					right--;
				}

				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
			}
		}

		return A;
	}
}
