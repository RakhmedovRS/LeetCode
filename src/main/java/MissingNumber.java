import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(id = 268, name = "Missing Number", url = "https://leetcode.com/problems/missing-number/")
public class MissingNumber
{
	public int missingNumber(int[] nums)
	{
		Set<Integer> memo = new HashSet<>();
		for (int value: nums)
		{
			memo.add(value);
		}

		for (int i = 1; i <= nums.length; i++)
		{
			if (!memo.contains(i))
			{
				return i;
			}
		}

		return 0;
	}
}
