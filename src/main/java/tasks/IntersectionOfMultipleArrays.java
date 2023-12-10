package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 4/24/2022
 */
@LeetCode(
		id = 2248,
		name = "Intersection of Multiple Arrays",
		url = "https://leetcode.com/problems/intersection-of-multiple-arrays/",
		difficulty = Difficulty.EASY
)
public class IntersectionOfMultipleArrays {
	public List<Integer> intersection(int[][] nums) {
		int[] count = new int[1001];
		for (int[] numss : nums) {
			boolean[] b = new boolean[1001];
			for (int num : numss) {
				b[num] = true;
			}

			for (int i = 0; i < b.length; i++) {
				if (b[i]) {
					count[i]++;
				}
			}
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < count.length; i++) {
			if (count[i] == nums.length) {
				answer.add(i);
			}
		}

		return answer;
	}
}
