package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/19/2022
 */
@LeetCode(
		id = 2178,
		name = "Maximum Split of Positive Even Integers",
		url = "https://leetcode.com/problems/maximum-split-of-positive-even-integers/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumSplitOfPositiveEvenIntegers {
	public List<Long> maximumEvenSplit(long finalSum) {
		if (finalSum % 2 != 0) {
			return new ArrayList<>();
		}

		LinkedList<Long> answer = new LinkedList<>();
		if (finalSum == 2 || finalSum == 4) {
			answer.addLast(finalSum);
		}
		else {
			answer.addLast(2L);
			long sum = 2;
			while (finalSum != sum) {
				if (sum > finalSum) {
					long diff = sum - finalSum;
					answer.remove(diff);
					sum -= diff;
				}
				else {
					sum += answer.getLast() + 2;
					answer.addLast(answer.getLast() + 2);
				}
			}
		}

		return answer;
	}
}
