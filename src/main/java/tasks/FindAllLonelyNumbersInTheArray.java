package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/23/2022
 */
@LeetCode(
		id = 2150,
		name = "Find All Lonely Numbers in the Array",
		url = "https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/",
		difficulty = Difficulty.MEDIUM
)
public class FindAllLonelyNumbersInTheArray
{
	public List<Integer> findLonely(int[] nums)
	{
		int[] memo = new int[1_000_002];
		for (int num : nums)
		{
			memo[num]++;
		}

		List<Integer> answer = new ArrayList<>();
		for (int num : nums)
		{
			if (num != 0)
			{
				if (memo[num] == 1 && memo[num - 1] == 0 && memo[num + 1] == 0)
				{
					answer.add(num);
				}
			}
			else
			{
				if (memo[num] == 1 && memo[num + 1] == 0)
				{
					answer.add(num);
				}
			}
		}

		return answer;
	}
}
