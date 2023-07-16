package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 10/11/2022
 */
@LeetCode(
		id = 2434,
		name = "Using a Robot to Print the Lexicographically Smallest String",
		url = "https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/",
		difficulty = Difficulty.MEDIUM
)
public class UsingRobotToPrintTheLexicographicallySmallestString
{
	public String robotWithString(String input)
	{
		LinkedList<Character> buffer = new LinkedList<>();
		StringBuilder paper = new StringBuilder();
		char[] chars = input.toCharArray();
		char[] memo = new char[chars.length];
		memo[memo.length - 1] = chars[chars.length - 1];
		for (int i = memo.length - 2; i >= 0; i--)
		{
			memo[i] = (char) ('a' + Math.min(memo[i + 1] - 'a', chars[i] - 'a'));
		}

		for (int i = 0; i < memo.length; i++)
		{
			while (!buffer.isEmpty() && buffer.getLast() <= chars[i] && buffer.getLast() <= memo[i])
			{
				paper.append(buffer.removeLast());
			}

			if (chars[i] > memo[i])
			{
				buffer.addLast(chars[i]);
			}
			else
			{
				paper.append(chars[i]);
			}
		}

		while (!buffer.isEmpty())
		{
			paper.append(buffer.removeLast());
		}

		return paper.toString();
	}
}
