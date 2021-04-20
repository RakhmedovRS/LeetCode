package tasks;

import common.LeetCode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 02-Jul-20
 */
@LeetCode(id = 809, name = "Expressive Words", url = "https://leetcode.com/problems/expressive-words/")
public class ExpressiveWords
{
	public int expressiveWords(String S, String[] words)
	{
		int count = 0;
		List<Pair<Character, Integer>> pattern = shortWord(S);
		outer:
		for (String word : words)
		{
			List<Pair<Character, Integer>> shortWord = shortWord(word);
			if (pattern.size() == shortWord.size())
			{
				for (int i = 0; i < pattern.size(); i++)
				{
					char ch1 = shortWord.get(i).getKey();
					char ch2 = pattern.get(i).getKey();
					int pSize = pattern.get(i).getValue();
					int wSize = shortWord.get(i).getValue();

					if (ch1 != ch2 || (wSize > pSize || pSize < 3 && pSize != wSize))
					{
						continue outer;
					}
				}
				count++;
			}
		}

		return count;
	}

	private List<Pair<Character, Integer>> shortWord(String word)
	{
		if (word == null || word.isEmpty())
		{
			return Collections.emptyList();
		}

		int pos = 0;
		char prev = word.charAt(0);
		int count = 0;
		List<Pair<Character, Integer>> result = new ArrayList<>();
		while (pos < word.length())
		{
			while (pos < word.length() && word.charAt(pos) == prev)
			{
				pos++;
				count++;
			}

			result.add(new Pair<>(prev, count));
			if (pos < word.length())
			{
				prev = word.charAt(pos);
				count = 0;
			}
		}

		return result;
	}
}
