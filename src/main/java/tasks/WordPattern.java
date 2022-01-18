package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11-Jul-20
 */
@LeetCode(
		id = 290,
		name = "Word Pattern",
		url = "https://leetcode.com/problems/word-pattern/",
		difficulty = Difficulty.MEDIUM
)
public class WordPattern
{
	public boolean wordPattern(String pattern, String str)
	{
		String[] parts = str.split(" ");
		if (parts.length != pattern.length())
		{
			return false;
		}
		Map<String, Character> wordToCharacter = new HashMap<>();
		Map<Character, String> characterToWord = new HashMap<>();
		for (int i = 0; i < parts.length; i++)
		{
			wordToCharacter.putIfAbsent(parts[i], pattern.charAt(i));
			characterToWord.putIfAbsent(pattern.charAt(i), parts[i]);

			if (wordToCharacter.get(parts[i]) != pattern.charAt(i) || !characterToWord.get(pattern.charAt(i)).equals(parts[i]))
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
