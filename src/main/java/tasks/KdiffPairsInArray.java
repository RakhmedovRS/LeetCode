package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 09-Apr-20
 */
@LeetCode(id = 532, name = "K-diff Pairs in an Array", url = "https://leetcode.com/problems/k-diff-pairs-in-an-array/")
public class KdiffPairsInArray {
	public int findPairs(int[] nums, int k) {
		int pairs = 0;
		Arrays.sort(nums);
		Map<Integer, Set<Integer>> used = new HashMap<>();
		Set<Integer> numbers = new HashSet<>();
		int searchValue;
		for (int num : nums) {
			searchValue = num - k;
			if (numbers.contains(searchValue)) {
				if (used.containsKey(searchValue) && used.get(searchValue).contains(num)) {
					continue;
				}
				pairs++;
				used.putIfAbsent(searchValue, new HashSet<>());
				used.get(searchValue).add(num);
			}

			numbers.add(num);
		}

		return pairs;
	}

	public static void main(String[] args) {
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 2, 3, 4, 5}, -1));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 2, 3, 4, 5}, 4));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
		System.out.println(new KdiffPairsInArray().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
	}
}
