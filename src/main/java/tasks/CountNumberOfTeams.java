package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 14-Aug-20
 */
@LeetCode(id = 1395, name = "Count Number of Teams", url = "https://leetcode.com/problems/count-number-of-teams/")
public class CountNumberOfTeams {
	public int numTeams(int[] rating) {
		int numberOfTeams = 0;
		if (rating.length < 3) {
			return numberOfTeams;
		}

		List<List<Integer>> increasing = new ArrayList<>(rating.length);
		List<List<Integer>> decreasing = new ArrayList<>(rating.length);
		for (int i = 0; i < rating.length; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			increasing.add(list);

			list = new ArrayList<>();
			list.add(1);
			decreasing.add(list);
		}

		for (int i = 1; i < rating.length; i++) {
			for (int j = 0; j < i; j++) {
				if (rating[j] < rating[i]) {
					for (int count : increasing.get(j)) {
						if (count + 1 == 3) {
							numberOfTeams++;
						}
						else if (count + 1 <= 2) {
							increasing.get(i).add(count + 1);
						}
					}
				}
			}
		}

		for (int i = rating.length - 2; i >= 0; i--) {
			for (int j = rating.length - 1; j > i; j--) {
				if (rating[i] > rating[j]) {
					for (int count : decreasing.get(j)) {
						if (count + 1 == 3) {
							numberOfTeams++;
						}
						else if (count + 1 <= 2) {
							decreasing.get(i).add(count + 1);
						}
					}
				}
			}
		}

		return numberOfTeams;
	}
}
