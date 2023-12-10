package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/9/2021
 */
@LeetCode(
		id = 2032,
		name = "Two Out of Three",
		url = "https://leetcode.com/problems/two-out-of-three/",
		difficulty = Difficulty.EASY
)
public class TwoOutOfThree {
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
		int[] vals = new int[101];
		Set<Integer> s1 = new HashSet<>();
		for (int num : nums1) {
			s1.add(num);
		}

		Set<Integer> s2 = new HashSet<>();
		for (int num : nums2) {
			s2.add(num);
		}

		Set<Integer> s3 = new HashSet<>();
		for (int num : nums3) {
			s3.add(num);
		}

		for (int v : s1) {
			vals[v]++;
		}

		for (int v : s2) {
			vals[v]++;
		}

		for (int v : s3) {
			vals[v]++;
		}

		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] >= 2) {
				answer.add(i);
			}
		}

		return answer;
	}
}
