import common.LeetCode;
import common.TreeBuilder;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 01-Aug-20
 */
@LeetCode(id = 450, name = "Delete Node in a BST", url = "https://leetcode.com/problems/delete-node-in-a-bst/")
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
			if (root.left == null && root.right == null)
			{
				return null;
			}
			else if (root.left == null)
			{
				return root.right;
			}
			else if (root.right == null)
			{
				return root.left;
			}
			else
			{
				int[] min = new int[1];
				root.right = findAndDeleteMinimum(root.right, min);
				root.val = min[0];
				return root;
			}
		}

		if (root.val > key)
		{
			root.left = deleteNode(root.left, key);
		}
		else
		{
			root.right = deleteNode(root.right, key);
		}

		return root;
	}

	private TreeNode findAndDeleteMinimum(TreeNode treeNode, int[] min)
	{
		if (treeNode.left != null)
		{
			treeNode.left = findAndDeleteMinimum(treeNode.left, min);
		}
		else
		{
			min[0] = treeNode.val;
			return treeNode.right;
		}
		return treeNode;
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
