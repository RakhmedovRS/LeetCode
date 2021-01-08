import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/8/2021
 */
@LeetCode(
	id = 31,
	name = "Next Permutation",
	url = "https://leetcode.com/problems/next-permutation/",
	difficulty = Difficulty.MEDIUM
)
public class NextPermutation
{
	public void nextPermutation(int[] nums)
	{
		int n = nums.length;
		for (int i = n - 1; i > 0; i--)
		{
			if (nums[i - 1] < nums[i])
			{
				int id = i;
				for (int j = i; j < n; j++)
				{
					if (nums[j] > nums[i - 1] && nums[j] < nums[id])
					{
						id = j;
					}
				}

				int temp = nums[i - 1];
				nums[i - 1] = nums[id];
				nums[id] = temp;

				Arrays.sort(nums, i, n);

				return;
			}
		}

		Arrays.sort(nums);
	}
}
