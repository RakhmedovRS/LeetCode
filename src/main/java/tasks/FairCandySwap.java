package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/22/2020
 */
@LeetCode(id = 888, name = "Fair tasks.Candy Swap", url = "https://leetcode.com/problems/fair-candy-swap/")
public class FairCandySwap {
	public int[] fairCandySwap(int[] A, int[] B) {
		int aSum = 0;
		Set<Integer> set = new HashSet<>();
		for (int a : A) {
			set.add(a);
			aSum += a;
		}

		int bSum = 0;
		for (int b : B) {
			bSum += b;
		}

		int diff = (aSum - bSum) / 2;
		for (int b : B) {
			if (set.contains(b + diff)) {
				return new int[]{b + diff, b};
			}
		}

		return new int[0];
	}
}
