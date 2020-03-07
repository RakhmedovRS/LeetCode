/**
 * Maximum Product Subarray
 * LeetCode 152
 *
 * @author RakhmedovRS
 * @created 07-Mar-20
 */
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

	public static void main(String[] args)
	{
		System.out.println(new MaximumProductSubarray().maxProduct(new int[]{0, 2}));
	}
}
