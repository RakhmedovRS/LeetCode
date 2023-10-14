package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 10/14/2023
 */
@LeetCode(
		id = 2901,
		name = "Longest Unequal Adjacent Groups Subsequence II",
		url = "https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class LongestUnequalAdjacentGroupsSubsequenceII
{
	public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups)
	{
		Map<String, String> prev = new HashMap<>();
		Map<String, Integer> longest = new HashMap<>();
		Map<String, Integer> group = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			String word = words[i];
			int g = groups[i];

			prev.put(word, null);
			group.put(word, g);
		}

		int maxLen = 0;
		String w = null;
		for (int i = 0; i < n; i++)
		{
			String word = words[i];
			int g = groups[i];

			Map<String, Integer> l = new HashMap<>();
			Map<String, String> p = new HashMap<>();

			for (Map.Entry<String, Integer> entry : longest.entrySet())
			{
				String wrd = entry.getKey();
				int len = entry.getValue();

				if (word.length() == wrd.length() && g != group.get(wrd) && distOne(word, wrd))
				{
					if (l.containsKey(word))
					{
						if (l.get(word) < len + 1)
						{
							l.put(word, len + 1);
							p.put(word, wrd);
						}
					}
					else
					{
						l.put(word, len + 1);
						p.put(word, wrd);
					}

					if (maxLen < l.get(word))
					{
						w = word;
						maxLen = l.get(word);
					}
				}
			}

			l.putIfAbsent(word, 1);
			if (w == null)
			{
				w = word;
			}

			longest.putAll(l);
			prev.putAll(p);
		}

		LinkedList<String> answer = new LinkedList<>();
		while (w != null)
		{
			answer.addFirst(w);
			w = prev.get(w);
		}


		return answer;
	}

	private boolean distOne(String a, String b)
	{
		if (a.length() != b.length())
		{
			return false;
		}

		int diff = 0;
		for (int i = 0; i < a.length(); i++)
		{
			if (a.charAt(i) != b.charAt(i))
			{
				diff++;
				if (diff > 1)
				{
					return false;
				}
			}
		}

		return diff == 1;
	}
}
