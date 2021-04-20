package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 23-Apr-20
 */
@LeetCode(id = 216, name = "Combination Sum III", url = "https://leetcode.com/problems/combination-sum-iii/")
public class CombinationSumIII
{
	public List<List<Integer>> combinationSum3(int k, int n)
	{
		int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<List<Integer>> answer = new ArrayList<>();
		dfs(numbers, 0, k, n, answer, new ArrayList<>());
		return answer;
	}

	private void dfs(int[] numbers, int pos, int k, int target, List<List<Integer>> answer, List<Integer> current)
	{
		if (pos == numbers.length)
		{
			if (k == 0 && target == 0)
			{
				answer.add(new ArrayList<>(current));
			}
			return;
		}

		if (target < 0)
		{
			return;
		}

		if (k == 0)
		{
			if (target == 0)
			{
				answer.add(new ArrayList<>(current));
			}
			return;
		}

		for (int i = pos; i < numbers.length; i++)
		{
			current.add(numbers[i]);
			dfs(numbers, i + 1, k - 1, target - numbers[i], answer, current);
			current.remove(current.size() - 1);
		}
	}
}
