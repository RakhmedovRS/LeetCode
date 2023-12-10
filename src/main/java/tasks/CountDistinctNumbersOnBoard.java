package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 1/29/2023
 */
@LeetCode(
		id = 2549,
		name = "Count Distinct Numbers on Board",
		url = "https://leetcode.com/problems/count-distinct-numbers-on-board/",
		difficulty = Difficulty.EASY
)
public class CountDistinctNumbersOnBoard {
	public int distinctIntegers(int n) {
		Set<Integer> set = new HashSet<>();
		set.add(n);

		Set<Integer> copy = new HashSet<>();
		Set<String> seen = new HashSet<>();
		while (true) {
			copy = new HashSet<>(set);
			for (int num : set) {
				for (int i = 1; i <= n; i++) {
					if (num % i == 1) {
						copy.add(i);
					}
				}
			}

			if (!seen.add(copy.toString())) {
				break;
			}

			set = copy;
		}

		return set.size();
	}
}
