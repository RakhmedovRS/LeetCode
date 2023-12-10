package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 18-Feb-20
 */
@LeetCode(id = 961, name = "N-Repeated Element in Size 2N Array", url = "https://leetcode.com/problems/n-repeated-element-in-size-2n-array/")
public class NRepeatedElementIn2NArray {
	public int repeatedNTimes(int[] A) {
		Set<Integer> cache = new HashSet<>();
		for (int val : A) {
			if (!cache.add(val)) {
				return val;
			}
		}

		return -1;
	}
}
