package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
@LeetCode(
		id = 1209,
		name = "Remove All Adjacent Duplicates in String II",
		url = "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveAllAdjacentDuplicatesInStringII
{
	public String removeDuplicates(String s, int k)
	{
		if (k == 1)
		{
			return "";
		}

		boolean removed = false;
		LinkedList<Character> characters = new LinkedList<>();
		LinkedList<Integer> counts = new LinkedList<>();
		for (char ch : s.toCharArray())
		{
			if (!characters.isEmpty() && characters.getLast() == ch && counts.getLast() == k - 1)
			{
				for (int i = 0; i < k - 1; i++)
				{
					characters.removeLast();
					counts.removeLast();
				}
				removed = true;
			}
			else
			{
				if (characters.isEmpty() || characters.getLast() != ch)
				{
					counts.addLast(1);
				}
				else
				{
					counts.addLast(counts.getLast() + 1);
				}

				characters.addLast(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : characters)
		{
			sb.append(ch);
		}

		return removed ? removeDuplicates(sb.toString(), k) : sb.toString();
	}
}
