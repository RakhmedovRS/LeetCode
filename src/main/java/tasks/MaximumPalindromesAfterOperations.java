package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-10
 */
@LeetCode(
		id = 3035,
		name = "Maximum Palindromes After Operations",
		url = "https://leetcode.com/problems/maximum-palindromes-after-operations/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumPalindromesAfterOperations {
	public int maxPalindromesAfterOperations(String[] words) {
		int[] totalFreqTable = new int[26];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (String word : words) {
			int[] freqTable = createCharFrequencyTable(word);
			for (int i = 0; i < 26; i++) {
				totalFreqTable[i] += freqTable[i];
			}

			pq.add(word.length());
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			int len = pq.remove();
			if (possibleToCreate(totalFreqTable, len)) {
				ans++;
			}
		}

		return ans;
	}

	private boolean possibleToCreate(int[] totalFreqTable, int len) {
		int[] used = new int[26];
		while (len > 0) {
			int val = len;
			for (int i = 0; i < 26 && len > 0; i++) {
				if ((totalFreqTable[i] - used[i]) > 0) {
					if (len % 2 == 0) {
						if ((totalFreqTable[i] - used[i]) > 1) {
							used[i] += 2;
							len -= 2;
						}
					} else {
						int oddPos = findOddPos(totalFreqTable, used);
						if (oddPos != -1) {
							used[oddPos] += 1;
						} else {
							used[i] += 1;
						}
						len -= 1;
					}
				}
			}

			if (len == val) {
				break;
			}
		}

		if (len > 0) {
			return false;
		}

		for (int i = 0; i < 26; i++) {
			totalFreqTable[i] -= used[i];
		}

		return true;
	}

	private int findOddPos(int[] totalFreqTable, int[] used) {
		for (int i = 0; i < 26; i++) {
			if ((totalFreqTable[i] - used[i]) % 2 == 1) {
				return i;
			}
		}
		return -1;
	}

	public static int[] createCharFrequencyTable(String word) {
		int[] pattern = new int[26];
		for (char ch : word.toCharArray()) {
			pattern[ch - 'a']++;
		}

		return pattern;
	}
}