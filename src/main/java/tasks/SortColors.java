package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(
		id = 75,
		name = "Sort Colors",
		url = "https://leetcode.com/problems/sort-colors/",
		difficulty = Difficulty.MEDIUM
)
public class SortColors {
	public void sortColors(int[] nums) {
		int[] temp = new int[3];
		for (int num : nums) {
			temp[num]++;
		}

		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			while (temp[i] == 0) {
				i++;
			}

			nums[j] = i;
			temp[i]--;
		}
	}

	public static void main(String[] args) {
		int[] colors = new int[]{2, 0, 2, 1, 1, 0};
		new SortColors().sortColors(colors);
		System.out.println(Arrays.toString(colors));

		colors = new int[]{0};
		new SortColors().sortColors(colors);
		System.out.println(Arrays.toString(colors));
	}
}
