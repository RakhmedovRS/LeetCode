import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 21-Apr-20
 */
@LeetCode(id = 977, name = "Squares of a Sorted Array", url = "https://leetcode.com/problems/squares-of-a-sorted-array/")
public class SquaresOfSortedArray
{
	public int[] sortedSquares(int[] A)
	{
		if (A == null || A.length == 0)
		{
			return A;
		}

		int[] answer = new int[A.length];
		int left = 0;
		int right = A.length - 1;
		for (int i = A.length - 1; i >= 0; i--)
		{
			int l = A[left] * A[left];
			int r = A[right] * A[right];
			if (r > l)
			{
				answer[i] = r;
				right--;
			}
			else
			{
				answer[i] = l;
				left++;
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
	}
}
