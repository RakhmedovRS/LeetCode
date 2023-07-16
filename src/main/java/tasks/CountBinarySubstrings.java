package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Jul-20
 */
@LeetCode(
		id = 696,
		name = "Count Binary Substrings",
		url = "https://leetcode.com/problems/count-binary-substrings/",
		difficulty = Difficulty.EASY
)
public class CountBinarySubstrings
{
	public int countBinarySubstrings(String s)
	{
		int count = 0;

		char[] chars = s.toCharArray();
		for (int left = 0, right = 1; right < s.length(); left++, right++)
		{
			if (chars[left] != chars[right])
			{
				count++;
				for (int shift = 1; left - shift >= 0 && right + shift < s.length() && chars[left] == chars[left - shift] && chars[right] == chars[right + shift]; shift++)
				{
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args)
	{
		CountBinarySubstrings clazz = new CountBinarySubstrings();
		System.out.println(clazz.countBinarySubstrings("00110"));
		System.out.println(clazz.countBinarySubstrings("10101"));
	}
}
