package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/20/2020
 */
@LeetCode(
		id = 718,
		name = "Maximum Length of Repeated Subarray",
		url = "https://leetcode.com/problems/maximum-length-of-repeated-subarray/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumLengthOfRepeatedSubarray {
	public int findLength(int[] nums1, int[] nums2) {
		int max = 0;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			map.putIfAbsent(nums2[i], new ArrayList<>());
			map.get(nums2[i]).add(i);
		}

		for (int i = 0; i < nums1.length; i++) {
			for (int j : map.getOrDefault(nums1[i], Collections.emptyList())) {
				int a = i;
				int b = j;
				while (a < nums1.length && b < nums2.length && nums1[a] == nums2[b]) {
					max = Math.max(max, 1 + a - i);
					a++;
					b++;
				}
			}
		}

		return max;
	}
}
