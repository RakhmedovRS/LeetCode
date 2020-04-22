import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
@LeetCode(id = 724, name = "Find Pivot Index", url = "https://leetcode.com/problems/find-pivot-index/")
public class FindPivotIndex
{
	public int pivotIndex(int[] nums)
	{
		int[] leftToRight = new int[nums.length];
		int[] rightToLeft = new int[nums.length];
		for (int i = 0; i < leftToRight.length; i++)
		{
			leftToRight[i] += nums[i];
			if (i != 0)
			{
				leftToRight[i] += leftToRight[i - 1];
			}
		}

		for (int i = rightToLeft.length - 1; i >= 0; i--)
		{
			rightToLeft[i] += nums[i];
			if (i != rightToLeft.length - 1)
			{
				rightToLeft[i] += rightToLeft[i + 1];
			}
		}

		for (int i = 0; i < leftToRight.length; i++)
		{
			if (leftToRight[i] == rightToLeft[i])
			{
				return i;
			}
		}

		return -1;
	}
}
