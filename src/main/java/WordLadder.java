import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 18-Mar-20
 */
@LeetCode(id = 127, name = "Word Ladder", url = "https://leetcode.com/problems/word-ladder/")
public class WordLadder
{
	public int ladderLength(String beginWord, String endWord, List<String> wordList)
	{
		Set<String> dictionary = new HashSet<>(wordList);

		if (!dictionary.contains(endWord))
		{
			return 0;
		}

		int level = 1;
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> used = new HashSet<>();
		while (!queue.isEmpty())
		{
			int size = queue.size();
			for (int i = 0; i < size; i++)
			{
				String current = queue.poll();
				for (String possibleTarget : dictionary)
				{
					if (canBeTransformed(current, possibleTarget))
					{
						if (possibleTarget.equals(endWord))
						{
							return level + 1;
						}

						if (!used.contains(possibleTarget))
						{
							queue.offer(possibleTarget);
							used.add(possibleTarget);
						}
					}
				}
				dictionary.remove(current);
			}


			level++;
		}

		return 0;
	}

	private boolean canBeTransformed(String current, String target)
	{
		int steps = 1;
		for (int i = 0; i < current.length(); i++)
		{
			if (current.charAt(i) != target.charAt(i))
			{
				steps--;
			}
			if (steps < 0)
			{
				return false;
			}
		}

		return steps == 0;
	}
}
