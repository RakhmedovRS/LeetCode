package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

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
		int left = 0;
		int right = nums.length - 1;
		int x;
		int y;
		IntUnaryOperator function = z -> a * z * z + z * b  + c;
		if (a > 0)
		{
			for (int i = answer.length - 1; i>=0; i--)
			{
				x = function.applyAsInt(nums[left]);
				y = function.applyAsInt(nums[right]);
				if (x >= y)
				{
					answer[i] = x;
					left++;
				}
				else
				{
					answer[i] = y;
					right--;
				}
			}
		}
		else
		{
			for (int i = 0; i < answer.length; i++)
			{
				x = function.applyAsInt(nums[left]);
				y = function.applyAsInt(nums[right]);
				if (x <= y)
				{
					answer[i] = x;
					left++;
				}
				else
				{
					answer[i] = y;
					right--;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		SortTransformedArray clazz = new SortTransformedArray();
		System.out.println(Arrays.toString(clazz.sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5)));
	}
}
