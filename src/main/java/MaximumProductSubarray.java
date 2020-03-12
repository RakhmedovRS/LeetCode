/**
 * @author RakhmedovRS
 * @created 07-Mar-20
 */
@LeetCode(id = 152, name = "Maximum Product Subarray", url = "https://leetcode.com/problems/maximum-product-subarray/")
public class MaximumProductSubarray
{
	public int maxProduct(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int currentMin = nums[0];
		int currentMax = nums[0];
		int finalMax = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			int temp = currentMax;
			currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
			currentMin = Math.min(nums[i], Math.min(temp * nums[i], currentMin * nums[i]));

			if (currentMax > finalMax)
			{
				finalMax = currentMax;
			}
		}

		return finalMax;
	}

	public int maxProduct1(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int[] negative = new int[nums.length];
		int[] positive = new int[nums.length];
		negative[0] = nums[0];
		positive[0] = nums[0];

		int maxProduct = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] == 0)
			{
				negative[0] = 0;
				positive[0] = 0;
			}
			positive[i] = Math.max(nums[i], Math.max(nums[i] * positive[i - 1], nums[i] * negative[i - 1]));
			negative[i] = Math.min(nums[i], Math.min(nums[i] * positive[i - 1], nums[i] * negative[i - 1]));
			maxProduct = Math.max(maxProduct, positive[i]);
		}

		return maxProduct;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumProductSubarray().maxProduct(new int[]{0, 2}));
	}
}
