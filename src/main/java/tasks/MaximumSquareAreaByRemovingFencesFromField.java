package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 12/23/2023
 */
@LeetCode(
		id = 2975,
		name = "Maximum Square Area by Removing Fences From a Field",
		url = "https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumSquareAreaByRemovingFencesFromField {
	int MOD = 1_000_000_007;

	public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
		if (m == n) {
			return (int) (((long) (m - 1) * (m - 1)) % MOD);
		}

		int[] hFencesCopy = Arrays.copyOf(hFences, hFences.length + 2);
		hFencesCopy[hFences.length] = 1;
		hFencesCopy[hFences.length + 1] = m;
		Arrays.sort(hFencesCopy);

		Set<Long> hs = new HashSet<>();
		for (int i = 0; i < hFencesCopy.length; i++) {
			for (int j = i + 1; j < hFencesCopy.length; j++) {
				long diff = hFencesCopy[j] - hFencesCopy[i];
				hs.add(diff);
			}
		}

		int[] vFencesCopy = Arrays.copyOf(vFences, vFences.length + 2);
		vFencesCopy[vFences.length] = 1;
		vFencesCopy[vFences.length + 1] = n;
		Arrays.sort(vFencesCopy);

		long ans = -1;
		for (int i = 0; i < vFencesCopy.length; i++) {
			for (int j = i + 1; j < vFencesCopy.length; j++) {
				long diff = vFencesCopy[j] - vFencesCopy[i];
				if (hs.contains(diff)) {
					ans = Math.max(ans, diff);
				}
			}
		}

		if (ans == -1) {
			return -1;
		}

		return (int) (ans * ans % MOD);
	}
}
