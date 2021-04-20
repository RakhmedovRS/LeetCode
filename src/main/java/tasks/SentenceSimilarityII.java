package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/20/2021
 */
@LeetCode(
	id = 737,
	name = "Sentence Similarity II",
	url = "https://leetcode.com/problems/sentence-similarity-ii/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class SentenceSimilarityII
{
	class UnionFind
	{
		Map<String, String> parents;

		public UnionFind(Set<String> uniqueWords)
		{
			parents = new HashMap<>();
			for (String uniqueWord : uniqueWords)
			{
				parents.put(uniqueWord, uniqueWord);
			}
		}

		public String findParent(String word)
		{
			if (!parents.containsKey(word))
			{
				return word;
			}

			String parent = word;
			while (!parent.equals(parents.get(parent)))
			{
				parent = parents.get(parent);
			}

			String temp;
			while (!word.equals(parents.get(word)))
			{
				temp = parents.get(word);
				parents.put(word, parent);
				word = temp;
			}

			return parent;
		}

		public void join(String wordA, String wordB)
		{
			String parentA = findParent(wordA);
			String parentB = findParent(wordB);

			if (!parentA.equals(parentB))
			{
				parents.put(parentB, parentA);
			}
		}
	}

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs)
	{
		if (words1.length != words2.length)
		{
			return false;
		}

		Set<String> uniqueWords = new HashSet<>(Arrays.asList(words1));
		uniqueWords.addAll(Arrays.asList(words2));
		for (List<String> pair : pairs)
		{
			uniqueWords.addAll(pair);
		}

		UnionFind uf = new UnionFind(uniqueWords);
		for (List<String> pair : pairs)
		{
			uf.join(pair.get(0), pair.get(1));
		}

		String wordA;
		String wordB;
		for (int i = 0; i < words1.length; i++)
		{
			wordA = words1[i];
			wordB = words2[i];
			if (!uf.findParent(wordA).equals(uf.findParent(wordB)))
			{
				return false;
			}
		}

		return true;
	}
}
