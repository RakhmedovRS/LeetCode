package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-08-31
 */
@LeetCode(
		id = 3273,
		name = "Minimum Amount of Damage Dealt to Bob",
		url = "https://leetcode.com/problems/minimum-amount-of-damage-dealt-to-bob/description/",
		difficulty = Difficulty.HARD
)
public class MinimumAmountOfDamageDealtToBob {
	public long minDamage(int power, int[] damage, int[] health) {
		long ans = 0;

		double[] ratios = new double[damage.length];
		long[] temp = new long[damage.length];
		for (int i = 0; i < damage.length; i++) {
			long hits = health[i] / power;
			if (health[i] % power != 0) {
				hits++;
			}
			long d = hits * damage[i];
			ratios[i] = 1D * damage[i] / hits;
			String a = "";
		}


		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (Double.compare(ratios[a], ratios[b]) == 0) {
				if (damage[a] != damage[b]) {
					return damage[b] - damage[a];
				}
				return health[a] - health[b];
			}
			return Double.compare(ratios[b], ratios[a]);
		});

		long totalDamage = 0;
		for (int i = 0; i < damage.length; i++) {
			totalDamage += damage[i];
			pq.add(i);
		}
		while (!pq.isEmpty()) {
			int i = pq.remove();
			int d = damage[i];
			int h = health[i];

			int numberOfAttacks = h / power;
			if (h % power != 0) {
				numberOfAttacks += 1;
			}

			ans += (totalDamage * numberOfAttacks);
			totalDamage -= d;
		}

		return ans;
	}
}