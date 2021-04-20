package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 9/26/2020
 */
@LeetCode(id = 889, name = "Construct Binary Tree from Preorder and Postorder Traversal", url = "https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/")
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal
{
	public TreeNode constructFromPrePost(int[] pre, int[] post)
	{
		return constructFromPrePost(pre, new int[]{0}, post, new int[]{0});
	}

	public TreeNode constructFromPrePost(int[] pre, int[] prePos, int[] post, int[] postPos)
	{
		TreeNode root = new TreeNode(pre[prePos[0]++]);
		if (root.val != post[postPos[0]])
		{
			root.left = constructFromPrePost(pre, prePos, post, postPos);
		}
		if (root.val != post[postPos[0]])
		{
			root.right = constructFromPrePost(pre, prePos, post, postPos);
		}
		postPos[0]++;

		return root;
	}

	public static void main(String[] args)
	{
		TreeNode root = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7},
			new int[]{4, 5, 2, 6, 7, 3, 1});

		new PrintBinaryTree().printTree(root).forEach(System.out::println);
	}
}
