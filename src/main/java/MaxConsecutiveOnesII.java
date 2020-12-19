import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/19/2020
 */
@LeetCode(
	id = 487,
	name = "Max Consecutive Ones II",
	url = "https://leetcode.com/problems/max-consecutive-ones-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class MaxConsecutiveOnesII
{
	public int findMaxConsecutiveOnes(int[] nums)
	{
		int max = 1;
		List<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == 1)
			{
				count++;
				max = Math.max(max, i == nums.length - 1 ? count : count + 1);
			}
			else
			{
				list.add(count);
				count = 0;
			}
		}

		if (count != 0)
		{
			list.add(count);
		}

		for (int i = 1; i < list.size(); i++)
		{
			max = Math.max(max, 1 + list.get(i - 1) + list.get(i));
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{1, 1}));
		System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{1, 0}));
		System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{0}));
		System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{1}));
		System.out.println(new MaxConsecutiveOnesII().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
	}
}
