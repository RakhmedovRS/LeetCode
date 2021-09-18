package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 9/18/2021
 */
@LeetCode(
	id = 2007,
	name = "Find Original Array From Doubled Array",
	url = "https://leetcode.com/problems/find-original-array-from-doubled-array/",
	difficulty = Difficulty.MEDIUM
)
public class FindOriginalArrayFromDoubledArray
{
	public int[] findOriginalArray(int[] changed)
	{
		if (changed.length % 2 != 0)
		{
			return new int[0];
		}

		int i = 0;
		int[] answer = new int[changed.length / 2];
		int[] memo = new int[200_002];
		for (int num : changed)
		{
			memo[num]++;
		}

		Arrays.sort(changed);

		for (int num : changed)
		{
			if (memo[num * 2] == 0)
			{
				continue;
			}
			else if (memo[num] != 0)
			{
				if (num == 0 && memo[num] < 2)
				{
					break;
				}

				answer[i++] = num;
				memo[num]--;
				memo[num * 2]--;
			}
		}

		return i == answer.length ? answer : new int[0];
	}
}
