package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(id = 969, name = "Pancake Sorting", url = "https://leetcode.com/problems/pancake-sorting/")
public class PancakeSorting
{
	public List<Integer> pancakeSort(int[] A)
	{
		List<Integer> result = new ArrayList<>();
		if (A == null || A.length == 0)
		{
			return result;
		}
		int right = A.length - 1;
		while (right > 0)
		{
			if (A[right] != right + 1)
			{
				int left = 0;
				for (; left < right; left++)
				{
					if (A[left] == right + 1)
					{
						break;
					}
				}
				result.add(left + 1);
				flip(A, left);
				result.add(right + 1);
				flip(A, right);
			}
			right--;
		}
		return result;
	}

	private void flip(int[] A, int k)
	{
		int left = 0;
		int right = k;
		while (left < right)
		{
			int tmp = A[left];
			A[left] = A[right];
			A[right] = tmp;
			left++;
			right--;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new PancakeSorting().pancakeSort(new int[]{3, 2, 4, 1}));
		System.out.println(new PancakeSorting().pancakeSort(new int[]{1, 2, 3}));
	}
}
