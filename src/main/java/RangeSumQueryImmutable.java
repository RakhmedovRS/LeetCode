import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-May-20
 */
@LeetCode(id = 303, name = "Range Sum Query - Immutable", url = "https://leetcode.com/problems/range-sum-query-immutable/")
public class RangeSumQueryImmutable
{
	class NumArray
	{
		int[] sum;

		public NumArray(int[] nums)
		{
			sum = new int[nums.length + 1];
			for (int i = 0; i < nums.length; i++)
			{
				sum[i + 1] = sum[i] + nums[i];
			}
		}

		public int sumRange(int i, int j)
		{
			return sum[j + 1] - sum[i];
		}
	}
}
