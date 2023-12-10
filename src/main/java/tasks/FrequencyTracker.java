package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 5/7/2023
 */
@LeetCode(
		id = 2671,
		name = "Frequency Tracker",
		url = "https://leetcode.com/problems/frequency-tracker/",
		difficulty = Difficulty.MEDIUM
)
public class FrequencyTracker {
	Map<Integer, Integer> freq;
	Map<Integer, Set<Integer>> freqSorted;

	public FrequencyTracker() {
		freq = new HashMap<>();
		freqSorted = new HashMap<>();
	}

	public void add(int number) {
		if (freq.containsKey(number)) {
			int count = freq.remove(number);
			freqSorted.get(count).remove(number);
			freq.put(number, ++count);
			freqSorted.putIfAbsent(count, new HashSet<>());
			freqSorted.get(count).add(number);
		}
		else {
			freq.put(number, 1);
			freqSorted.putIfAbsent(1, new HashSet<>());
			freqSorted.get(1).add(number);
		}
	}

	public void deleteOne(int number) {
		if (freq.containsKey(number)) {
			int count = freq.remove(number);
			freqSorted.get(count).remove(number);
			if (count - 1 > 0) {
				freq.put(number, count - 1);
				freqSorted.get(count - 1).add(number);
			}
		}
	}

	public boolean hasFrequency(int frequency) {
		return freqSorted.containsKey(frequency) && !freqSorted.get(frequency).isEmpty();
	}
}
