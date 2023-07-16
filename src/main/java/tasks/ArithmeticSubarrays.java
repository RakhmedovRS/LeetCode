package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10/25/2020
 */
@LeetCode(
		id = 1630,
		name = "Arithmetic Subarrays",
		url = "https://leetcode.com/problems/arithmetic-subarrays/",
		difficulty = Difficulty.MEDIUM
)
public class ArithmeticSubarrays
{
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r)
	{
		List<Boolean> answer = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < l.length; i++)
		{
			list.clear();
			for (int a = l[i]; a <= r[i]; a++)
			{
				list.add(nums[a]);
			}
			answer.add(canBeRearranged(list));
		}

		return answer;
	}

	private boolean canBeRearranged(List<Integer> list)
	{
		list.sort(null);
		int diff = list.get(1) - list.get(0);
		for (int i = 1; i < list.size(); i++)
		{
			if (list.get(i) - list.get(i - 1) != diff)
			{
				return false;
			}
		}

		return true;
	}
}
