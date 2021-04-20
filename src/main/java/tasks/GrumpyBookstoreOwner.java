package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Aug-20
 */
@LeetCode(id = 1052, name = "Grumpy Bookstore Owner", url = "https://leetcode.com/problems/grumpy-bookstore-owner/")
public class GrumpyBookstoreOwner
{
	public int maxSatisfied(int[] customers, int[] grumpy, int X)
	{
		int[] satisfiedBefore = new int[customers.length];
		int sum = 0;
		for (int i = 0; i < customers.length; i++)
		{
			if (grumpy[i] == 0)
			{
				sum += customers[i];
			}
			satisfiedBefore[i] = sum;
		}

		int max = sum;

		int[] satisfiedAfter = new int[customers.length];
		sum = 0;
		for (int i = customers.length - 1; i >= 0; i--)
		{
			if (grumpy[i] == 0)
			{
				sum += customers[i];
			}
			satisfiedAfter[i] = sum;
		}
		max = Math.max(max, sum);

		int left = 0;
		int right = 0;
		sum = 0;
		while (right < customers.length)
		{
			sum += customers[right];
			if (right - left >= X)
			{
				sum -= customers[left++];
			}

			max = Math.max(max, sum + (left > 0 ? satisfiedBefore[left - 1] : 0) + (right < customers.length - 1 ? satisfiedAfter[right + 1] : 0));
			right++;
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new GrumpyBookstoreOwner().maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2));
		System.out.println(new GrumpyBookstoreOwner().maxSatisfied(new int[]{2, 6, 6, 9}, new int[]{0, 0, 1, 1}, 1));
		System.out.println(new GrumpyBookstoreOwner().maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
	}
}
