package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 7/22/2023
 */
@LeetCode(
		id = 2788,
		name = "Split Strings by Separator\n",
		url = "https://leetcode.com/problems/split-strings-by-separator/",
		difficulty = Difficulty.EASY
)
public class SplitStringsBySeparator
{
	public List<String> splitWordsBySeparator(List<String> words, char separator)
	{
		List<String> an = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("\\");
		sb.append(separator);
		for (String s : words)
		{
			for (String ss : s.split(sb.toString()))
			{
				if (!ss.isEmpty())
				{
					an.add(ss);
				}
			}
		}
		return an;
	}
}
