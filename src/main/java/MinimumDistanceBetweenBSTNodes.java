import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 19-Apr-20
 */
@LeetCode(id = 783, name = "Minimum Distance Between BST Nodes", url = "https://leetcode.com/problems/minimum-distance-between-bst-nodes/")
public class MinimumDistanceBetweenBSTNodes
{
	public int minDiffInBST(TreeNode root)
	{
		List<Integer> values = new ArrayList<>();
		minDiffInBST(root, values);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < values.size(); i++)
		{
			int diff = Math.abs(values.get(i) - values.get(i - 1));
			if (min > diff)
			{
				min = diff;
			}
		}
		return min;
	}

	public void minDiffInBST(TreeNode root, List<Integer> values)
	{
		if (root == null)
		{
			return;
		}

		if (root.left != null)
		{
			minDiffInBST(root.left, values);
		}

		values.add(root.val);

		if (root.right != null)
		{
			minDiffInBST(root.right, values);
		}
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(root));
	}
}
