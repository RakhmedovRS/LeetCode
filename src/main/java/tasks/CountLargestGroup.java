package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 21-Jun-20
 */
@LeetCode(id = 1399, name = "Count Largest Group", url = "https://leetcode.com/problems/count-largest-group/")
public class CountLargestGroup {
	public int countLargestGroup(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int curr;
		int sum;
		for (int i = 1; i <= n; i++) {
			curr = i;
			sum = 0;
			while (curr > 0) {
				sum += curr % 10;
				curr /= 10;
			}

			int count = map.getOrDefault(sum, 0) + 1;
			if (count > max) {
				max = count;
			}
			map.put(sum, count);
		}

		int res = 0;
		for (Integer count : map.values()) {
			if (count == max) {
				res++;
			}
		}
		return res;
	}
}
