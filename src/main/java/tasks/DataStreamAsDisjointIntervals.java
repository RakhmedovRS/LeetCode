package tasks;

import common.LeetCode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 16-Sep-20
 */
@LeetCode(id = 352, name = "Data Stream as Disjoint Intervals", url = "https://leetcode.com/problems/data-stream-as-disjoint-intervals/")
public class DataStreamAsDisjointIntervals {
	class SummaryRanges {
		TreeMap<Integer, int[]> treeMap;

		public SummaryRanges() {
			treeMap = new TreeMap<>();
		}

		public void addNum(int val) {
			if (treeMap.containsKey(val)) {
				return;
			}

			Map.Entry<Integer, int[]> lower = treeMap.lowerEntry(val);
			Map.Entry<Integer, int[]> higher = treeMap.higherEntry(val);
			if (lower != null && higher != null && lower.getValue()[1] + 1 == val && higher.getValue()[0] - 1 == val) {
				lower.getValue()[1] = higher.getValue()[1];
				treeMap.remove(higher.getKey());
			}
			else if (lower != null && lower.getValue()[1] + 1 >= val) {
				lower.getValue()[1] = Math.max(lower.getValue()[1], val);
			}
			else if (higher != null && higher.getValue()[0] <= val + 1) {
				higher.getValue()[0] = Math.min(higher.getValue()[0], val);
			}
			else {
				treeMap.put(val, new int[]{val, val});
			}
		}

		public int[][] getIntervals() {
			int[][] intervals = new int[treeMap.size()][];
			Iterator<int[]> iterator = treeMap.values().iterator();
			for (int i = 0; i < intervals.length; i++) {
				intervals[i] = iterator.next();
			}

			return intervals;
		}
	}
}
