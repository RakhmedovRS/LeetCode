package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 10/14/2023
 */
@LeetCode(
		id = 2899,
		name = "Last Visited Integers",
		url = "https://leetcode.com/problems/last-visited-integers/",
		difficulty = Difficulty.EASY
)
public class LastVisitedIntegers
{
	public List<Integer> lastVisitedIntegers(List<String> words)
	{
		List<Integer> list = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		int pos = -1;
		for (String word : words)
		{
			if (word.charAt(0) == 'p')
			{
				if (pos < 0)
				{
					answer.add(-1);
				}
				else
				{
					answer.add(list.get(pos--));
				}
			}
			else
			{
				list.add(Integer.parseInt(word));
				pos = list.size() - 1;
			}
		}

		return answer;
	}
}
