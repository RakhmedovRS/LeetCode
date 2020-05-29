import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 29-May-20
 */
@LeetCode(id = 819, name = "Most Common Word", url = "https://leetcode.com/problems/most-common-word/")
public class MostCommonWord
{
	public String mostCommonWord(String paragraph, String[] banned)
	{
		Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
		Set<Character> bannedChars = new HashSet<>(Arrays.asList('!', '?', '\'', ',', '.', ':', ';'));

		Map<String, Integer> wordToCount = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();
		for (char ch : paragraph.toCharArray())
		{
			if (bannedChars.contains(ch))
			{
				stringBuilder.append(' ');
				continue;
			}
			stringBuilder.append(Character.toLowerCase(ch));
		}
		for (String word : stringBuilder.toString().split(" "))
		{
			if (!bannedWords.contains(word) && !word.isEmpty())
			{
				wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
			}
		}

		PriorityQueue<String> maxHeap = new PriorityQueue<>((s1, s2) -> wordToCount.get(s2) - wordToCount.get(s1));
		maxHeap.addAll(wordToCount.keySet());
		return maxHeap.peek();
	}
}
