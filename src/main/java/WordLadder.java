import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 18-Mar-20
 */
@LeetCode(id = 127, name = "Word Ladder", url = "https://leetcode.com/problems/word-ladder/")
public class WordLadder
{
	private void fillGraph(Map<String, Set<String>> graph, Map<String, Set<String>> dictionary, String word)
	{
		char[] pattern = word.toCharArray();
		for (int i = 0; i < pattern.length; i++)
		{
			char temp = pattern[i];
			pattern[i] = '*';
			String newWord = new String(pattern);
			pattern[i] = temp;

			Set<String> set = graph.getOrDefault(newWord, new HashSet<>());
			set.add(word);
			graph.put(newWord, set);

			set = dictionary.getOrDefault(word, new HashSet<>());
			set.add(newWord);
			dictionary.put(word, set);
		}
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList)
	{
		Map<String, Set<String>> graph = new HashMap<>();
		Map<String, Set<String>> dictionary = new HashMap<>();
		for (String word : wordList)
		{
			fillGraph(graph, dictionary, word);
		}

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		Queue<Set<String>> queue = new LinkedList<>();
		char[] pattern = beginWord.toCharArray();
		for (int i = 0; i < pattern.length; i++)
		{
			char temp = pattern[i];
			pattern[i] = '*';
			String next = new String(pattern);
			pattern[i] = temp;
			if (graph.containsKey(next))
			{
				queue.add(graph.get(next));
			}
		}

		int level = 1;
		int size;
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				Set<String> curr = queue.remove();
				if (curr.contains(endWord))
				{
					return level + 1;
				}

				for (String string : curr)
				{
					if (visited.add(string))
					{
						for (String next: dictionary.get(string))
						{
							Set<String> nextSet = graph.getOrDefault(next, Collections.emptySet());
							if (nextSet.contains(endWord))
							{
								return level + 2;
							}
							if (!nextSet.isEmpty())
							{
								queue.add(nextSet);
							}
						}
					}
				}
			}

			level++;
		}

		return 0;
	}

	public static void main(String[] args)
	{
		System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
		System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
	}
}
