import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(id = 967, name = "Numbers With Same Consecutive Differences", url = "https://leetcode.com/problems/numbers-with-same-consecutive-differences/")
public class NumbersWithSameConsecutiveDifferences
{
	public int[] numsSameConsecDiff(int N, int K)
	{
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 10; i++)
		{
			backtrack(N - 1, K, set, i);
		}

		int i = 0;
		int[] answer = new int[set.size()];
		for (int val : set)
		{
			answer[i++] = val;
		}
		return answer;
	}

	private void backtrack(int N, int K, Set<Integer> set, int number)
	{
		if (N == 0)
		{
			set.add(number);
			return;
		}

		if (number == number * 10)
		{
			return;
		}

		int prevDigit = number % 10;
		if (prevDigit + K < 10)
		{
			backtrack(N - 1, K, set, number * 10 + (prevDigit + K));
		}

		if (prevDigit - K >= 0)
		{
			backtrack(N - 1, K, set, number * 10 + (prevDigit - K));
		}
	}
}
