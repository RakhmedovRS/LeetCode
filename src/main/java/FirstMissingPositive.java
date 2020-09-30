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
		int pos;
		int temp;
		for (int i = 0; i < nums.length; i++)
		{
			while (nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= nums.length)
			{
				pos = nums[i] - 1;
				if (nums[pos] == pos + 1)
				{
					break;
				}

				temp = nums[i];
				nums[i] = nums[pos];
				nums[pos] = temp;
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
