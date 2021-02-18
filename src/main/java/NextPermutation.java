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
		int max = nums[nums.length - 1];
		for (int i = nums.length - 1; i >= 0; i--)
		{
			if (nums[i] < max)
			{
				int minGreaterCurrentPos = i + 1;
				for (int j = minGreaterCurrentPos; j < nums.length; j++)
				{
					if (nums[j] > nums[i] && nums[j] < nums[minGreaterCurrentPos])
					{
						minGreaterCurrentPos = j;
					}
				}

				int temp = nums[i];
				nums[i] = nums[minGreaterCurrentPos];
				nums[minGreaterCurrentPos] = temp;
				Arrays.sort(nums, i + 1, nums.length);

				return;
			}

			max = Math.max(max, nums[i]);
		}

		Arrays.sort(nums);
	}
}
