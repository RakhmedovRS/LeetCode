import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 04-Mar-20
 */
@LeetCode(id = 451, name = "Sort Characters By Frequency", url = "https://leetcode.com/problems/sort-characters-by-frequency/")
public class SortCharactersByFrequency
{
	public String frequencySort(String s)
	{
		if (s == null || s.isEmpty())
		{
			return s;
		}

		Map<Character, Integer> memo = new HashMap<>();
		for (char ch : s.toCharArray())
		{
			memo.put(ch, memo.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<>((ch1, ch2) -> memo.get(ch2).compareTo(memo.get(ch1)));
		maxHeap.addAll(memo.keySet());
		StringBuilder stringBuilder = new StringBuilder();
		while (!maxHeap.isEmpty())
		{
			char ch = maxHeap.remove();
			int count = memo.get(ch);
			while (count-- > 0)
			{
				stringBuilder.append(ch);
			}
		}

		return stringBuilder.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new SortCharactersByFrequency().frequencySort("tree"));
	}
}
