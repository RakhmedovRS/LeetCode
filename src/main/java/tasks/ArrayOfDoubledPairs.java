package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 22-Jul-20
 */
@LeetCode(
		id = 954,
		name = "Array of Doubled Pairs",
		url = "https://leetcode.com/problems/array-of-doubled-pairs/",
		difficulty = Difficulty.MEDIUM
)
public class ArrayOfDoubledPairs {
	public boolean canReorderDoubled(int[] A) {
		int pairs = 0;
		Map<Integer, Integer> numToCount = new HashMap<>();
		for (int num : A) {
			numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
		}

		Arrays.sort(A);
		for (int value : A) {
			if (!numToCount.containsKey(value)) {
				continue;
			}

			if (value < 0) {
				if (numToCount.containsKey(value / 2) && value % 2 == 0) {
					pairs++;
					int c1 = numToCount.remove(value) - 1;
					if (c1 > 0) {
						numToCount.put(value, c1);
					}
					int c2 = numToCount.remove(value / 2) - 1;
					if (c2 > 0) {
						numToCount.put(value / 2, c2);
					}
				}
			}
			else if (value > 0) {
				if (numToCount.containsKey(value * 2)) {
					pairs++;
					int c1 = numToCount.remove(value) - 1;
					if (c1 > 0) {
						numToCount.put(value, c1);
					}

					int c2 = numToCount.remove(value * 2) - 1;
					if (c2 > 0) {
						numToCount.put(value * 2, c2);
					}
				}
			}
			else {
				if (numToCount.getOrDefault(value, 0) > 1) {
					pairs++;
					numToCount.put(value, numToCount.get(value) - 2);
				}
			}
		}

		return pairs == A.length / 2;
	}
}
