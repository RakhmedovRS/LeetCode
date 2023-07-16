package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

@LeetCode(id = 1567, name = "Maximum Length of Subarray With Positive Product", url = "https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/")
public class MaximumLengthOfSubarrayWithPositiveProduct
{
	public int getMaxLen(int[] nums)
	{
		int max = 0;
		int negatives = 0;
		List<Integer> numbers = new ArrayList<>();
		for (int num : nums)
		{
			if (num == 0)
			{
				max = Math.max(max, getMaxLen(numbers, negatives));
				numbers.clear();
				negatives = 0;
			}
			else
			{
				numbers.add(num);
				negatives += num < 0 ? 1 : 0;
			}
		}
		max = Math.max(max, getMaxLen(numbers, negatives));

		return max;
	}

	private int getMaxLen(List<Integer> numbers, int negatives)
	{
		if (numbers.isEmpty())
		{
			return 0;
		}

		if (negatives % 2 == 0)
		{
			return numbers.size();
		}
		else
		{
			int left = 0;
			int right = numbers.size() - 1;
			while (left < numbers.size() && numbers.get(left) > 0)
			{
				left++;
			}

			while (right >= 0 && numbers.get(right) > 0)
			{
				right--;
			}

			return Math.max(right, numbers.size() - left - 1);
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2})); //8
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{-16, 0, -5, 2, 2, -13, 11, 8})); //6
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1})); //6
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{1, 1, 1, 1, 1, 1})); //6
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{1, -2, -3, 4})); //4
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{0, 1, -2, -3, -4})); //3
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{-1, -2, -3, 0, 1})); //2
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{-1, 2})); //1
		System.out.println(new MaximumLengthOfSubarrayWithPositiveProduct().getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10})); //4
	}
}
