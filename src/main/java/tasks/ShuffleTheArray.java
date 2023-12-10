package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Jun-20
 */
@LeetCode(id = 1470, name = "Shuffle the Array", url = "https://leetcode.com/problems/shuffle-the-array/")
public class ShuffleTheArray {
	public int[] shuffle(int[] nums, int n) {
		int[] answer = new int[nums.length];
		int x = 0;
		int y = n;
		int i = 0;
		while (i < answer.length) {
			answer[i++] = nums[x++];
			answer[i++] = nums[y++];
		}
		return answer;
	}
}
