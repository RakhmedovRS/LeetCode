package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/14/2021
 */
@LeetCode(
		id = 381,
		name = "Insert Delete GetRandom O(1) - Duplicates allowed",
		url = "https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/",
		difficulty = Difficulty.HARD
)
public class InsertDeleteGetRandomO1DuplicatesAllowed {
	class RandomizedCollection {

		/**
		 * Initialize your data structure here.
		 */
		Map<Integer, Set<Integer>> map;
		List<Integer> values;
		Random random;
		int elements;

		public RandomizedCollection() {
			map = new HashMap<>();
			values = new ArrayList<>();
			random = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
		 */
		public boolean insert(int val) {
			boolean contains = map.containsKey(val) && map.get(val).size() > 0;
			if (!contains) {
				map.put(val, new HashSet<>());
			}

			if (elements == values.size()) {
				values.add(0);
			}
			values.set(elements, val);

			map.get(val).add(elements);
			elements++;
			return !contains;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained the specified element.
		 */
		public boolean remove(int val) {
			boolean contains = map.containsKey(val) && map.get(val).size() > 0;

			if (contains && elements == 1) {
				map.get(val).remove(elements - 1);
				elements--;
			}
			else if (contains) {
				int emptied = map.get(val).iterator().next();
				int last = elements - 1;
				map.get(val).remove(emptied);
				map.get(values.get(last)).remove(last);

				values.set(emptied, values.get(last));

				if (emptied != last) {
					map.get(values.get(emptied)).add(emptied);
				}

				elements--;
			}

			return contains;
		}

		/**
		 * Get a random element from the collection.
		 */
		public int getRandom() {
			return values.get(random.nextInt(elements));
		}
	}
}
