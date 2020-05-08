import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 08-May-20
 */
@LeetCode(id = 95, name = "Unique Binary Search Trees II", url = "https://leetcode.com/problems/unique-binary-search-trees-ii/")
public class UniqueBinarySearchTreesII
{
	public List<TreeNode> generateTrees(int n)
	{
		if (n == 0)
		{
			return new ArrayList<>();
		}

		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int left, int right)
	{
		List<TreeNode> treeNodes = new ArrayList<>();
		if (left > right)
		{
			treeNodes.add(null);
			return treeNodes;
		}

		List<TreeNode> leftNodes;
		List<TreeNode> rightNodes;
		for (int i = left; i <= right; i++)
		{
			leftNodes = generateTrees(left, i - 1);
			rightNodes = generateTrees(i + 1, right);

			for (TreeNode leftNode : leftNodes)
			{
				for (TreeNode rightNode : rightNodes)
				{
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					root.right = rightNode;
					treeNodes.add(root);
				}
			}
		}

		return treeNodes;
	}
}
