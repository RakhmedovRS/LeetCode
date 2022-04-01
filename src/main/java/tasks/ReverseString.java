package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Mar-20
 */
@LeetCode(
	id = 344,
	name = "Reverse String",
	url = "https://leetcode.com/problems/reverse-string/",
	difficulty = Difficulty.EASY
)
public class ReverseString
{
	public void reverseString(char[] s)
	{
		int left = 0;
		int right = s.length - 1;
		while (left < right)
		{
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}
}
