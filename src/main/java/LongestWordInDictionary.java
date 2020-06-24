import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(id = 720, name = "Longest Word in Dictionary", url = "https://leetcode.com/problems/longest-word-in-dictionary/")
public class LongestWordInDictionary
{
	public String longestWord(String[] words)
	{
		Arrays.sort(words);
		Set<String> seen = new HashSet<>();
		seen.add("");
		String answer = "";
		for (String word : words)
		{
			if (seen.contains(word.substring(0, word.length() - 1)))
			{
				if (word.length() > answer.length())
				{
					answer = word;
				}

				seen.add(word);
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestWordInDictionary().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
	}
}
