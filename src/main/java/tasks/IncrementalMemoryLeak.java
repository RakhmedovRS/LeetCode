package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/15/2021
 */
@LeetCode(
		id = 1860,
		name = "Incremental Memory Leak",
		url = "https://leetcode.com/problems/incremental-memory-leak/",
		difficulty = Difficulty.MEDIUM
)
public class IncrementalMemoryLeak {
	public int[] memLeak(int memory1, int memory2) {
		for (int i = 1; i <= Integer.MAX_VALUE - 1; i++) {
			if (memory1 >= memory2) {
				if (memory1 < i) {
					return new int[]{i, memory1, memory2};
				}

				memory1 -= i;
			}
			else {
				if (memory2 < i) {
					return new int[]{i, memory1, memory2};
				}

				memory2 -= i;
			}
		}

		return null;
	}
}
