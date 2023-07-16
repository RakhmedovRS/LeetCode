package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 04-Mar-20
 */
@LeetCode(
		id = 451,
		name = "Sort Characters By Frequency",
		url = "https://leetcode.com/problems/sort-characters-by-frequency/",
		difficulty = Difficulty.MEDIUM
)
public class SortCharactersByFrequency
{
	public String frequencySort(String s)
	{
		Map<Character, Integer> freq = new HashMap<>();
		for (char ch : s.toCharArray())
		{
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
		priorityQueue.addAll(freq.keySet());

		StringBuilder sb = new StringBuilder();
		while (!priorityQueue.isEmpty())
		{
			char ch = priorityQueue.remove();
			int count = freq.remove(ch);

			while (count-- > 0)
			{
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
	}
}
