package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 11/27/2021
 */
@LeetCode(
		id = 2086,
		name = "Minimum Number of Buckets Required to Collect Rainwater from Houses",
		url = "https://leetcode.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfBucketsRequiredToCollectRainwaterFromHouses {
	public int minimumBuckets(String street) {
		int count = 0;
		int houses = 0;
		char[] chars = street.toCharArray();
		for (char ch : chars) {
			houses += ch == 'H' ? 1 : 0;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'H') {
				continue;
			}

			int c = 0;
			if (i - 1 >= 0 && chars[i - 1] == 'H') {
				c++;
			}
			if (i + 1 < chars.length && chars[i + 1] == 'H') {
				c++;
			}

			if (c > 0) {
				map.put(i, c);
			}
		}

		TreeSet<Integer> treeSet = new TreeSet<>((a, b) ->
		{
			int aCount = map.getOrDefault(a, 0);
			int bCount = map.getOrDefault(b, 0);

			if (aCount == bCount) {
				return a - b;
			}

			return bCount - aCount;
		});

		treeSet.addAll(map.keySet());
		while (!treeSet.isEmpty()) {
			int i = treeSet.pollFirst();
			boolean used = false;
			if (i - 1 >= 0 && chars[i - 1] == 'H') {
				houses--;
				used = true;
				chars[i - 1] = 'T';

				if (i - 2 >= 0 && map.containsKey(i - 2)) {
					treeSet.remove(i - 2);
					map.put(i - 2, map.get(i - 2) - 1);
					treeSet.add(i - 2);
				}
			}

			if (i + 1 < chars.length && chars[i + 1] == 'H') {
				houses--;
				used = true;
				chars[i + 1] = 'T';

				if (i + 2 < chars.length && map.containsKey(i + 2)) {
					treeSet.remove(i + 2);
					map.put(i + 2, map.get(i + 2) - 1);
					treeSet.add(i + 2);
				}
			}

			if (used) {
				count++;
			}
		}

		return houses == 0 ? count : -1;
	}
}
