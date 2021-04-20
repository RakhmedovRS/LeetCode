package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 01-Jul-20
 */
@LeetCode(id = 343, name = "Integer Break", url = "https://leetcode.com/problems/integer-break/")
public class IntegerBreak
{
	public int integerBreak(int n)
	{
		Map<Integer, Integer> numToMultiplication = new HashMap<>();
		numToMultiplication.put(2, 1);
		numToMultiplication.put(3, 2);
		numToMultiplication.put(4, 4);

		return findMax(n, numToMultiplication);
	}

	private int findMax(int n, Map<Integer, Integer> numToMultiplication)
	{
		if (numToMultiplication.containsKey(n))
		{
			return numToMultiplication.get(n);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n / 2; i++)
		{
			int left = Math.max(i, findMax(i, numToMultiplication));
			int right = Math.max(n - i, findMax(n - i, numToMultiplication));
			max = Math.max(max, left * right);
		}

		numToMultiplication.put(n, max);

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new IntegerBreak().integerBreak(10));
		System.out.println(new IntegerBreak().integerBreak(2));
	}
}
