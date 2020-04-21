import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Apr-20
 */
@LeetCode(id = 905, name = "Sort Array By Parity", url = "https://leetcode.com/problems/sort-array-by-parity/")
public class SortArrayByParity
{
	public int[] sortArrayByParity(int[] A)
	{
		int left = 0;
		int right = A.length - 1;
		while (left < right)
		{
			if (A[left] % 2 != 0 && A[right] % 2 == 0)
			{
				int temp = A[right];
				A[right] = A[left];
				A[left] = temp;

				left++;
				right--;
			}
			else if (A[left] % 2 == 0 && A[right] % 2 == 0)
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		return A;
	}
}
