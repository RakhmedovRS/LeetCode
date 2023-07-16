package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 12/5/2021
 */
@LeetCode(
		id = 2096,
		name = "Step-By-Step Directions From a Binary Tree Node to Another",
		url = "https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/submissions/",
		difficulty = Difficulty.MEDIUM
)
public class StepByStepDirectionsFromBinaryTreeNodeToAnother
{
	public String getDirections(TreeNode root, int startValue, int destValue)
	{
		Map<TreeNode, TreeNode> parents = new HashMap<>();
		TreeNode[] start = new TreeNode[1];
		TreeNode[] end = new TreeNode[1];
		TreeNode lca = lowestCommonAncestor(root, startValue, destValue);
		dfs(root, null, parents, start, end, startValue, destValue);

		Set<TreeNode> valid = new HashSet<>();
		TreeNode temp = start[0];
		while (temp != null)
		{
			valid.add(temp);
			if (temp == lca)
			{
				break;
			}
			temp = parents.get(temp);
		}

		temp = end[0];
		while (temp != null && temp != lca)
		{
			valid.add(temp);
			if (temp == lca)
			{
				break;
			}
			temp = parents.get(temp);
		}

		StringBuilder sb = new StringBuilder();
		TreeNode s = start[0];
		TreeNode e = end[0];
		while (s != e)
		{
			valid.remove(s);
			if (parents.get(s) != null && valid.contains(parents.get(s)))
			{
				sb.append('U');
				s = parents.get(s);
			}
			else if (s.left != null && valid.contains(s.left))
			{
				sb.append('L');
				s = s.left;
			}
			else if (s.right != null && valid.contains(s.right))
			{
				sb.append('R');
				s = s.right;
			}
			valid.remove(s);
		}

		return sb.toString();
	}

	private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parents, TreeNode[] start, TreeNode[] end, int startValue, int destValue)
	{
		if (root == null)
		{
			return;
		}

		if (root.val == startValue)
		{
			start[0] = root;
		}

		if (root.val == destValue)
		{
			end[0] = root;
		}

		parents.put(root, parent);
		dfs(root.left, root, parents, start, end, startValue, destValue);
		dfs(root.right, root, parents, start, end, startValue, destValue);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, int p, int q)
	{
		if (root == null)
		{
			return null;
		}

		if (root.val == p || root.val == q)
		{
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (right != null && left != null)
		{
			return root;
		}
		else if (left != null)
		{
			return left;
		}
		else
		{
			return right;
		}
	}
}
