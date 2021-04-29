package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 29-May-20
 */
@LeetCode(
	id = 819,
	name = "Most Common Word",
	url = "https://leetcode.com/problems/most-common-word/",
	difficulty = Difficulty.EASY
)
public class MostCommonWord
{
	public String mostCommonWord(String paragraph, String[] banned)
	{
		Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> wordToCount = new HashMap<>();
		String[] words = formatParagraph(paragraph).split(" ");
		int count = 0;
		int temp;
		String answer = null;
		for (String word : words)
		{
			if (bannedWords.contains(word))
			{
				continue;
			}

			temp = wordToCount.getOrDefault(word, 0) + 1;
			wordToCount.put(word, temp);

			if (temp > count)
			{
				count = temp;
				answer = word;
			}
		}

		return answer;
	}

	private String formatParagraph(String paragraph)
	{
		StringBuilder sb = new StringBuilder();
		char ch;
		for (int i = 0; i < paragraph.length(); i++)
		{
			ch = paragraph.charAt(i);
			if (Character.isLetter(ch) || ch == ' ')
			{
				sb.append(Character.toLowerCase(ch));
			}
			else if (i + 1 < paragraph.length() && Character.isLetter(paragraph.charAt(i + 1)))
			{
				sb.append(" ");
			}
		}

		return sb.toString();
	}
}
