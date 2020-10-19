import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/19/2020
 */
@LeetCode(id = 1437, name = "Check If All 1's Are at Least Length K Places Away", url = "https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/")
public class CheckIfAll1sAreAtLeastLengthKPlacesAway
{
	public boolean kLengthApart(int[] nums, int k)
	{
		int gap = nums[0] == 1 ? Integer.MAX_VALUE : 0;
		for (int num : nums)
		{
			if (num == 1)
			{
				if (k > gap)
				{
					return false;
				}

				gap = 0;
			}
			else
			{
				gap++;
			}
		}

		return true;
	}
}
