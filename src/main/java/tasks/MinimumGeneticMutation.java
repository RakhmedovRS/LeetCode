package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 17-Jul-20
 */
@LeetCode(
	id = 433,
	name = "Minimum Genetic Mutation",
	url = "https://leetcode.com/problems/minimum-genetic-mutation/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumGeneticMutation
{
	public int minMutation(String start, String end, String[] bank)
	{
		List<String> words = new ArrayList<>(Arrays.asList(bank));
		words.add(start);

		Map<String, Set<String>> graph = buildGraph(words);
		if (!graph.containsKey(end))
		{
			return -1;
		}

		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		Set<String> seen = new HashSet<>();
		seen.add(start);
		int size;
		int permutations = 0;
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				String word = queue.remove();

				for (String edge : graph.get(word))
				{
					for (String next : graph.get(edge))
					{
						if (!seen.add(next))
						{
							continue;
						}

						if (next.equals(end))
						{
							return permutations + 1;
						}
						queue.add(next);
					}
				}
			}
			permutations++;
		}

		return -1;
	}

	private Map<String, Set<String>> buildGraph(List<String> words)
	{
		Map<String, Set<String>> graph = new HashMap<>();

		for (String word : words)
		{
			Set<String> permutations = createPossiblePermutations(word);
			graph.put(word, permutations);
			for (String permutation : permutations)
			{
				Set<String> edges = graph.getOrDefault(permutation, new HashSet<>());
				edges.add(word);
				graph.put(permutation, edges);
			}
		}

		return graph;
	}

	private Set<String> createPossiblePermutations(String gene)
	{
		char[] chars = gene.toCharArray();
		Set<String> ways = new HashSet<>();
		for (int i = 0; i < chars.length; i++)
		{
			char temp = chars[i];
			chars[i] = '*';
			ways.add(String.valueOf(chars));
			chars[i] = temp;
		}

		return ways;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
		System.out.println(new MinimumGeneticMutation().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
	}
}
