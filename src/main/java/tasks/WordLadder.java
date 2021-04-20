package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 18-Mar-20
 */
@LeetCode(
	id = 127,
	name = "Word Ladder",
	url = "https://leetcode.com/problems/word-ladder/",
	difficulty = Difficulty.HARD
)
public class WordLadder
{
	public int ladderLength(String beginWord, String endWord, List<String> wordList)
	{
		int steps = 0;
		Set<String> dictionary = new HashSet<>(wordList);
		if (!dictionary.contains(endWord))
		{
			return 0;
		}

		Queue<String> words = new LinkedList<>();
		words.add(beginWord);

		Set<String> visited = new HashSet<>();
		String current;
		int size;
		while (!words.isEmpty())
		{
			size = words.size();
			while (size-- > 0)
			{
				current = words.remove();
				if (!visited.add(current))
				{
					continue;
				}

				for (String word : wordList)
				{
					if (difference(current, word) < 2 && dictionary.contains(word) && !visited.contains(word))
					{
						if (word.equals(endWord))
						{
							return steps + 2;
						}
						words.add(word);
					}
				}
			}

			steps++;
		}

		return 0;
	}

	private int difference(String wordA, String wordB)
	{
		int diff = 0;
		for (int i = 0; i < wordA.length() && diff <= 1; i++)
		{
			if (wordA.charAt(i) != wordB.charAt(i))
			{
				diff++;
			}
		}

		return diff;
	}

	public static void main(String[] args)
	{
		WordLadder clazz = new WordLadder();

		System.out.println(clazz.ladderLength("coder", "goner",
			Arrays.asList("lover", "coder", "comer", "toner", "cover", "tower", "coyer", "bower",
				"honer", "poles", "hover", "lower", "homer", "boyer", "goner", "loner", "boner",
				"cower", "never", "sower", "asian")));

		System.out.println(clazz.ladderLength("hit", "cog",
			Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));

		System.out.println(clazz.ladderLength("hit", "cog",
			Arrays.asList("hot", "dot", "dog", "lot", "log")));
	}
}
