package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 7/12/2022
 */
@LeetCode(
		id = 2336,
		name = "Smallest Number in Infinite Set",
		url = "https://leetcode.com/problems/smallest-number-in-infinite-set/",
		difficulty = Difficulty.MEDIUM
)
public class SmallestNumberInInfiniteSet {
	class SmallestInfiniteSet {

		TreeSet<Integer> set;

		public SmallestInfiniteSet() {
			set = new TreeSet<>();
			for (int i = 1; i < 1001; i++) {
				set.add(i);
			}
		}

		public int popSmallest() {
			int val = set.first();
			set.remove(val);
			return val;
		}

		public void addBack(int num) {
			set.add(num);
		}
	}
}
