import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
@LeetCode(
	id = 104,
	name = "Maximum Depth of Binary Tree",
	url = "https://leetcode.com/problems/maximum-depth-of-binary-tree/",
	difficulty = Difficulty.EASY
)
public class MaximumDepthOfBinaryTree
{
	public int maxDepth(TreeNode root)
	{
		int depth = 0;
		LinkedList<TreeNode> nodes = new LinkedList<>();
		if (root != null)
		{
			nodes.addLast(root);
		}

		int size;
		TreeNode node;
		while (!nodes.isEmpty())
		{
			size = nodes.size();
			while (size-- > 0)
			{
				node = nodes.removeFirst();
				if (node.left != null)
				{
					nodes.addLast(node.left);
				}

				if (node.right != null)
				{
					nodes.addLast(node.right);
				}
			}

			depth++;
		}

		return depth;
	}
}
