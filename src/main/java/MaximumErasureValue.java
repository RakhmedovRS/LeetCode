import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/20/2020
 */
@LeetCode(
	id = 1695,
	name = "Maximum Erasure Value",
	url = "https://leetcode.com/problems/maximum-erasure-value/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumErasureValue
{
	public int maximumUniqueSubarray(int[] nums)
	{
		int[] table = new int[10_001];
		int sum = 0;
		int max = 0;
		int left = 0;
		int right = 0;
		while (right < nums.length)
		{
			sum += nums[right];
			table[nums[right]]++;
			if (table[nums[right]] == 1)
			{
				max = Math.max(max, sum);
			}
			else
			{
				while (left < right && table[nums[right]] != 1)
				{
					table[nums[left]]--;
					sum -= nums[left++];
				}
			}

			right++;
		}

		return max;
	}

	public static void main(String[] args)
	{
		MaximumErasureValue clazz = new MaximumErasureValue();

		System.out.println(clazz.maximumUniqueSubarray(new int[]{1, 2, 3, 4, 5}));
		System.out.println(clazz.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
		System.out.println(clazz.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
	}
}
