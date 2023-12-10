package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 5/1/2022
 */
@LeetCode(
		id = 2260,
		name = "Minimum Consecutive Cards to Pick Up",
		url = "https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumConsecutiveCardsToPickUp {
	public int minimumCardPickup(int[] cards) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < cards.length; i++) {
			map.putIfAbsent(cards[i], new ArrayList<>());
			map.get(cards[i]).add(i);
		}

		int min = Integer.MAX_VALUE;
		for (List<Integer> indices : map.values()) {
			int diff = Integer.MAX_VALUE;
			for (int i = 1; i < indices.size(); i++) {
				diff = Math.min(diff, 1 + indices.get(i) - indices.get(i - 1));
				min = Math.min(min, diff);
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}
}
