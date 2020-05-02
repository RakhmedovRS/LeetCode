import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(id = 167, name = "Two Sum II - Input array is sorted", url = "https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/")
public class TwoSumII
{
	public int[] twoSum(int[] num, int target)
	{
		int[] answer = new int[2];
		if (num == null || num.length < 2)
		{
			return answer;
		}

		int left = 0, right = num.length - 1;
		while (left < right)
		{
			int v = num[left] + num[right];
			if (v == target)
			{
				answer[0] = left + 1;
				answer[1] = right + 1;
				break;
			}
			else if (v > target)
			{
				right--;
			}
			else
			{
				left++;
			}
		}
		return answer;
	}

	public int[] twoSum1(int[] numbers, int target)
	{
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < numbers.length; i++)
		{
			cache.put(numbers[i], i);
		}

		int[] answer = new int[2];
		for (int i = 0; i < numbers.length; i++)
		{
			Integer idx = cache.get(target - numbers[i]);
			if (idx != null)
			{
				answer[0] = i + 1;
				answer[1] = idx + 1;
				break;
			}
		}

		return answer;
	}
}
