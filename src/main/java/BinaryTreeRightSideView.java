import common.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(id = 199, name = "Binary Tree Right Side View", url = "https://leetcode.com/problems/binary-tree-right-side-view/")
public class BinaryTreeRightSideView
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(){}

		TreeNode(int val){ this.val = val; }

		TreeNode(int val, TreeNode left, TreeNode right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();
		if (root == null)
		{
			return result;
		}

		Deque<TreeNode> levels = new LinkedList<>();
		levels.addLast(root);
		int levelSize;
		while (!levels.isEmpty())
		{
			levelSize = levels.size();
			while (levelSize-- > 0)
			{
				TreeNode node = levels.removeFirst();

				if (node.left != null)
				{
					levels.addLast(node.left);
				}

				if (node.right != null)
				{
					levels.addLast(node.right);
				}

				if (levelSize == 0)
				{
					result.add(node.val);
				}
			}
		}

		return result;
	}
}
