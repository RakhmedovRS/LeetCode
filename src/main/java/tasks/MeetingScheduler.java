package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 03-Feb-21
 */
@LeetCode(
		id = 1229,
		name = "Meeting Scheduler",
		url = "https://leetcode.com/problems/meeting-scheduler/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MeetingScheduler {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		int s1Index = 0;
		int s2Index = 0;

		Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);

		Arrays.sort(slots1, comparator);
		Arrays.sort(slots2, comparator);

		while (s1Index < slots1.length && s2Index < slots2.length) {
			if (slots1[s1Index][1] < slots2[s2Index][0]) {
				s1Index++;
			}
			else if (slots2[s2Index][1] < slots1[s1Index][0]) {
				s2Index++;
			}
			else {
				int start = Math.max(slots1[s1Index][0], slots2[s2Index][0]);
				int end = Math.min(slots1[s1Index][1], slots2[s2Index][1]);

				if (end - start >= duration) {
					return Arrays.asList(start, start + duration);
				}

				if (slots1[s1Index][1] == end) {
					s1Index++;
				}
				else {
					s2Index++;
				}
			}
		}

		return new ArrayList<>();
	}

	public static void main(String[] args) {
		MeetingScheduler clazz = new MeetingScheduler();

		System.out.println(clazz.minAvailableDuration(
				new int[][]{
						{216397070, 363167701},
						{98730764, 158208909},
						{441003187, 466254040},
						{558239978, 678368334},
						{683942980, 717766451}
				},
				new int[][]{
						{50490609, 222653186},
						{512711631, 670791418},
						{730229023, 802410205},
						{812553104, 891266775},
						{230032010, 399152578}
				},
				456085
		));

		System.out.println(clazz.minAvailableDuration(
				new int[][]{
						{10, 50},
						{50, 120},
						{140, 210}
				},
				new int[][]{
						{0, 15},
						{60, 70}
				},
				12
		));
	}
}
