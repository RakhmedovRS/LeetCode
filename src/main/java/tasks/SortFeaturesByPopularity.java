package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @since 25.02.2021
 */
@LeetCode(
		id = 1772,
		name = "Sort Features by Popularity",
		url = "https://leetcode.com/problems/sort-features-by-popularity/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class SortFeaturesByPopularity {
	public String[] sortFeatures(String[] features, String[] responses) {
		Map<String, Integer> map = new HashMap<>();
		Set<String> seen;
		int max = 0;
		for (String response : responses) {
			seen = new HashSet<>();
			String[] parts = response.split(" ");
			for (String part : parts) {
				if (seen.add(part)) {
					map.put(part, map.getOrDefault(part, 0) + 1);
					max = Math.max(max, map.get(part));
				}
			}
		}

		List<String>[] buckets = new ArrayList[max + 1];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<>();
		}

		int index;
		for (String feature : features) {
			index = map.getOrDefault(feature, 0);
			buckets[index].add(feature);
		}

		for (int i = 0, j = buckets.length - 1; j >= 0; j--) {
			for (String value : buckets[j]) {
				features[i++] = value;
			}
		}

		return features;
	}
}
