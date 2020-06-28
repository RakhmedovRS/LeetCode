import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-Jun-20
 */
@LeetCode(id = 1262, name = "Greatest Sum Divisible by Three", url = "https://leetcode.com/problems/greatest-sum-divisible-by-three/")
public class GreatestSumDivisibleByThree
{
	public int maxSumDivThree(int[] nums)
	{
		int sum = 0;
		long one = Integer.MAX_VALUE;
		long two = Integer.MAX_VALUE;
		for (int num : nums)
		{
			sum += num;
			if (num % 3 == 1)
			{
				two = Math.min(two, one + num);
				one = Math.min(one, num);
			}
			if (num % 3 == 2)
			{
				one = Math.min(one, two + num);
				two = Math.min(two, num);
			}
		}

		if (sum % 3 == 1)
		{
			return sum - (int)one;
		}
		else if (sum % 3 == 2)
		{
			return sum - (int)two;
		}
		return sum;
	}
}
