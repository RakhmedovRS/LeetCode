package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-01
 */
@LeetCode(
		id = 3169,
		name = "Count Days Without Meetings",
		url = "https://leetcode.com/problems/count-days-without-meetings/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountDaysWithoutMeetings {
	public int countDays(int days, int[][] meetings) {
		meetings = merge(meetings);
		int prevEnd = 0;
		int result = 0;
		int start;
		int end;
		for (int[] meeting : meetings) {
			start = meeting[0];
			end = meeting[1];

			if (days < start) {
				break;
			}

			result += Math.max(0, start - prevEnd - 1);

			prevEnd = end;
		}
		result += Math.max(0, days - prevEnd);
		return result;
	}

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) ->
		{
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}

			return a[1] - b[1];
		});

		LinkedList<int[]> list = new LinkedList<>();
		for (int[] interval : intervals) {
			if (!list.isEmpty() && list.getLast()[1] >= interval[0]) {

				while (!list.isEmpty() && list.getLast()[1] >= interval[0]) {
					interval[0] = Math.min(list.getLast()[0], interval[0]);
					interval[1] = Math.max(list.getLast()[1], interval[1]);
					list.removeLast();
				}
			}

			list.addLast(interval);
		}

		int pos = 0;
		int[][] answer = new int[list.size()][];
		for (int[] inteval : list) {
			answer[pos++] = inteval;
		}

		return answer;
	}
}