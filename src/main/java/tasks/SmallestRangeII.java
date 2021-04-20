package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/28/2020
 */
@LeetCode(
	id = 910,
	name = "Smallest Range II",
	url = "https://leetcode.com/problems/smallest-range-ii/",
	difficulty = Difficulty.MEDIUM
)
public class SmallestRangeII
{
	public int smallestRangeII(int[] A, int K)
	{
		Arrays.sort(A);
		int min = A[0];
		int max = A[A.length - 1];
		int minGap = max - min;
		for (int i = 0; i < A.length - 1; i++)
		{
			min = Math.min(A[0] + K, A[i + 1] - K);
			max = Math.max(A[A.length - 1] - K, A[i] + K);

			minGap = Math.min(minGap, max - min);
		}

		return minGap;
	}

	public static void main(String[] args)
	{
		System.out.println(new SmallestRangeII().smallestRangeII(new int[]{0, 0, 10}, 2));
		System.out.println(new SmallestRangeII().smallestRangeII(new int[]{0, 0, 0, 10}, 2));
		System.out.println(new SmallestRangeII().smallestRangeII(new int[]{0, 10}, 2));
		System.out.println(new SmallestRangeII().smallestRangeII(new int[]{2, 7, 2}, 1));
		System.out.println(new SmallestRangeII().smallestRangeII(new int[]{1, 3, 6}, 3));
	}
}
