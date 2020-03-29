import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 09-Mar-20
 */
@LeetCode(id = 102, name = "Binary Tree Level Order Traversal", url = "https://leetcode.com/problems/binary-tree-level-order-traversal/")
public class BinaryTreeLevelOrderTraversal
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public List<List<Integer>> levelOrder(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}

		List<List<Integer>> result = new LinkedList<>();
		LinkedList<TreeNode> tempo = new LinkedList<>();
		tempo.addLast(root);
		while (!tempo.isEmpty())
		{
			int currentLevelSize = tempo.size();
			LinkedList<Integer> currentLevelValues = new LinkedList<>();
			while (currentLevelSize > 0)
			{
				TreeNode node = tempo.removeFirst();
				if (node.left != null)
				{
					tempo.addLast(node.left);
				}
				if (node.right != null)
				{
					tempo.addLast(node.right);
				}
				currentLevelValues.addLast(node.val);

				currentLevelSize--;
			}
			result.add(currentLevelValues);
		}

		return result;
	}
}
