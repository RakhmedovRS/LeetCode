package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/4/2021
 */
@LeetCode(
	id = 1409,
	name = "Queries on a Permutation With Key",
	url = "https://leetcode.com/problems/queries-on-a-permutation-with-key/",
	difficulty = Difficulty.MEDIUM
)
public class QueriesOnPermutationWithKey
{
	public int[] processQueries(int[] queries, int m)
	{
		int[] answer = new int[queries.length];
		int[] numbers = new int[m];
		for (int i = 0; i < m; i++)
		{
			numbers[i] = i + 1;
		}

		for (int i = 0; i < queries.length; i++)
		{
			int j = 0;
			for (; j < numbers.length; j++)
			{
				if (numbers[j] == queries[i])
				{
					break;
				}
			}

			int temp = numbers[j];
			answer[i] = j;
			while (j > 0)
			{
				numbers[j] = numbers[j-1];
				j--;
			}

			numbers[0] = temp;
		}

		return answer;
	}
}
