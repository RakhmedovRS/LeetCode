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
		List<List<Integer>> result = new ArrayList<>();
		if (k == 0 || n == 0)
		{
			return result;
		}

		combinationSum3(result, 1, n, k, new ArrayList<>());
		return result;
	}

	private void combinationSum3(List<List<Integer>> result, int currNumber, int target, int steps, List<Integer> temp)
	{
		if (steps == 0)
		{
			if (target == 0)
			{
				result.add(new ArrayList<>(temp));
			}

			return;
		}

		for (int i = currNumber; i <= 9; i++)
		{
			temp.add(i);
			combinationSum3(result, i + 1, target - i, steps - 1, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
