import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(id = 105, name = "Construct Binary Tree from Preorder and Inorder Traversal", url = "https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/")
public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
		{
			cache.put(inorder[i], i);
		}
		return buildTree(preorder, cache, new int[]{0}, 0, inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, Map<Integer, Integer> cache, int[] rootIdx, int left, int right)
	{
		if (rootIdx[0] >= preorder.length || left > right)
		{
			return null;
		}

		TreeNode root = new TreeNode(preorder[rootIdx[0]++]);

		int rootPos = cache.get(root.val);

		root.left = buildTree(preorder, cache, rootIdx, left, rootPos - 1);
		root.right = buildTree(preorder, cache, rootIdx, rootPos + 1, right);

		return root;
	}
}
