package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 31-Jul-20
 */
@LeetCode(
	id = 472,
	name = "Concatenated Words",
	url = "https://leetcode.com/problems/concatenated-words/",
	difficulty = Difficulty.HARD
)
public class ConcatenatedWords
{
	public List<String> findAllConcatenatedWordsInADict(String[] words)
	{
		Arrays.sort(words, Comparator.comparingInt(String::length));
		Set<String> seen = new HashSet<>();
		List<String> answer = new ArrayList<>();
		for (String word : words)
		{
			if (dfs(0, word, seen))
			{
				answer.add(word);
			}
			seen.add(word);
		}

		return answer;
	}

	private boolean dfs(int pos, String word, Set<String> seen)
	{
		if (pos >= word.length() && word.length() > 0)
		{
			return true;
		}

		for (int i = pos; i < word.length(); i++)
		{
			if (seen.contains(word.substring(pos, i + 1)) && dfs(i + 1, word, seen))
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(
			new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"})
		);
	}
}
