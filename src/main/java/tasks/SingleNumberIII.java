package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(
	id = 260,
	name = "Single Number III",
	url = "https://leetcode.com/problems/single-number-iii/",
	difficulty = Difficulty.MEDIUM
)
public class SingleNumberIII
{
	public int[] singleNumber(int[] nums)
	{
		Set<Integer> set = new HashSet<>();
		for (int num : nums)
		{
			if (set.contains(num))
			{
				set.remove(num);
			}
			else
			{
				set.add(num);
			}
		}

		int i = 0;
		int[] answer = new int[set.size()];
		for (int num : set)
		{
			answer[i++] = num;
		}

		return answer;
	}
}
