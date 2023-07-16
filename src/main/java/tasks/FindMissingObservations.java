package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/3/2021
 */
@LeetCode(
		id = 2028,
		name = "Find Missing Observations",
		url = "https://leetcode.com/problems/find-missing-observations/",
		difficulty = Difficulty.MEDIUM
)
public class FindMissingObservations
{
	public int[] missingRolls(int[] rolls, int mean, int n)
	{
		int[] answer = new int[n];
		int sum = 0;
		for (int roll : rolls)
		{
			sum += roll;
		}

		int target = (n + rolls.length) * mean - sum;
		if (target > n * 6 || target < n)
		{
			return new int[0];
		}

		int a = target / n;
		int b = target % n;
		Arrays.fill(answer, a);

		for (int i = 0; i < n && b > 0; i++, b--)
		{
			answer[i]++;
		}

		return answer;
	}
}
