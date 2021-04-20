package tasks;

import common.LeetCode;

import java.util.Stack;

/**
 * @author RakhmedovRS
 * @created 10/2/2020
 */
@LeetCode(id = 907, name = "Sum of Subarray Minimums", url = "https://leetcode.com/problems/sum-of-subarray-minimums/")
public class SumOfSubarrayMinimums
{
	public int sumSubarrayMins(int[] numbers)
	{
		long sum = 0;
		Stack<int[]> lStack = new Stack<>();
		Stack<int[]> rStack = new Stack<>();
		int[] left = new int[numbers.length];
		int[] right = new int[numbers.length];
		int count;

		for (int i = 0; i < numbers.length; i++)
		{
			count = 1;
			while (!lStack.isEmpty() && lStack.peek()[0] > numbers[i])
			{
				count += lStack.pop()[1];
			}

			lStack.push(new int[]{numbers[i], count});
			left[i] = count;
		}

		for (int i = numbers.length - 1; i >= 0; i--)
		{
			count = 1;
			while (!rStack.isEmpty() && rStack.peek()[0] >= numbers[i])
			{
				count += rStack.pop()[1];
			}

			rStack.push(new int[]{numbers[i], count});
			right[i] = count;
		}

		for (int i = 0; i < numbers.length; i++)
		{
			sum = (sum + numbers[i] * left[i] * right[i]) % 1_000_000_007;
		}

		return (int) sum;
	}
}
