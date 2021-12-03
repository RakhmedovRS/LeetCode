package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Mar-20
 */
@LeetCode(
	id = 152,
	name = "Maximum Product Subarray",
	url = "https://leetcode.com/problems/maximum-product-subarray/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumProductSubarray
{
	public int maxProduct(int[] nums)
	{
		int maxProduct = 0;
		if (nums == null || nums.length == 0)
		{
			return maxProduct;
		}

		int[] negatives = new int[nums.length];
		int[] positives = new int[nums.length];
		int positive;
		int negative;

		positives[0] = nums[0];
		negatives[0] = nums[0];
		maxProduct = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			positive = nums[i] * positives[i - 1];
			negative = nums[i] * negatives[i - 1];

			positives[i] = Math.max(nums[i], Math.max(positive, negative));
			negatives[i] = Math.min(nums[i], Math.min(positive, negative));

			maxProduct = Math.max(maxProduct, positives[i]);
		}

		return maxProduct;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumProductSubarray().maxProduct(new int[]{0, 2}));
	}
}
