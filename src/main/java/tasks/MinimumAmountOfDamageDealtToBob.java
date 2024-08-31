package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
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

		List<Integer> indices = new ArrayList<>();
		double[] ratios = new double[damage.length];
		long totalDamage = 0;
		for (int i = 0; i < damage.length; i++) {
			long hits = health[i] / power;
			if (health[i] % power != 0) {
				hits++;
			}
			ratios[i] = 1D * damage[i] / hits;
			indices.add(i);
			totalDamage += damage[i];
		}

		indices.sort((a, b) -> {
			if (Double.compare(ratios[a], ratios[b]) == 0) {
				if (damage[a] != damage[b]) {
					return damage[b] - damage[a];
				}
				return health[a] - health[b];
			}
			return Double.compare(ratios[b], ratios[a]);
		});

		for (int i : indices){
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