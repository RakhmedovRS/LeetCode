package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 20-Sep-20
 */
@LeetCode(id = 1592, name = "Rearrange Spaces Between Words", url = "https://leetcode.com/problems/rearrange-spaces-between-words/")
public class RearrangeSpacesBetweenWords
{
	public String reorderSpaces(String text)
	{
		List<String> words = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int spaces = 0;
		for (char ch : text.toCharArray())
		{
			if (ch == ' ')
			{
				if (sb.length() != 0)
				{
					words.add(sb.toString());
					sb.setLength(0);
				}

				spaces++;
			}
			else
			{
				sb.append(ch);
			}
		}

		if (sb.length() != 0)
		{
			words.add(sb.toString());
			sb.setLength(0);
		}

		if (words.size() == 1)
		{
			sb.append(words.get(0));
			for (int i = 0; i < spaces; i++)
			{
				sb.append(' ');
			}
			return sb.toString();
		}

		int count = spaces / (words.size() - 1);
		for (String word : words)
		{
			if (sb.length() == 0)
			{
				sb.append(word);
			}
			else
			{
				for (int i = 0; i < count; i++)
				{
					sb.append(' ');
				}
				sb.append(word);
			}
		}

		spaces -= count * (words.size() - 1);
		for (int i = 0; i < spaces; i++)
		{
			sb.append(' ');
		}

		return sb.toString();
	}
}
