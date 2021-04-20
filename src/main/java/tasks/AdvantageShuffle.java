package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 23-Sep-20
 */
@LeetCode(
	id = 870,
	name = "Advantage Shuffle",
	url = "https://leetcode.com/problems/advantage-shuffle/",
	difficulty = Difficulty.MEDIUM
)
public class AdvantageShuffle
{
	public int[] advantageCount(int[] A, int[] B)
	{
		int[] answer = new int[A.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> B[i]));
		for (int i = 0; i < B.length; i++)
		{
			pq.add(i);
		}

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int num : A)
		{
			treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
		}

		int index;
		Map.Entry<Integer, Integer> entry;
		while (!pq.isEmpty())
		{
			index = pq.remove();
			entry = treeMap.ceilingEntry(B[index] + 1);
			if (entry == null)
			{
				entry = treeMap.firstEntry();
			}

			answer[index] = entry.getKey();
			if (entry.getValue() == 1)
			{
				treeMap.remove(entry.getKey());
			}
			else
			{
				treeMap.put(entry.getKey(), entry.getValue() - 1);
			}
		}

		return answer;
	}
}
