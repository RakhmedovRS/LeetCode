import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 21-Jun-20
 */
@LeetCode(id = 508, name = "Most Frequent Subtree Sum", url = "https://leetcode.com/problems/most-frequent-subtree-sum/")
public class MostFrequentSubtreeSum
{
	public int[] findFrequentTreeSum(TreeNode root)
	{
		if (root == null)
		{
			return new int[0];
		}

		Map<Integer, Integer> sums = new HashMap<>();
		traverse(root, sums);

		int max = Collections.max(sums.values());
		List<Integer> maxes = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : sums.entrySet())
		{
			if (entry.getValue() == max)
			{
				maxes.add(entry.getKey());
			}
		}

		int[] res = new int[maxes.size()];
		for (int i = 0; i < res.length; i++)
		{
			res[i] = maxes.get(i);
		}
		return res;
	}

	private int traverse(TreeNode root, Map<Integer, Integer> sums)
	{
		if (root.left == null && root.right == null)
		{
			sums.put(root.val, sums.getOrDefault(root.val, 0) + 1);
			return root.val;
		}

		int sum = root.val;
		sum += root.left == null ? 0 : traverse(root.left, sums);
		sum += root.right == null ? 0 : traverse(root.right, sums);
		sums.put(sum, sums.getOrDefault(sum, 0) + 1);

		return sum;
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-3);

		System.out.println(Arrays.toString(new MostFrequentSubtreeSum().findFrequentTreeSum(root)));
	}
}
