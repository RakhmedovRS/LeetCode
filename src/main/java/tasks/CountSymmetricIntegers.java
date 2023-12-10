package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 9/3/2023
 */
@LeetCode(
		id = 2843,
		name = "Count Symmetric Integers",
		url = "https://leetcode.com/problems/count-symmetric-integers/",
		difficulty = Difficulty.EASY
)
public class CountSymmetricIntegers {
	public int countSymmetricIntegers(int low, int high) {
		int count = 0;
		while (low <= high) {
			LinkedList<Integer> list = new LinkedList<>();
			int tmp = low;
			while (tmp > 0) {
				list.addFirst(tmp % 10);
				tmp /= 10;
			}

			if (list.size() % 2 == 0) {
				int left = 0;
				int right = 0;
				int size = list.size();
				for (int i = 0; i < size / 2; i++) {
					left += list.removeFirst();
				}

				while (!list.isEmpty()) {
					right += list.removeFirst();
				}

				count += (left == right) ? 1 : 0;
			}

			low++;
		}
		return count;
	}
}
