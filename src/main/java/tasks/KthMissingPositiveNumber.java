package tasks;

import common.Difficulty;
import common.LeetCode;


/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(
		id = 1539,
		name = "Kth Missing Positive Number",
		url = "https://leetcode.com/problems/kth-missing-positive-number/",
		difficulty = Difficulty.EASY)
public class KthMissingPositiveNumber
{
	public int findKthPositive(int[] arr, int k)
	{
		int diff;
		int prev = 0;
		for (int curr : arr)
		{
			diff = curr - prev;
			if (diff != 1)
			{
				if (diff > k)
				{
					return prev + k;
				}
				else
				{
					k -= diff - 1;
				}
			}

			prev = curr;
		}

		return prev + k;
	}

	public static void main(String[] args)
	{
		KthMissingPositiveNumber clazz = new KthMissingPositiveNumber();
		System.out.println(clazz.findKthPositive(new int[]{8, 17, 23, 34, 37, 42}, 16)); //18
		System.out.println(clazz.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5)); //9
		System.out.println(clazz.findKthPositive(new int[]{1, 2, 3, 4}, 2)); //6
		System.out.println(clazz.findKthPositive(new int[]{2}, 1)); //1
	}
}
