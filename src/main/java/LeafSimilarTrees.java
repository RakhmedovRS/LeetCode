import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 19-May-20
 */
@LeetCode(id = 872, name = "Leaf-Similar Trees", url = "https://leetcode.com/problems/leaf-similar-trees/")
public class LeafSimilarTrees
{
	public boolean leafSimilar(TreeNode root1, TreeNode root2)
	{
		List<Integer> leftTreeLeafs = new ArrayList<>();
		List<Integer> rightTreeLeafs = new ArrayList<>();

		getLeafs(root1, leftTreeLeafs);
		getLeafs(root2, rightTreeLeafs);

		if (leftTreeLeafs.size() != rightTreeLeafs.size())
		{
			return false;
		}

		return leftTreeLeafs.equals(rightTreeLeafs);
	}

	private void getLeafs(TreeNode treeNode, List<Integer> result)
	{
		if (treeNode == null)
		{
			return;
		}

		if (treeNode.left == null && treeNode.right == null)
		{
			result.add(treeNode.val);
		}

		if (treeNode.left != null)
		{
			getLeafs(treeNode.left, result);
		}

		if (treeNode.right != null)
		{
			getLeafs(treeNode.right, result);
		}
	}
}
