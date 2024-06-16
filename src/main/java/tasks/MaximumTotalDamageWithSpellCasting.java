package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-16
 */
@LeetCode(
		id = 3186,
		name = "Maximum Total Damage With Spell Casting",
		url = "https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumTotalDamageWithSpellCasting {
	public long maximumTotalDamage(int[] power) {
		TreeMap<Integer, Long> powers = new TreeMap<>();
		for (int p : power) {
			powers.put(p, powers.getOrDefault(p, 0L) + 1);
		}


		PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] == b[0]) {
				return Long.compare(a[1], b[1]);
			}
			return Long.compare(b[0], a[0]);
		});

		long[] ans = new long[]{0};
		powers.forEach((key, count) -> {
			ans[0] = Math.max(ans[0], key * count);
			List<long[]> toIns = new ArrayList<>();
			boolean found = false;
			while (!pq.isEmpty()) {
				long[] curr = pq.remove();
				if (curr[1] + 2 < key) {
					pq.add(new long[]{curr[0] + (key * count), key});
					ans[0] = Math.max(ans[0], curr[0] + (key * count));
					found = true;
					toIns.add(curr);
					break;
				} else {
					toIns.add(curr);
				}
			}
			pq.addAll(toIns);
			if (!found) {
				pq.add(new long[]{key * count, key});
			}
		});

		return ans[0];
	}
}