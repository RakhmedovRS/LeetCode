package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/19/2020
 */
@LeetCode(
		id = 1437,
		name = "Check If All 1's Are at Least Length K Places Away",
		url = "https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/",
		difficulty = Difficulty.EASY
)
public class CheckIfAll1sAreAtLeastLengthKPlacesAway
{
	public boolean kLengthApart(int[] nums, int k)
	{
		int count = k;
		for (int num : nums)
		{
			if (num == 0)
			{
				count++;
			}
			else
			{
				if (count < k)
				{
					return false;
				}
				count = 0;
			}
		}

		return true;
	}
}
