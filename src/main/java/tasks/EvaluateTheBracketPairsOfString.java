package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 3/28/2021
 */
@LeetCode(
		id = 1807,
		name = "Evaluate the Bracket Pairs of a String",
		url = "https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/",
		difficulty = Difficulty.MEDIUM
)
public class EvaluateTheBracketPairsOfString
{
	public String evaluate(String s, List<List<String>> knowledge)
	{
		StringBuilder sb = new StringBuilder();
		Map<String, String> map = new HashMap<>();
		for (List<String> pair : knowledge)
		{
			map.put(pair.get(0), pair.get(1));
		}

		Integer prev = null;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				prev = i;
			}
			else if (s.charAt(i) == ')')
			{
				sb.append(map.getOrDefault(s.substring(prev + 1, i), "?"));
				prev = null;
			}
			else if (prev == null)
			{
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}
}
