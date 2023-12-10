package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/25/2020
 */
@LeetCode(
		id = 245,
		name = "Shortest Word Distance III",
		url = "https://leetcode.com/problems/shortest-word-distance-iii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.putIfAbsent(words[i], new ArrayList<>());
			map.get(words[i]).add(i);
		}

		int min = Integer.MAX_VALUE;
		if (word1.equals(word2)) {
			Integer prev = null;
			for (Integer id : map.get(word1)) {
				if (prev != null) {
					min = Math.min(min, id - prev);
				}

				prev = id;
			}
		}
		else {
			List<Integer> ids1 = map.get(word1);
			List<Integer> ids2 = map.get(word2);
			for (int id1 : ids1) {
				for (int id2 : ids2) {
					min = Math.min(min, Math.abs(id1 - id2));
				}
			}
		}

		return min;
	}
}
