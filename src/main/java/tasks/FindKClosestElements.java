package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 5/19/2021
 */
@LeetCode(
	id = 658,
	name = "Find K Closest Elements",
	url = "https://leetcode.com/problems/find-k-closest-elements/",
	difficulty = Difficulty.MEDIUM
)
public class FindKClosestElements
{
	public List<Integer> findClosestElements(int[] arr, int k, int x)
	{
		List<Integer> answer = new ArrayList<>();
		if (x <= arr[0])
		{
			for (int i = 0; i < k; i++)
			{
				answer.add(arr[i]);
			}
		}
		else if (x >= arr[arr.length - 1])
		{
			for (int i = arr.length - k; i < arr.length; i++)
			{
				answer.add(arr[i]);
			}
		}
		else
		{
			int pos = findPos(arr, x);
			int left = pos;
			int right = pos + 1;
			for (int i = 0; i < k; i++)
			{
				if (left >= 0 && right < arr.length)
				{
					if (x - arr[left] <= arr[right] - x)
					{
						answer.add(arr[left--]);
					}
					else
					{
						answer.add(arr[right++]);
					}
				}
				else if (left >= 0)
				{
					answer.add(arr[left--]);
				}
				else
				{
					answer.add(arr[right++]);
				}
			}

			answer.sort(null);
		}

		return answer;
	}

	private int findPos(int[] arr, int val)
	{
		int pos = -1;
		int left = 0;
		int middle;
		int right = arr.length - 1;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (arr[middle] <= val)
			{
				left = middle + 1;
				pos = middle;
			}
			else
			{
				right = middle - 1;
			}
		}

		return pos;
	}

	public static void main(String[] args)
	{
		FindKClosestElements clazz = new FindKClosestElements();
		System.out.println(clazz.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
		System.out.println(clazz.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
		System.out.println(clazz.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 5));
	}
}
