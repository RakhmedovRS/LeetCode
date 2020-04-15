import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Apr-20
 */
@LeetCode(id= 238, name = "Product of Array Except Self", url = "https://leetcode.com/problems/product-of-array-except-self/")
public class ProductOfArrayExceptSelf
{
	public int[] productExceptSelf(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return new int[]{};
		}

		int[] result1 = new int[nums.length];
		result1[0] = 1;
		int[] result2 = new int[nums.length];
		result2[nums.length - 1] = 1;
		for (int i = 1; i < nums.length; i++)
		{
			result1[i] = result1[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--)
		{
			result2[i] = result2[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++)
		{
			result2[i] *= result1[i];
		}

		return result2;
	}
}
