package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 02-Jun-20
 */
@LeetCode(
	id = 1414,
	name = "Find the Minimum Number of Fibonacci Numbers Whose Sum Is K",
	url = "https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/",
	difficulty = Difficulty.MEDIUM
)
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK
{
	public int findMinFibonacciNumbers(int k)
	{
		List<Integer> fib = new ArrayList<>();
		fib.add(1);
		fib.add(1);
		int i = 2;
		while (fib.get(i - 1) + fib.get(i - 2) <= k)
		{
			fib.add(fib.get(i - 1) + fib.get(i - 2));
			i++;
		}

		return findMinFibonacciNumbers(k, fib);
	}

	int findMinFibonacciNumbers(int k, List<Integer> fib)
	{
		if (k == 0)
		{
			return 0;
		}

		int i = 0;
		while (i < fib.size() && fib.get(i) <= k)
		{
			i++;
		}

		return 1 + findMinFibonacciNumbers(k - fib.get(i == 0 ? 0 : i - 1), fib);
	}
}
