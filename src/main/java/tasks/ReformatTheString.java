package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 20-May-20
 */
@LeetCode(id = 1417, name = "Reformat The String", url = "https://leetcode.com/problems/reformat-the-string/")
public class ReformatTheString
{
	public String reformat(String s)
	{
		List<Character> characters = new ArrayList<>();
		List<Character> integers = new ArrayList<>();

		for (char ch : s.toCharArray())
		{
			if (Character.isDigit(ch))
			{
				integers.add(ch);
			}
			else
			{
				characters.add(ch);
			}
		}

		if (Math.abs(characters.size() - integers.size()) > 1)
		{
			return "";
		}

		if (characters.size() > integers.size())
		{
			return buildAnswer(characters, integers);
		}
		else
		{
			return buildAnswer(integers, characters);
		}
	}

	private String buildAnswer(List<Character> list1, List<Character> list2)
	{
		StringBuilder answer = new StringBuilder();
		int l1 = 0;
		int l2 = 0;
		boolean even = true;
		while (l1 < list1.size() || l2 < list2.size())
		{
			if (even)
			{
				answer.append(list1.get(l1++));
				even = false;

			}
			else
			{
				answer.append(list2.get(l2++));
				even = true;
			}
		}

		return answer.toString();
	}
}
