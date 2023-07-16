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
		id = 244,
		name = "Shortest Word Distance II",
		url = "https://leetcode.com/problems/shortest-word-distance-ii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ShortestWordDistanceII
{
	class WordDistance
	{
		Map<String, List<Integer>> positions;

		public WordDistance(String[] words)
		{
			positions = new HashMap<>();
			for (int i = 0; i < words.length; i++)
			{
				positions.putIfAbsent(words[i], new ArrayList<>());
				positions.get(words[i]).add(i);
			}
		}

		public int shortest(String word1, String word2)
		{
			List<Integer> ids1 = positions.get(word1);
			List<Integer> ids2 = positions.get(word2);
			int min = Integer.MAX_VALUE;
			for (int id1 : ids1)
			{
				for (int id2 : ids2)
				{
					min = Math.min(min, Math.abs(id1 - id2));
				}
			}
			return min;
		}
	}
}
