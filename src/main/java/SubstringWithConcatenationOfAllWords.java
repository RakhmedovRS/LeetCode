import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/26/2020
 */
@LeetCode(id = 30, name = "Substring with Concatenation of All Words", url = "https://leetcode.com/problems/substring-with-concatenation-of-all-words/")
public class SubstringWithConcatenationOfAllWords
{
	public List<Integer> findSubstring(String s, String[] words)
	{
		int wordsCount = words.length;
		int wordLength = words[0].length();
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> target = new HashMap<>();
		for (String word : words)
		{
			target.put(word, target.getOrDefault(word, 0) + 1);
		}

		String sub;
		int step = wordLength * wordsCount - 1;
		outer:
		for (int i = step; i < s.length(); i++)
		{
			Map<String, Integer> seen = new HashMap<>();
			for (int j = i - step; j <= i; j += wordLength)
			{
				sub = s.substring(j, j + wordLength);
				if (target.containsKey(sub))
				{
					seen.put(sub, seen.getOrDefault(sub, 0) + 1);
					if (seen.get(sub) > target.get(sub))
					{
						continue outer;
					}
				}
				else
				{
					continue outer;
				}
			}

			answer.add(i - step);
		}

		return answer;
	}
}
