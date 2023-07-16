package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 5/26/2021
 */
@LeetCode(
		id = 388,
		name = "Longest Absolute File Path",
		url = "https://leetcode.com/problems/longest-absolute-file-path/",
		difficulty = Difficulty.MEDIUM
)
public class LongestAbsoluteFilePath
{
	public int lengthLongestPath(String input)
	{
		int longest = 0;
		String[] parts = input.split("\n");
		Deque<Integer> deque = new LinkedList<>();
		deque.push(0);
		for (String part : parts)
		{
			int lastTabIndex = part.lastIndexOf('\t') + 1;
			int len = part.length() - lastTabIndex;
			while (deque.size() > lastTabIndex + 1)
			{
				deque.pop();
			}

			if (!part.contains("."))
			{
				deque.push(deque.peek() + len + 1);
			}
			else
			{
				longest = Math.max(longest, deque.peek() + len);
			}
		}

		return longest;
	}
}
