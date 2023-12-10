package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 3/28/2021
 */
@LeetCode(
		id = 1806,
		name = "Minimum Number of Operations to Reinitialize a Permutation",
		url = "https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToReinitializePermutation {
	public int numDifferentIntegers(String word) {
		Set<Integer> set = new HashSet<>();
		Integer number = null;
		for (int i = 0; i < word.length(); i++) {
			if (Character.isDigit(word.charAt(i))) {
				number = number == null ? 0 : number;
				number *= 10;
				number += word.charAt(i) - '0';
			}
			else {
				if (number != null) {
					set.add(number);
					number = null;
				}
			}
		}

		if (number != null) {
			set.add(number);
		}

		return set.size();
	}

	public int reinitializePermutation(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i;
		}

		int steps = 1;
		array = shuffle(array);
		while (!check(array)) {
			array = shuffle(array);
			steps++;
		}

		return steps;
	}

	int[] shuffle(int[] arr) {
		int[] next = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				next[i] = arr[i / 2];
			}
			else {
				next[i] = arr[arr.length / 2 + (i - 1) / 2];
			}
		}
		return next;
	}

	boolean check(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i) {
				return false;
			}
		}

		return true;
	}
}
