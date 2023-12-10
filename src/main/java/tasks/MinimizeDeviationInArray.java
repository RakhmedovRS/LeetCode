package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 30-Jan-21
 */
@LeetCode(
		id = 1675,
		name = "Minimize Deviation in Array",
		url = "https://leetcode.com/problems/minimize-deviation-in-array/",
		difficulty = Difficulty.HARD
)
public class MinimizeDeviationInArray {
	public int minimumDeviation(int[] nums) {
		int min = Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int num : nums) {
			if (num % 2 != 0) {
				num *= 2;
			}

			pq.add(num);
			min = Math.min(min, num);
		}

		int minDeviation = Integer.MAX_VALUE;
		int current;
		while (!pq.isEmpty()) {
			current = pq.remove();
			minDeviation = Math.min(minDeviation, current - min);
			if (current % 2 != 0) {
				break;
			}

			current /= 2;
			min = Math.min(min, current);
			pq.add(current);
		}

		return minDeviation;
	}

	public static void main(String[] args) {
		MinimizeDeviationInArray clazz = new MinimizeDeviationInArray();
		System.out.println(clazz.minimumDeviation(new int[]{4, 9, 4, 5}));
		System.out.println(clazz.minimumDeviation(new int[]{3, 5}));
		System.out.println(clazz.minimumDeviation(new int[]{4, 1, 5, 20, 3}));
		System.out.println(clazz.minimumDeviation(new int[]{2, 10, 8}));
	}
}
