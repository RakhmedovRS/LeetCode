package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 12/12/2021
 */
@LeetCode(
		id = 2103,
		name = "Rings and Rods",
		url = "https://leetcode.com/problems/rings-and-rods/",
		difficulty = Difficulty.EASY
)
public class RingsAndRods {
	public int countPoints(String rings) {
		Map<Integer, Set<Character>> map = new HashMap<>();
		for (int i = 0; i < rings.length(); i += 2) {
			char color = rings.charAt(i);
			int rod = rings.charAt(i + 1) - '0';

			map.putIfAbsent(rod, new HashSet<>());
			map.get(rod).add(color);
		}

		int count = 0;
		for (Map.Entry<Integer, Set<Character>> entry : map.entrySet()) {
			if (entry.getValue().size() == 3) {
				count++;
			}
		}

		return count;
	}
}
