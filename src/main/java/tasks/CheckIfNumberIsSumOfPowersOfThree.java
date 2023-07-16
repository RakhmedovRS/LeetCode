package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 3/6/2021
 */
@LeetCode(
		id = 1780,
		name = "Check if Number is a Sum of Powers of Three",
		url = "https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfNumberIsSumOfPowersOfThree
{
	public boolean checkPowersOfThree(int n)
	{
		List<Integer> powers = new ArrayList<>();
		for (int i = 0; Math.pow(3, i) < 10_000_000; i++)
		{
			powers.add((int) Math.pow(3, i));
		}

		return dfs(n, new HashSet<>(), powers, new HashMap<>());
	}

	private boolean dfs(int n, Set<Integer> used, List<Integer> powers, Map<Integer, Boolean> memo)
	{
		if (n < 0)
		{
			return false;
		}

		if (n == 0)
		{
			return true;
		}

		if (memo.containsKey(n))
		{
			return memo.get(n);
		}

		boolean result = false;
		for (Integer power : powers)
		{
			if (power > n)
			{
				break;
			}

			if (!used.contains(power))
			{
				used.add(power);
				if (dfs(n - power, used, powers, memo))
				{
					result = true;
					break;
				}
				used.remove(power);
			}
		}

		memo.put(n, result);

		return result;
	}

	public static void main(String[] args)
	{
		CheckIfNumberIsSumOfPowersOfThree clazz = new CheckIfNumberIsSumOfPowersOfThree();
		System.out.println(clazz.checkPowersOfThree(29781));
		System.out.println(clazz.checkPowersOfThree(1));
		System.out.println(clazz.checkPowersOfThree(12));
		System.out.println(clazz.checkPowersOfThree(91));
		System.out.println(clazz.checkPowersOfThree(21));
	}
}
