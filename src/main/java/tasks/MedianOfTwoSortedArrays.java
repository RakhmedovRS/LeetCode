package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(id = 4, name = "Median of Two Sorted Arrays", url = "https://leetcode.com/problems/median-of-two-sorted-arrays/")
public class MedianOfTwoSortedArrays
{
	public double findMedianSortedArrays(int[] nums1, int[] nums2)
	{
		if (nums1.length > nums2.length)
		{
			return findMedianSortedArrays(nums2, nums1);
		}

		int low = 0;
		int high = nums1.length;
		int totalLength = nums1.length + nums2.length;
		while (low <= high)
		{
			int partX = low + (high - low) / 2;
			int partY = (totalLength + 1) / 2 - partX;

			int leftX = getMax(nums1, partX);
			int rightX = getMin(nums1, partX);
			int leftY = getMax(nums2, partY);
			int rightY = getMin(nums2, partY);

			if (leftX <= rightY && leftY <= rightX)
			{
				if (totalLength % 2 == 0)
				{
					return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2D;
				}
				else
				{
					return Math.max(leftX, leftY);
				}
			}

			if (leftX > rightY)
			{
				high = partX - 1;
			}
			else
			{
				low = partX + 1;
			}
		}

		return -1;
	}

	private int getMax(int[] nums, int partition)
	{
		if (partition == 0)
		{
			return Integer.MIN_VALUE;
		}
		return nums[partition - 1];
	}

	private int getMin(int[] nums, int partition)
	{
		if (partition == nums.length)
		{
			return Integer.MAX_VALUE;
		}
		return nums[partition];
	}

	public static void main(String[] args)
	{
		System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 4, 5}, new int[]{2, 3}));
	}
}
