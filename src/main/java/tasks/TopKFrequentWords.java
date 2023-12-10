package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 29-Apr-20
 */
@LeetCode(id = 692, name = "Top K Frequent Words", url = "https://leetcode.com/problems/top-k-frequent-words/")
public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		LinkedList<String> result = new LinkedList<>();
		if (words == null || words.length == 0 || k == 0) {
			return result;
		}

		Map<String, Integer> wordToCount = new HashMap<>();
		for (String word : words) {
			wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
		}

		Comparator<String> stringComparator = (string1, string2) ->
		{
			Integer count1 = wordToCount.get(string1);
			Integer count2 = wordToCount.get(string2);
			if (count1.equals(count2)) {
				return string2.compareTo(string1);
			}
			else {
				return count1 - count2;
			}
		};

		PriorityQueue<String> priorityQueue = new PriorityQueue<>(stringComparator);
		for (String word : wordToCount.keySet()) {
			priorityQueue.offer(word);
			if (priorityQueue.size() > k) {
				priorityQueue.poll();
			}
		}

		while (!priorityQueue.isEmpty()) {
			result.addFirst(priorityQueue.remove());
		}

		return result;
	}
}
