package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/3/2020
 */
@LeetCode(
	id = 734,
	name = "Sentence Similarity",
	url = "https://leetcode.com/problems/sentence-similarity/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class SentenceSimilarity
{
	public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs)
	{
		if (sentence1.length != sentence2.length)
		{
			return false;
		}

		Map<String, Set<String>> map = new HashMap<>();
		for (List<String> pair : similarPairs)
		{
			String a = pair.get(0);
			String b = pair.get(1);

			map.putIfAbsent(a, new HashSet<>());
			map.putIfAbsent(b, new HashSet<>());

			map.get(a).add(b);
			map.get(b).add(a);
		}

		for (int i = 0; i < sentence1.length; i++)
		{
			if (!sentence1[i].equals(sentence2[i]))
			{
				if (!map.getOrDefault(sentence1[i], Collections.emptySet()).contains(sentence2[i])
					&& !map.getOrDefault(sentence2[i], Collections.emptySet()).contains(sentence1[i]))
				{
					return false;
				}
			}
		}

		return true;
	}
}
