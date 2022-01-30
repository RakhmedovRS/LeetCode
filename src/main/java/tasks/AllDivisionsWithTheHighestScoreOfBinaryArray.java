package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/30/2022
 */
@LeetCode(
	id = 2155,
	name = "All Divisions With the Highest Score of a Binary Array",
	url = "https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/",
	difficulty = Difficulty.MEDIUM
)
public class AllDivisionsWithTheHighestScoreOfBinaryArray
{
	public List<Integer> maxScoreIndices(int[] nums)
	{
		int[] zeros = new int[nums.length];
		int[] ones = new int[nums.length];
		int score = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == 0)
			{
				score++;
			}

			zeros[i] = score;
		}

		score = 0;
		for (int i = nums.length - 1; i >= 0; i--)
		{
			if (nums[i] == 1)
			{
				score++;
			}

			ones[i] = score;
		}

		int max = 0;

		int z;
		int o;
		for (int i = 0; i <= nums.length; i++)
		{
			z = (i - 1 >= 0 ? zeros[i - 1] : 0);
			o = (i < ones.length ? ones[i] : 0);


			max = Math.max(max, z + o);
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i <= nums.length; i++)
		{
			z = (i - 1 >= 0 ? zeros[i - 1] : 0);
			o = (i < ones.length ? ones[i] : 0);

			if (max == z + o)
			{
				answer.add(i);
			}
		}

		return answer;
	}
}
