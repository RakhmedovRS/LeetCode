package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 8/1/2021
 */
@LeetCode(
	id = 1952,
	name = "Three Divisors",
	url = "https://leetcode.com/problems/three-divisors/",
	difficulty = Difficulty.EASY
)
public class ThreeDivisors
{
	public boolean isThree(int n)
	{
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++)
		{
			if (n % i == 0 && !set.add(i))
			{
				break;
			}
		}

		return set.size() == 3;
	}
}
