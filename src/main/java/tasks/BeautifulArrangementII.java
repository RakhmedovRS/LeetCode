package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/3/2021
 */
@LeetCode(
		id = 667,
		name = "Beautiful Arrangement II",
		url = "https://leetcode.com/problems/beautiful-arrangement-ii/",
		difficulty = Difficulty.MEDIUM
)
public class BeautifulArrangementII {
	public int[] constructArray(int n, int k) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		for (int i = 1; i < n && k > 1; i++, k--) {
			reverse(arr, i);
		}

		return arr;
	}

	private void reverse(int[] arr, int left) {
		int temp;
		int right = arr.length - 1;
		while (left < right) {
			temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
