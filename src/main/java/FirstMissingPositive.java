import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Apr-20
 */
@LeetCode(id = 41, name = "First Missing Positive", url = "https://leetcode.com/problems/first-missing-positive/")
public class FirstMissingPositive
{
	public int firstMissingPositive(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			int num = nums[i];
			int pos = num - 1;

			if (pos >= 0 && pos < nums.length && nums[pos] != num)
			{
				nums[i] = nums[pos];
				nums[pos] = num;
				i--;
			}
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != i + 1)
			{
				return i + 1;
			}
		}

		return nums.length + 1;
	}
}
