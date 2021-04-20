package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 12/21/2020
 */
@LeetCode(
	id = 1602,
	name = "Find Nearest Right Node in Binary Tree",
	url = "https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class FindNearestRightNodeInBinaryTree
{
	public TreeNode findNearestRightNode(TreeNode root, TreeNode u)
	{
		int size;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode current;
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				if (current == u)
				{
					if (size == 0 || queue.isEmpty())
					{
						return null;
					}

					return queue.remove();
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
		}

		return null;
	}
}
