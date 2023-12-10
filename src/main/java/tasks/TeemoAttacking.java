package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 9/26/2020
 */
@LeetCode(id = 495, name = "Teemo Attacking", url = "https://leetcode.com/problems/teemo-attacking/")
public class TeemoAttacking {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		Deque<int[]> intervals = new LinkedList<>();
		for (int time : timeSeries) {
			if (!intervals.isEmpty() && intervals.peek()[1] >= time) {
				int[] interval = intervals.remove();
				interval[1] = time + duration - 1;
				intervals.addFirst(interval);
			}
			else {
				intervals.addFirst(new int[]{time, time + duration - 1});
			}
		}

		int poisoned = 0;
		while (!intervals.isEmpty()) {
			poisoned += 1 + intervals.peek()[1] - intervals.peek()[0];
			intervals.remove();
		}

		return poisoned;
	}

	public static void main(String[] args) {
		System.out.println(new TeemoAttacking().findPoisonedDuration(new int[]{1, 3, 5}, 5));
		System.out.println(new TeemoAttacking().findPoisonedDuration(new int[]{1, 4}, 2));
		System.out.println(new TeemoAttacking().findPoisonedDuration(new int[]{1, 2}, 2));
	}
}
