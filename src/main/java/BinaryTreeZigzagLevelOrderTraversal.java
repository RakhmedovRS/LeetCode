import common.LeetCode;
import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 07-Apr-20
 */
@LeetCode(id = 103, name = "Binary Tree Zigzag Level Order Traversal", url = "https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/")
public class BinaryTreeZigzagLevelOrderTraversal
{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
		{
			return result;
		}
		Deque<TreeNode> nodes = new LinkedList<>();
		nodes.addFirst(root);
		int nodesCount;
		boolean directOrder = true;
		TreeNode tempNode;
		while (!nodes.isEmpty())
		{
			List<Integer> leafs = new LinkedList<>();
			nodesCount = nodes.size();
			for (int i = 0; i < nodesCount; i++)
			{
				if (directOrder)
				{
					tempNode = nodes.removeFirst();
					leafs.add(tempNode.val);
					if (tempNode.left != null)
					{
						nodes.addLast(tempNode.left);
					}

					if (tempNode.right != null)
					{
						nodes.addLast(tempNode.right);
					}
				}
				else
				{
					tempNode = nodes.removeLast();
					leafs.add(tempNode.val);
					if (tempNode.right != null)
					{
						nodes.addFirst(tempNode.right);
					}
					if (tempNode.left != null)
					{
						nodes.addFirst(tempNode.left);
					}
				}
			}
			directOrder = !directOrder;
			result.add(leafs);
		}

		return result;
	}
}
