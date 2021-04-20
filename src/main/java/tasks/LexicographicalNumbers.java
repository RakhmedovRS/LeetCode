package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/16/2020
 */
@LeetCode(
	id = 386,
	name = "Lexicographical Numbers",
	url = "https://leetcode.com/problems/lexicographical-numbers/",
	difficulty = Difficulty.MEDIUM
)
public class LexicographicalNumbers
{
	public List<Integer> lexicalOrder(int n)
	{
		List<Integer> answer = new ArrayList<>();
		dfs(answer, n, 0);
		return answer;
	}

	private void dfs(List<Integer> answer, int n, int num)
	{
		int next;
		for (int i = 0; i <= 9; i++)
		{
			next = num * 10 + i;
			if (next == 0)
			{
				continue;
			}

			if (next > n)
			{
				return;
			}

			answer.add(next);
			dfs(answer, n, next);
		}
	}
}
