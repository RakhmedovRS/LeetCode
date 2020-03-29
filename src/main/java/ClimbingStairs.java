import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
@LeetCode(id = 70, name = "Climbing Stairs", url = "https://leetcode.com/problems/climbing-stairs/")
public class ClimbingStairs
{
	public int climbStairs(int n)
	{
		if (n <= 2)
		{
			return n;
		}
		else
		{
			int[] steps = new int[n + 1];
			steps[0] = 1;
			steps[1] = 1;
			for (int i = 2; i < steps.length; i++)
			{
				steps[i] = steps[i - 2] + steps[i - 1];
			}

			return steps[n];
		}
	}
}
