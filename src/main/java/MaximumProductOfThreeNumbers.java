import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-Feb-20
 */
@LeetCode(id = 628, name = "Maximum Product of Three Numbers", url = "https://leetcode.com/problems/maximum-product-of-three-numbers/")
public class MaximumProductOfThreeNumbers
{
	public int maximumProduct(int[] nums)
	{
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for (int num : nums)
		{

			if (num <= firstMin)
			{
				secondMin = firstMin;
				firstMin = num;
			}
			else if (num <= secondMin)
			{
				secondMin = num;
			}

			if (num >= firstMax)
			{
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = num;
			}
			else if (num >= secondMax)
			{
				thirdMax = secondMax;
				secondMax = num;
			}
			else if (num > thirdMax)
			{
				thirdMax = num;
			}
		}

		return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
	}
}
