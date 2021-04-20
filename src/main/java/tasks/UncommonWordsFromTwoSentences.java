package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(id = 884, name = "Uncommon Words from Two Sentences", url = "https://leetcode.com/problems/uncommon-words-from-two-sentences/")
public class UncommonWordsFromTwoSentences
{
	public String[] uncommonFromSentences(String A, String B)
	{
		Map<String, Integer> aMap = new HashMap<>();
		for (String word : A.split(" "))
		{
			aMap.put(word, aMap.getOrDefault(word, 0) + 1);
		}

		Map<String, Integer> bMap = new HashMap<>();
		for (String word : B.split(" "))
		{
			bMap.put(word, bMap.getOrDefault(word, 0) + 1);
		}

		List<String> values = new ArrayList<>();

		for (Map.Entry<String, Integer> entry: aMap.entrySet())
		{
			if (entry.getValue() == 1 && bMap.get(entry.getKey()) == null)
			{
				values.add(entry.getKey());
			}
		}

		for (Map.Entry<String, Integer> entry: bMap.entrySet())
		{
			if (entry.getValue() == 1 && aMap.get(entry.getKey()) == null)
			{
				values.add(entry.getKey());
			}
		}

		return values.toArray(new String[0]);
	}
}
