package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(
	id = 442,
	name = "Find All Duplicates in an Array",
	url = "https://leetcode.com/problems/find-all-duplicates-in-an-array/",
	difficulty = Difficulty.MEDIUM
)
public class FindAllDuplicatesInArray
{
	public List<Integer> findDuplicates(int[] nums)
	{
		int[] memo = new int[100_001];
		for (int num : nums)
		{
			memo[num]++;
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < memo.length; i++)
		{
			if (memo[i] == 2)
			{
				answer.add(i);
			}
		}

		return answer;
	}
}
