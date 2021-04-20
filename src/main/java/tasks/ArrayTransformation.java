package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/3/2021
 */
@LeetCode(
	id = 1243,
	name = "Array Transformation",
	url = "https://leetcode.com/problems/array-transformation/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class ArrayTransformation
{
	public List<Integer> transformArray(int[] arr)
	{
		List<Integer> answer = new ArrayList<>();
		boolean changed = true;
		int add;
		int n = arr.length;
		while (changed)
		{
			changed = false;
			add = 0;
			for (int i = 1; i < n - 1; i++)
			{
				if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1])
				{
					changed = true;
					arr[i - 1] += add;
					add = -1;
				}
				else if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1])
				{
					changed = true;
					arr[i - 1] += add;
					add = 1;
				}
				else
				{
					arr[i - 1] += add;
					add = 0;
				}
			}

			arr[n - 2] += add;
		}

		for (int num : arr)
		{
			answer.add(num);
		}

		return answer;
	}

	public static void main(String[] args)
	{
		ArrayTransformation clazz = new ArrayTransformation();
		System.out.println(clazz.transformArray(new int[]{1, 6, 3, 4, 3, 5}));
		System.out.println(clazz.transformArray(new int[]{2, 1, 2, 1, 1, 2, 2, 1}));
	}
}
