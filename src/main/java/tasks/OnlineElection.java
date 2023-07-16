package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11-Feb-21
 */
@LeetCode(
		id = 911,
		name = "Online Election",
		url = "https://leetcode.com/problems/online-election/",
		difficulty = Difficulty.MEDIUM
)
public class OnlineElection
{
	class TopVotedCandidate
	{
		TreeMap<Integer, Integer> table;

		public TopVotedCandidate(int[] persons, int[] times)
		{
			table = new TreeMap<>();

			Map<Integer, LinkedList<Integer>> map = new HashMap<>();
			for (int i = 0; i < times.length; i++)
			{
				map.putIfAbsent(persons[i], new LinkedList<>());
				map.get(persons[i]).addLast(times[i]);
			}


			Map<Integer, Integer> counts = new HashMap<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> map.get(a).getFirst()));
			pq.addAll(map.keySet());
			int candidate;
			LinkedList<Integer> current;
			int time;
			int max = 0;
			int votes;
			while (!pq.isEmpty())
			{
				candidate = pq.remove();
				current = map.get(candidate);
				time = current.removeFirst();
				counts.put(candidate, counts.getOrDefault(candidate, 0) + 1);
				votes = counts.get(candidate);
				if (votes >= max)
				{
					table.put(time, candidate);
					max = votes;
				}

				if (!current.isEmpty())
				{
					pq.add(candidate);
				}
			}
		}

		public int q(int t)
		{
			return table.floorEntry(t).getValue();
		}
	}
}
