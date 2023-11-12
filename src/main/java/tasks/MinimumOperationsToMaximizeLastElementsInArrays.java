package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 11/11/2023
 */
@LeetCode(
		id = 2934,
		name = "Minimum Operations to Maximize Last Elements in Arrays",
		url = "https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMaximizeLastElementsInArrays
{
	public int minOperations(int[] nums1, int[] nums2)
	{
		int[] num1Maxes = Arrays.copyOf(nums1, nums1.length);
		int[] num2Maxes = Arrays.copyOf(nums2, nums2.length);
		for (int i = 1; i < num1Maxes.length; i++)
		{
			num1Maxes[i] = Math.max(num1Maxes[i - 1], num1Maxes[i]);
			num2Maxes[i] = Math.max(num2Maxes[i - 1], num2Maxes[i]);
		}

		int ops1 = calc(Arrays.copyOf(nums1, nums1.length), Arrays.copyOf(nums2, nums2.length), num1Maxes, num2Maxes, nums1[nums1.length - 1], nums2[nums1.length - 1]);
		int ops2 = calc(Arrays.copyOf(nums1, nums1.length), Arrays.copyOf(nums2, nums2.length), num1Maxes, num2Maxes, nums2[nums1.length - 1], nums1[nums1.length - 1]);
		if (nums1[nums1.length - 1] != nums2[nums1.length - 1] && ops2 != -1)
		{
			ops2++;
		}

		if (ops1 != -1 && ops2 != -1)
		{
			return Math.min(ops1, ops2);
		}
		else if (ops1 != -1)
		{
			return ops1;
		}
		return ops2;
	}

	private int calc(int[] nums1, int[] nums2, int[] num1Maxes, int[] num2Maxes, int num1Max, int num2Max)
	{
		int ops = 0;
		for (int i = nums1.length - 2; i >= 0; i--)
		{
			if ((nums1[i] > num1Max || nums2[i] > num2Max) && nums1[i] != nums2[i])
			{
				int temp = nums1[i];
				nums1[i] = nums2[i];
				nums2[i] = temp;
				ops++;
			}
		}


		return isValid(nums1, num1Max) && isValid(nums2, num2Max) ? ops : -1;
	}

	boolean isValid(int[] nums, int max)
	{
		for (int i = 0; i < nums.length - 1; i++)
		{
			if (nums[i] > max)
			{
				return false;
			}
		}

		return true;
	}
}
