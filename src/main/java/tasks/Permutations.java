package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 01-Mar-20
 */
@LeetCode(id = 46, name = "Permutations", url = "https://leetcode.com/problems/permutations/")
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> tempo = new LinkedList<>();
		permute(result, tempo, nums);
		return result;
	}

	private void permute(List<List<Integer>> result, LinkedList<Integer> tempo, int[] nums) {
		if (nums.length == 0) {
			result.add(new ArrayList<>(tempo));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			tempo.addLast(nums[i]);
			permute(result, tempo, createSubArray(nums, i));
			tempo.removeLast();
		}
	}

	private int[] createSubArray(int[] values, int excludeIndex) {
		int[] subArray = new int[values.length - 1];
		int counter = 0;
		for (int i = 0; i < values.length; i++) {
			if (i != excludeIndex) {
				subArray[counter++] = values[i];
			}
		}

		return subArray;
	}

	public static void main(String[] args) {
		System.out.println(new Permutations().permute(new int[]{1, 2}));
		System.out.println();
		System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
		System.out.println();
		System.out.println(new Permutations().permute(new int[]{1, 2, 3, 4}));
	}
}
