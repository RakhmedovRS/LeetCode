import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/13/2021
 */
@LeetCode(
	id = 285,
	name = "Inorder Successor in BST",
	url = "https://leetcode.com/problems/inorder-successor-in-bst/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class InorderSuccessorInBST
{
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
	{
		if (p.right != null)
		{
			p = p.right;
			while (p.left != null)
			{
				p = p.left;
			}

			return p;
		}

		Map<TreeNode, TreeNode> parents = new HashMap<>();
		dfs(null, root, parents);

		TreeNode parent;
		while (p != null)
		{
			parent = parents.get(p);
			if (parent != null && parent.left == p)
			{
				return parent;
			}

			p = parent;
		}

		return null;
	}

	private void dfs(TreeNode parent, TreeNode root, Map<TreeNode, TreeNode> parents)
	{
		if (root == null)
		{
			return;
		}

		if (parent != null)
		{
			parents.put(root, parent);
		}

		dfs(root, root.left, parents);
		dfs(root, root.right, parents);
	}
}
