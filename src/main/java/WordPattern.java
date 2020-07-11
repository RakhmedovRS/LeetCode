import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11-Jul-20
 */
@LeetCode(id = 290, name = "Word Pattern", url = "https://leetcode.com/problems/word-pattern/")
public class WordPattern
{
	public boolean wordPattern(String pattern, String str)
	{
		Map<Character, String> charToWord = new HashMap<>();
		Map<String, Character> wordToChar = new HashMap<>();
		char[] p = pattern.toCharArray();
		String[] words = str.split(" ");
		if (p.length != words.length)
		{
			return false;
		}

		for (int i = 0; i < p.length; i++)
		{
			String word = charToWord.getOrDefault(p[i], null);
			if (word == null)
			{
				if (p[i] != wordToChar.getOrDefault(words[i], p[i]))
				{
					return false;
				}
				charToWord.put(p[i], words[i]);
				wordToChar.put(words[i], p[i]);
			}
			else if (!words[i].equals(word))
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new WordPattern().wordPattern("abba", "dog dog dog dog"));
		System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
		System.out.println(new WordPattern().wordPattern("abba", "dog cat cat fish"));
		System.out.println(new WordPattern().wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(new WordPattern().wordPattern("aaaa", "dog dog dog dog"));
	}
}
