import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 07-Jul-20
 */
@LeetCode(id = 623, name = "Add One Row to Tree", url = "https://leetcode.com/problems/add-one-row-to-tree/")
public class AddOneRowToTree
{
	public TreeNode addOneRow(TreeNode root, int v, int d)
	{
		if (d == 1)
		{
			TreeNode newRoot = new TreeNode(v);
			newRoot.left = root;
			return newRoot;
		}

		LinkedList<TreeNode> current = new LinkedList<>();
		current.add(root);
		int currentLevel = 1;
		while (currentLevel < d - 1)
		{
			LinkedList<TreeNode> temp = new LinkedList<>();
			for (TreeNode node : current)
			{
				if (node != null)
				{
					if (node.left != null)
					{
						temp.add(node.left);
					}
					if (node.right != null)
					{
						temp.add(node.right);
					}
				}
			}
			current = temp;
			currentLevel++;
		}

		while (!current.isEmpty())
		{
			TreeNode node = current.removeFirst();
			TreeNode temp = node.left;
			node.left = new TreeNode(v);
			node.left.left = temp;
			temp = node.right;
			node.right = new TreeNode(v);
			node.right.right = temp;
		}

		return root;
	}
}
