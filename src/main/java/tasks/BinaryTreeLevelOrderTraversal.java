package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 09-Mar-20
 */
@LeetCode(
		id = 102,
		name = "Binary Tree Level Order Traversal",
		url = "https://leetcode.com/problems/binary-tree-level-order-traversal/",
		difficulty = Difficulty.MEDIUM
)
public class BinaryTreeLevelOrderTraversal
{
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> answer = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int size;
		TreeNode current;
		while (!queue.isEmpty())
		{
			size = queue.size();
			List<Integer> list = new ArrayList<>();
			while (size-- > 0)
			{
				current = queue.remove();
				if (current == null)
				{
					continue;
				}

				list.add(current.val);

				queue.add(current.left);
				queue.add(current.right);

			}

			if (!list.isEmpty())
			{
				answer.add(list);
			}
		}


		return answer;
	}
}
