package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 09-Jul-20
 */
@LeetCode(id = 1331, name = "Rank Transform of an Array", url = "https://leetcode.com/problems/rank-transform-of-an-array/")
public class RankTransformOfArray {
	public int[] arrayRankTransform(int[] arr) {
		Map<Integer, List<Integer>> numToIndexes = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> positions = numToIndexes.getOrDefault(arr[i], new ArrayList<>());
			positions.add(i);
			numToIndexes.put(arr[i], positions);
		}

		int[] answer = new int[arr.length];
		List<Integer> values = new ArrayList<>(numToIndexes.keySet());
		values.sort(null);
		for (int i = 0; i < values.size(); i++) {
			for (int pos : numToIndexes.get(values.get(i))) {
				answer[pos] = i + 1;
			}
		}

		return answer;
	}
}
