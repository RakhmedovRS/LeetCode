import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 2/9/2021
 */
@LeetCode(
	id = 360,
	name = "Sort Transformed Array",
	url = "https://leetcode.com/problems/sort-transformed-array/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class SortTransformedArray
{
	public int[] sortTransformedArray(int[] nums, int a, int b, int c)
	{
		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			answer[i] = calc(nums[i], a, b, c);
		}

		Arrays.sort(answer);

		return answer;
	}

	private int calc(int x, int a, int b, int c)
	{
		return a * (x * x) + b * x + c;
	}

	public static void main(String[] args)
	{
		SortTransformedArray clazz = new SortTransformedArray();
		System.out.println(Arrays.toString(clazz.sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5)));
	}
}
