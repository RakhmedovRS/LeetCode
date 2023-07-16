package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 7/24/2021
 */
@LeetCode(
		id = 1943,
		name = "Describe the Painting",
		url = "https://leetcode.com/problems/describe-the-painting/",
		difficulty = Difficulty.MEDIUM
)
public class DescribeThePainting
{
	public List<List<Long>> splitPainting(int[][] segments)
	{
		List<Integer>[] memo = new ArrayList[100_001];
		for (int i = 0; i < memo.length; i++)
		{
			memo[i] = new ArrayList<>();
		}

		for (int[] segment : segments)
		{
			memo[segment[0]].add(segment[2]);
			memo[segment[1]].add(-segment[2]);
		}

		List<List<Long>> answer = new ArrayList<>();
		long sum = 0;
		Integer prev = null;
		for (int i = 0; i < memo.length; i++)
		{
			if (memo[i].isEmpty())
			{
				continue;
			}
			else
			{
				if (prev != null && sum != 0)
				{
					answer.add(Arrays.asList(Long.valueOf(prev), (long) i, sum));
				}

				for (Integer add : memo[i])
				{
					sum += add;
				}

				prev = i;
			}
		}

		return answer;
	}
}
