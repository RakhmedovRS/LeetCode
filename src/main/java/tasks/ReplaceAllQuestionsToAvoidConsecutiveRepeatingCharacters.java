package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Sep-20
 */
@LeetCode(id= 1576, name = "Replace All ?'s to Avoid Consecutive Repeating Characters", url = "https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/")
public class ReplaceAllQuestionsToAvoidConsecutiveRepeatingCharacters
{
	public String modifyString(String s)
	{
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == '?')
			{
				int ch = 'a';
				for (; ch <= 'z'; ch++)
				{
					if ((i > 0 && chars[i - 1] == ch) || (i + 1 < chars.length && chars[i + 1] == ch))
					{
						continue;
					}
					else
					{
						break;
					}
				}
				chars[i] = (char) (ch);
			}
		}

		return String.valueOf(chars);
	}
}
