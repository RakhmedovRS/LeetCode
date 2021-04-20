package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 3/29/2021
 */
@LeetCode(
	id = 971,
	name = "Flip Binary Tree To Match Preorder Traversal",
	url = "https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/",
	difficulty = Difficulty.MEDIUM
)
public class FlipBinaryTreeToMatchPreorderTraversal
{
	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage)
	{
		List<Integer> answer = new ArrayList<>();
		return dfs(root, voyage, new int[]{0}, answer) ? answer : Arrays.asList(-1);
	}

	private boolean dfs(TreeNode root, int[] voyage, int[] pos, List<Integer> list)
	{
		if (root == null)
		{
			return true;
		}

		if (pos[0] == voyage.length)
		{
			return root == null;
		}

		if (root.val != voyage[pos[0]])
		{
			return false;
		}

		pos[0]++;

		if (pos[0] < voyage.length)
		{
			if (root.right != null && root.right.val == voyage[pos[0]] && root.left != null)
			{
				list.add(root.val);
				flipChildren(root);
			}

			boolean left = dfs(root.left, voyage, pos, list);
			boolean right = dfs(root.right, voyage, pos, list);

			return left && right;
		}

		return true;
	}

	private void flipChildren(TreeNode node)
	{
		TreeNode left = node.left;
		node.left = node.right;
		node.right = left;
	}
}
