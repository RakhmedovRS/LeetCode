package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
@LeetCode(
	id = 448,
	name = "Find All Numbers Disappeared in an Array",
	url = "https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/",
	difficulty = Difficulty.EASY
)
public class FindAllNumbersDisappearedInArray
{
	public List<Integer> findDisappearedNumbers(int[] nums)
	{
		int pos = 0;
		while (pos < nums.length)
		{
			if (nums[pos] == pos + 1 || nums[nums[pos] - 1] == nums[pos])
			{
				pos++;
			}
			else
			{
				int temp1 = nums[pos];
				int temp2 = nums[nums[pos] - 1];
				nums[nums[pos] - 1] = temp1;
				nums[pos] = temp2;
			}
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != i + 1)
			{
				answer.add(i + 1);
			}
		}

		return answer;
	}
}
