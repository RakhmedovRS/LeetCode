package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(
		id = 380,
		name = "Insert Delete GetRandom O(1)",
		url = "https://leetcode.com/problems/insert-delete-getrandom-o1/",
		difficulty = Difficulty.MEDIUM
)
public class InsertDeleteGetRandom {
	class RandomizedSet {
		/**
		 * Initialize your data structure here.
		 */
		private final Map<Integer, Integer> map;
		private final List<Integer> list;
		private final Random random;

		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
			random = new Random();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				return false;
			}

			list.add(val);
			map.put(val, list.size() - 1);
			return true;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the specified element.
		 */
		public boolean remove(int val) {
			if (!map.containsKey(val)) {
				return false;
			}

			int idx = map.remove(val);
			int last = list.remove(list.size() - 1);
			if (val != last) {
				list.set(idx, last);
				map.put(last, idx);
			}
			return true;
		}

		/**
		 * Get a random element from the set.
		 */
		public int getRandom() {
			return list.get(random.nextInt(list.size()));
		}
	}

	public static void main(String[] args) {
		RandomizedSet set = new InsertDeleteGetRandom().new RandomizedSet();
		System.out.println(set.insert(1));
		System.out.println(set.remove(2));
		System.out.println(set.insert(2));
		System.out.println(set.getRandom());
		System.out.println(set.remove(1));
		System.out.println(set.remove(2));
	}
}
