package tasks;

import common.LeetCode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 13-Jul-20
 */
@LeetCode(id = 1438, name = "Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit", url = "https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/")
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
	public int longestSubarray(int[] nums, int limit) {
		int left = 0;
		int right = 0;
		int max = 0;
		TreeSet<Integer> minHeap = new TreeSet<>();
		TreeSet<Integer> maxHeap = new TreeSet<>(Comparator.reverseOrder());
		minHeap.add(nums[0]);
		maxHeap.add(nums[0]);
		while (left <= right && right < nums.length) {
			if (maxHeap.first() - minHeap.first() <= limit && right < nums.length) {
				max = Math.max(max, 1 + right - left);
				right++;
				if (right == nums.length) {
					continue;
				}
				minHeap.add(nums[right]);
				maxHeap.add(nums[right]);
			}
			else {
				minHeap.remove(nums[left]);
				maxHeap.remove(nums[left]);
				left++;
				minHeap.add(nums[left]);
				maxHeap.add(nums[left]);
			}
		}

		return max;
	}
}
