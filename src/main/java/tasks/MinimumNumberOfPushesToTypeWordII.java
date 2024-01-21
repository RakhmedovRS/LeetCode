package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-01-20
 */
@LeetCode(
		id = 3016,
		name = "Minimum Number of Pushes to Type Word II",
		url = "https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfPushesToTypeWordII {
	public int minimumPushes(String word) {
		int[] used = new int[10];
		int pushes = 0;
		Map<Character, Integer> memo = new HashMap<>();
		for (char ch : word.toCharArray()) {
			memo.put(ch, memo.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Character> pq = new PriorityQueue<>((ch1, ch2) -> memo.getOrDefault(ch2, 0) - memo.getOrDefault(ch1, 0));
		pq.addAll(memo.keySet());


		outer:
		while (!pq.isEmpty()) {
			char ch = pq.remove();

			for (int i = 2; i < 10; i++) {
				if (used[i] == 0) {
					used[i]++;
					pushes += memo.get(ch);
					continue outer;
				}
			}

			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 2; i < 10; i++) {
				if (used[i] < min) {
					minIndex = i;
					min = used[i];
				}
			}

			used[minIndex]++;
			pushes += used[minIndex] * memo.get(ch);
		}

		return pushes;
	}
}