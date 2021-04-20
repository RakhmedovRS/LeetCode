package tasks;

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
		if (n == 1)
		{
			return 1;
		}
		if (n == 2)
		{
			return 2;
		}

		int prevPrev = 1;
		int prev = 2;
		int curr = 0;
		for (int i = 3; i <= n; i++)
		{
			curr = prevPrev + prev;
			prevPrev = prev;
			prev = curr;
		}

		return curr;
	}
}
