package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 1/21/2021
 */
@LeetCode(
		id = 544,
		name = "Output Contest Matches",
		url = "https://leetcode.com/problems/output-contest-matches/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class OutputContestMatches
{
	public String findContestMatch(int n)
	{
		String pattern = "(%s,%s)";
		LinkedList<String> current = new LinkedList<>();
		LinkedList<String> next;

		for (int i = 1; i <= n; i++)
		{
			current.addLast(String.valueOf(i));
		}

		while (current.size() > 2)
		{
			next = new LinkedList<>();
			while (!current.isEmpty())
			{
				next.addLast(String.format(pattern, current.removeFirst(), current.removeLast()));
			}

			current = next;
		}

		return String.format(pattern, current.removeFirst(), current.removeLast());
	}
}
