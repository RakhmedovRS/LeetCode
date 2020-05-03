import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@LeetCode(id= 373, name = "Find K Pairs with Smallest Sums", url = "https://leetcode.com/problems/find-k-pairs-with-smallest-sums/")
public class FindKPairsWithSmallestSums
{
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
	{
		List<List<Integer>> result = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0)
		{
			return result;
		}

		PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(list -> (list.get(0) + list.get(1))));
		for (int num1 : nums1)
		{
			for (int num2 : nums2)
			{
				minHeap.add(Arrays.asList(num1, num2));
			}
		}

		while (!minHeap.isEmpty() && k-- > 0)
		{
			result.add(minHeap.remove());
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindKPairsWithSmallestSums().kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
	}
}
