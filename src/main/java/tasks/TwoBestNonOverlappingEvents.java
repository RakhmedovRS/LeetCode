package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 10/30/2021
 */
@LeetCode(
		id = 2054,
		name = "Two Best Non-Overlapping Events",
		url = "https://leetcode.com/problems/two-best-non-overlapping-events/",
		difficulty = Difficulty.MEDIUM
)
public class TwoBestNonOverlappingEvents {
	public int maxTwoEvents(int[][] events) {
		Arrays.sort(events, (a, b) ->
		{
			if (a[0] == b[0]) {
				if (a[1] == b[1]) {
					return b[2] - a[2];
				}
				else {
					return a[1] - b[1];
				}
			}
			else {
				return a[0] - b[0];
			}
		});

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();

		for (int[] event : events) {
			int end = event[1];
			int cost = event[2];

			treeMap.put(end, Math.max(cost, treeMap.getOrDefault(end, 0)));
		}

		int max = 0;
		Set<Integer> keys = treeMap.keySet();
		for (Integer key : keys) {
			max = Math.max(max, treeMap.get(key));
			treeMap.put(key, max);
		}

		int answer = 0;
		for (int[] event : events) {
			int start = event[0];
			int cost = event[2];
			Map.Entry<Integer, Integer> floorEntry = treeMap.floorEntry(start - 1);

			answer = Math.max(answer, cost + (floorEntry == null ? 0 : floorEntry.getValue()));
		}

		return answer;
	}
}
