package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 01-May-20
 */
@LeetCode(
		id = 106,
		name = "Construct Binary Tree from Inorder and Postorder Traversal",
		url = "https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/",
		difficulty = Difficulty.MEDIUM
)
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
			return null;
		}

		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			cache.put(inorder[i], i);
		}

		return buildTree(postorder, 0, postorder.length - 1, new int[]{postorder.length - 1}, cache);
	}

	private TreeNode buildTree(int[] postorder, int left, int right, int[] position, Map<Integer, Integer> cache) {
		if (left > right) {
			return null;
		}

		TreeNode node = new TreeNode(postorder[position[0]--]);

		if (left == right) {
			return node;
		}
		node.right = buildTree(postorder, cache.get(node.val) + 1, right, position, cache);
		node.left = buildTree(postorder, left, cache.get(node.val) - 1, position, cache);
		return node;
	}

	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal cbt = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		cbt.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
	}
}
