import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Mar-20
 */
@LeetCode(id = 16, name = "3Sum Closest", url = "https://leetcode.com/problems/3sum-closest/")
public class ThreeSumClosest
{
	public int threeSumClosest(int[] nums, int target)
	{
		if (nums.length == 0)
		{
			return 0;
		}

		int diff = Integer.MAX_VALUE;
		int closest = 0;
		int sumOfThree;
		for (int first = 0; first < nums.length - 2; first++)
		{
			for (int second = first + 1; second < nums.length - 1; second++)
			{
				for (int third = second + 1; third < nums.length; third++)
				{
					sumOfThree = nums[first] + nums[second] + nums[third];
					if (sumOfThree == target)
					{
						return target;
					}

					int currentDiff = Math.abs(sumOfThree - target);
					if (currentDiff < diff)
					{
						diff = currentDiff;
						closest = sumOfThree;
					}
				}
			}
		}

		return closest;
	}
}
