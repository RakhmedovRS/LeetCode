package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 06-Jun-20
 */
@LeetCode(id = 406, name = "Queue Reconstruction by Height", url = "https://leetcode.com/problems/queue-reconstruction-by-height/")
public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		List<int[]> list = new ArrayList<>();
		for (int[] p : people) {
			list.add(p[1], p);
		}
		return list.toArray(new int[list.size()][]);
	}
}
