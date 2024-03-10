package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 3/9/2024
 */
@LeetCode(
		id = 3076,
		name = "Shortest Uncommon Substring in an Array",
		url = "https://leetcode.com/problems/shortest-uncommon-substring-in-an-array/description/",
		difficulty = Difficulty.MEDIUM
)
public class ShortestUncommonSubstringInArray {
	public String[] shortestSubstrings(String[] arr) {
		Map<String, Set<String>> suffixTree = new HashMap<>();
		Map<String, Integer> counts = new HashMap<>();
		for (String str : arr) {
			suffixTree.put(str, generatePrefixes(str));
			counts.put(str, counts.getOrDefault(str, 0) + 1);
		}

		String[] answer = new String[arr.length];
		Arrays.fill(answer, "");
		for (int i = 0; i < arr.length; i++) {
			String shortest = null;
			String currStr = arr[i];
			if (counts.get(currStr) > 1) {
				continue;
			}

			Set<String> prefixesOfCurrStr = suffixTree.get(currStr);
			outer:
			for (String currPrefix : prefixesOfCurrStr) {
				for (Map.Entry<String, Set<String>> entry : suffixTree.entrySet()) {
					String str = entry.getKey();
					if (str.equals(currStr)) {
						continue;
					}

					Set<String> prefixes = entry.getValue();
					if (prefixes.contains(currPrefix)) {
						continue outer;
					}
				}

				if (shortest == null || shortest.length() > currPrefix.length() || (shortest.length() == currPrefix.length() && shortest.compareTo(currPrefix) > 0)) {
					shortest = currPrefix;
				}
			}

			if (shortest != null) {
				answer[i] = shortest;
			}
		}

		return answer;
	}

	private Set<String> generatePrefixes(String str) {
		Set<String> prefixes = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				prefixes.add(str.substring(i, j + 1));
			}
		}
		return prefixes;
	}
}
