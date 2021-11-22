package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeBuilder;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 01-Aug-20
 */
@LeetCode(
	id = 450,
	name = "Delete Node in a BST",
	url = "https://leetcode.com/problems/delete-node-in-a-bst/",
	difficulty = Difficulty.MEDIUM
)
public class DeleteNodeInBST
{
	public TreeNode deleteNode(TreeNode root, int key)
	{
		if (root == null)
		{
			return null;
		}

		if (root.val == key)
		{
			if (root.left == null)
			{
				return root.right;
			}
			else if (root.right == null)
			{
				return root.left;
			}
			else
			{
				root.val = findMin(root.right);
				root.right = deleteNode(root.right, root.val);
			}
		}
		else if (key > root.val)
		{
			root.right = deleteNode(root.right, key);
		}
		else
		{
			root.left = deleteNode(root.left, key);
		}

		return root;
	}

	private int findMin(TreeNode treeNode)
	{
		while (treeNode.left != null)
		{
			treeNode = treeNode.left;
		}

		return treeNode.val;
	}

	public static void main(String[] args)
	{
		TreeNode root = TreeBuilder.deserializeBinaryTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
		new PrintBinaryTree().printTree(root).forEach(System.out::println);
		new DeleteNodeInBST().deleteNode(root, 5);
		System.out.println();
		new PrintBinaryTree().printTree(root).forEach(System.out::println);
	}
}
