package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 2/28/2021
 */
@LeetCode(
		id = 1775,
		name = "Equal Sum Arrays With Minimum Number of Operations",
		url = "https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/",
		difficulty = Difficulty.MEDIUM
)
public class EqualSumArraysWithMinimumNumberOfOperations {
	public int minOperations(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length * 6 || nums1.length * 6 < nums2.length) {
			return -1;
		}

		int sum1 = sum(nums1);
		int sum2 = sum(nums2);

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		if (sum1 < sum2) {
			for (int num : nums1) {
				minHeap.add(num);
			}

			for (int num : nums2) {
				maxHeap.add(num);
			}
		}
		else if (sum1 > sum2) {
			for (int num : nums2) {
				minHeap.add(num);
			}

			for (int num : nums1) {
				maxHeap.add(num);
			}

			int temp = sum1;
			sum1 = sum2;
			sum2 = temp;
		}

		int steps = 0;
		while (sum1 < sum2) {
			if (maxHeap.isEmpty() || 6 - minHeap.peek() > maxHeap.peek() - 1) {
				sum1 += 6 - minHeap.remove();
			}
			else {
				sum2 -= maxHeap.remove() - 1;
			}

			steps++;
		}

		return steps;
	}

	private int sum(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}

	public static void main(String[] args) {
		EqualSumArraysWithMinimumNumberOfOperations clazz = new EqualSumArraysWithMinimumNumberOfOperations();

		System.out.println(clazz.minOperations(new int[]{5, 6, 4, 3, 1, 2}, new int[]{6, 3, 3, 1, 4, 5, 3, 4, 1, 3, 4}));
		System.out.println(clazz.minOperations(new int[]{6, 6}, new int[]{1}));
		System.out.println(clazz.minOperations(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{6}));
		System.out.println(clazz.minOperations(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 2, 2, 2, 2}));
	}
}
