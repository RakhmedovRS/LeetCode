package tasks;

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

	public static void main(String[] args)
	{
		FormArrayByConcatenatingSubarraysOfAnotherArray clazz = new FormArrayByConcatenatingSubarraysOfAnotherArray();
		System.out.println(clazz.canChoose(new int[][]
				{
					{1, -1, -1},
					{3, -2, 0}
				},
			new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0}));

		System.out.println(clazz.canChoose(new int[][]
				{
					{10, -2},
					{1, 2, 3, 4}
				},
			new int[]{1, 2, 3, 4, 10, -2}));

		System.out.println(clazz.canChoose(new int[][]
				{
					{1, 2, 3},
					{3, 4}
				},
			new int[]{7, 7, 1, 2, 3, 4, 7, 7}));
	}
}
