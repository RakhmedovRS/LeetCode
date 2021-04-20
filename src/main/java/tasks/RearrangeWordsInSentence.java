package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 06-Jul-20
 */
@LeetCode(id = 1451, name = "Rearrange Words in a Sentence", url = "https://leetcode.com/problems/rearrange-words-in-a-sentence/")
public class RearrangeWordsInSentence
{
	public String arrangeWords(String text)
	{
		if (text == null || text.length() == 0)
		{
			return text;
		}

		String[] words = text.split(" ");
		words[0] = words[0].toLowerCase();

		int max = Integer.MIN_VALUE;
		for (String word : words)
		{
			max = Math.max(max, word.length());
		}

		List<List<String>> buckets = new ArrayList<>();
		for (int i = 0; i <= max; i++)
		{
			buckets.add(new ArrayList<>());
		}

		for (String word : words)
		{
			buckets.get(word.length()).add(word);
		}

		StringBuilder sb = new StringBuilder();
		for (List<String> bucket : buckets)
		{
			for (String word : bucket)
			{
				if (sb.length() != 0)
				{
					sb.append(word);
				}
				else
				{
					char[] chars = word.toCharArray();
					chars[0] = Character.toUpperCase(chars[0]);
					sb.append(chars);
				}
				sb.append(" ");
			}
		}

		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
