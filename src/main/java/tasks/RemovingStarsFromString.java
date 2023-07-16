package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 9/3/2022
 */
@LeetCode(
		id = 2390,
		name = "Removing Stars From a String",
		url = "https://leetcode.com/problems/removing-stars-from-a-string/",
		difficulty = Difficulty.MEDIUM
)
public class RemovingStarsFromString
{
	public String removeStars(String s)
	{
		LinkedList<Character> list = new LinkedList<>();
		for (char ch : s.toCharArray())
		{
			if (ch == '*')
			{
				if (!list.isEmpty())
				{
					list.removeLast();
				}
			}
			else
			{
				list.addLast(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!list.isEmpty())
		{
			sb.append(list.removeFirst());
		}

		return sb.toString();
	}
}
