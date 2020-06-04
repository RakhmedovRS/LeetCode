import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 04-Jun-20
 */
@LeetCode(id = 501, name = "Find Mode in Binary Search Tree", url = "https://leetcode.com/problems/find-mode-in-binary-search-tree/")
public class FindModeInBinarySearchTree
{
	public int[] findMode(TreeNode root)
	{
		if (root == null)
		{
			return new int[0];
		}
		Map<Integer, Integer> freq = new HashMap<>();
		traverse(root, freq);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(freq::get).reversed());
		maxHeap.addAll(freq.keySet());

		List<Integer> answer = new ArrayList<>();
		answer.add(maxHeap.remove());
		while (!maxHeap.isEmpty() &&
			freq.get(maxHeap.peek()).equals(freq.get(answer.get(0))))
		{
			answer.add(maxHeap.remove());
		}

		int[] res = new int[answer.size()];
		for (int i = 0; i < res.length; i++)
		{
			res[i] = answer.get(i);
		}
		return res;
	}

	private void traverse(TreeNode root, Map<Integer, Integer> freq)
	{
		if (root == null)
		{
			return;
		}

		freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
		traverse(root.left, freq);
		traverse(root.right, freq);
	}
}
