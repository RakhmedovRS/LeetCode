package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/22/2021
 */
@LeetCode(
		id = 1980,
		name = "Find Unique Binary String",
		url = "https://leetcode.com/problems/find-unique-binary-string/",
		difficulty = Difficulty.MEDIUM
)
public class FindUniqueBinaryString
{
	public String findDifferentBinaryString(String[] nums)
	{
		boolean[] used = new boolean[(int) Math.pow(2, 16) + 2];
		for (String num : nums)
		{
			used[Integer.parseInt(num, 2)] = true;
		}

		for (int i = 0; i < used.length; i++)
		{
			if (!used[i])
			{
				StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
				sb.reverse();
				while (sb.length() < nums[0].length())
				{
					sb.append("0");
				}

				return sb.reverse().toString();
			}
		}
		return "";
	}
}
