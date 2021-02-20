import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/20/2021
 */
@LeetCode(
	id = 1764,
	name = "Form Array by Concatenating Subarrays of Another Array",
	url = "https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/",
	difficulty = Difficulty.MEDIUM
)
public class FormArrayByConcatenatingSubarraysOfAnotherArray
{
	public boolean canChoose(int[][] groups, int[] nums)
	{
		return dfs(0, 0, groups, nums, new boolean[nums.length]);
	}

	private boolean dfs(int pos, int i, int[][] groups, int[] nums, boolean[] used)
	{
		if (pos == groups.length)
		{
			return true;
		}

		outer:
		for (; i < nums.length; i++)
		{
			if (nums[i] == groups[pos][0] && !used[i])
			{
				int j = 0;
				for (int x = i; x < nums.length && j < groups[pos].length; x++, j++)
				{
					if (nums[x] != groups[pos][j] || used[x])
					{
						continue outer;
					}
				}

				if (j == groups[pos].length)
				{
					if (dfs(pos + 1, i + groups[pos].length, groups, nums, used))
					{
						return true;
					}
				}
			}
		}

		return false;
	}
}
