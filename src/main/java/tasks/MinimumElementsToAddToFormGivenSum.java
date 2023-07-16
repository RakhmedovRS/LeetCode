package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/7/2021
 */
@LeetCode(
		id = 1785,
		name = "Minimum Elements to Add to Form a Given Sum",
		url = "https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumElementsToAddToFormGivenSum
{
	public int minElements(int[] nums, int limit, int goal)
	{
		int adds = 0;
		long sum = 0;
		for (int num : nums)
		{
			sum += num;
		}

		if ((sum >= 0 && goal >= 0) || (sum < 0 && goal < 0))
		{
			goal = Math.abs(goal);
			sum = Math.abs(sum);

			if ((goal - sum) % limit == 0)
			{
				return (int) ((goal - sum) / limit);
			}
			else
			{
				return 1 + (int) ((goal - sum) / limit);
			}
		}
		else if (sum >= 0 && goal < 0)
		{
			sum = Math.abs(sum);

			if ((sum - goal) % limit == 0)
			{
				return (int) ((sum - goal) / limit);
			}
			else
			{
				return 1 + (int) ((sum - goal) / limit);
			}
		}
		else if (sum < 0 && goal >= 0)
		{
			sum = Math.abs(sum);
			if ((sum + goal) % limit == 0)
			{
				return (int) ((sum + goal) / limit);
			}
			else
			{
				return 1 + (int) ((sum + goal) / limit);
			}
		}

		return adds;
	}

	public static void main(String[] args)
	{
		MinimumElementsToAddToFormGivenSum clazz = new MinimumElementsToAddToFormGivenSum();
		System.out.println(clazz.minElements(new int[]{0, -10, -10, -10, 10, 7, -10, 2}, 10, 109_765_576)); //771843705
		System.out.println(clazz.minElements(new int[]{-1, 0, 1, 1, 1}, 1, 771843707)); //771843705
		System.out.println(clazz.minElements(new int[]{-1, 0, 1, 1, 1}, 1, -771843707)); //771843709
		System.out.println(clazz.minElements(new int[]{-1, 0, 1, 1, 1}, 2, 771843707)); //385921853
		System.out.println(clazz.minElements(new int[]{-1, 0, 1, 1, 1}, 2, -771843707)); //385921855
		System.out.println(clazz.minElements(new int[]{-1, 0, 1, 1, 1}, 3, 771843707)); //257281235
		System.out.println(clazz.minElements(new int[]{-1, 0, 1, 1, 1}, 3, -771843707)); //257281237
		System.out.println(clazz.minElements(new int[]{1, -1, 1}, 3, -4)); //2
		System.out.println(clazz.minElements(new int[]{1, -10, 9, 1}, 100, 0)); //1
		System.out.println(clazz.minElements(new int[]{-5, -6, -7}, 8, -17)); //1
	}
}
