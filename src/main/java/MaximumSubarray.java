import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Mar-20
 */
@LeetCode(id = 53, name = "Maximum Subarray", url = "https://leetcode.com/problems/maximum-subarray/")
public class MaximumSubarray
{
	public int maxSubArray(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		return maxSubArray(nums, 0, nums.length - 1);
	}

	public int maxSubArray(int[] nums, int left, int right)
	{
		if (left == right)
		{
			return nums[left];
		}

		if (left > right)
		{
			return Integer.MIN_VALUE;
		}

		int center = left + (right - left) / 2;
		int leftMax = maxSubArray(nums, left, center);
		int rightMax = maxSubArray(nums, center + 1, right);
		int centerMax = maxCrossSubArray(nums, left, center, right);

		return Math.max(centerMax, Math.max(leftMax, rightMax));
	}

	private int maxCrossSubArray(int[] nums, int left, int center, int right)
	{
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;

		int sum = 0;
		for (int i = center; i >= left; i--)
		{
			sum += nums[i];
			leftMax = Math.max(leftMax, sum);
		}

		sum = 0;
		for (int i = center + 1; i <= right; i++)
		{
			sum += nums[i];
			rightMax = Math.max(rightMax, sum);
		}

		return leftMax + rightMax;
	}

	public int maxSubArray1(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int currentMax = nums[0];
		int totalMax = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			currentMax = Math.max(currentMax + nums[i], nums[i]);
			totalMax = Math.max(totalMax, currentMax);
		}

		return totalMax;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}
