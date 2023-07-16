package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 10/29/2022
 */
@LeetCode(
		id = 2451,
		name = "Odd String Difference",
		url = "https://leetcode.com/problems/odd-string-difference/",
		difficulty = Difficulty.EASY
)
public class OddStringDifference
{
	public String oddString(String[] words)
	{
		Map<String, List<String>> map = new HashMap<>();

		for (String word : words)
		{
			int[] nums = new int[word.length() - 1];
			for (int i = 1; i < word.length(); i++)
			{
				nums[i - 1] = (word.charAt(i) - 'a') - (word.charAt(i - 1) - 'a');
			}

			String key = Arrays.toString(nums);
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(word);
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet())
		{
			if (entry.getValue().size() == 1)
			{
				return entry.getValue().get(0);
			}
		}

		return "";
	}
}
