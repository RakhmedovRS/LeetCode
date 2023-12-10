package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 7/4/2021
 */
@LeetCode(
		id = 1921,
		name = "Eliminate Maximum Number of Monsters",
		url = "https://leetcode.com/problems/eliminate-maximum-number-of-monsters/",
		difficulty = Difficulty.MEDIUM
)
public class EliminateMaximumNumberOfMonsters {
	public int eliminateMaximum(int[] dist, int[] speed) {
		double[][] monsters = new double[dist.length][];
		for (int i = 0; i < dist.length; i++) {
			monsters[i] = new double[]{dist[i], speed[i]};
		}

		Arrays.sort(monsters, Comparator.comparingDouble(a -> a[0] / a[1]));

		for (int i = 0; i < monsters.length; i++) {
			if ((monsters[i][0] - (monsters[i][1] * i)) <= 0) {
				return i;
			}
		}

		return dist.length;
	}
}
