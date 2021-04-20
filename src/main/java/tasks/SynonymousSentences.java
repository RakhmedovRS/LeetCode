package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/19/2021
 */
@LeetCode(
	id = 1258,
	name = "Synonymous Sentences",
	url = "https://leetcode.com/problems/synonymous-sentences/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class SynonymousSentences
{
	class UnionFind
	{
		Map<String, String> parents;

		public UnionFind(String[] uniqueWords)
		{
			parents = new HashMap<>();
			for (String uniqueWord : uniqueWords)
			{
				parents.put(uniqueWord, uniqueWord);
			}
		}

		public String findParent(String word)
		{
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

		public boolean exists(String word)
		{
			return parents.containsKey(word);
		}
	}

	public List<String> generateSentences(List<List<String>> synonyms, String text)
	{
		Set<String> set = new HashSet<>();
		for (List<String> synonymsList : synonyms)
		{
			set.addAll(synonymsList);
		}

		String[] uniqueWords = set.toArray(new String[0]);
		UnionFind unionFind = new UnionFind(uniqueWords);

		for (List<String> synonymsList : synonyms)
		{
			unionFind.join(synonymsList.get(0), synonymsList.get(1));
		}

		Map<String, TreeSet<String>> parentsMap = new HashMap<>();
		String parent;
		TreeSet<String> treeSet;
		for (String uniqueWord : uniqueWords)
		{
			parent = unionFind.findParent(uniqueWord);
			treeSet = parentsMap.getOrDefault(parent, new TreeSet<>());
			treeSet.add(uniqueWord);
			parentsMap.put(parent, treeSet);
		}

		List<String> answer = new ArrayList<>();
		dfs(0, text.split(" "), new LinkedList<>(), answer, unionFind, parentsMap);
		return answer;
	}

	private void dfs(int pos, String[] words, LinkedList<String> current, List<String> answer, UnionFind uf, Map<String, TreeSet<String>> parentsMap)
	{
		if (pos == words.length)
		{
			answer.add(String.join(" ", current));
			return;
		}

		if (uf.exists(words[pos]))
		{
			for (String synonym : parentsMap.get(uf.findParent(words[pos])))
			{
				current.addLast(synonym);
				dfs(pos + 1, words, current, answer, uf, parentsMap);
				current.removeLast();
			}
		}
		else
		{
			current.addLast(words[pos]);
			dfs(pos + 1, words, current, answer, uf, parentsMap);
			current.removeLast();
		}
	}
}
