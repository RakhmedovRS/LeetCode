import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 09-Apr-20
 */
@LeetCode(id = 844, name = "Backspace String Compare", url = "https://leetcode.com/problems/backspace-string-compare/")
public class BackspaceStringCompare
{
	public boolean backspaceCompare(String first, String second)
	{
		if (first == null && second == null)
		{
			return true;
		}
		else if (first == null || second == null)
		{
			return false;
		}

		LinkedList<Character> firstChars = new LinkedList<>();
		LinkedList<Character> secondChars = new LinkedList<>();

		for (int i = 0; i < first.length(); i++)
		{
			if (first.charAt(i) == '#')
			{
				if (!firstChars.isEmpty())
				{
					firstChars.removeLast();
				}
			}
			else
			{
				firstChars.addLast(first.charAt(i));
			}
		}

		for (int i = 0; i < second.length(); i++)
		{
			if (second.charAt(i) == '#')
			{
				if (!secondChars.isEmpty())
				{
					secondChars.removeLast();
				}
			}
			else
			{
				secondChars.addLast(second.charAt(i));
			}
		}

		if (firstChars.size() != secondChars.size())
		{
			return false;
		}

		while (!firstChars.isEmpty())
		{
			if (firstChars.removeLast() != secondChars.removeLast())
			{
				return false;
			}
		}

		return true;
	}
}
