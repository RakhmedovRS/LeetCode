package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 3/13/2022
 */
@LeetCode(
		id = 2200,
		name = "Find All K-Distant Indices in an Array",
		url = "https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/",
		difficulty = Difficulty.EASY
)
public class FindAllKDistantIndicesInArray
{
	public List<Integer> findKDistantIndices(int[] nums, int key, int k)
	{
		boolean[] memo = new boolean[nums.length];
		List<Integer> answer = new ArrayList<>();
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == key)
			{
				indices.add(i);
			}
		}

		for (int index : indices)
		{
			for (int i = Math.max(0, index - k); i <= Math.min(index + k, nums.length - 1); i++)
			{
				memo[i] = true;
			}
		}

		for (int i = 0; i < memo.length; i++)
		{
			if (memo[i])
			{
				answer.add(i);
			}
		}

		return answer;
	}
}
