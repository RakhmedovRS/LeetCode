package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/4/2021
 */
@LeetCode(
		id = 1214,
		name = "Two Sum BSTs",
		url = "https://leetcode.com/problems/two-sum-bsts/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class TwoSumBSTs
{
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target)
	{
		if (root1 == null || root2 == null)
		{
			return false;
		}

		Set<Integer> set = new HashSet<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root1);
		TreeNode current;
		while (!queue.isEmpty())
		{
			current = queue.remove();
			set.add(current.val);
			if (current.left != null)
			{
				queue.add(current.left);
			}

			if (current.right != null)
			{
				queue.add(current.right);
			}
		}

		queue.add(root2);
		while (!queue.isEmpty())
		{
			current = queue.remove();

			if (set.contains(target - current.val))
			{
				return true;
			}

			if (current.left != null)
			{
				queue.add(current.left);
			}

			if (current.right != null)
			{
				queue.add(current.right);
			}
		}

		return false;
	}
}
