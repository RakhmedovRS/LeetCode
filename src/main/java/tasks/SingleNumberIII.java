package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jun-20
 */
@LeetCode(id = 260, name = "Single Number III", url = "https://leetcode.com/problems/single-number-iii/")
public class SingleNumberIII
{
	public int[] singleNumber(int[] nums)
	{
		int diff = 0;
		for (int num : nums)
		{
			diff ^= num;
		}

		diff &= -diff;
		int[] answer = new int[]{0, 0};
		for (int num : nums)
		{
			if ((diff & num) == 0)
			{
				answer[0] ^= num;
			}
			else
			{
				answer[1] ^= num;
			}
		}

		return answer;
	}
}
