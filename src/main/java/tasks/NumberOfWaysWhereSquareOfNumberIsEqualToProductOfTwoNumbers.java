package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 06-Sep-20
 */
@LeetCode(id = 1577, name = "Number of Ways Where Square of Number Is Equal to Product of Two Numbers", url = "https://leetcode.com/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/")
public class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
	public int numTriplets(int[] nums1, int[] nums2) {
		Map<Long, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			map.putIfAbsent((long) nums2[i] * nums2[i], new ArrayList<>());
			map.get((long) nums2[i] * nums2[i]).add(i);
		}

		int count = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = i + 1; j < nums1.length; j++) {
				count += map.getOrDefault((long) nums1[i] * nums1[j], Collections.emptyList()).size();
			}
		}

		map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.putIfAbsent((long) nums1[i] * nums1[i], new ArrayList<>());
			map.get((long) nums1[i] * nums1[i]).add(i);
		}

		for (int i = 0; i < nums2.length; i++) {
			for (int j = i + 1; j < nums2.length; j++) {
				count += map.getOrDefault((long) nums2[i] * nums2[j], Collections.emptyList()).size();
			}
		}

		return count;
	}
}
