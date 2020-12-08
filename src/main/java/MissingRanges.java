import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/4/2020
 */
@LeetCode(
	id = 163,
	name = "Missing Ranges",
	url = "https://leetcode.com/problems/missing-ranges/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class MissingRanges
{
	public List<String> findMissingRanges(int[] nums, int lower, int upper)
	{
		if (nums.length == 0)
		{
			return Arrays.asList(getRange(lower, upper));
		}

		List<String> answer = new ArrayList<>();
		if (lower < nums[0])
		{
			answer.add(getRange(lower, nums[0] - 1));
		}

		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] - nums[i - 1] != 1)
			{
				answer.add(getRange(nums[i - 1] + 1, nums[i] - 1));
			}
		}

		if (nums[nums.length - 1] < upper)
		{
			answer.add(getRange(nums[nums.length - 1] + 1, upper));
		}

		return answer;
	}

	private String getRange(int lower, int upper)
	{
		return lower == upper ? "" + lower : lower + "->" + upper;
	}
}
