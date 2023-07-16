package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/17/2020
 */
@LeetCode(
		id = 1213,
		name = "Intersection of Three Sorted Arrays",
		url = "https://leetcode.com/problems/intersection-of-three-sorted-arrays/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class IntersectionOfThreeSortedArrays
{
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3)
	{
		List<Integer> answer = new ArrayList<>();
		int[] table = new int[2001];

		for (int num : arr1)
		{
			table[num]++;
		}

		for (int num : arr2)
		{
			table[num]++;
		}

		for (int num : arr3)
		{
			table[num]++;
		}

		for (int i = 0; i < table.length; i++)
		{
			if (table[i] == 3)
			{
				answer.add(i);
			}
		}

		return answer;
	}
}
