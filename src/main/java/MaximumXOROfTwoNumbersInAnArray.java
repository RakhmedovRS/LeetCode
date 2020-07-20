import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jul-20
 */
@LeetCode(id = 421, name = "Maximum XOR of Two Numbers in an Array", url = "https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/")
public class MaximumXOROfTwoNumbersInAnArray
{
	public int findMaximumXOR(int[] nums)
	{
		int max = 0;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				max = Math.max(max, nums[i] ^ nums[j]);
			}
		}

		return max;
	}
}
