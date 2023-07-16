package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 5/27/2021
 */
@LeetCode(
		id = 1874,
		name = "Minimize Product Sum of Two Arrays",
		url = "https://leetcode.com/problems/minimize-product-sum-of-two-arrays/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MinimizeProductSumOfTwoArrays
{
	public int minProductSum(int[] nums1, int[] nums2)
	{
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int sum = 0;
		for (int i = 0, j = nums2.length - 1; i < nums1.length && j >= 0; i++, j--)
		{
			sum += nums1[i] * nums2[j];
		}

		return sum;
	}
}
