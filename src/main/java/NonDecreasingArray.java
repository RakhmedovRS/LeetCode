import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Jul-20
 */
@LeetCode(id = 665, name = "Non-decreasing Array", url = "https://leetcode.com/problems/non-decreasing-array/")
public class NonDecreasingArray
{
	public boolean checkPossibility(int[] nums)
	{
		Integer missIndex = null;
		for (int i = 0; i < nums.length - 1; i++)
		{
			if (nums[i] > nums[i + 1])
			{
				if (missIndex == null)
				{
					missIndex = i;
				}
				else
				{
					return false;
				}
			}
		}

		return missIndex == null || missIndex == 0 || missIndex == nums.length - 2 || nums[missIndex - 1] <= nums[missIndex + 1] || nums[missIndex] <= nums[missIndex + 2];
	}
}
