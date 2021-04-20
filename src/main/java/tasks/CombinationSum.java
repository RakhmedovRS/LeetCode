package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10/2/2020
 */
@LeetCode(id = 39, name = "Combination Sum", url = "https://leetcode.com/problems/combination-sum/")
public class CombinationSum
{
	public List<List<Integer>> combinationSum(int[] candidates, int target)
	{
		List<List<Integer>> answer = new ArrayList<>();
		dfs(candidates, 0, 0, target, new ArrayList<>(), answer);
		return answer;
	}

	private void dfs(int[] candidates, int pos, int currentSum, int targetSum, ArrayList<Integer> candidate, List<List<Integer>> answer)
	{
		if (pos == candidates.length || currentSum >= targetSum)
		{
			if (currentSum == targetSum)
			{
				answer.add(new ArrayList<>(candidate));
			}

			return;
		}

		for (int i = pos; i < candidates.length; i++)
		{
			candidate.add(candidates[i]);
			dfs(candidates, i, currentSum + candidates[i], targetSum, candidate, answer);
			candidate.remove(candidate.size() - 1);
		}
	}
}
