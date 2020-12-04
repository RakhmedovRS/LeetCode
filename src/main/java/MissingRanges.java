import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
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
		List<String> ranges = new ArrayList<>();
		if (nums.length == 0)
		{
			ranges.add(getRange(lower, upper));
		}
		else
		{
			if (nums[0] > lower)
			{
				ranges.add(getRange(lower, nums[0] - 1));
			}

			for (int i = 1; i < nums.length; i++)
			{
				if (nums[i - 1] + 1 != nums[i])
				{
					ranges.add(getRange(nums[i - 1] + 1, nums[i] - 1));
				}
			}

			if (nums[nums.length - 1] < upper)
			{
				ranges.add(getRange(nums[nums.length - 1] + 1, upper));
			}
		}

		return ranges;
	}

	private String getRange(int lower, int upper)
	{
		if (lower == upper)
		{
			return String.valueOf(lower);
		}
		else
		{
			return lower + "->" + upper;
		}
	}
}
