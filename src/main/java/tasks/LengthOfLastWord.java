package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Sep-20
 */
@LeetCode(id = 58, name = "Length of Last Word", url = "https://leetcode.com/problems/length-of-last-word/")
public class LengthOfLastWord
{
	public int lengthOfLastWord(String s)
	{
		int counter = 0;
		boolean seenLetter = false;
		for (int i = s.length() - 1; i >= 0; i--)
		{
			if (Character.isLetter(s.charAt(i)))
			{
				counter++;
				seenLetter = true;
			}
			else if (seenLetter)
			{
				break;
			}
		}

		return counter;
	}
}
