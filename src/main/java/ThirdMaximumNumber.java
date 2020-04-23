import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Apr-20
 */
@LeetCode(id = 414, name = "Third Maximum Number", url = "https://leetcode.com/problems/third-maximum-number/")
public class ThirdMaximumNumber
{
	public int thirdMax(int[] nums)
	{
		Integer[] max = new Integer[3];
		for (int i = 0; i < nums.length; i++)
		{
			if (max[0] == null || nums[i] > max[0])
			{
				max[2] = max[1];
				max[1] = max[0];
				max[0] = nums[i];
			}
			else if (nums[i] != max[0] && (max[1] == null || nums[i] > max[1]))
			{
				max[2] = max[1];
				max[1] = nums[i];
			}
			else if (max[1] != null
				&& nums[i] != max[0]
				&& nums[i] != max[1]
				&& (max[2] == null || nums[i] > max[2]))
			{
				max[2] = nums[i];
			}
		}

		return max[2] == null ? max[0] : max[2];
	}
}
