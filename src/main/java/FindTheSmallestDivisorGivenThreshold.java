import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/30/2020
 */
@LeetCode(id = 1283, name = "Find the Smallest Divisor Given a Threshold", url = "")
public class FindTheSmallestDivisorGivenThreshold
{
	public int smallestDivisor(int[] nums, int threshold)
	{
		int divisor = 0;
		int smallest = 1;
		int highest = Integer.MAX_VALUE;
		int middle;
		int sum;

		while (smallest <= highest)
		{
			middle = smallest + (highest - smallest) / 2;
			sum = calSum(nums, middle);
			if (sum > threshold)
			{
				smallest = middle + 1;
			}
			else
			{
				highest = middle - 1;
				divisor = middle;
			}
		}

		return divisor;
	}

	private int calSum(int[] nums, int divisor)
	{
		int sum = 0;
		for (int num : nums)
		{
			if (num % divisor == 0)
			{
				sum += num / divisor;
			}
			else
			{
				sum += num / divisor + 1;
			}
		}

		return sum;
	}
}
