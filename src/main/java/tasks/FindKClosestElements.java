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
		List<Integer> list = new ArrayList<>();
		int left = 0;
		int right = arr.length - 1;
		while (1 + right - left > k)
		{
			if (Math.abs(arr[left] - x) >= Math.abs(arr[right] - x))
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		while (left <= right)
		{
			list.add(arr[left++]);
		}

		return list;
	}

	public static void main(String[] args)
	{
		FindKClosestElements clazz = new FindKClosestElements();
		System.out.println(clazz.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
		System.out.println(clazz.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
		System.out.println(clazz.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 5));
	}
}
