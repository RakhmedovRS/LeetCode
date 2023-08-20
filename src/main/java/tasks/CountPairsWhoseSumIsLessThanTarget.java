package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 8/20/2023
 */
@LeetCode(
		id = 2824,
		name = "Count Pairs Whose Sum is Less than Target",
		url = "https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/",
		difficulty = Difficulty.EASY
)
public class CountPairsWhoseSumIsLessThanTarget
{
	public int countPairs(List<Integer> nums, int target)
	{
		nums.sort(null);
		int cnt = 0;
		outer: for (int i = 0; i < nums.size(); i++)
		{
			for (int j = i + 1; j < nums.size(); j++)
			{
				if (nums.get(i) + nums.get(j) >= target)
				{
					continue outer;
				}
				cnt++;
			}
		}
		return cnt;
	}
}
